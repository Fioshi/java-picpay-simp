package Fioshi.com.github.PicPaySimplificado.domain.model.Account;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AccountDTO(

        @NotNull
        Long id,

        @NotNull
        BigDecimal balance,

        @NotNull
        User user

) {
}
