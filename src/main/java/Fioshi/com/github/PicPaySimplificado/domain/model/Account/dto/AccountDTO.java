package Fioshi.com.github.PicPaySimplificado.domain.model.Account.dto;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.dto.UserDtoGet;
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
