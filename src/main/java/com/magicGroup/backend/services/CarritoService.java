/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.services;

import com.magicGroup.backend.model.Carrito;
import com.magicGroup.backend.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jhonn
 */

@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> findById(Integer id) {
        return carritoRepository.findById(id);
    }

    public Carrito save(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public Carrito update(Integer id, Carrito carritoActualizado) {
        carritoActualizado.setId(id);
        return carritoRepository.save(carritoActualizado);
    }

    public void deleteById(Integer id) {
        carritoRepository.deleteById(id);
    }
}