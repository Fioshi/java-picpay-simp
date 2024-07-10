package Fioshi.com.github.PicPaySimplificado.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorTreatment {

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity tratarErroRegraDeNegocio(AuthorizationException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(SubscribeException.class)
    public ResponseEntity subscribleException(SubscribeException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
