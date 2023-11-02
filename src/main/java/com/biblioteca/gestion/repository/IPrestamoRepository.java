package com.biblioteca.gestion.repository;

import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.model.Prestamo;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrestamoRepository extends JpaRepository<Prestamo, Long> {
    /*@Query(value = "SELECT * FROM libro lib WHERE lib.titulo LIKE CONCAT('%', :titulo, '%')", nativeQuery = true)
    List<Libro> findByTitulo(@Param("titulo") String titulo);*/
/*
*
    @Query(name = "Libro.findByTitulo")
    List<Libro> findByTitulo(@Param("titulo") String titulo);
* 1*/

    //@Query(value = "SELECT * FROM prestamo")
    //List<Prestamo> findByFechaVencimiento();
   // List<Prestamo> findByUsuario();

}
