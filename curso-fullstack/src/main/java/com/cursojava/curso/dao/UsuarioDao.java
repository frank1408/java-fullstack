package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {

List<Usuario> getUsuarios();

Usuario getUsuario( Long id );

void deleteUsuario( Long id );

void createUsuario( Usuario newUser );

} // public interface UsuarioDao
