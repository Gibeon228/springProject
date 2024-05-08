package ru.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.model.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    List<Worker> findByName(String name);
    List<Worker> findByNamePC(String namePC);
    List<Worker> findByNameSubdivision(String nameSubdivision);
    Worker findById(long id);

    Optional<Worker> findByLogin(String login);

}
