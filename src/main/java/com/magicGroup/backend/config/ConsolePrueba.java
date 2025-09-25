/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.magicGroup.backend.config;

import com.magicGroup.backend.model.Cliente;
import com.magicGroup.backend.services.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 *
 * @author Jhonn
 */
public class ConsolePrueba {

    private final ClienteService clienteService;

    public ConsolePrueba(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Registro de nuevo cliente ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setPassword(password);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);

        clienteService.save(cliente);

        System.out.println("✅ Cliente guardado con éxito en la base de datos!");
    }

}
