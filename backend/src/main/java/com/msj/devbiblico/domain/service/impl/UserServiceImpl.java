package com.msj.devbiblico.domain.service.impl;

import com.msj.devbiblico.domain.exception.EmailCreatedException;
import com.msj.devbiblico.domain.exception.ObjectNotFoundException;
import com.msj.devbiblico.domain.exception.UserCreatedException;
import com.msj.devbiblico.domain.model.User;
import com.msj.devbiblico.domain.repository.UserRepository;
import com.msj.devbiblico.domain.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }


    public User save(User user) {
        boolean existsUsername = userRepository.existsByUsername(user.getUsername());

        if (existsUsername) {
            throw new UserCreatedException("Este nome Já está em uso " + user.getUsername());
        }

        boolean existsEmail = userRepository.existsByEmail(user.getEmail());

        if (existsEmail) {
            throw new EmailCreatedException("Este email Já está em uso " + user.getEmail());
        }

        return userRepository.save(user);
    }

    public User update(User user) {
        try {
            Optional<User> currentUser = userRepository.findById(user.getId());
            if (currentUser != null) {
                BeanUtils.copyProperties(user, currentUser.get(), "id");
            }
            return userRepository.save(user);
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("User não encontrado");
        }
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException(String.format("Não existe usúario com o código %d", id));
        }
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        return user.orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));
    }

}
