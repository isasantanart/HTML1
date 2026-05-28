package com.petz.petshop.repository;

import com.petz.petshop.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Basta adicionar esta linha. O Spring entende que deve fazer: 
    // SELECT * FROM usuarios WHERE email = ?
    Usuario findByEmail(String email);
}