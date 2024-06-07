package Fioshi.com.github.PicPaySimplificado.infra.configuration;

import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.validations.PaymentValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class BeanValidations {

    @Bean
    public List<PaymentValidation> myList() {
        return new LinkedList<>();
    }

}
