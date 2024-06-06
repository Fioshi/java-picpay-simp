package Fioshi.com.github.PicPaySimplificado.service;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.TypeUser;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import Fioshi.com.github.PicPaySimplificado.domain.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void insert(User user){
        var account = new Account(user);
        accountRepository.save(account);
    }

    @Transactional
    public void updateValues(Double value, Account payee, Account payer){

        payer.transfer(new BigDecimal(value));
        payee.receive(new BigDecimal(value));

        accountRepository.save(payee);
        accountRepository.save(payer);
    }

}
