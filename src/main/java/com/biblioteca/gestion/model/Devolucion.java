package com.biblioteca.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Devolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDevolucion;

    @OneToOne
    private Prestamo prestamo;

    private LocalDate fechaDevolución;
    private double multa;
}
