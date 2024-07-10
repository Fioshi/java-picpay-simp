package Fioshi.com.github.PicPaySimplificado.service;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.domain.model.Account.AccountDTO;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import Fioshi.com.github.PicPaySimplificado.domain.repository.AccountRepository;
import Fioshi.com.github.PicPaySimplificado.domain.repository.UserRepository;
import Fioshi.com.github.PicPaySimplificado.infra.Security.AuthenticateFacade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticateFacade facade;

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

    public List<AccountDTO> getAllAccounts(){
        return accountRepository.findAll().stream().map(AccountDTO::new).toList();
    }

    public Account getAccount () {
        var user = userRepository.findByEmail(facade.getCurrentUser());
        return accountRepository.getReferenceById(user.getAccount().getId());
    }
}
