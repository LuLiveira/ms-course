package br.com.lucas.hrpayroll.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lucas.hrpayroll.dto.WorkerDTO;

@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerClient {

	@RequestMapping("/{id}")
	ResponseEntity<WorkerDTO> findById(@PathVariable long id);
}
