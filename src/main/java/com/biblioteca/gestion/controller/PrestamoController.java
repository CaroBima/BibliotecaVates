package com.biblioteca.gestion.controller;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.model.Usuario;
import com.biblioteca.gestion.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador para gestionar los prestamos de libros.
 * Permite listar los prestamos registrados en la base de datos, registrar un nuevo prestamo y buscar préstamos
 * por fecha de vencimiento o por usuario
 */

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

    @Autowired
    IPrestamoService prestamoService;

    /**
     * Devuelve el listado de prestamos registrados en la base de datos
     * @return Listado de prestamos
     */
    @GetMapping("/listarPrestamos")
    public List<Prestamo> listarLibros(){
        return prestamoService.findAll();
    }

    /**
     * Permite registrar un nuevo prestamo
     * @param nuevoPrestamo
     * @return prestamo que fue registrado en el sistema
     */
    @PostMapping("/nuevo")
    public Prestamo crearPrestamo(@RequestBody Prestamo nuevoPrestamo){
        return prestamoService.registrarPrestamo(nuevoPrestamo);
    }

    /**
     * Permite realizar la busqueda de prestamos cuya fecha de vencimiento coincide con la pasada por parámetro
     * @param fechaVencimiento
     * @return listado de prestamos que vencen en la fecha consultada
     */

    @GetMapping("/busqueda/fvencimiento/{fechaVencimiento}")
    public List<Prestamo> buscarPorFechaVenc(@PathVariable LocalDate fechaVencimiento){
        return prestamoService.consultarPrestamosPorFechaVenc(fechaVencimiento);
    }

    /**
     * Busqueda de prestamos realizados por un determinado usuario
     * @param usuario
     * @return listado de prestamos solicitados por un usuario puntual
     */
    @PostMapping("/busqueda/usuario")
    public List<Prestamo> buscarPorUsuario(@RequestBody Usuario usuario){
        return prestamoService.consultrarPrestamosPorUsuario(usuario);
    }

}
