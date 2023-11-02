package com.biblioteca.gestion.service;

import com.biblioteca.gestion.model.Libro;

import java.util.List;

public interface ILibroService {
    Libro guardarLibro(Libro libro);
    Libro editarLibro(Libro libroEditado);
    void borrarLibro(Long idABorrar);
    List<Libro> findAll();
    List<Libro> findLibroTitulo(String titulo);
    List<Libro> findLibroAutor(String autor);
    List<Libro> findLibroGenero(String genero);
}
