package com.biblioteca.gestion.controller;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    ILibroService libroService;

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

    @PutMapping("/editar")
    public Libro editarLibro(@RequestBody Libro libroEditado){
        return libroService.editarLibro(libroEditado);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarLibro(@PathVariable Long id){
        libroService.borrarLibro(id);
        return "Libro borrado";
    }

    @GetMapping("/busqueda/titulo/{titulo}")
    public List<Libro> buscarPorTitulo(@PathVariable String titulo) {

        return libroService.findLibroTitulo(titulo);
    }

    @GetMapping("/busqueda/autor/{autor}")
    public List<Libro> buscarPorAutor(@PathVariable String autor) {

        return libroService.findLibroAutor(autor);
    }

    @GetMapping("/busqueda/genero/{genero}")
    public List<Libro> buscarPorGenero(@PathVariable String genero) {

        return libroService.findLibroGenero(genero);
    }
}
