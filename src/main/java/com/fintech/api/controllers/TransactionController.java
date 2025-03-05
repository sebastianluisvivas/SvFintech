package com.fintech.api.controllers;

import com.fintech.api.models.Transaction;
import com.fintech.api.models.User;
import com.fintech.api.repositories.SvFintechRepository;
import com.fintech.api.repositories.TransactionRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
    
      @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private SvFintechRepository userRepository; // Repositorio de User
    
    
     // Obtener todas las transacciones de un usuario
    @CrossOrigin
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable Long userId) {
        if (!userRepository.existsById(userId)) {
            return ResponseEntity.notFound().build();
        }
        List<Transaction> transactions = transactionRepository.findByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
    
    
    
    
    // Crear una nueva transacción
    @CrossOrigin
@PostMapping("/{userId}")
    public ResponseEntity<Transaction> createTransaction(
            @PathVariable Long userId,
            @RequestBody Transaction transaction) {
        
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        User user = userOptional.get();
        transaction.setUser(user);
        transaction.setDate(LocalDateTime.now());
        
        Transaction savedTransaction = transactionRepository.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
    }
    
    
}
