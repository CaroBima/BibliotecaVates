package com.biblioteca.gestion.service;

import com.biblioteca.gestion.model.Libro;

import java.util.List;

public interface ILibroService {
    Libro guardarLibro(Libro libro);
    Libro editarLibro(Libro libroEditado);
    void borrarLibro(Long idABorrar);
    List<Libro> buscarPorTitulo(String titulo);
    List<Libro> buscarPorAutor(String nombreAutor);
    List<Libro> buscarPorGenero(String genero);

    List<Libro> findAll();

    List<Libro> findLibroTitulo(String titulo);
}
