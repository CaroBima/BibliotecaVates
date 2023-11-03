package com.biblioteca.gestion.service;

import com.biblioteca.gestion.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario buscarPorId(Long id);
    List<Usuario> buscarXApellidoYNombre(String apellido, String nombre);
    Usuario buscarPorDni(String dni);

    List<Usuario> buscarUsuarios();
}
