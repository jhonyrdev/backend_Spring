/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.services;

import com.magicGroup.backend.model.Cliente;
import com.magicGroup.backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jhonn
 */

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final PasswordService passwordService;

    public ClienteService(ClienteRepository clienteRepository, 
            PasswordService passwordService) {
        this.clienteRepository = clienteRepository;        
        this.passwordService = passwordService;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        String rawPassword = cliente.getPassword();
        String finalPassword = passwordService.encodePasswordIfNeeded(rawPassword);
        cliente.setPassword(finalPassword);
        return clienteRepository.save(cliente);
    }

    public Cliente update(Integer id, Cliente clienteActualizado) {
        clienteActualizado.setId(id);
        return clienteRepository.save(clienteActualizado);
    }

    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }
}