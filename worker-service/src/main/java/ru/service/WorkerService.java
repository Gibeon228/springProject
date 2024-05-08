package ru.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.model.Worker;
import ru.repository.WorkerRepository;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository repository;

    @Transactional
    public void renameWorker(Long id, String newName) {
        Worker worker = repository.findById(id)
                .orElseThrow();

        worker.setName(newName);
        repository.save(worker);
    }

    @Transactional
    public void renamePCWorker(Long id, String newNamePc) {
        Worker worker = repository.findById(id)
                .orElseThrow();

        worker.setNamePC(newNamePc);
        repository.save(worker);
    }

    @Transactional
    public void renameSubdivision(Long id, String newNamePc) {
        Worker worker = repository.findById(id)
                .orElseThrow();

        worker.setNameSubdivision(newNamePc);
        repository.save(worker);
    }
}
