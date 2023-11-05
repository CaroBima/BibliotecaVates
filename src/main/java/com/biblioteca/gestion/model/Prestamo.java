package com.biblioteca.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;

    private LocalDate fechaRetiro;
    private LocalDate fechaVencimiento;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "prestamo_libro",
            joinColumns = @JoinColumn(name = "prestamo_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id" ))
    private List<Libro> listaDeLibros;
}
