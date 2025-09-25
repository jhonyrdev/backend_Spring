/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 *
 * @author Jhonn
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @OneToOne
    @JoinColumn(name = "metodo_pago_id")
    private MetodoPago metodoPago;
}
