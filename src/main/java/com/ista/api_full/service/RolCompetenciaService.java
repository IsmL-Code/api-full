package com.ista.api_full.service;

import com.ista.api_full.entity.Persona;
import com.ista.api_full.entity.RolCompetencia;
import com.ista.api_full.repository.RolCompetenciaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class RolCompetenciaService {

    private final RolCompetenciaRepository rolCompetenciaRepository;

    public RolCompetencia postRolc(RolCompetencia rc){
        return rolCompetenciaRepository.save(rc);
    }

    public List<RolCompetencia> getAllRolc() {
        return  rolCompetenciaRepository.findAll();
    }

    public RolCompetencia getRolcById(Long id) {
        return  rolCompetenciaRepository.findById(id).orElse(null);
    }

    public RolCompetencia updateRolc(RolCompetencia competencia) {
        return rolCompetenciaRepository.save(competencia);
    }

    public void deleteRolc(Long id) {
        rolCompetenciaRepository.deleteById(id);
    }
}
