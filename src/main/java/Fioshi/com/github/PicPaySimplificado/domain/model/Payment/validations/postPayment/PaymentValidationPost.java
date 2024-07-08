package Fioshi.com.github.PicPaySimplificado.domain.model.Payment.validations.postPayment;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;


public interface PaymentValidationPost {

    void validation(Double value, Account payee, Account payer);

}
