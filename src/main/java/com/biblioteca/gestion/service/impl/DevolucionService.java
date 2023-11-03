package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Devolucion;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.service.IDevolucionService;
import org.springframework.stereotype.Service;

@Service
public class DevolucionService implements IDevolucionService {
    @Override
    public Devolucion registrarDevolucion(Devolucion devolucion) {
        return null;
    }

    /**
     * Recibe el prestamo, verifica si hay días de retraso en la devolucion y en caso de haberlos
     * devuelve el importe de la multa
     *
     * @param prestamo
     * @return double, valor de la multa (0 en caso de que no haya retraso)
     */
    private double calcularMulta(Prestamo prestamo){
        //
        return 0.0;
    }
}
