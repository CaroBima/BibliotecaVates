package com.biblioteca.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditorial;
    private String nombre;

    @OneToMany//(mappedBy = "listaTemas", fetch=FetchType.LAZY)
    private List<Libro> catalogoLibros;
}
