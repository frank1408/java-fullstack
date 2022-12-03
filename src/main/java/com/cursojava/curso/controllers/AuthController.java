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
    @RequestMapping( value = "api/login", method = RequestMethod.POST  )
    public String loginUsuario( @RequestBody Usuario infoUser ) {

        String ans = "";
        /* necesito correo y contrasena */
        Usuario usuariOK = usuarioDao.obtenerUsuarioPorCredenciales( infoUser );

        if( usuariOK != null ){
            ans = jwtUtil.create(
                    String.valueOf( usuariOK.getId() ),
                    usuariOK.getCorreo()
            );
        }
        return ans;
    } // public Usuario loginUsuario
    /* CON ACCESO A BASE DE DATOS */

} // public class AuthController
