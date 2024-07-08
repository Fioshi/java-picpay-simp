package Fioshi.com.github.PicPaySimplificado.domain.model.Account;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.UserDtoGet;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AccountDTO(

        @NotNull
        Long id,

        @NotNull
        BigDecimal balance,

        @NotNull
        UserDtoGet user

) {
        public AccountDTO (Account account){
               this(account.getId(), account.getBalance(), new UserDtoGet(account.getUser()));
        }
}
