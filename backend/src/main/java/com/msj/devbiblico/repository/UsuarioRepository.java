package com.msj.devbiblico.repository;

import com.msj.devbiblico.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNomeUsuario(String nome);

    Boolean existsByNomeUsuario(String nome);

    Boolean existsByEmail(String email);
}
