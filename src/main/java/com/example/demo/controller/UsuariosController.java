package com.example.demo.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;


@Controller
public class UsuariosController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/usuario/fechaBaja/{id}")
    public String addFechaBaja(@PathVariable Integer id) {
        Optional<Usuario> optionalProduct = usuarioRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Usuario usuario = optionalProduct.get();
            usuario.setFechaBaja(new Date());
            usuarioRepository.save(usuario);
        } 
        
        return "redirect:/";
    }
	@GetMapping("/usuario/eliminarFechaBaja/{id}")
    public String deleteFechaBaja(@PathVariable Integer id) {
        Optional<Usuario> optionalProduct = usuarioRepository.findById(id);
        
        if (optionalProduct.isPresent()) {
            Usuario usuario = optionalProduct.get();
            usuario.setFechaBaja(null);
            usuarioRepository.save(usuario);
        } 
        
        return "redirect:/";
    }
	
	@GetMapping("/usuario/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		if (usuarioRepository.existsById(id)) {
			Usuario user = usuarioRepository.findById(id).get();
			
			usuarioRepository.delete(user);
		}
		return "redirect:/";

	}
	@GetMapping("/usuario/edit/{id}")
	public String obtenerFormulario(Model model, @PathVariable Integer id) {
		if (usuarioRepository.existsById(id)) {
			usuarioRepository.findById(id).ifPresent(c -> model.addAttribute("usuario", c));
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
	    if (usuario.getId() != null && usuarioRepository.existsById(usuario.getId())) {
	        Usuario existingUser = usuarioRepository.findById(usuario.getId()).get();
	        existingUser.setNombreUsuario(usuario.getNombreUsuario());
	        existingUser.setNombre(usuario.getNombre());
	        existingUser.setApellido1(usuario.getApellido1());
	        existingUser.setApellido2(usuario.getApellido2());
	        existingUser.setEdad(usuario.getEdad());
	        existingUser.setDireccion(usuario.getDireccion());
	        usuarioRepository.save(existingUser);
	    } else {
	    	usuario.setFechaAlta(new Date());
	        usuarioRepository.save(usuario);
	    }
	    return "redirect:/";
	}

}
