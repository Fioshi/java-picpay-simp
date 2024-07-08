package Fioshi.com.github.PicPaySimplificado.service;

import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.Payment;
import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.PaymentDTO;
import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.PaymentDTOGet;
import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.validations.getPayment.PaymentValidationGet;
import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.validations.postPayment.PaymentValidationPost;
import Fioshi.com.github.PicPaySimplificado.domain.repository.AccountRepository;
import Fioshi.com.github.PicPaySimplificado.domain.repository.PaymentRepository;
import Fioshi.com.github.PicPaySimplificado.infra.Security.AuthenticateFacade;
import Fioshi.com.github.PicPaySimplificado.infra.exception.AuthorizationException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private AuthenticateFacade facade;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private List<PaymentValidationPost> validations;

    @Autowired
    private List<PaymentValidationGet> validationsGet;

    @Async("asyncTransaction")
    @Transactional(rollbackOn = AuthorizationException.class)
    public void payment(PaymentDTO dto) throws IOException {

        var payee = accountRepository.getReferenceById(dto.payee());
        var payer = accountRepository.getReferenceById(dto.payer());
        var payment = new Payment();

        payment.dtoToEntity(dto.value(), payee, payer);

        validations.forEach(v -> v.validation(payment.getValue(), payee, payer));

        paymentRepository.save(payment);

        accountService.updateValues(payment.getValue(), payee, payer);

        authorizationService.authorization();
    }

    public List<PaymentDTOGet> getPayments(Long id) {
        validationsGet.forEach(v -> v.validation(accountRepository.getReferenceById(id)));
        return paymentRepository.findAllByPayerId(id).stream().map(PaymentDTOGet::new).toList();
    }
}
