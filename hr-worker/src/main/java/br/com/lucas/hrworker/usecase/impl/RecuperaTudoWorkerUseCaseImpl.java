package br.com.lucas.hrworker.usecase.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lucas.hrworker.dto.WorkerDTO;
import br.com.lucas.hrworker.ports.WorkerDatabaseBuscaPort;
import br.com.lucas.hrworker.usecase.RecuperaTudoWorkerUseCase;

@Service
public class RecuperaTudoWorkerUseCaseImpl implements RecuperaTudoWorkerUseCase {

	private final WorkerDatabaseBuscaPort workerDatabaseBuscaPort;

	public RecuperaTudoWorkerUseCaseImpl(WorkerDatabaseBuscaPort workerDatabaseBuscaPort) {
		this.workerDatabaseBuscaPort = workerDatabaseBuscaPort;
	}
	
	@Override
	public List<WorkerDTO> execute() {
		return workerDatabaseBuscaPort.execute();
		
	}

}
