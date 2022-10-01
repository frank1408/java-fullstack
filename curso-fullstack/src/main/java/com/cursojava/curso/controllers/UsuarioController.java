package com.cursojava.curso.controllers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UsuarioController {

    @RequestMapping( value = "prueba" )
    public String prueba(){
        return "Prueba 1";
    } // prueba 1

    @RequestMapping( value = "prueba2" )
    public List<String> prueba2(){
        return List.of("manzana", "mandarina", "fresa");
    } // prueba 2



    @RequestMapping( value = "usuariofijo" )
    public Usuario getUsuario(){
        Usuario usuarioFijo = new Usuario();
        usuarioFijo.setId("-1");
        usuarioFijo.setNombre("Jennifer");
        usuarioFijo.setApellido("Barrios");
        usuarioFijo.setEmail("jbarrios@gmail.com");
        usuarioFijo.setPassword("123456");
        usuarioFijo.setTelefono("43215678");

        return usuarioFijo;
    } // public Usuario getUsuario




    @RequestMapping( value = "usuariofijo/{id}" )
    public Usuario getUsuarioId( @PathVariable String id ) {
        Usuario usuarioFijo = new Usuario();
        usuarioFijo.setId(id);
        usuarioFijo.setNombre("Jennifer");
        usuarioFijo.setApellido("Barrios");
        usuarioFijo.setEmail("jbarrios@gmail.com");
        usuarioFijo.setPassword("123456");
        usuarioFijo.setTelefono("43215678");

        return usuarioFijo;
    } // public Usuario getUsuarioId






    /*-----*/



    @RequestMapping( value = "usuariofijo/update" )
    public Usuario updateUsuario(){
        Usuario usuarioFijo = new Usuario();
        usuarioFijo.setNombre("Jennifer");
        usuarioFijo.setApellido("Barrios");
        usuarioFijo.setEmail("jbarrios@gmail.com");
        usuarioFijo.setPassword("123456");
        usuarioFijo.setTelefono("43215678");

        return usuarioFijo;
    } // public Usuario updateUsuario






    @RequestMapping( value = "usuariofijo/delete" )
    public Usuario deleteUsuario(){
        Usuario usuarioFijo = new Usuario();
        usuarioFijo.setNombre("Jennifer");
        usuarioFijo.setApellido("Barrios");
        usuarioFijo.setEmail("jbarrios@gmail.com");
        usuarioFijo.setPassword("123456");
        usuarioFijo.setTelefono("43215678");

        return usuarioFijo;
    } // public Usuario deleteUsuario







    @RequestMapping( value = "usuariofijo/find" )
    public Usuario buscarUsuario(){
        Usuario usuarioFijo = new Usuario();
        usuarioFijo.setNombre("Jennifer");
        usuarioFijo.setApellido("Barrios");
        usuarioFijo.setEmail("jbarrios@gmail.com");
        usuarioFijo.setPassword("123456");
        usuarioFijo.setTelefono("43215678");

        return usuarioFijo;
    } // public Usuario buscarUsuario



} // UsuarioController

/*
Un controlador se encarga de gestionar/controlar las URL
 */