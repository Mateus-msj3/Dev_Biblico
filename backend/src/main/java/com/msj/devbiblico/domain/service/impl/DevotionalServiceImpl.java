package com.msj.devbiblico.domain.service.impl;

import com.msj.devbiblico.domain.exception.ObjectNotFoundException;
import com.msj.devbiblico.domain.model.Devotional;
import com.msj.devbiblico.domain.repository.DevotionalRepository;
import com.msj.devbiblico.domain.service.DevotionalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DevotionalServiceImpl implements DevotionalService {

    @Autowired
    private DevotionalRepository devotionalRepository;

    public List<Devotional> findAll() {
        return  devotionalRepository.findAll();
    }

    public Devotional findById(Long id) {
        Optional<Devotional> devotional = devotionalRepository.findById(id);
        if(devotional.isPresent()) {
            return devotional.get();
        }
        return devotional.orElseThrow(()-> new ObjectNotFoundException("Devocional não encontrado"));
    }

    public Devotional save(Devotional devotional) {

        return devotionalRepository.save(devotional);
    }

    public Devotional update(Devotional devotional) {
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
