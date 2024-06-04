package Fioshi.com.github.PicPaySimplificado.service;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import Fioshi.com.github.PicPaySimplificado.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void insert(User user){
        var account = new Account(user);
        accountRepository.save(account);
    }

}
