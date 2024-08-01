package com.ista.api_full.repository;
import com.ista.api_full.entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Long >{
}
