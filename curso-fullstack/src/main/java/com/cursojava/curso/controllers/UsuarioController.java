package com.cursojava.curso.controllers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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




    @RequestMapping( value = "usuarios" )
    public List<Usuario> getUsuarios() {

        Usuario u1 = new Usuario();
        u1.setId("-1");
        u1.setNombre("Jennifer");
        u1.setApellido("Barrios");
        u1.setEmail("jbarrios@gmail.com");
        u1.setPassword("123456");
        u1.setTelefono("43215678");

        Usuario u2 = new Usuario();
        u2.setId("-2");
        u2.setNombre("Julissa");
        u2.setApellido("Estrada");
        u2.setEmail("jestrada@gmail.com");
        u2.setPassword("a8df798");
        u2.setTelefono("43215678");

        Usuario u3 = new Usuario();
        u3.setId("-3");
        u3.setNombre("Jeimy");
        u3.setApellido("Meda");
        u3.setEmail("jmeda@gmail.com");
        u3.setPassword("123456");
        u3.setTelefono("19873918");

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        return listaUsuarios;
    } // public List<Usuario> getUsuarios
















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