package br.com.lucas.hrworker.usecase;

import org.springframework.stereotype.Component;

import br.com.lucas.hrworker.dto.WorkerDTO;

@Component
public interface RecuperaWorkerPeloIdUseCase {

	WorkerDTO execute(Long id);
}
