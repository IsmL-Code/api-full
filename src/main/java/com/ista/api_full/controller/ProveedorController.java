package com.ista.api_full.controller;
import com.ista.api_full.entity.Persona;
import com.ista.api_full.entity.Proveedores;
import com.ista.api_full.service.ProveedoresService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProveedorController {
    private final ProveedoresService  proveedoresService;

    @PostMapping("proveedor")
    public Proveedores postProveedores(@RequestBody Proveedores proveedores) {
        return proveedoresService.postPersona(proveedores);
    }

    @GetMapping("/proveedores")
    private List<Proveedores>getAllProveedores() {
        return proveedoresService.getAllProveedores();
    }

    @GetMapping("/proveedor/{id}")
    public ResponseEntity<Proveedores>getProveedoresById(@PathVariable Long id) {
        Proveedores  prov =  proveedoresService.getProveedoresById(id);
        if(prov == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(prov);
    }


    @PutMapping("/proveedor-up/{id}")
    public ResponseEntity<Proveedores> updateProveedores(@PathVariable Long id, @RequestBody Proveedores prov) {
        Proveedores  existingprv = proveedoresService.getProveedoresById(id);
        if(existingprv == null)
            return ResponseEntity.notFound().build();
        existingprv.setRuc(prov.getRuc());
        existingprv.setTelefono(prov.getTelefono());
        existingprv.setPais(prov.getPais());
        existingprv.setCorreo(prov.getCorreo());
        existingprv.setMoneda(prov.getMoneda());
        Proveedores updateprov = proveedoresService.updateProveedores(existingprv);
        return ResponseEntity.ok(updateprov);
    }

    @DeleteMapping("/proveedor-dl/{id}")
    public ResponseEntity<?> deleteProveedores(@PathVariable Long id) {
        Proveedores existingprv = proveedoresService.getProveedoresById(id);
        if(existingprv == null)
            return ResponseEntity.notFound().build();
        proveedoresService.deleteProveedores(id);
        return ResponseEntity.ok().build();
    }
}
