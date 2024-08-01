package com.ista.api_full.repository;
import com.ista.api_full.entity.Factura;
import com.ista.api_full.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository  extends JpaRepository<Factura, Long >{
}
