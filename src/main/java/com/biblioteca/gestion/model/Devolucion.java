package com.biblioteca.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
/**
 * Representa una devolución de un prestamo.
 * Contiene información del prestamo devuelto, la fecha de devolución y el importe de la multa (0 si no tiene multa,
 * sino $50 por cada día de atraso)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Devolucion {
    /**
     * Clave primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDevolucion;

    /**
     * Objeto de tipo prestamo que contiene el prestamo que se devolvió
     */
    @OneToOne
    private Prestamo prestamo;

    /**
     * Fecha en la que se realizó la devolución
     */
    private LocalDate fechaDevolucion;

    /**
     * Importe de la multa
     */
    private double multa;
}
