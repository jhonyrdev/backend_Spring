/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Jhonn
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private BigDecimal precio;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    //@JsonManagedReference 
    private Categoria categoria;

}
