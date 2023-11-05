package com.biblioteca.gestion.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    private String nombre;
    private String apellido;

    @ManyToMany(mappedBy = "listaAutores")
    @JsonIgnore
    private List<Libro> librosEscritos;

}
