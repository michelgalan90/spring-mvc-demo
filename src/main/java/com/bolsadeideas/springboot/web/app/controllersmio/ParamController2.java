package com.bolsadeideas.springboot.web.app.controllersmio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController2 {

    @RequestMapping("/perrito")
    public String damePerro(@RequestParam(value = "sato") String valor, Model modelo){
        modelo.addAttribute("perro", valor);
        return "parametros/perrito";
    }

    @ModelAttribute("atributo")
    public String atributo(){
        return "Este es un atributo pasado por anotacion";
    }
}
