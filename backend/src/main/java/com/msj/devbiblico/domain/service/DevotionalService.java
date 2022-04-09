package com.msj.devbiblico.domain.service;

import com.msj.devbiblico.domain.model.Devotional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DevotionalService {

    public List<Devotional> findAll();

    public Devotional findById(Long id);

    public Devotional save(Devotional devotional);

    public Devotional update(Devotional devotional);

    public void delete(Long id);

}
