package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
public class UsuariosController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/usuario/fechaBaja/{id}")
    public String addFechaBaja(@PathVariable Integer id) {
        usuarioService.addFechaBaja(id);
        return "redirect:/";
    }
    
    @GetMapping("/usuario/eliminarFechaBaja/{id}")
    public String deleteFechaBaja(@PathVariable Integer id) {
        usuarioService.deleteFechaBaja(id);
        return "redirect:/";
    }
    
    @GetMapping("/usuario/delete/{id}")
    public String deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/";
    }
    
    @GetMapping("/usuario/edit/{id}")
    public String obtenerFormulario(Model model, @PathVariable Integer id) {
        if (usuarioService.existsById(id)) {
            usuarioService.findById(id).ifPresent(c -> model.addAttribute("usuario", c));
            return "formulario";
        } else {
            return "redirect:/usuario/form";
        }
    }
    
    @GetMapping("/usuario/form")
    public String obtenerFormularioVacio(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario";
    }
    
    @PostMapping("/usuarioGuardado")
    public String gestionUsuario(@ModelAttribute Usuario usuario) {
        if (usuario.getId() != null && usuarioService.existsById(usuario.getId())) {
            Usuario existingUser = usuarioService.findById(usuario.getId()).get();
            existingUser.setNombreUsuario(usuario.getNombreUsuario());
            existingUser.setNombre(usuario.getNombre());
            existingUser.setApellido1(usuario.getApellido1());
            existingUser.setApellido2(usuario.getApellido2());
            existingUser.setEdad(usuario.getEdad());
            existingUser.setDireccion(usuario.getDireccion());
            usuarioService.saveUsuario(existingUser);
        } else {
            usuario.setFechaAlta(new Date());
            usuarioService.saveUsuario(usuario);
        }
        return "redirect:/";
    }
}

