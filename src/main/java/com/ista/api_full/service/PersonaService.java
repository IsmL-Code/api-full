package com.ista.api_full.service;
import com.ista.api_full.entity.Persona;
import com.ista.api_full.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {
    private final PersonaRepository personaRepository;


    public Persona postPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public List<Persona> getAllPersona() {
        return  personaRepository.findAll();
    }

    public Persona getPersonaById(Long id) {
        return  personaRepository.findById(id).orElse(null);
    }

    public Persona updatePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

}
