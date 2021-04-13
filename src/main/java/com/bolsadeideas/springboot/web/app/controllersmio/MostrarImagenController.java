package com.bolsadeideas.springboot.web.app.controllersmio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagen")
public class MostrarImagenController {

    @GetMapping({"/", ""})
    public String mostrarImagen(){
        return "htmlmios/imagen";
    }
}
