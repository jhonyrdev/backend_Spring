/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.services;

import com.magicGroup.backend.model.Reclamo;
import com.magicGroup.backend.repository.ReclamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jhonn
 */

@Service
public class ReclamoService {

    private final ReclamoRepository reclamoRepository;

    public ReclamoService(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    public List<Reclamo> findAll() {
        return reclamoRepository.findAll();
    }

    public Optional<Reclamo> findById(Integer id) {
        return reclamoRepository.findById(id);
    }

    public Reclamo save(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
    }

    public Reclamo update(Integer id, Reclamo reclamoActualizado) {
        reclamoActualizado.setId(id);
        return reclamoRepository.save(reclamoActualizado);
    }

    public void deleteById(Integer id) {
        reclamoRepository.deleteById(id);
    }
}