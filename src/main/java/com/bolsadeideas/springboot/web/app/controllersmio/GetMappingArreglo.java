package com.bolsadeideas.springboot.web.app.controllersmio;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/getmapping")
public class GetMappingArreglo {
    final private String titulo = "Esta es mi pagina de prueba beibi";

    @GetMapping({"", "/"})
    public String index(Model model){
        model.addAttribute("titulo", titulo);
        return "animal/index";
    }
    @GetMapping(value = {"/lobo/{lobito}", "/leon/{leoncito}"})
    public String dameMapa(@PathVariable(required = false) String lobito, 
                           @PathVariable(required = false) String leoncito, Model modelo){
        if(lobito != null){
        modelo.addAttribute("lobito ", lobito);
            modelo.addAttribute("leoncito", "El leon no tiene nombre, usa otra ruta");
        }
        if(leoncito != null){
        modelo.addAttribute("leoncito", leoncito);
            modelo.addAttribute("lobito", "El lobito no tiene nombre, usa otra ruta");
        }
        return "animal/animal";
    }
}
