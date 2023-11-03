package com.biblioteca.gestion.repository;

import com.biblioteca.gestion.model.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDevolucionRepository extends JpaRepository<Devolucion, Long> {
}
