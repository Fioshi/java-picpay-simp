package Fioshi.com.github.PicPaySimplificado.domain.model.Payment.validations.postPayment;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.infra.exception.AuthorizationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidationPostBalance implements PaymentValidationPost {

    @Override
    public void validation(Double value, Account payee, Account payer) {
        if (new BigDecimal(value).compareTo(payer.getBalance()) > 0) {
            throw new AuthorizationException("Não há dinheiro suficiente na conta");
        }

    }
}
