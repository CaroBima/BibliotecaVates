package com.biblioteca.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Representa un prestamo en el sistema.
 * Contiene información detallada sobre un prestamo específico: usuario que lo solicitó, fecha en que se realizó
 * el prestamo, fecha de vencimiento del mismo y lista de libros que fueron retirados.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prestamo {

    /**
     * Clave primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    /**
     * Usuario que solicitó el prestamo
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    /**
     * Fecha en la que se realizó el prestamo
     */
    private LocalDate fechaRetiro;

    /**
     * Fecha de vencimiento del prestamo, antes de esa fecha deben ser devueltos
     */
    private LocalDate fechaVencimiento;

    /**
     * Lista de libros que fueron retirados por el usuario
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prestamo_libro",
            joinColumns = @JoinColumn(name = "prestamo_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id" ))
    private List<Libro> listaDeLibros;
}
