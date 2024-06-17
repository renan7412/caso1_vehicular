package com.caso.vehicular.controllers;

import com.caso.vehicular.Service.RolService;
import com.caso.vehicular.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/roles")
public class RolControllers {

    @Autowired
    RolService rolService;

    @GetMapping
    public String getAllRolws(Model model) {
        List<Rol> roles = rolService.findAll();
        model.addAttribute("roles", roles);
        return "roles/lista";
    }

    @GetMapping("/{id}")
    public String getRolById(@PathVariable Long id, Model model) {
        Optional<Rol> rol = rolService.findById(id);
        if (rol.isPresent()) {
            model.addAttribute("rol", rol.get());
            return "roles/detalle";  // Vista Thymeleaf
        } else {
            return "error/404";  // Vista de error
        }
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/formulario";  // Formulario de creación de rol
    }

    @PostMapping
    public String createRol(@ModelAttribute Rol rol) {
        rolService.save(rol);
        return "redirect:/roles";  // Redirige a la lista de roles
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Rol> rol = rolService.findById(id);
        if (rol.isPresent()) {
            model.addAttribute("rol", rol.get());
            return "roles/formulario";  // Formulario de edición de rol
        } else {
            return "error/404";  // Vista de error
        }
    }

    @PostMapping("/actualizar/{id}")
    public String updateRol(@PathVariable Long id, @ModelAttribute Rol rolDetails) {
        Optional<Rol> rol = rolService.findById(id);
        if (rol.isPresent()) {
            Rol existingRol = rol.get();
            existingRol.setName(rolDetails.getName());
            rolService.save(existingRol);
            return "redirect:/roles";
        } else {
            return "error/404";  // Vista de error
        }
    }

    @GetMapping("/eliminar/{id}")
    public String deleteRol(@PathVariable Long id) {
        rolService.deleteById(id);
        return "redirect:/roles";
    }
}
