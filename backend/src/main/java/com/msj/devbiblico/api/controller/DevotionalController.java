package com.msj.devbiblico.api.controller;

import com.msj.devbiblico.domain.model.Devotional;
import com.msj.devbiblico.domain.service.DevotionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/devotional")
public class DevotionalController {

    @Autowired
    private DevotionalService devotionalService;

    @GetMapping
    public List<Devotional> allDevotionals() {
        return devotionalService.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Devotional> findById(@PathVariable Long id) {
        Devotional devotional = devotionalService.devotionalId(id);
        return ResponseEntity.ok().body(devotional);
    }

    @PostMapping
    public ResponseEntity<Devotional> saveDevotional(@Valid @RequestBody Devotional devotional) {
        devotional = devotionalService.create(devotional);
        return ResponseEntity.status(HttpStatus.CREATED).body(devotional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Devotional> update(@PathVariable Long id, @RequestBody Devotional devotional) {
        devotional.setId(id);
        devotional = devotionalService.alter(devotional);
        return ResponseEntity.ok(devotional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        devotionalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
