package Fioshi.com.github.PicPaySimplificado.service;

import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.Payment;
import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.PaymentDTO;
import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.validations.PaymentValidation;
import Fioshi.com.github.PicPaySimplificado.domain.repository.AccountRepository;
import Fioshi.com.github.PicPaySimplificado.domain.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private NotifyService notifyService;

    @Autowired
    private List<PaymentValidation> validations;

    @Transactional
    public void payment(PaymentDTO dto){

        var payee = accountRepository.getReferenceById(dto.payee());
        var payer = accountRepository.getReferenceById(dto.payer());
        var payment = new Payment();

        payment.dtoToEntity(dto.value(), payee, payer);

        /*
         * Realiza validações de pagamento
         */
        validations.forEach(v -> v.validation(payment.getValue(), payee, payer));

        paymentRepository.save(payment);

        accountService.updateValues(payment.getValue(), payee, payer);
    }
}
