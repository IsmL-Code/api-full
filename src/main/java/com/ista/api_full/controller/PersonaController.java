package com.ista.api_full.controller;
import com.ista.api_full.entity.Persona;
import com.ista.api_full.service.PersonaService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;



    @PostMapping("persona")
    public Persona postPersona( @RequestBody Persona persona) {
        return personaService.postPersona(persona);
    }

    @GetMapping("/personas")
    private List<Persona>getAllPersona() {
        return personaService.getAllPersona();
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<Persona>getPersonaById(@PathVariable Long id) {
        Persona  persona =  personaService.getPersonaById(id);
        if(persona == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(persona);
    }

    @PutMapping("/persona-up/{id}")
    public ResponseEntity<Persona> updateCustomer(@PathVariable Long id, @RequestBody Persona persona) {
        Persona  existingCustomer = personaService.getPersonaById(id);
        if(existingCustomer == null)
            return ResponseEntity.notFound().build();
        existingCustomer.setNombre(persona.getNombre());
        existingCustomer.setApellido(persona.getApellido());
        existingCustomer.setCorreo(persona.getCorreo());
        existingCustomer.setCelular(persona.getCelular());
        existingCustomer.setDni(persona.getDni());
        Persona updateCustomer = personaService.updatePersona(existingCustomer);
        return ResponseEntity.ok(updateCustomer);
    }


    @DeleteMapping("/customer-dl/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id) {
        Persona existingCostomer = personaService.getPersonaById(id);
        if(existingCostomer == null)
            return ResponseEntity.notFound().build();
        personaService.deletePersona(id);
        return ResponseEntity.ok().build();
    }

}
