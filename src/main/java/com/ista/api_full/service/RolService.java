package com.ista.api_full.service;


import com.ista.api_full.entity.Rol;
import com.ista.api_full.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {
    private final RolRepository rolRepository;

    public Rol postRol(Rol rol){
        return rolRepository.save(rol);
    }

    public List<Rol> getAllRol() {
        return  rolRepository.findAll();
    }

    public Rol getRolById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public Rol updateRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }


}
