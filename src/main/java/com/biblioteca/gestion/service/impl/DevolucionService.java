package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Devolucion;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.repository.IDevolucionRepository;
import com.biblioteca.gestion.service.IDevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class DevolucionService implements IDevolucionService {

    @Autowired
    IDevolucionRepository devolucionRepository;
    @Override
    public ResponseEntity<Devolucion> registrarDevolucion(Devolucion devolucion) {

        Devolucion fueDevuelto = this.buscarByIdPrestamo(devolucion.getPrestamo().getIdPrestamo());

        if(fueDevuelto == null){ //si no esta registrado como devuelto, lo guarda
            devolucion.setMulta(this.calcularMulta(devolucion.getPrestamo().getFechaVencimiento(), devolucion.getFechaDevolucion()));
            try {
                devolucionRepository.save(devolucion);
                return new ResponseEntity(devolucion, HttpStatus.CREATED);
            }catch(Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else{
            return new ResponseEntity(fueDevuelto, HttpStatus.CONFLICT);
        }

    }

    @Override
    public Devolucion buscarByIdPrestamo(Long idPrestamo) {
        return devolucionRepository.findByIdPrestamo(idPrestamo);
    }

    /**
     * Recibe el prestamo, verifica si hay días de retraso en la devolucion y en caso de haberlos
     * devuelve el importe de la multa (cantidad de dias * 50$ por dia)
     *
     * @param fechaPrestamo, fechaDevolucion
     * @return double, valor de la multa (0 en caso de que no haya retraso)
     */
    private double calcularMulta(LocalDate fechaPrestamo, LocalDate fechaDevolucion){
        long diasDeDiferencia = ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);
        System.out.println(diasDeDiferencia);
        if(diasDeDiferencia > 0) {
            return Math.abs(diasDeDiferencia) * 50;
        }else{
            return 0;
        }
    }
}
