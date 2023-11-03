package com.biblioteca.gestion.repository;


import com.biblioteca.gestion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "Select * from usuario where dni = :dni", nativeQuery = true )
    Usuario findByDni(@Param("dni") String dni);

}
