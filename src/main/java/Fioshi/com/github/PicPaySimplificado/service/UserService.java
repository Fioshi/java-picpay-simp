package Fioshi.com.github.PicPaySimplificado.service;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.UserDTO;
import Fioshi.com.github.PicPaySimplificado.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private NotifyService notifyService;

    public void insert(UserDTO dto) throws IOException {

        var user = new User();
        user.dtoToEntity(dto);
        repository.save(user);

        accountService.insert(user);
    }
}
