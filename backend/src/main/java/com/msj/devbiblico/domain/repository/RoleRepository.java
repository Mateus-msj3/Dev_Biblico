package com.msj.devbiblico.domain.repository;

import com.msj.devbiblico.domain.model.Role;
import com.msj.devbiblico.domain.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleEnum name);

}
