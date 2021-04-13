package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(){
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name="texto"
            , required = false, defaultValue = "No introdujo un parametro") String textoOtro, Model model){
        model.addAttribute("resultado", "El texto enviado es: ".concat(textoOtro));

        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){
        model.addAttribute("resultado"
                , "El saludo enviado es: " + saludo +
                "  y el numero es " + numero);

        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest quest, Model model){
        String saludo = quest.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(quest.getParameter("numero"));
        }catch (NumberFormatException e){
            numero = 0;
        }
        model.addAttribute("resultado"
                , "El saludo enviado es: " + saludo +
                        "  y el numero es " + numero);

        return "params/ver";
    }


    @GetMapping("/mezcla-param")
    public String param(@RequestParam Integer numerito, @RequestParam Integer numero, Model model){
        model.addAttribute("resultado", "El numerito es: " +
                numerito + " y el numero escogido es: " + numero);

        return "params/ver";
    }
}
