/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.magicGroup.backend.repository;

import com.magicGroup.backend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Jhonny
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findByNombre(String nombre);
}
