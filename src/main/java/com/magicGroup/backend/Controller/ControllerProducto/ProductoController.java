
package com.magicGroup.backend.Controller.ControllerProducto;

import com.magicGroup.backend.services.CategoriaService;
import com.magicGroup.backend.model.Producto;
import com.magicGroup.backend.services.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/* @author Jhonny */

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {
    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, 
            CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.save(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        productoService.deleteById(id);
    }
}
