package com.example.Backend.SECURITY.repositorios;

import com.example.Backend.SECURITY.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}
