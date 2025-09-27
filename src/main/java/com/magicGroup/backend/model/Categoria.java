
package com.magicGroup.backend.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;
/* @author Jhonny */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    @JsonBackReference 
    private List<Producto> productos;

}
