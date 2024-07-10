package Fioshi.com.github.PicPaySimplificado.domain.service;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.dto.UserDto;
import Fioshi.com.github.PicPaySimplificado.domain.model.validations.subscribe.SubscribeValidation;
import Fioshi.com.github.PicPaySimplificado.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private NotifyService notifyService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private List<SubscribeValidation> validations;

    public void insert(UserDto dto) throws IOException {

        validations.forEach(v -> v.validation(dto));

        var user = new User();
        user.dtoToEntity(dto, encoder);
        repository.save(user);

        accountService.insert(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByEmail(username);
    }
}