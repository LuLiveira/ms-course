package br.com.lucas.hrworker.usecase.impl;

import org.springframework.stereotype.Service;

import br.com.lucas.hrworker.dto.WorkerDTO;
import br.com.lucas.hrworker.ports.WorkerDatabaseRecuperaPeloId;
import br.com.lucas.hrworker.usecase.RecuperaWorkerPeloIdUseCase;

@Service
public class RecuperaWorkerPeloIdUseCaseImpl implements RecuperaWorkerPeloIdUseCase {

	private WorkerDatabaseRecuperaPeloId workerDatabaseRecuperaPeloId;
	
	public RecuperaWorkerPeloIdUseCaseImpl(WorkerDatabaseRecuperaPeloId workerDatabaseRecuperaPeloId) {
		this.workerDatabaseRecuperaPeloId = workerDatabaseRecuperaPeloId;
	}
	
	@Override
	public WorkerDTO execute(final Long id) {
		return workerDatabaseRecuperaPeloId.execute(id);
	}

}
