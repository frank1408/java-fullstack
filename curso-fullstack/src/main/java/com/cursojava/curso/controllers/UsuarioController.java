package com.cursojava.curso.controllers;

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



} // UsuarioController

/*
Un controlador se encarga de gestionar/controlar las URL
 */