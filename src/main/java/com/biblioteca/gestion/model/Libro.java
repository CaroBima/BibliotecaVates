package com.biblioteca.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;

/**
 * Representa una entidad de libro en el sistema.
 * Contiene información detallada sobre un libro específico: isbn, titulo del libro, la lista de autores del mismo,
 * editorial, fecha de publicación y la lista de géneros a la que pertenece.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libro {
    /**
     * Clave primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    /**
     * Isbn asociado al libro
     */
    @Column(unique = true, nullable = false)
    private String isbn;

    /**
     * Título del libro
     */
    private String titulo;

    /**
     * Lista de autores del libro
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id" ))
    private List<Autor> listaAutores;

    /**
     * Empresa que editó el libro
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Editorial editorial;

    /**
     * Fecha en la que el libro fue publicado
     */
    private LocalDate fechaPublicacion;

    /**
     * Lista de géneros que corresponden al libro
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "libro_genero",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "generolibro_id" ))
    private List<GeneroLibro> listaGeneros;

}
