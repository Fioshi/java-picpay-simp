package Fioshi.com.github.PicPaySimplificado.controller;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.dto.AccountDTO;
import Fioshi.com.github.PicPaySimplificado.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/picpay/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<AccountDTO> getCurrentAccount(){
        var account = accountService.getAccount();
        return ResponseEntity.ok(new AccountDTO(account));
    }
}
