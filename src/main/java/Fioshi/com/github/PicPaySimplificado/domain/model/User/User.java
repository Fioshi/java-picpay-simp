package Fioshi.com.github.PicPaySimplificado.domain.model.User;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;

    private String cpf;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;

    public void dtoToEntity(UserDto dto, PasswordEncoder encoder) {
        this.name = dto.name();
        this.surname = dto.surname();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.password = encoder.encode(dto.password());
        this.typeUser = dto.typeUser();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public Account getAccount() {
        return account;
    }
}
