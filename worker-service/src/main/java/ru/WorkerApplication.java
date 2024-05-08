package ru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.model.Worker;
import ru.repository.WorkerRepository;


@SpringBootApplication
public class WorkerApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(WorkerApplication.class, args);


        WorkerRepository workerRepository = context.getBean(WorkerRepository.class);

        for(int i = 1; i< 5; i++) {
            Worker worker = new Worker();
            worker.setId((long) i);
            worker.setName("Ib" + i);
            worker.setNamePC("PC-" + worker.getName());
            worker.setNameSubdivision("ib");
            worker.setLogin("Ib" + i);
            worker.setPassword("Ib" + i);
            workerRepository.save(worker);

        }
        for(int i = 5; i< 10; i++) {
            Worker worker = new Worker();
            worker.setId((long) i);
            worker.setName("It" + i);
            worker.setNamePC("PC-" + worker.getName());
            worker.setNameSubdivision("it");
            worker.setLogin("It" + i);
            worker.setPassword("It" + i);
            workerRepository.save(worker);
        }
        for(int i = 10; i< 15; i++) {
            Worker worker = new Worker();
            worker.setId((long) i);
            worker.setName("odo" + i);
            worker.setNamePC("PC-" + worker.getName());
            worker.setNameSubdivision("odo");
            worker.setLogin("odo" + i);
            worker.setPassword("odo" + i);
            workerRepository.save(worker);

        }
        for(int i = 15; i< 20; i++) {
            Worker worker = new Worker();
            worker.setId((long) i);
            worker.setName("yxo" + i);
            worker.setNamePC("PC-" + worker.getName());
            worker.setNameSubdivision("yxo");
            worker.setLogin("yxo" + i);
            worker.setPassword("yxo" + i);
            workerRepository.save(worker);

        }

    }
}