/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.services;

import com.magicGroup.backend.model.Usuario;
import com.magicGroup.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Jhonn
 */

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;
    
    public UsuarioService(UsuarioRepository usuarioRepository,
    PasswordService passwordService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordService = passwordService;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        String rawPassword = usuario.getPassword();
        String finalPassword = passwordService.encodePasswordIfNeeded(rawPassword);
        usuario.setPassword(finalPassword);
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Integer id, Usuario usuarioActualizado) {
        usuarioActualizado.setId(id);
        return usuarioRepository.save(usuarioActualizado);
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
