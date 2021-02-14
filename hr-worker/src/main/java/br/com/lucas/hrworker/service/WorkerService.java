package br.com.lucas.hrworker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.lucas.hrworker.entities.Worker;
import br.com.lucas.hrworker.entities.dto.WorkerDTO;
import br.com.lucas.hrworker.repositories.WorkerRepository;
import br.com.lucas.hrworker.service.exceptions.UserNotFoundException;

@Service
public class WorkerService {
    
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<WorkerDTO> findAll(){
        var workers = workerRepository.findAll();
        // var workerDTOs = workers.stream().map(Worker::toDTO).collect(Collectors.toList());
        var workerDTOs = workers.stream().map(worker -> new WorkerDTO(worker.getName(), worker.getDailyIncome())).collect(Collectors.toList());

        return workerDTOs;
    }

    public WorkerDTO findById(Long id){
        var workerById = workerRepository.findById(id);

        Worker worker = workerById.orElseThrow(() -> new UserNotFoundException("User not found."));

        return new WorkerDTO(worker.getName(), worker.getDailyIncome());
    }
}


