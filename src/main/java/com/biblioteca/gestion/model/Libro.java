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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    @Column(unique = true, nullable = false)
    private Long isbn;

    private String titulo;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id" ))
    private List<Autor> listaAutores;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Editorial editorial;

    private LocalDate fechaPublicacion;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "libro_genero",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "generolibro_id" ))
    private List<GeneroLibro> listaGeneros;

}
