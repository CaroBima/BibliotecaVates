package com.biblioteca.gestion.controller;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

    @Autowired
    IPrestamoService prestamoService;
    @GetMapping("/listarPrestamos")
    public List<Prestamo> listarLibros(){
        return prestamoService.findAll();
    }

    @PostMapping("/nuevo")
    public Prestamo crearPrestamo(@RequestBody Prestamo nuevoPrestamo){
        return prestamoService.registrarPrestamo(nuevoPrestamo);
    }

}
