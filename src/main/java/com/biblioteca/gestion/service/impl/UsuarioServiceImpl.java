package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Usuario;
import com.biblioteca.gestion.repository.IUsuarioRepository;
import com.biblioteca.gestion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Usuario buscarPorDni(String dni) {

        return usuarioRepository.findByDni(dni);
    }

    @Override
    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }
}
