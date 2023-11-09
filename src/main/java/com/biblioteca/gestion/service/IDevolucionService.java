package com.biblioteca.gestion.service;

import com.biblioteca.gestion.model.Devolucion;
import com.biblioteca.gestion.model.Prestamo;
import org.springframework.http.ResponseEntity;

public interface IDevolucionService {
    ResponseEntity<Devolucion> registrarDevolucion(Devolucion devolucion);

    Devolucion buscarByIdPrestamo(Long idPrestamo);
}
