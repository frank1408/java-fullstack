package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;



    /* CON ACCESO A BASE DE DATOS */
    /* CON ACCESO A BASE DE DATOS */
    @RequestMapping( value = "api/login", method = RequestMethod.POST  )
    public boolean loginUsuario( @RequestBody Usuario infoUser ) {

       return usuarioDao.verificarEmailPassword( infoUser );
    } // public Usuario loginUsuario



} // public class AuthController

