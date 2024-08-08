package com.ista.api_full.controller;
import com.ista.api_full.entity.Factura;
import com.ista.api_full.service.FacturaService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class FacturaController {

    protected final FacturaService  facturaService;

    @PostMapping("factura")
    public Factura postFactura(@RequestBody Factura factura) {
        return facturaService.postFactura(factura);
    }

    @GetMapping("/facturas")
    private List<Factura>getAllFactura() {
        return facturaService.getAllFactura();
    }


    @GetMapping("/factura/{id}")
    public ResponseEntity<Factura>getFacturaById(@PathVariable Long id) {
        Factura  factura =  facturaService.getFacturaById(id);
        if(factura == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(factura);
    }


    @DeleteMapping("/fatura-dl/{id}")
    public ResponseEntity<?> deleteFactura(@PathVariable Long id) {
        Factura existing = facturaService.getFacturaById(id);
        if(existing == null)
            return ResponseEntity.notFound().build();
        facturaService.deleteFactura(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/factura-up/{id}")
    public ResponseEntity<Factura> updateCustomer(@PathVariable Long id, @RequestBody Factura factura) {
        Factura  existingf = facturaService.getFacturaById(id);
        if(existingf == null)
            return ResponseEntity.notFound().build();
        existingf.setRuc(factura.getRuc());
        Factura updatef = facturaService.updateFactura(existingf);
        return ResponseEntity.ok(updatef);
    }

}
