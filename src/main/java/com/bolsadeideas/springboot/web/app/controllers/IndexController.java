package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/app")
public class IndexController {
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping(path = {"/index", "/", "", "/home"})
    public String index(Model model){

        model.addAttribute("titulo", textoIndex);

        return "index";
    }

    @RequestMapping(value = "/perfil")
    public String perfil(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Andres");
        usuario.setApellido("Amarillo");
        usuario.setEmail("apestas@gmail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping(value = "/listar")
    public String listar(Model model) {

//        Otra forma de construir la lista de arriba con la clase Arrays.asList
    /*    List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Andres", "Guzman", "andres@correo.com"));
        usuarios.add(new Usuario("Tony", "Stark", "tony@correo.com"));
        usuarios.add(new Usuario("Capitan", "America", "capi@correo.com"));*/

       model.addAttribute("titulo", textoListar);
//        model.addAttribute("usuarios", usuariosList);
        return "listar";
    }
/*EL annotation @ModelAttribute se comparte en toda la clase...osea esta accesible en todas las vistas...
* por lo tanto puedo acceder a usuarios desde perfil, listar, index, etc...*/

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuariosList =
                Arrays.asList(new Usuario("Andres", "Guzman", "andres@correo.com"),
                        new Usuario("Tony", "Stark", "tony@correo.com"),
                        new Usuario("Capitan", "America", "capi@correo.com"),
                        new Usuario("Tornado", "Row", "tornado@gmail.com"),
                        new Usuario("Hulk", "Banner", "hulk@gmail.com"));
        return usuariosList;

    }
}
