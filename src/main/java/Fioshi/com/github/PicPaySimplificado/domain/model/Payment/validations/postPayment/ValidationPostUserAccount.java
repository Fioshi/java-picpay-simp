package Fioshi.com.github.PicPaySimplificado.domain.model.Payment.validations.postPayment;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.infra.Security.AuthenticateFacade;
import Fioshi.com.github.PicPaySimplificado.infra.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidationPostUserAccount implements PaymentValidationPost {

    @Autowired
    private AuthenticateFacade facade;

    @Override
    public void validation(Double value, Account payee, Account payer) {
        if (!Objects.equals(facade.getCurrentUser(), payer.getUser().getEmail()))
            throw new AuthorizationException("Usuario diferente do conectado");
    }
}
