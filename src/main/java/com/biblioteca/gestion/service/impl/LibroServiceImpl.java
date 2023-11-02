package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.repository.ILibroRepository;
import com.biblioteca.gestion.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService {

    @Autowired
    ILibroRepository libroRepository;
    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro editarLibro(Libro libroEditado) {
        return libroRepository.save(libroEditado);
    }

    @Override
    public void borrarLibro(Long idABorrar) {
        libroRepository.deleteById(idABorrar);
    }

    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        return null;
    }

    @Override
    public List<Libro> buscarPorAutor(String nombreAutor) {
        return null;
    }

    @Override
    public List<Libro> buscarPorGenero(String genero) {
        return null;
    }

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public List<Libro> findLibroTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }
}
