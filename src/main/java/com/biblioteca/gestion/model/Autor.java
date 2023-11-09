package com.biblioteca.gestion.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Representa una entidad de autor en el sistema.
 * Contiene información detallada sobre un autor específico: nombre, apellido y el listado de libros que escribió.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Autor {
    /**
     * Clave primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    /**
     * Nombre del escritor
     */
    private String nombre;

    /**
     * Apellido del escritor
     */
    private String apellido;

    /**
     * Lista de libros escritos por el autor
     */
    @ManyToMany(mappedBy = "listaAutores")
    @JsonIgnore
    private List<Libro> librosEscritos;

}
