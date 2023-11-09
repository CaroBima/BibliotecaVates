package com.biblioteca.gestion.controller;

import com.biblioteca.gestion.model.Usuario;
import com.biblioteca.gestion.service.IUsuarioService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/listarusuarios")
    public List<Usuario> listarUsuarios(){

        return usuarioService.buscarUsuarios();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Usuario> crearLibro(@RequestBody Usuario nuevoUsuario){

        return usuarioService.crearUsuario(nuevoUsuario);
    }



}
