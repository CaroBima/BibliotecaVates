package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Usuario;
import com.biblioteca.gestion.repository.IUsuarioRepository;
import com.biblioteca.gestion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Usuario> buscarXApellidoYNombre(String apellido, String nombre) {
        return null;
    }

    @Override
    public List<Usuario> buscarPorDni(String dni) {
        return null;
    }
}
