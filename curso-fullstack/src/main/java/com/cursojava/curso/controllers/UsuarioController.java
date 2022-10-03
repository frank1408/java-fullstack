package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;


    /* sin acceso a bases de datos */
    /* sin acceso a bases de datos */
    @RequestMapping( value = "prueba" )
    public String prueba(){
        return "Prueba 1";
    } // prueba 1


    /* sin acceso a bases de datos */
    /* sin acceso a bases de datos */
    @RequestMapping( value = "prueba2" )
    public List<String> prueba2(){
        return List.of("manzana", "mandarina", "fresa");
    } // prueba 2


    /* sin acceso a bases de datos */
    /* sin acceso a bases de datos */
    @RequestMapping( value = "getUsuarioFijo" )
    public Usuario getUsuario(){
        Usuario usuarioFijo = new Usuario();
        usuarioFijo.setId(-1L);
        usuarioFijo.setNombre("Jennifer");
        usuarioFijo.setApellido("Barrios");
        usuarioFijo.setEmail("jbarrios@gmail.com");
        usuarioFijo.setPassword("123456");
        usuarioFijo.setTelefono("43215678");

        return usuarioFijo;
    } // public Usuario getUsuarioFijo


    /* sin acceso a bases de datos */
    /* sin acceso a bases de datos */
    @RequestMapping( value = "usuariofijo/{id}" )
    public Usuario getUsuarioId( @PathVariable Long id ) {
        Usuario usuarioFijo = new Usuario();
        usuarioFijo.setId(id);
        usuarioFijo.setNombre("Jennifer");
        usuarioFijo.setApellido("Barrios");
        usuarioFijo.setEmail("jbarrios@gmail.com");
        usuarioFijo.setPassword("123456");
        usuarioFijo.setTelefono("43215678");

        return usuarioFijo;
    } // public Usuario getUsuarioId


    /* sin acceso a bases de datos */
    /* sin acceso a bases de datos */
    @RequestMapping( value = "usuariosfijos" )
    public List<Usuario> getUsuariosFijos() {

        Usuario u1 = new Usuario();
        u1.setId(-1L);
        u1.setNombre("Jennifer");
        u1.setApellido("Barrios");
        u1.setEmail("jbarrios@gmail.com");
        u1.setPassword("123456");
        u1.setTelefono("43215678");

        Usuario u2 = new Usuario();
        u2.setId(-2L);
        u2.setNombre("Julissa");
        u2.setApellido("Estrada");
        u2.setEmail("jestrada@gmail.com");
        u2.setPassword("a8df798");
        u2.setTelefono("43215678");

        Usuario u3 = new Usuario();
        u3.setId(-3L);
        u3.setNombre("Jeimy");
        u3.setApellido("Meda");
        u3.setEmail("jmeda@gmail.com");
        u3.setPassword("123456");
        u3.setTelefono("19873918");

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
        listaUsuarios.add(u3);

        return listaUsuarios;
    } // public List<Usuario> getUsuariosFijios


    /* sin acceso a bases de datos */
    /* sin acceso a bases de datos */
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



    /* sin acceso a bases de datos */
    /* sin acceso a bases de datos */
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


    /* sin acceso a bases de datos */
    /* sin acceso a bases de datos */
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









    /* CON ACCESO A BASE DE DATOS */
    /* CON ACCESO A BASE DE DATOS */
    @RequestMapping( value = "api/usuarios", method = RequestMethod.GET )
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    } // public List<Usuario> getUsuariosFijios


    /* CON ACCESO A BASE DE DATOS */
    /* CON ACCESO A BASE DE DATOS */
    @RequestMapping( value = "api/usuarios/{id}", method = RequestMethod.GET  )
    public Usuario getUsuario( @PathVariable Long id ) {
        return usuarioDao.getUsuario( id );
    } // public Usuario getUsuario


    /* CON ACCESO A BASE DE DATOS */
    /* CON ACCESO A BASE DE DATOS */
    @RequestMapping( value = "api/usuarios/{id}", method = RequestMethod.DELETE )
    public void deleteUsuario( @PathVariable Long id ) {
        usuarioDao.deleteUsuario( id );
    } // public Usuario deleteUsuario


    /* CON ACCESO A BASE DE DATOS */
    /* CON ACCESO A BASE DE DATOS */
    @RequestMapping( value = "api/usuarios", method = RequestMethod.POST  )
    public void createUsuario( @RequestBody Usuario newUser ) {
        usuarioDao.createUsuario( newUser );
    } // public Usuario getUsuario















} // UsuarioController
