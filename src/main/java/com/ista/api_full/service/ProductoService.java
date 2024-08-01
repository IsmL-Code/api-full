package com.ista.api_full.service;

import com.ista.api_full.entity.Producto;
import com.ista.api_full.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    protected final ProductoRepository productoRepository;

    public Producto postProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id) {
        return  productoRepository.findById(id).orElse(null);
    }

    public Producto updateProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
