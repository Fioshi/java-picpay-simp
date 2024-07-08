package Fioshi.com.github.PicPaySimplificado.service;

import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.validations.postPayment.PaymentValidationPost;
import Fioshi.com.github.PicPaySimplificado.domain.repository.AccountRepository;
import Fioshi.com.github.PicPaySimplificado.domain.repository.PaymentRepository;
import Fioshi.com.github.PicPaySimplificado.infra.Security.AuthenticateFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class PaymentServiceTest {

    @Mock
    private AuthenticateFacade facade;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountService accountService;

    @Mock
    private AuthorizationService authorizationService;

    @Mock
    private List<PaymentValidationPost> validations;

    @Autowired
    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("The payments is OK")
    void paymentCase1() {
        var payee = accountRepository.getReferenceById();
        var payer = accountRepository.getReferenceById();
    }

    @Test
    @DisplayName("The payments throw a Exception because is not allowed")
    void paymentCase2() {
    }
}