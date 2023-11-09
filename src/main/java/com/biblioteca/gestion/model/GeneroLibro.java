package com.biblioteca.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un genero de libros en el sistema (Novela, novela histórica, poesía, etc).
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GeneroLibro {
    /**
     * Clave primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGeneroLibro;

    /**
     * Nombre del genero
     */
    //@ManyToMany(mappedBy = "listaGeneros")
    private String genero;
}
