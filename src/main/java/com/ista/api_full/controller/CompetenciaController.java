package com.ista.api_full.controller;
import com.ista.api_full.entity.Competencia;
import com.ista.api_full.service.CompetenciaService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CompetenciaController {

    private final CompetenciaService competenciaService;

    @PostMapping("competencia")
    public Competencia postCompetencia(@RequestBody Competencia competencia) {
        return competenciaService.postCompetencia(competencia);
    }

    @GetMapping("/competencias")
    private List<Competencia>getAllCompetencia() {
        return competenciaService.getAllCompetencia ();
    }

    @GetMapping("/competencias/{id}")
    public ResponseEntity<Competencia>getCompetenciaById(@PathVariable Long id) {
        Competencia  competencias =  competenciaService.getCompetenciaById(id);
        if(competencias == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(competencias);
    }


    @DeleteMapping("/competencias-dl/{id}")
    public ResponseEntity<?> deleteCompetencia(@PathVariable Long id) {
        Competencia existingCon = competenciaService.getCompetenciaById(id);
        if(existingCon== null)
            return ResponseEntity.notFound().build();
        competenciaService.deleteCompetencia(id);
        return ResponseEntity.ok().build();
    }
}
