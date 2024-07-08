package Fioshi.com.github.PicPaySimplificado.domain.model.Payment.validations.getPayment;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.infra.Security.AuthenticateFacade;
import Fioshi.com.github.PicPaySimplificado.infra.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidationGetUserAccount implements PaymentValidationGet {

    @Autowired
    private AuthenticateFacade facade;

    @Override
    public void validation(Account payer) {
        if (!Objects.equals(facade.getCurrentUser(), payer.getUser().getEmail()))
            throw new AuthorizationException("Usuario diferente do conectado");
    }
}
