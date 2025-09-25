/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.magicGroup.backend.repository;

import com.magicGroup.backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Jhonn
 */

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}