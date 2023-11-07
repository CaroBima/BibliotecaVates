package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.model.Usuario;
import com.biblioteca.gestion.repository.IPrestamoRepository;
import com.biblioteca.gestion.service.ILibroService;
import com.biblioteca.gestion.service.IPrestamoService;
import com.biblioteca.gestion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PrestamoServiceImpl implements IPrestamoService {

    @Autowired
    IPrestamoRepository prestamoRepository;

    @Autowired
    IUsuarioService usuarioService;
    @Autowired
    ILibroService libroService;

    /**
     * Registra un nuevo prestamo, validando previamente si el usuario y los libros del mismo ya se encuentran
     * registrados en la base de datos.
     *
     * @param prestamo
     * @return Prestamo, devuelve el prestamo registrado
     */
    @Override
    public Prestamo registrarPrestamo(Prestamo prestamo) {
        Usuario usuarioExistente = usuarioService.buscarPorDni(prestamo.getUsuario().getDni());


        if (usuarioExistente != null) {//valido si el usuario ya esta registrado
            prestamo.setUsuario(usuarioExistente);
        } else {
            usuarioService.crearUsuario(prestamo.getUsuario()); //Si el usuario no existe lo guardo primero
        }

        for (int i = 0; i < prestamo.getListaDeLibros().size(); i++) {
            Libro libroExistente = libroService.findLibroIsbn(prestamo.getListaDeLibros().get(i).getIsbn());

            if (libroExistente != null && libroExistente.getIsbn() != null) {
                prestamo.getListaDeLibros().set(i, libroExistente); // el libro ya estaba en la bbdd, lo seteo en la lista de prestamos
            } else {
                libroService.guardarLibro(prestamo.getListaDeLibros().get(i)); // el libro no está guardado, lo guardo
            }
        }

        return prestamoRepository.save(prestamo);
    }


    @Override
    public List<Prestamo> consultrarPrestamosPorUsuario(Usuario usuario) {
        return prestamoRepository.findByDni(usuario.getDni());
    }

    @Override
    public List<Prestamo> consultarPrestamosPorFechaVenc(LocalDate fechaVencConsultada) {

        return prestamoRepository.findByFechaVencimiento(fechaVencConsultada);
    }

    @Override
    public List<Prestamo> findAll() {

        return prestamoRepository.findAll();
    }
}


