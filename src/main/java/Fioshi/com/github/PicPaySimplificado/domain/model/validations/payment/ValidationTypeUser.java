package Fioshi.com.github.PicPaySimplificado.domain.model.validations.payment;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.TypeUser;
import Fioshi.com.github.PicPaySimplificado.infra.exception.AuthorizationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class ValidationTypeUser implements PaymentValidation {

    @Override
    public void validation(Double value, Account payee, Account payer) {
        if (payer.getUser().getTypeUser().equals(TypeUser.LOGISTICIAN))
            throw new AuthorizationException("Esse tipo de usuário não pode realizar transferencias");
    }
}
