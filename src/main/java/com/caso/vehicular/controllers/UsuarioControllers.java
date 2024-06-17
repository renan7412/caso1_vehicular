package com.caso.vehicular.controllers;

import com.caso.vehicular.Service.UsuarioService;
import com.caso.vehicular.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioControllers {

    @Autowired
    UsuarioService usuarioService;

    // Método que devuelve un solo usuario
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        return usuarioService.findById(id).orElse(null);
    }
    // Método para obtener usuarios de la bd
   @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    // Método para registrar un usuario
    @PostMapping
    public void registrarUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

    @RequestMapping(value = "usuarios11")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setUsername("David");
        usuario.setApellido("Jara");
        usuario.setEmail("djara@gmail.com");
        usuario.setTelefono("0974569874");
        return usuario;
    }

    @RequestMapping(value = "usuarios13")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setUsername("Esther");
        usuario.setApellido("Ramirez");
        usuario.setEmail("estherram@gmail.com");
        usuario.setTelefono("0974587674");
        return usuario;
    }

    // Método para eliminar a un usuario.
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }

    // Metodos de registro y login
    @GetMapping("/registrO")
    public String registration(Model model) {
        model.addAttribute("userForm", new Usuario());
        return "registration";
    }

    @PostMapping("/registrO")
    public String registrO(@RequestBody Usuario user, Model model) {
        if (UsuarioService.findByUsername("user.getUsername() != null")) {
            model.addAttribute("error", "Username already exists");
            return "registro";
        }
        usuarioService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/formularioLogin")
    public String login() {
        return "login";
    }
}
