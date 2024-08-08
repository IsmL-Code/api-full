package com.ista.api_full.service;
import com.ista.api_full.entity.Persona;
import com.ista.api_full.entity.UsuarioRol;
import com.ista.api_full.repository.UsuarioRolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioRolService {

    private final UsuarioRolRepository usuarioRolRepository;

    public UsuarioRol postUsuarior(UsuarioRol ur){
        return usuarioRolRepository.save(ur);
    }

    public List<UsuarioRol> getAllUsuarior() {
        return  usuarioRolRepository.findAll();
    }

    public UsuarioRol getUsuariorById(Long id) {
        return  usuarioRolRepository.findById(id).orElse(null);
    }

    public UsuarioRol updateUsuarior(UsuarioRol persona) {
        return usuarioRolRepository.save(persona);
    }

    public void deleteUsuarior(Long id) {
        usuarioRolRepository.deleteById(id);
    }
}
