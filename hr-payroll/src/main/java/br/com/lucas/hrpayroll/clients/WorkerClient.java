package br.com.lucas.hrpayroll.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lucas.hrpayroll.dto.WorkerDTO;

@FeignClient(name = "hr-worker", url = "http://localhost:8081")
public interface WorkerClient {

	@RequestMapping("/workers/{id}")
	WorkerDTO findById(@PathVariable long id);
}
