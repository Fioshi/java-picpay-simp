package Fioshi.com.github.PicPaySimplificado.domain.model.Payment.dto;

import jakarta.validation.constraints.NotNull;

public record PaymentDTO(

        @NotNull
        Double value,

        @NotNull
        Long payer,

        @NotNull
        Long payee

) {
}
