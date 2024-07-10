package Fioshi.com.github.PicPaySimplificado.infra.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class SubscribeException extends RuntimeException {

    public SubscribeException(String message){
        super(message);
    }

}
