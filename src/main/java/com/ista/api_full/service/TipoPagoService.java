package com.ista.api_full.service;
import com.ista.api_full.entity.TipoPago;
import com.ista.api_full.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoPagoService {

    private final PagoRepository pagoRepository;

    public TipoPago postTipoPago(TipoPago tipoPago){
        return pagoRepository.save(tipoPago);
    }

    public List<TipoPago> getAllTipoPago() {
        return  pagoRepository.findAll();
    }

    public TipoPago getTipoPagoById(Long id) {
        return  pagoRepository.findById(id).orElse(null);
    }

    public TipoPago updateTipoPago(TipoPago tipoPago) {
        return pagoRepository.save(tipoPago);
    }

    public void deleteTipoPago(Long id) {
        pagoRepository.deleteById(id);
    }

}
