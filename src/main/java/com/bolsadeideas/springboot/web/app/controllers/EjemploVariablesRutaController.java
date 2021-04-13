package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
class EjemploVariablesRutaController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo",
                "Enviar parametros de la ruta (@PathVariable)");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
    /*Si el parametro en el metodo se llama igual 'texto' no hace falta ponerle el name en @PathVariable */
    public String variables(@PathVariable(name = "texto") String textoOtro, Model model){
        model.addAttribute("titulo",
                "Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado",
                "El texto enviado en la ruta es: " + textoOtro);
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    /*Si el parametro en el metodo se llama igual 'texto' no hace falta ponerle el name en @PathVariable(name="") */
    public String variables(@PathVariable String texto
            , @PathVariable Integer numero , Model model){
        model.addAttribute("titulo",
                "Recibir 2 varios parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado",
                "El texto enviado en la ruta es: " + texto +
                " y el numero enviado en el path es: " + numero);
        return "variables/ver";
    }

    @GetMapping("/pathvariable/{variable}")
    public String variables(@PathVariable(name = "variable")  String var, Model model, String xd){

        model.addAttribute("titulo", "Probando @PathVariable");
        model.addAttribute("resultado", "Este es el valor: " + var);

        return "variables/ver";
    }
}
