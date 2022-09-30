package com.cursojava.curso.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {

    @RequestMapping( value = "prueba" )
    public String prueba(){
        return "Prueba 1";
    } // prueba


} // UsuarioController

/*
Un controlador se encarga de gestionar/controlar las URL
 */