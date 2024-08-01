package com.ista.api_full.service;
import com.ista.api_full.entity.Competencia;
import com.ista.api_full.entity.Persona;
import com.ista.api_full.repository.CompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenciaService {

    protected final CompetenciaRepository competenciaRepository;

    public Competencia postCompetencia(Competencia competencia){
        return competenciaRepository.save(competencia);
    }

    public List<Competencia> getAllCompetencia() {
        return  competenciaRepository.findAll();
    }

    public Competencia getCompetenciaById(Long id) {
        return  competenciaRepository.findById(id).orElse(null);
    }

    public Competencia updateCompetencia(Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

    public void deleteCompetencia(Long id) {
        competenciaRepository.deleteById(id);
    }
}
