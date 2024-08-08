package com.ista.api_full.controller;
import com.ista.api_full.entity.RolCompetencia;
import com.ista.api_full.service.RolCompetenciaService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RolCompetenciaController {
    private final RolCompetenciaService rolCompetenciaService;

    @PostMapping("rolc")
    public RolCompetencia postRolc(@RequestBody RolCompetencia  usuario) {
        return rolCompetenciaService.postRolc(usuario);
    }

    @GetMapping("/rolcs")
    private List<RolCompetencia >getAllRolc() {
        return rolCompetenciaService.getAllRolc();
    }

    @GetMapping("/rolc/{id}")
    public ResponseEntity<RolCompetencia>getRolcById(@PathVariable Long id) {
        RolCompetencia   personau =  rolCompetenciaService.getRolcById(id);
        if(personau == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(personau);
    }


    @PutMapping("/rolc-up/{id}")
    public ResponseEntity<RolCompetencia> updateRolc(@PathVariable Long id, @RequestBody RolCompetencia  persona) {
        RolCompetencia   existingCustomer = rolCompetenciaService.getRolcById(id);
        if(existingCustomer == null)
            return ResponseEntity.notFound().build();

        RolCompetencia  updateCustomer = rolCompetenciaService.updateRolc(existingCustomer);
        return ResponseEntity.ok(updateCustomer);
    }



    @DeleteMapping("/rolc-dl/{id}")
    public ResponseEntity<?> deleteRolc(@PathVariable Long id) {
        RolCompetencia  existingCostomer = rolCompetenciaService.getRolcById(id);
        if(existingCostomer == null)
            return ResponseEntity.notFound().build();
        rolCompetenciaService.deleteRolc(id);
        return ResponseEntity.ok().build();
    }


}
