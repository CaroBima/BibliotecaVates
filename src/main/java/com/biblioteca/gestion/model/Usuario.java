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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String dni;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_libro",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "prestamo_id" ))
    private List<Prestamo> listaPrestamos;

}
