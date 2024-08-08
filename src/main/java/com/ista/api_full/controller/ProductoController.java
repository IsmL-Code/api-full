package com.ista.api_full.controller;

import com.ista.api_full.entity.Producto;
import com.ista.api_full.service.ProductoService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("producto")
    public Producto postProducto(@RequestBody Producto producto) {
        return productoService.postProducto(producto);
    }

    @GetMapping("/productos")
    private List<Producto>getAllProducto() {
        return productoService.getAllProducto();
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto>getProductoById(@PathVariable Long id) {
        Producto  producto =  productoService.getProductoById(id);
        if(producto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/producto-up/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody  Producto producto) {
        Producto  existingp = productoService.getProductoById(id);
        if(existingp == null)
            return ResponseEntity.notFound().build();
        existingp.setStock(producto.getStock());
        existingp.setPrecio_unitario(producto.getPrecio_unitario());
        Producto updateCustomer = productoService.updateProducto(existingp);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/producto-dl/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id) {
        Producto existingpd = productoService.getProductoById(id);
        if(existingpd == null)
            return ResponseEntity.notFound().build();
        productoService.deleteProducto(id);
        return ResponseEntity.ok().build();
    }


}
