package com.msj.devbiblico.domain.service;

import com.msj.devbiblico.domain.exception.EmailCreatedException;
import com.msj.devbiblico.domain.exception.ObjectNotFoundException;
import com.msj.devbiblico.domain.exception.UserCreatedException;
import com.msj.devbiblico.domain.model.Book;
import com.msj.devbiblico.domain.model.Role;
import com.msj.devbiblico.domain.model.User;
import com.msj.devbiblico.domain.repository.RoleRepository;
import com.msj.devbiblico.domain.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> all() {
        return  userRepository.findAll();
    }

    public User userId(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        return user.orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));
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

    public User alterUser(User user) {
        try {
            Optional<User> currentUser = userRepository.findById(user.getId());
            if (currentUser.isPresent()) {
                BeanUtils.copyProperties(user, currentUser.get(), "id");
            }
            return userRepository.save(user);
        } catch(NoSuchElementException e) {
            throw new ObjectNotFoundException("User não encontrado");
        }
    }


}
