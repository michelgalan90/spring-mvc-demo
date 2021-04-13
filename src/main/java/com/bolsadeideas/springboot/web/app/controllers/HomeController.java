package com.bolsadeideas.springboot.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        /*usando forward se mantiene la misma ruta en el navegador...en este caso la raiz
        * si uso redirect cambiara la ruta y pondra la real...osea /app/index */
//        EL redirect reinicia el request, osea es como una peticion completamente nueva sin parametros
        return "redirect:/app/index";
        /*Con el forward los parametros del request no se pierden, y hace la llamada sin refrescar el navegador*/
    }
}
