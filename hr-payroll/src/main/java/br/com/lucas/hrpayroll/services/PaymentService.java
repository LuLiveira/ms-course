package br.com.lucas.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.lucas.hrpayroll.clients.WorkerClient;
import br.com.lucas.hrpayroll.dto.PaymentDTO;
import br.com.lucas.hrpayroll.dto.WorkerDTO;

@Service
public class PaymentService {

	private WorkerClient client;

	public PaymentService(WorkerClient client) {
		this.client = client;
	}
	
	public PaymentDTO getPayment(final long workerId, final int days) {
		WorkerDTO workerDTO = client.findById(workerId);
		return new PaymentDTO(workerDTO.getName(), workerDTO.getDailyIncome(), days);
	}
}
