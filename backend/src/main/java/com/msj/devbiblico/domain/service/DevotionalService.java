package com.msj.devbiblico.domain.service;

import com.msj.devbiblico.domain.exception.ObjectNotFoundException;
import com.msj.devbiblico.domain.model.Devotional;
import com.msj.devbiblico.domain.repository.DevotionalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DevotionalService {

    @Autowired
    private DevotionalRepository devotionalRepository;

    public List<Devotional> all() {
        return  devotionalRepository.findAll();
    }

    public Devotional devotionalId(Long id) {
        Optional<Devotional> devotional = devotionalRepository.findById(id);
        if(devotional.isPresent()) {
            return devotional.get();
        }
        return devotional.orElseThrow(()-> new ObjectNotFoundException("Devocional não encontrado"));
    }

    public Devotional create(Devotional devotional) {

//        Long bookId = devotional.getBook().getId();

//        Book book = bookRepository.findById(bookId)
//                .orElseThrow(() -> new ObjectNotFoundException(
//                        String.format("Não existe cadastro de livro com código %d", bookId)));
//
//        devotional.setBook(book);

        return devotionalRepository.save(devotional);
    }

    public Devotional alter(Devotional devotional) {
        try {
            Optional<Devotional> currentDevotional = devotionalRepository.findById(devotional.getId());
            if (currentDevotional != null) {
                BeanUtils.copyProperties(devotional, currentDevotional.get(), "id");
            }
            return devotionalRepository.save(devotional);
        } catch(NoSuchElementException e) {
            throw new ObjectNotFoundException("Devocional não encontrado");
        }
    }

    public void delete(Long id) {
        try {
            devotionalRepository.deleteById(id);

        }catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException(String.format("Não existe devocional com o código %d", id));
        }
    }


}
