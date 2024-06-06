package Fioshi.com.github.PicPaySimplificado.controller;

import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.PaymentDTO;
import Fioshi.com.github.PicPaySimplificado.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/picpay/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public void payment(@RequestBody PaymentDTO dto){
        service.payment(dto);

    }

}
