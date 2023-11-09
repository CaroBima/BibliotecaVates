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

@RestController
@RequestMapping("/devolucion")
public class DevolucionController {

    @Autowired
    IDevolucionService devolucionService;

    @PostMapping("/registro")
    public ResponseEntity<Devolucion> registrarDevolucion(@RequestBody Devolucion devolucion){
        return devolucionService.registrarDevolucion(devolucion);
    }
}
