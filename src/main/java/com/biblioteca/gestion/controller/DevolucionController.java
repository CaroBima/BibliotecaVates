package com.biblioteca.gestion.controller;

import com.biblioteca.gestion.model.Devolucion;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.service.IDevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para gestionar las operaciones relacionadas con las devoluciones de los prestamos.
 */
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {

    @Autowired
    IDevolucionService devolucionService;

    /**
     * Registra una devolución.
     *
     * @param devolucion La devolución a registrar.
     * @return ResponseEntity con la devolución registrada.
     */
    @PostMapping("/registro")
    public ResponseEntity<Devolucion> registrarDevolucion(@RequestBody Devolucion devolucion){
        return devolucionService.registrarDevolucion(devolucion);
    }
}
