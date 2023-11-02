package com.biblioteca.gestion.repository;

import com.biblioteca.gestion.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
    @Query(value = "SELECT * FROM libro lib WHERE lib.titulo LIKE CONCAT('%', :titulo, '%')", nativeQuery = true)
    List<Libro> findByTitulo(@Param("titulo") String titulo);

    @Query(value = "SELECT l.* FROM autor a, libro l, libro_autor la WHERE a.id = la.autor_id AND l.id = la.libro_id AND (a.nombre LIKE CONCAT('%', :autor, '%') OR a.apellido LIKE CONCAT('%', :autor, '%'))", nativeQuery = true)
    List<Libro> findByAutor(@Param("autor") String autor);

    @Query(value = "Select l.* from libro l, genero_libro g, libro_genero lg where l.id = lg.libro_id and g.id = lg.generolibro_id and g.genero LIKE CONCAT('%', :genero, '%')", nativeQuery = true)
    List<Libro> findByGenero(@Param("genero") String genero);

}
