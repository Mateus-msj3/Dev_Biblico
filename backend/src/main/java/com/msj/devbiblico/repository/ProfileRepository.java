package com.msj.devbiblico.repository;

import com.msj.devbiblico.model.Profile;
import com.msj.devbiblico.model.ProfileEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByName(ProfileEnum name);

}
