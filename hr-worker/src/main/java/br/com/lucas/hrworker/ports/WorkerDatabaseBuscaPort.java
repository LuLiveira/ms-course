package br.com.lucas.hrworker.ports;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.lucas.hrworker.dto.WorkerDTO;

@Component
public interface WorkerDatabaseBuscaPort {

	List<WorkerDTO> execute();
}
