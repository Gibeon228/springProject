package ru.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.model.Worker;
import ru.repository.WorkerRepository;

import java.util.List;
import java.util.Objects;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class WorkerControllerTest {

    @Autowired
    WebTestClient webTestClient;
    @Autowired
    WorkerRepository workerRepository;

    @Test
    void testGetAll() {
        //подготовка даннных
        List<Worker> expected = workerRepository.saveAll(List.of(
                new Worker(1L, "ib1", "PC-firstName","ib", "Ib1", "Ib1"),
                new Worker(2L, "ib2", "PC-secondName","ib", "ib2", "ib2")
        ));

         List<WorkerResponse> responseBody = webTestClient.get()
                .uri("/worker")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<WorkerResponse>>() {
                })
                .returnResult()
                .getResponseBody();

        Assertions.assertEquals(expected.size(), responseBody.size());
        for (WorkerResponse workerResponse : responseBody) {
            boolean found = expected.stream()
                    .filter(it -> Objects.equals(it.getId(), workerResponse.getId()))
                    .anyMatch(it -> Objects.equals(it.getName(), workerResponse.getName()));
            Assertions.assertTrue(found);
        }
    }
}
