package com.fintech.api.controllers;

import com.fintech.api.models.User;
import com.fintech.api.repositories.SvFintechRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class FintechController {

    @Autowired
    private SvFintechRepository svFintechRepository;

    @CrossOrigin
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return svFintechRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = svFintechRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = svFintechRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (!svFintechRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        svFintechRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        if (!svFintechRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedUser.setId(id);
        User savedUser = svFintechRepository.save(updatedUser);
        return ResponseEntity.ok(savedUser);

    }

    
    
}
