package com.bolsadeideas.springboot.web.app.controllersmio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {

    @GetMapping("/parametro")
    public String dameParam(@RequestParam(name="jaja", defaultValue = "Que mierda") String para, Model model){

        model.addAttribute("papito", "Este es el objeto " + para);

        return "parametros/parametrico";
    }
}
