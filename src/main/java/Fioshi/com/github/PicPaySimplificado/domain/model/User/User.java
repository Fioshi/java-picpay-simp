package Fioshi.com.github.PicPaySimplificado.domain.model.User;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class User {

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


    public void dtoToEntity(UserDTO dto) {
        this.name = dto.name();
        this.surname = dto.surname();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.password = dto.password();
        this.typeUser = dto.typeUser();
    }
}
