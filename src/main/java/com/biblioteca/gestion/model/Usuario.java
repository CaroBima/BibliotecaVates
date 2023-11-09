package com.biblioteca.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
/**
 * Representa un usuario de la biblioteca
 *
 * Esta clase encapsula la información detallada de un usuario: incluyendo dni, nombre, apellido y
 * una lista de los prestamos solicitados
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    /**
     * Clave primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    /**
     * Nombre del usuario
     */
    private String nombre;

    /**
     * Apellido del usuario
     */
    private String apellido;

    /**
     * Dni del usuario
     */
    @Column(unique = true)
    private String dni;

    /**
     * Lista de prestamos que fueron solicitados por el usuario
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_libro",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "prestamo_id" ))
    private List<Prestamo> listaPrestamos;

}
