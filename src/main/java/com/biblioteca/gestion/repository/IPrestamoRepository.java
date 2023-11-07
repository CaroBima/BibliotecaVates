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

    @Query(value = "Select * from prestamo p, libro l, prestamo_libro pl, usuario u where p.id_prestamo = pl.prestamo_id and l.id_libro = pl.libro_id and p.usuario_id_usuario = u.id_usuario and u.dni=:dni", nativeQuery = true)
    List<Prestamo> findByDni(@Param("dni") String dni);

}
