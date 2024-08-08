package com.ista.api_full.controller;
import com.ista.api_full.entity.ItemFactura;

import com.ista.api_full.service.ItemService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("item-factura")
    public ItemFactura postItemFactura(@RequestBody ItemFactura persona) {
        return itemService.postItemFactura(persona);
    }

    @GetMapping("/item-facturas")
    private List<ItemFactura>getAllItemFactura() {
        return itemService.getAllItemFactura();
    }

    @GetMapping("/item-facturas/{id}")
    public ResponseEntity<ItemFactura>getItemFacturaById(@PathVariable Long id) {
        ItemFactura  item =  itemService.getItemFacturaById(id);
        if(item == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(item);
    }


    @PutMapping("/item-facturas-up/{id}")
    public ResponseEntity<ItemFactura> updateItemFactura(@PathVariable Long id, @RequestBody ItemFactura itemFactura) {
        ItemFactura  existingItm = itemService.getItemFacturaById(id);
        if(existingItm == null)
            return ResponseEntity.notFound().build();
        existingItm.setCantidad(itemFactura.getCantidad());
        existingItm.setPrecio(itemFactura.getPrecio());
        existingItm.setSub_total(itemFactura.getSub_total());
        ItemFactura updateItm = itemService.updateItemFactura(existingItm);
        return ResponseEntity.ok(updateItm);
    }

    @DeleteMapping("/item-facturas-dl/{id}")
    public ResponseEntity<?> deleteItemFactura (@PathVariable Long id) {
        ItemFactura  existingItem = itemService.getItemFacturaById(id);
        if(existingItem == null)
            return ResponseEntity.notFound().build();
        itemService.deletePersona(id);
        return ResponseEntity.ok().build();
    }
}
