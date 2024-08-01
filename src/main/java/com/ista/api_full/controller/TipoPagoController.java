package com.ista.api_full.controller;

import com.ista.api_full.entity.TipoPago;
import com.ista.api_full.service.TipoPagoService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TipoPagoController {

    protected final TipoPagoService tipoPagoService;

    @PostMapping("pago")
    public TipoPago postTipoPago(@RequestBody TipoPago tipop) {
        return tipoPagoService.postTipoPago(tipop);
    }

    @GetMapping("/pagos")
    private List<TipoPago>getAllTipoPago() {
        return tipoPagoService.getAllTipoPago();
    }

    @GetMapping("/pagos/{id}")
    public ResponseEntity<TipoPago>getTipoPagoById(@PathVariable Long id) {
        TipoPago  pago =  tipoPagoService.getTipoPagoById(id);
        if(pago == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pago);
    }

    @PutMapping("/pagos-up/{id}")
    public ResponseEntity<TipoPago> updateTipoPago(@PathVariable Long id, @RequestBody TipoPago tipoPago) {
        TipoPago  existingPago = tipoPagoService.getTipoPagoById(id);
        if(existingPago == null)
            return ResponseEntity.notFound().build();
        existingPago.setTipo(tipoPago.getTipo());
        existingPago.setDescripcion(tipoPago.getDescripcion());
        TipoPago updateTipoPago = tipoPagoService.updateTipoPago(existingPago);
        return ResponseEntity.ok(updateTipoPago);
    }

    @DeleteMapping("/pagos-dl/{id}")
    public ResponseEntity<?> deleteTipoPago(@PathVariable Long id) {
        TipoPago existingPago = tipoPagoService.getTipoPagoById(id);
        if( existingPago == null)
            return ResponseEntity.notFound().build();
        tipoPagoService.deleteTipoPago(id);
        return ResponseEntity.ok().build();
    }
}
