package com.example.demo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public void addFechaBaja(Integer id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setFechaBaja(new Date());
            usuarioRepository.save(usuario);
        }
    }

    public void deleteFechaBaja(Integer id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setFechaBaja(null);
            usuarioRepository.save(usuario);
        }
    }

    public void deleteUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = usuarioRepository.findById(id).get();
            usuarioRepository.delete(usuario);
        }
    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public boolean existsById(Integer id) {
        return usuarioRepository.existsById(id);
    }
}
