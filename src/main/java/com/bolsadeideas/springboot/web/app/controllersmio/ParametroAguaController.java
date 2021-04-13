package com.bolsadeideas.springboot.web.app.controllersmio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/agua")
public class ParametroAguaController {

    @GetMapping({"/", ""})
    public String teDoyAgua(){
        return "htmlmios/index";
    }

    @GetMapping("/dulce")
    public String dameAgua(@RequestParam(name="agua") String aguita, Model model){
        model.addAttribute("titulo", "Probando los parametros por query");
        model.addAttribute("parametro", "Este es el parametro: " + aguita);

        return "htmlmios/agua";
    }

    @GetMapping("/salada")
    public String aguaSalada(@RequestParam String palabra, @RequestParam Integer numero, Model model){
        model.addAttribute("titulo", "Probando dos parametros por query");
        model.addAttribute("parametro", "la palabra es : "
        + palabra + " y el numero es "+ numero);

        return "htmlmios/agua";
    }

    @GetMapping("/poderosa/{parametro}")
    public String agua(@PathVariable(name="parametro") String para, Model model){
        model.addAttribute("titulo", "Usando @PathVariable");
        model.addAttribute("parametro", "El parametro es: " + para);

        return "htmlmios/agua";
    }

    @GetMapping("/httpservlet")
    public String httpBeibi(HttpServletRequest parametro, Model model){
        String nombre = parametro.getParameter("nombre");
        String apellido = parametro.getParameter("apellido");

        model.addAttribute("titulo", "Utilizando HttpServletRequest");
        model.addAttribute("parametro",
                "Este es el nombre: " + nombre +
                " y este es el apellido: " + apellido);

        return "htmlmios/agua";
    }
}
