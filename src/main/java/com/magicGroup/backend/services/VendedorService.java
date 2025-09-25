/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.services;

import com.magicGroup.backend.model.Vendedor;
import com.magicGroup.backend.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jhonn
 */

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;
    private final PasswordService passwordService;

    public VendedorService(VendedorRepository vendedorRepository,
            PasswordService passwordService) {
        this.vendedorRepository = vendedorRepository;
        this.passwordService = passwordService;
    }

    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> findById(Integer id) {
        return vendedorRepository.findById(id);
    }

    public Vendedor save(Vendedor vendedor) {
        String rawPassword = vendedor.getPassword();
        String finalPassword = passwordService.encodePasswordIfNeeded(rawPassword);
        vendedor.setPassword(finalPassword);
        return vendedorRepository.save(vendedor);
    }

    public Vendedor update(Integer id, Vendedor vendedorActualizado) {
        vendedorActualizado.setId(id);
        return vendedorRepository.save(vendedorActualizado);
    }

    public void deleteById(Integer id) {
        vendedorRepository.deleteById(id);
    }
}