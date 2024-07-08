package Fioshi.com.github.PicPaySimplificado.domain.repository;

import Fioshi.com.github.PicPaySimplificado.domain.model.Payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findAllByPayerId(Long id);
}
