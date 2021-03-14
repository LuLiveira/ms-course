package br.com.lucas.hrworker.adapters.entrada;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.hrworker.dto.WorkerDTO;
import br.com.lucas.hrworker.usecase.RecuperaTudoWorkerUseCase;
import br.com.lucas.hrworker.usecase.RecuperaWorkerPeloIdUseCase;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

	private final RecuperaTudoWorkerUseCase recuperaTudoWorkerUseCase;
	private final RecuperaWorkerPeloIdUseCase recuperaWorkerPeloIdUseCase;

	public WorkerResource(RecuperaTudoWorkerUseCase recuperaTudoWorkerUseCase, RecuperaWorkerPeloIdUseCase recuperaWorkerPeloIdUseCase) {
		this.recuperaTudoWorkerUseCase = recuperaTudoWorkerUseCase;
		this.recuperaWorkerPeloIdUseCase = recuperaWorkerPeloIdUseCase;
	}

	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll() {
		return ResponseEntity.ok(recuperaTudoWorkerUseCase.execute());
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkerDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(recuperaWorkerPeloIdUseCase.execute(id));
	}
}
