package com.msj.devbiblico.domain.service;

import com.msj.devbiblico.domain.exception.EmailCreatedException;
import com.msj.devbiblico.domain.exception.ObjectNotFoundException;
import com.msj.devbiblico.domain.exception.UserCreatedException;
import com.msj.devbiblico.domain.model.Role;
import com.msj.devbiblico.domain.model.User;
import com.msj.devbiblico.domain.repository.RoleRepository;
import com.msj.devbiblico.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> all() {
        return  userRepository.findAll();
    }

    public User create(User user) {
        boolean existsUsername = userRepository.existsByUsername(user.getUsername());

        if (existsUsername) {
            throw new UserCreatedException("Este nome Já está em uso " + user.getUsername());
        }

        boolean existsEmail = userRepository.existsByEmail(user.getEmail());

        if (existsEmail) {
            throw new EmailCreatedException("Este email Já está em uso " + user.getEmail());
        }

        Long roleId = user.getRole().getId();
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("Não existe cadastro de perfil com código %d", roleId)));
        user.setRole(role);

        return userRepository.save(user);
    }


}
