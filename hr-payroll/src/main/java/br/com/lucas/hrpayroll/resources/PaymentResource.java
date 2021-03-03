package br.com.lucas.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.lucas.hrpayroll.services.PaymentService;
import br.com.lucas.hrpayroll.vo.PaymentVo;

@RestController
@RequestMapping("/payments")
public class PaymentResource {
	
	private final PaymentService paymentService;

	public PaymentResource(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@HystrixCommand(fallbackMethod = "getPaymentByWorkerIdFallback")
	@GetMapping("/workers/{id}")
	public ResponseEntity<PaymentVo> getPaymentByWorkerId(@PathVariable Long id, @RequestParam(defaultValue = "0", required = false, name = "days") Integer days){
		return ResponseEntity.ok(paymentService.getPayment(id, days));
	}
	
	public ResponseEntity<PaymentVo> getPaymentByWorkerIdFallback(Long id, Integer days){
		return ResponseEntity.ok(new PaymentVo("Lucas Fallback", 100.0, 31));
	}
}
