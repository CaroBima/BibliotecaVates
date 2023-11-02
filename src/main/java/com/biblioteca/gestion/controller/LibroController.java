package com.biblioteca.gestion.controller;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/nuevo")
    public Libro crearLibro(@RequestBody Libro nuevoLibro){
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

}
