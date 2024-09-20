package Fioshi.com.github.PicPaySimplificado.controller;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.dto.AccountDTO;
import Fioshi.com.github.PicPaySimplificado.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/picpay/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<AccountDTO> getCurrentAccount(UriComponentsBuilder builder) throws URISyntaxException {
        var account = accountService.getAccount();
        var uri = builder.uri(new URI("/picpay/account/{id}")).buildAndExpand(account.getUser().getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountDTO(account));
    }
}
