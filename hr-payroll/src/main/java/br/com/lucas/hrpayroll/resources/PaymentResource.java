package br.com.lucas.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.hrpayroll.dto.PaymentDTO;
import br.com.lucas.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {
	
	private final PaymentService paymentService;

	public PaymentResource(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping("/workers/{id}")
	public ResponseEntity<PaymentDTO> getPaymentByWorkerId(@PathVariable Long id, @RequestParam(defaultValue = "0", required = false, name = "days") Integer days){
		return ResponseEntity.ok(paymentService.getPayment(id, days));
	}
}
