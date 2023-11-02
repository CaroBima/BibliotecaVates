package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.model.Usuario;
import com.biblioteca.gestion.repository.IPrestamoRepository;
import com.biblioteca.gestion.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class PrestamoServiceImpl implements IPrestamoService {

    @Autowired
    IPrestamoRepository prestamoRepository;

    @Override
    public Prestamo registrarPrestamo(Prestamo prestamo) {
        //validar datos registrados antes del guardado
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


