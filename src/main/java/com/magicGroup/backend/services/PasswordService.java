/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jhonn
 */

@Service
public class PasswordService {

    private final PasswordEncoder passwordEncoder;

    public PasswordService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // Método principal
    public String encodePasswordIfNeeded(String rawPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("Password no puede ser null");
        }
        if (isBCryptHash(rawPassword)) {
            return rawPassword;
        }
        return encodePassword(rawPassword);
    }

    // Métodos Auxiliares
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean isBCryptHash(String password) {
        return password.startsWith("$2a$") || 
                password.startsWith("$2b$") || 
                password.startsWith("$2y$");
    }
    
    // Método de Comparacion de contraseña
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}