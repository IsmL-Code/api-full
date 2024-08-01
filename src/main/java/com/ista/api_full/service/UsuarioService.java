package com.ista.api_full.service;

import com.ista.api_full.entity.Usuario;
import com.ista.api_full.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    protected final UsuarioRepository usuarioRepository;



    public Usuario postUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuario() {
        return  usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return  usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
