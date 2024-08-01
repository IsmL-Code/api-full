package com.ista.api_full.controller;
import com.ista.api_full.entity.Clasificacion;
import com.ista.api_full.entity.Persona;
import com.ista.api_full.service.ClasificacacionService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClasificacionController {

    private final ClasificacacionService  clasificacionService;


    @PostMapping("clasificacion")
    public Clasificacion postClasificacion(@RequestBody Clasificacion clasificacion) {
        return clasificacionService.postClasificacion(clasificacion);
    }

    @GetMapping("/clasificacion")
    private List<Clasificacion>getAllClasificacion() {
        return clasificacionService.getAllClasificacion();
    }

    @GetMapping("/clasificacion/{id}")
    public ResponseEntity<Clasificacion>getClasificacionById(@PathVariable Long id) {
        Clasificacion  clasif =  clasificacionService.getClasificacionById(id);
        if(clasif  == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(clasif);
    }


    @PutMapping("/clasificacion-up/{id}")
    public ResponseEntity<Clasificacion> updateCustomer(@PathVariable Long id, @RequestBody Clasificacion clasifica) {
        Clasificacion  existingCla = clasificacionService.getClasificacionById(id);
        if(existingCla == null)
            return ResponseEntity.notFound().build();
        existingCla.setGrupo(clasifica.getGrupo());

        Clasificacion updateCla = clasificacionService.updateClasificacion(existingCla);
        return ResponseEntity.ok(updateCla);
    }

}
