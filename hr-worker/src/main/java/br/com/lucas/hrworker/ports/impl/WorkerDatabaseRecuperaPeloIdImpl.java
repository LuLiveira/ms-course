package br.com.lucas.hrworker.ports.impl;

import br.com.lucas.hrworker.adapters.saida.WorkerRepository;
import br.com.lucas.hrworker.dto.WorkerDTO;
import br.com.lucas.hrworker.ports.WorkerDatabaseRecuperaPeloId;
import br.com.lucas.hrworker.service.exceptions.UserNotFoundException;

public class WorkerDatabaseRecuperaPeloIdImpl implements WorkerDatabaseRecuperaPeloId {
	
	private final WorkerRepository workerRepository;
	
	public WorkerDatabaseRecuperaPeloIdImpl(WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}
	
	@Override
	public WorkerDTO execute(Long id) {
        var workerById = workerRepository.findById(id);
        var worker = workerById.orElseThrow(() -> new UserNotFoundException("User not found."));

        return new WorkerDTO(worker.getName(), worker.getDailyIncome());
	}

}
