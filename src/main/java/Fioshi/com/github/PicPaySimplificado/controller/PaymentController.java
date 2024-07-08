package Fioshi.com.github.PicPaySimplificado.controller;

import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.PaymentDTO;
import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.PaymentDTOGet;
import Fioshi.com.github.PicPaySimplificado.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/picpay/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public void payment(@RequestBody PaymentDTO dto) throws IOException {
        service.payment(dto);
    }

    @GetMapping("payer/{payer}")
    public ResponseEntity<List<PaymentDTOGet>> getPayments(@PathVariable Long payer){
        var payments = service.getPayments(payer);
        return ResponseEntity.ok(payments);
    }
}
