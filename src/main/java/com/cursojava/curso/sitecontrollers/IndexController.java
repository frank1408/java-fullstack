package com.cursojava.curso.sitecontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/mensajee")
    public String mensaje(){
        return "base";
    }

} /* IndexController */
