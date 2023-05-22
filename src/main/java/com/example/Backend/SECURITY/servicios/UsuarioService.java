package com.example.Backend.SECURITY.servicios;

import com.example.Backend.SECURITY.modelo.Usuario;
import com.example.Backend.SECURITY.modelo.UsuarioRol;


import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}
