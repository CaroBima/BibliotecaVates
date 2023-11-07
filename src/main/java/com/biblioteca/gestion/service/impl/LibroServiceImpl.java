package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.repository.ILibroRepository;
import com.biblioteca.gestion.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService {

    @Autowired
    ILibroRepository libroRepository;

    /**
     * Permite guardar un libro nuevo. Valida primero por el isbn si el libro ya se encuentra guardado, si no lo está
     * lo guarda. Si el libro está devuelve el libro que ya se encuentra guardado en la base de datos.
     * @param libro
     * @return ResponseEntity Created en caso de que se cree ok, Conflict en caso de que el libro ya haya estado guardado
     * o Server Error en caso de haber alguna excepcion
     */
    @Override
    public ResponseEntity<Libro> guardarLibro(Libro libro) {
        Libro libroYaGuardado = libroRepository.findByIsbn(libro.getIsbn());

        try {
            if(libroYaGuardado != null){
                return new ResponseEntity(libroYaGuardado, HttpStatus.CONFLICT);
            }else{
                libroRepository.save(libro);
                return new ResponseEntity(libro, HttpStatus.CREATED);
            }
         }catch( Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



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
    public List<Libro> findAll() {

        return libroRepository.findAll();
    }

    @Override
    public List<Libro> findLibroTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    @Override
    public List<Libro> findLibroAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

    @Override
    public List<Libro> findLibroGenero(String genero) {
        return libroRepository.findByGenero(genero);
    }

    @Override
    public Libro findLibroIsbn(String isbnABuscar){
        return libroRepository.findByIsbn(isbnABuscar);
    }
}
