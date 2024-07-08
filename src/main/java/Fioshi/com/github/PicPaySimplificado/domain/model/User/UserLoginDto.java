package Fioshi.com.github.PicPaySimplificado.domain.model.User;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDto(@NotBlank
                           String email,

                           @NotBlank
                           String password) {
}
