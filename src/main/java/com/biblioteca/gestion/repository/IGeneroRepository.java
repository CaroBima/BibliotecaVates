package com.biblioteca.gestion.repository;

import com.biblioteca.gestion.model.GeneroLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneroRepository extends JpaRepository<GeneroLibro, Long> {
}
