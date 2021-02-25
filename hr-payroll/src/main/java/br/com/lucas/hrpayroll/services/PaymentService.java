package br.com.lucas.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.lucas.hrpayroll.clients.WorkerClient;
import br.com.lucas.hrpayroll.dto.WorkerDTO;
import br.com.lucas.hrpayroll.vo.PaymentVo;

@Service
public class PaymentService {

	private WorkerClient client;

	public PaymentService(WorkerClient client) {
		this.client = client;
	}
	
	public PaymentVo getPayment(final long workerId, final int days) {
		WorkerDTO workerDTO = client.findById(workerId).getBody();
		return new PaymentVo(workerDTO.getName(), workerDTO.getDailyIncome(), days);
	}
}	
