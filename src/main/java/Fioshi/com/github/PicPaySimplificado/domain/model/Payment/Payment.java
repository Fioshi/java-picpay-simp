package Fioshi.com.github.PicPaySimplificado.domain.model.Payment;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.TypeUser;
import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_payment")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    @ManyToOne
    @JoinColumn(name = "payer_id", nullable = false)
    private Account payer;

    @ManyToOne
    @JoinColumn(name = "payee_id", nullable = false)
    private Account payee;

    public void dtoToEntity(Double value, Account payee, Account payer){
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }

    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public Account getPayer() {
        return payer;
    }

    public Account getPayee() {
        return payee;
    }
}