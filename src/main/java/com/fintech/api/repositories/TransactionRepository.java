
package com.fintech.api.repositories;
    
import com.fintech.api.models.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        List<Transaction> findByUserId(Long userId);

}
