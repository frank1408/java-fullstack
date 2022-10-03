package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.DataLogin;
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
    public DataLogin loginUsuario( @RequestBody Usuario infoUser ) {
        String token_JWT = null;
        Usuario usuariOK = usuarioDao.obtenerUsuarioPorCredenciales( infoUser );
        DataLogin dataLogin = null;

        if( usuariOK != null ){

            token_JWT = jwtUtil.create(
                    String.valueOf( usuariOK.getId() ),
                    usuariOK.getEmail()
            );
            dataLogin = new DataLogin();
            dataLogin.setId( String.valueOf( usuariOK.getId() ) );
            dataLogin.setToken( token_JWT );

        }

       return dataLogin;
    } // public Usuario loginUsuario



} // public class AuthController

