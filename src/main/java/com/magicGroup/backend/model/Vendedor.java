/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.model;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author Jhonn
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor extends Usuario {

    private String empresa;

    private String ruc;
}
