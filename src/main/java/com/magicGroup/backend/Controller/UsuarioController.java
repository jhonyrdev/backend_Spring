
package com.magicGroup.backend.Controller;

import com.magicGroup.backend.model.Usuario;
import com.magicGroup.backend.services.UsuarioService;
import com.magicGroup.backend.services.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map; 

/* @author Jhonny */

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173") // Puerto de react
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordService passwordService;

    public UsuarioController(UsuarioService usuarioService, 
            PasswordService passwordService) {
        this.usuarioService = usuarioService;
        this.passwordService = passwordService;
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.findAll();
    }

    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario usuario) {
        // fuerza el nombre a "cliente" al registrarse
        usuario.setNombre("cliente");
        return usuarioService.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Integer id) {
        return usuarioService.findById(id).orElseThrow();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
        Optional<Usuario> user = usuarioService.findByEmail(loginRequest.getEmail());

        if (user.isPresent() &&
            passwordService.matches(loginRequest.getPassword(), user.get().getPassword())) {

            Usuario loggedUser = user.get();
            loggedUser.setPassword(null);
            return ResponseEntity.ok(loggedUser);

        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
    
    @PostMapping("/admin/verify")
public ResponseEntity<?> verifyAdmin(@RequestBody Map<String, String> body) {
    String password = body.get("password");

    Optional<Usuario> admin = usuarioService.findByEmail("RichardR@gmail.com");

    if (admin.isPresent() && passwordService.matches(password, admin.get().getPassword())) {
        return ResponseEntity.ok("Acceso permitido");
    } else {
        return ResponseEntity.status(401).body("Contraseña incorrecta");
    }
}

}