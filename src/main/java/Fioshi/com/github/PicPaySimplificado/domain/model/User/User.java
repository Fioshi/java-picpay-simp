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
    @Column(name = "user_id")
    private long id;

    private String name;
    private String surname;

    private String cpf;
    private String email;
    private String password;
    private TypeUser typeUser;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    @OneToMany(mappedBy = "payer")
    private List<Payment> paymentsAsPayer;

    @OneToMany(mappedBy = "payee")
    private List<Payment> paymentsAsPayee;
    

}
