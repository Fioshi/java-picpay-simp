package Fioshi.com.github.PicPaySimplificado.domain.model.Payment;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.UserDtoGet;
import jakarta.validation.constraints.NotNull;

public record PaymentDTOGet(

        Long id,

        Double value,

        UserDtoGet payer,

        UserDtoGet payee
) {
    public PaymentDTOGet(Payment payment){
        this(payment.getId(), payment.getValue(), new UserDtoGet(payment.getPayer().getUser()), new UserDtoGet(payment.getPayee().getUser()));
    }
}
