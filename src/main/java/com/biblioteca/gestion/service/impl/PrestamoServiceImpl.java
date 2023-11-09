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
import java.util.stream.IntStream;

/**
 * Implementación de la interfaz {@link IPrestamoService}.
 * PrestamoServiceImpl es un servicio que proporciona métodos para obtener información de préstamos de libros
 *
 * @see IPrestamoService
 * @see Prestamo
 */

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

        IntStream.range(0, prestamo.getListaDeLibros().size())
                .forEach(i -> {
                    Libro libroExistente = libroService.findLibroIsbn(prestamo.getListaDeLibros().get(i).getIsbn());

                    if (libroExistente != null && libroExistente.getIsbn() != null) {
                        prestamo.getListaDeLibros().set(i, libroExistente); //el libro ya estaba en la bbdd, lo seteo en la lista de prestamos
                    } else {
                        libroService.guardarLibro(prestamo.getListaDeLibros().get(i));// el libro no está guardado, lo guardo
                    }
                });

        return prestamoRepository.save(prestamo);
    }

    /**
     * Permite consultar todos aquellos préstamos que han sido solicitados por un usuario determinado
     * @param usuario
     * @return Listado de los prestamos
     */
    @Override
    public List<Prestamo> consultrarPrestamosPorUsuario(Usuario usuario) {
        return prestamoRepository.findByDni(usuario.getDni());
    }

    /**
     * Consulta prestamos cuya fecha de vencimiento coincide con la pasada por parámetro
     * @param fechaVencConsultada
     * @return listado de prestamos con fecha de vencimiento igual a la recibida por parámetro
     */
    @Override
    public List<Prestamo> consultarPrestamosPorFechaVenc(LocalDate fechaVencConsultada) {

        return prestamoRepository.findByFechaVencimiento(fechaVencConsultada);
    }

    /**
     * Permite realizar la búsqueda de todos los prestamos realizados
     * @return listado de prestamos
     */
    @Override
    public List<Prestamo> findAll() {

        return prestamoRepository.findAll();
    }


}


