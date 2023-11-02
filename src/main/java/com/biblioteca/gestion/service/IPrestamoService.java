package com.biblioteca.gestion.service;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.model.Prestamo;
import com.biblioteca.gestion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IPrestamoService{
    Prestamo registrarPrestamo(Prestamo prestamo);
    List<Prestamo> consultrarPrestamosPorUsuario(Usuario usuario);

    List<Prestamo> consultarPrestamosPorFechaVenc(LocalDate fechaVencConsultada);


    List<Prestamo> findAll();
}
