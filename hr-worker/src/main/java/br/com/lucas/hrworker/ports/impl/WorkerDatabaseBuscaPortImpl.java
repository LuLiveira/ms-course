package br.com.lucas.hrworker.ports.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.lucas.hrworker.adapters.saida.WorkerRepository;
import br.com.lucas.hrworker.dto.WorkerDTO;
import br.com.lucas.hrworker.entities.Worker;
import br.com.lucas.hrworker.ports.WorkerDatabaseBuscaPort;

@Service
public class WorkerDatabaseBuscaPortImpl implements WorkerDatabaseBuscaPort {

	private final WorkerRepository workerRepository;
	
	public WorkerDatabaseBuscaPortImpl(WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}
	
	@Override
	public List<WorkerDTO> execute() {
		List<Worker> workers = workerRepository.findAll();
        var workerDTOs = workers.stream().map(worker -> new WorkerDTO(worker::getName, worker::getDailyIncome)).collect(Collectors.toList());
        return workerDTOs;
	}

}
