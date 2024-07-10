package Fioshi.com.github.PicPaySimplificado.domain.model.validations.subscribe;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.dto.UserDto;
import Fioshi.com.github.PicPaySimplificado.domain.repository.UserRepository;
import Fioshi.com.github.PicPaySimplificado.infra.exception.SubscribeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationCPF implements SubscribeValidation {

    @Autowired
    private UserRepository repository;

    @Override
    public void validation(UserDto dto) {
        if (repository.existsByCpf(dto.cpf()))
            throw new SubscribeException("Cpf já cadastrado");
    }
}
