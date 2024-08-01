package com.ista.api_full.service;
import com.ista.api_full.entity.Proveedores;

import com.ista.api_full.repository.ProveedoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedoresService {

    private final ProveedoresRepository proveedoresRepository;

    public Proveedores postPersona(Proveedores proveedores){
        return proveedoresRepository.save(proveedores);
    }

    public List<Proveedores> getAllProveedores() {
        return  proveedoresRepository.findAll();
    }

    public Proveedores getProveedoresById(Long id) {
        return  proveedoresRepository.findById(id).orElse(null);
    }

    public Proveedores updateProveedores(Proveedores proveedores) {
        return proveedoresRepository.save(proveedores);
    }

    public void deleteProveedores(Long id) {
        proveedoresRepository.deleteById(id);
    }




}
