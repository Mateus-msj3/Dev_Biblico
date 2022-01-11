package com.msj.devbiblico.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasProfile('USUARIO') or hasProfile('MODERADOR') or hasProfile('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasProfile('MODERATOR')")
    public String moderatorAccess() {
        return "Moderador Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasProfile('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
