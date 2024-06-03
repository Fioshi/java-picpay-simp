package Fioshi.com.github.PicPaySimplificado.domain.model.Payment;

import Fioshi.com.github.PicPaySimplificado.domain.model.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;
    private User payer;
    private User payee;

}
