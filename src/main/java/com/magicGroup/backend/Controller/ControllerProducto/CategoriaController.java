
package com.magicGroup.backend.Controller.ControllerProducto;

import com.magicGroup.backend.model.Categoria;
import com.magicGroup.backend.services.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* @author Jhonny */

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.findAll();
    }
}
