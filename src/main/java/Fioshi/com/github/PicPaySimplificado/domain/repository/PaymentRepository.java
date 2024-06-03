package Fioshi.com.github.PicPaySimplificado.domain.repository;

import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
