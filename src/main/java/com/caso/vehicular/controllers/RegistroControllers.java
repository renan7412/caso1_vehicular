package com.caso.vehicular.controllers;

import com.caso.vehicular.Service.UsuarioService;
import com.caso.vehicular.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroControllers {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Muestra el formulario de registro
    @GetMapping("/registro")
    public String showRegistroForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    // Si no esta registrado el usuario, se guarda el nuevo usuario.
    @PostMapping("/registro")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (usuarioService.findByUsername("username") != true) {

            model.addAttribute("error", "Usuario ya existe");
            return "registro";
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password));
        usuarioService.save(usuario);
        return "redirect:/formularioLogin";
    }

    // Muestra el formulario de logín
    /*@GetMapping("/formularioLogin")
    public String muestroPropioLogin() {
        return "login";
    }
    */

}
