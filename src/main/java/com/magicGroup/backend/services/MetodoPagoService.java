/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.services;

/**
 *
 * @author Jhonn
 */
import com.magicGroup.backend.model.MetodoPago;
import com.magicGroup.backend.repository.MetodoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll();
    }

    public Optional<MetodoPago> findById(Integer id) {
        return metodoPagoRepository.findById(id);
    }

    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public MetodoPago update(Integer id, MetodoPago metodoPagoActualizado) {
        metodoPagoActualizado.setId(id);
        return metodoPagoRepository.save(metodoPagoActualizado);
    }

    public void deleteById(Integer id) {
        metodoPagoRepository.deleteById(id);
    }
}