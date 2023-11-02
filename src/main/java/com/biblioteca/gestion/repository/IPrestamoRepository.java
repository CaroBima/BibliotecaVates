package com.biblioteca.gestion.repository;

import com.biblioteca.gestion.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrestamoRepository extends JpaRepository<Prestamo, Long> {
}
