package com.bolsadeideas.springboot.web.app.controllersmio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mezcla")
public class MezclaParamController {

    @Value("${nombre}")
    private String nombre;

    @RequestMapping({"/", ""})
    public String sendParam(){
        return "mezcla/sendparam";
    }

    @RequestMapping("/getparam")
    public String getParam(@RequestParam String palabra, @RequestParam Integer numero, Model model){
        model.addAttribute("res", "La palabra es: "+
                palabra + " y el numero es: " + numero);
        model.addAttribute("name", this.nombre);

        return "mezcla/getparam";
    }
}
