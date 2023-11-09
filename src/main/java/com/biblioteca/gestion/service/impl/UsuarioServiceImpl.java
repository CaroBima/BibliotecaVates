package com.biblioteca.gestion.service.impl;

import com.biblioteca.gestion.model.Usuario;
import com.biblioteca.gestion.repository.IUsuarioRepository;
import com.biblioteca.gestion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<Usuario> crearUsuario(Usuario usuario) {

        try {
            Usuario usuGuardado = usuarioRepository.save(usuario);
            return new ResponseEntity(usuGuardado, HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Usuario buscarPorId(Long id) {

        //falta la logica para la busqueda y devolucion del usuario
        return null;
    }

    @Override
    public List<Usuario> buscarXApellidoYNombre(String apellido, String nombre) {
        //falta definir la logica para la busqueda y devolver el listado de usuarios encontrados
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
