package com.ista.api_full.service;
import com.ista.api_full.entity.Factura;
import com.ista.api_full.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public Factura postFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    public List<Factura> getAllFactura() {
        return  facturaRepository.findAll();
    }

    public Factura getFacturaById(Long id) {
        return  facturaRepository.findById(id).orElse(null);
    }

    public Factura updateFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}
