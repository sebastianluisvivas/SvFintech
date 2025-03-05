package com.fintech.api.controllers;

import com.fintech.api.models.User;
import com.fintech.api.repositories.SvFintechRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Gestión de Usuarios", description = "Operaciones CRUD para usuarios") // Documenta el controlador
public class FintechController {

    @Autowired
    private SvFintechRepository svFintechRepository;

        
    
    
    @CrossOrigin
    @GetMapping("/users")
    @Operation(
            summary = "Obtener todos los usuarios",
            description = "Devuelve una lista completa de usuarios registrados en el sistema"
    )
    @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida exitosamente")
    public List<User> getAllUsers() {
        return svFintechRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener un usuario por ID",
            description = "Busca un usuario específico usando su ID único"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
       public ResponseEntity<User> getUserById(
               @Parameter(description = "ID del usuario", example = "123")
               @PathVariable Long id 
       ){
        Optional<User> user = svFintechRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
       
       
        @CrossOrigin
        @PostMapping
        @Operation(summary = "Crear un nuevo usuario", description = "Registra un nuevo usuario en la base de datos")
        @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos del usuario inválidos")
        })
        public ResponseEntity<User> createUser(
                @io.swagger.v3.oas.annotations.parameters.RequestBody(
                   description = "Datos del usuario a crear",
                   required = true
            )
        @org.springframework.web.bind.annotation.RequestBody User user  // Dos anotaciones separadas
    ) {
        User savedUser = svFintechRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

            
            
            
        @CrossOrigin
        @DeleteMapping("/{id}")
        @Operation(
                summary = "Eliminar un usuario",
                description = "Elimina un usuario existente usando su ID"
        )
        @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuario eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
        })
        public ResponseEntity<Void> deleteUser(
        @Parameter(description = "ID del usuario a eliminar", example = "123") @PathVariable Long id
    ) {
        if (!svFintechRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        svFintechRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
        
        

        @CrossOrigin
        @PutMapping("/{id}")

        @Operation(
                summary = "Actualizar un usuario",
                description = "Actualiza los datos de un usuario existente usando su ID"
        )
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
        })
        
        
public ResponseEntity<User> updateUser(
        @Parameter(description = "ID del usuario a actualizar", example = "123") 
        @PathVariable Long id,  // Solo UN @PathVariable
        
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos actualizados del usuario",
            required = true
        )
        @org.springframework.web.bind.annotation.RequestBody User updatedUser
    ) {
        if (!svFintechRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedUser.setId(id);
        User savedUser = svFintechRepository.save(updatedUser);
        return ResponseEntity.ok(savedUser);
    }
}