package com.biblioteca.gestion.repository;

import com.biblioteca.gestion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
