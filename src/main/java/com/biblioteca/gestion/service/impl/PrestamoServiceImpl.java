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
import java.util.List;


@Service
public class PrestamoServiceImpl implements IPrestamoService {

    @Autowired
    IPrestamoRepository prestamoRepository;

    @Autowired
    IUsuarioService usuarioService;

    @Override
    public Prestamo registrarPrestamo(Prestamo prestamo) {
        //validar datos registrados antes del guardado
        Usuario usuario = prestamo.getUsuario();
        if(usuarioService.buscarPorDni(usuario.getDni()) != null){
            usuarioService.crearUsuario(usuario);
        }

        return prestamoRepository.save(prestamo);
    }

    @Override
    public List<Prestamo> consultrarPrestamosPorUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Prestamo> consultarPrestamosPorFechaVenc(LocalDate fechaVencConsultada) {
        return null;
    }

    @Override
    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }
}


