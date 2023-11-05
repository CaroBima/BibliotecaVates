package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.model.Usuario;
import com.biblioteca.gestion.repository.IPrestamoRepository;
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

    @Override
    public Prestamo registrarPrestamo(Prestamo prestamo) {
        Usuario usuarioExistente = usuarioService.buscarPorDni(prestamo.getUsuario().getDni());

        if (usuarioExistente != null) {//valido si el usuario ya esta registrado
            prestamo.setUsuario(usuarioExistente);
        } else {
            usuarioService.crearUsuario(prestamo.getUsuario()); //Si el usuario no existe lo guardo primero
        }

        return prestamoRepository.save(prestamo);
    }


    @Override
    public List<Prestamo> consultrarPrestamosPorUsuario(Usuario usuario) {
        /*List<Prestamo> listaPrestamosBD = prestamoRepository.findAll();
        List<Prestamo> listaPrestamosUsuario = new ArrayList<>();

        listaPrestamosUsuario = listaPrestamosBD.stream()
                .filter(prestamo -> prestamo.getUsuario().getDni().equals(usuario.getDni()))
                .collect(Collectors.toList());

        return listaPrestamosUsuario;*/

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


