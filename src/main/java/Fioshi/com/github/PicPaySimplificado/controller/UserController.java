package Fioshi.com.github.PicPaySimplificado.controller;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.dto.UserDto;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.dto.UserLoginDto;
import Fioshi.com.github.PicPaySimplificado.domain.service.TokenService;
import Fioshi.com.github.PicPaySimplificado.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/picpay/user")
public class UserController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("subscribe")
    public ResponseEntity<String> subscribe(@RequestBody UserDto dto) throws IOException {
        userService.insert(dto);
        return ResponseEntity.ok("Criado com sucesso");
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody @Valid UserLoginDto dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto. email(), dto.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(tokenJWT);
    }
}
