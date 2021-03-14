package br.com.lucas.hrworker.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.lucas.hrworker.dto.WorkerDTO;

@Component
public interface RecuperaTudoWorkerUseCase {

	List<WorkerDTO> execute();
}
