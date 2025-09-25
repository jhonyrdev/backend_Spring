/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.magicGroup.backend.repository;

import com.magicGroup.backend.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jhonn
 */

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}