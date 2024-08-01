package com.ista.api_full.service;
import com.ista.api_full.entity.Clasificacion;
import com.ista.api_full.entity.Persona;
import com.ista.api_full.repository.ClasificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClasificacacionService {

    protected final ClasificacionRepository clasificacionRepository;

    public Clasificacion postClasificacion(Clasificacion clasificacion){
        return clasificacionRepository.save(clasificacion);
    }

    public List<Clasificacion> getAllClasificacion() {
        return  clasificacionRepository.findAll();
    }

    public Clasificacion getClasificacionById(Long id) {
        return clasificacionRepository.findById(id).orElse(null);
    }

    public Clasificacion updateClasificacion(Clasificacion clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }

    public void deleteClasificacion(Long id) {
        clasificacionRepository.deleteById(id);
    }
}
