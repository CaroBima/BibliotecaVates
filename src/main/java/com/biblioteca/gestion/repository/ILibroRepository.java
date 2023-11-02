package com.biblioteca.gestion.repository;

import com.biblioteca.gestion.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
    @Query(value = "SELECT * FROM libro lib WHERE lib.titulo LIKE (:titulo)", nativeQuery = true)
    List<Libro> findByTitulo(@Param("titulo") String titulo);


}
