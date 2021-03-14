package br.com.lucas.hrworker.ports;

import org.springframework.stereotype.Component;

import br.com.lucas.hrworker.dto.WorkerDTO;

@Component
public interface WorkerDatabaseRecuperaPeloId {

	WorkerDTO execute(Long id);
}
