package com.biblioteca.gestion.repository;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.model.Prestamo;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPrestamoRepository extends JpaRepository<Prestamo, Long> {
    @Query(value = "SELECT p.* FROM prestamo p where p.fecha_vencimiento = :fechaVencimiento", nativeQuery = true)
    List<Prestamo> findByFechaVencimiento(@Param("fechaVencimiento") LocalDate fechaVencimiento);


}
