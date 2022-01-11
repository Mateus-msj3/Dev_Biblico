package com.msj.devbiblico.repository;

import com.msj.devbiblico.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
