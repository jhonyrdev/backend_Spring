/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.config;

import com.magicGroup.backend.model.Usuario;
import com.magicGroup.backend.repository.UsuarioRepository;
import com.magicGroup.backend.services.PasswordService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Jhonn
 */

@Component
public class MigrationPassword implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;

    public MigrationPassword(UsuarioRepository usuarioRepository, 
            PasswordService passwordService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordService = passwordService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🔄 Verificando contraseñas antiguas...");

        List<Usuario> usuarios = usuarioRepository.findAll();
        int actualizados = 0;

        for (Usuario usuario : usuarios) {
            String currentPassword = usuario.getPassword();

            // Si no está encriptada, la encriptamos y guardamos
            if (!passwordService.isBCryptHash(currentPassword)) {
                String newPassword = passwordService.encodePassword(currentPassword);
                usuario.setPassword(newPassword);
                usuarioRepository.save(usuario);
                actualizados++;
                System.out.println("✅ Contraseña actualizada para usuario: " + usuario.getEmail());
            }
        }

        if (actualizados == 0) {
            System.out.println("✅ Todas las contraseñas ya estaban encriptadas.");
        } else {
            System.out.println("🔐 Contraseñas actualizadas: " + actualizados);
        }
    }
}