package ru.api;

import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.model.Worker;
import ru.repository.WorkerRepository;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerRepository repository;


    @GetMapping()
    public ResponseEntity<List<Worker>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping()
    public void createWorker(@PathVariable long id, Worker worker) {
        repository.save(worker);
    }

    @PutMapping()
    public void updateWorker(@PathVariable long id, Worker worker) {
        Worker oldWorker = repository.getById(id);
        if (oldWorker == null) {
            throw new RuntimeException("Данного пользователя нет");
        }
        repository.save(worker);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).orElseThrow());
    }

    @GetMapping("/odo")
    public ResponseEntity<List<Worker>> getAllOdo() {
        return ResponseEntity.ok(repository.findByNameSubdivision("odo"));
    }
    @GetMapping("/yxo")
    public ResponseEntity<List<Worker>> getAllYxo() {
        return ResponseEntity.ok(repository.findByNameSubdivision("yxo"));
    }
    @PostMapping
    public ResponseEntity<Worker> save(@RequestBody Worker worker) {
        return ResponseEntity.ok(repository.save(worker));
    }

}
