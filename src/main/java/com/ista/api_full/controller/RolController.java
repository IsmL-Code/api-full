package com.ista.api_full.controller;
import com.ista.api_full.entity.Persona;
import com.ista.api_full.entity.Rol;
import com.ista.api_full.service.RolService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RolController {
    private final RolService rolService;

    @PostMapping("rol")
    public Rol postRol(@RequestBody Rol rol) {
        return rolService.postRol(rol);
    }
    @GetMapping("/rols")
    private List<Rol>getAllRol() {
        return rolService.getAllRol();
    }

    @GetMapping("/rol/{id}")
    public ResponseEntity<Rol>getRolById(@PathVariable Long id) {
        Rol  rol =  rolService.getRolById(id);
        if(rol == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(rol);
    }

    @PutMapping("/rol-up/{id}")
    public ResponseEntity<Rol> updateCustomer(@PathVariable Long id, @RequestBody Rol rol) {
        Rol  existingCustomer = rolService.getRolById(id);
        if(existingCustomer == null)
            return ResponseEntity.notFound().build();
        existingCustomer.setCompetencias(rol.getCompetencias());
        Rol updateCustomer = rolService.updateRol(existingCustomer);
        return ResponseEntity.ok(updateCustomer);
    }



    @DeleteMapping("/rol-dl/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable Long id) {
        Rol existingCostomer = rolService.getRolById(id);
        if(existingCostomer == null)
            return ResponseEntity.notFound().build();
        rolService.deleteRol(id);
        return ResponseEntity.ok().build();
    }
}
