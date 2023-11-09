package com.biblioteca.gestion.repository;

import com.biblioteca.gestion.model.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDevolucionRepository extends JpaRepository<Devolucion, Long> {
    @Query(value = "SELECT * FROM `devolucion` WHERE prestamo_id_prestamo = :idPrestamo", nativeQuery = true)
    Devolucion findByIdPrestamo(@Param("idPrestamo") Long idPrestamo);

}
