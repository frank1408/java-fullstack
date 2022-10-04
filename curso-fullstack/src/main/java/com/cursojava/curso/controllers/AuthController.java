package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;



    /* CON ACCESO A BASE DE DATOS */
    /* CON ACCESO A BASE DE DATOS */
    @RequestMapping( value = "api/login", method = RequestMethod.POST  )
    public String loginUsuario( @RequestBody Usuario infoUser ) {
        Usuario usuariOK = usuarioDao.obtenerUsuarioPorCredenciales( infoUser );
        if( usuariOK != null ){
            return jwtUtil.create( String.valueOf( usuariOK.getId() ), usuariOK.getEmail() );
        }
        return "false";
    } // public Usuario loginUsuario



} // public class AuthController

