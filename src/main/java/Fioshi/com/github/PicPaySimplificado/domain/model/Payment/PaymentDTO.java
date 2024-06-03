package Fioshi.com.github.PicPaySimplificado.domain.model.Payment;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import jakarta.validation.constraints.NotNull;

public record PaymentDTO(

        @NotNull
        Long id,

        @NotNull
        Double value,

        @NotNull
        Long payer,

        @NotNull
        Long payee

) {
}
