package com.biblioteca.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Representa una entidad de editorial en el sistema.
 * Contiene información de una empresa editorial: nombre  catálogo de libros editados por dicha editorial.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Editorial {
    /**
     * Clave primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditorial;

    /**
     * Nombre de la editorial
     */
    private String nombre;

    /**
     * Catálogo de libros que le pertenecen
     */
    @OneToMany//(mappedBy = "listaTemas", fetch=FetchType.LAZY)
    private List<Libro> catalogoLibros;
}
