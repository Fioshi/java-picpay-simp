package Fioshi.com.github.PicPaySimplificado.controller;

import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.dto.PaymentDTO;
import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.dto.PaymentDTOGet;
import Fioshi.com.github.PicPaySimplificado.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/picpay/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<String> payment(@RequestBody PaymentDTO dto) throws ExecutionException, InterruptedException {
        var result = service.payment(dto).get();
        return ResponseEntity.ok(result);
    }

    @GetMapping("all")
    public ResponseEntity<List<PaymentDTOGet>> getPayments(){
        var payments = service.getPayments();
        return ResponseEntity.ok(payments);
    }
}
