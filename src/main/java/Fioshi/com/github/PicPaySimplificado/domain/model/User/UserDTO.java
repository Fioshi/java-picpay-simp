package Fioshi.com.github.PicPaySimplificado.domain.model.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(
        @NotBlank
        String name,

        @NotBlank
        String surname,

        @NotBlank
        String cpf,

        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotNull
        TypeUser typeUser

) {



}
