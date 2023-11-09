package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Devolucion;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.repository.IDevolucionRepository;
import com.biblioteca.gestion.service.IDevolucionService;
import com.biblioteca.gestion.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Implementación de la interfaz {@link IDevolucionService}.
 * DevolucionService es un servicio que proporciona métodos para obtener información sobre la devolución
 * de préstamos de libros
 *
 * @see IDevolucionService
 * @see Prestamo
 */

@Service
public class DevolucionService implements IDevolucionService {

    @Autowired
    IDevolucionRepository devolucionRepository;

    /**
     * Registra una devolución en el sistema. Verifica si el préstamo asociado a la devolución ya ha
     * sido devuelto. Si no ha sido devuelto, se registra la devolución y se calcula la multa (si aplica).
     *
     * @param devolucion
     * @return ResponseEntity con la devolución registrada y el código de estado correspondiente:
     *          - HttpStatus.CREATED (201) si la devolución se registró con éxito.
     *          - HttpStatus.CONFLICT (409) si el préstamo ya había sido devuelto anteriormente.
     *          - HttpStatus.INTERNAL_SERVER_ERROR (500) si ocurrió un error interno durante el registro.
     */
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

    /**
     * Realiza la búsqueda de una devolución por el id del préstamo.
     * @param idPrestamo
     * @return Devolucion - prestamo cuyo id coincide con el pasado por parámetro
     */
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
