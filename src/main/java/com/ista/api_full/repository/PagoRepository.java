package com.ista.api_full.repository;
import com.ista.api_full.entity.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PagoRepository extends JpaRepository<TipoPago, Long >{
}
