package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.UsuarioRepository;


@Controller
public class EntradaController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/")
	public String indexMostrarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "index";
	}
}
