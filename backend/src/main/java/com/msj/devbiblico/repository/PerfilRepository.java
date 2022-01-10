package com.msj.devbiblico.repository;

import com.msj.devbiblico.model.Perfil;
import com.msj.devbiblico.model.PerfilEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByNome(PerfilEnum nome);

}
