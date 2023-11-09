package com.biblioteca.gestion.controller;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gestionar las altas, bajas, modificaciones y borrado de libros
 */
@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    ILibroService libroService;

    /**
     * Devuelve el listado de el catálogo de libros completo
     * @return Lista de libros
     */
    @GetMapping("/listarlibros")
    public List<Libro> listarLibros(){
        return libroService.findAll();
    }


    /**
     * Permite guardar un nuevo libro en la base de datos
     * @param nuevoLibro
     * @return ResponseEntity que indica si el valor ha podido ser guardado
     */
    @PostMapping("/nuevo")
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro nuevoLibro){
        return libroService.guardarLibro(nuevoLibro);
    }

    /**
     * Realiza la edición de un libro
     * @param libroEditado
     * @return libro ya editado que fue guardado en la base de datos
     */
    @PutMapping("/editar")
    public Libro editarLibro(@RequestBody Libro libroEditado){
        return libroService.editarLibro(libroEditado);
    }

    /**
     * Permite realizar el borrado de un libro cuyo id se pasa por parametro
     * @param id
     * @return String indicando que el libro ha sido borrado
     */
    @DeleteMapping("/borrar/{id}")
    public String borrarLibro(@PathVariable Long id){
        libroService.borrarLibro(id);
        return "Libro borrado";
    }

    /**
     * Permite realizar la búsqueda de un libro por el título del mismo
     * @param titulo
     * @return listado de libros cuyo titulo coinciden con el buscado
     */
    @GetMapping("/busqueda/titulo/{titulo}")
    public List<Libro> buscarPorTitulo(@PathVariable String titulo) {

        return libroService.findLibroTitulo(titulo);
    }

    /**
     * Permite realizar la búsqueda de un libro por el autor del mismo
     * @param autor
     * @return listado de libros cuyo autor coinciden con el buscado
     */
    @GetMapping("/busqueda/autor/{autor}")
    public List<Libro> buscarPorAutor(@PathVariable String autor) {

        return libroService.findLibroAutor(autor);
    }

    /**
     * Permite realizar la búsqueda de un libro por el género al que pertenece
     * @param genero
     * @return listado de libros pertenecientes al género buscado
     */
    @GetMapping("/busqueda/genero/{genero}")
    public List<Libro> buscarPorGenero(@PathVariable String genero) {

        return libroService.findLibroGenero(genero);
    }
}
