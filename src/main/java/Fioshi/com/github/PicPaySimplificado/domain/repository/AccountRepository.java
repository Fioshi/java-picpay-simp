package Fioshi.com.github.PicPaySimplificado.domain.repository;

import Fioshi.com.github.PicPaySimplificado.domain.model.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
