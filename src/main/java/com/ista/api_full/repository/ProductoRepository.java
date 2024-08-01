package com.ista.api_full.repository;

import com.ista.api_full.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductoRepository  extends JpaRepository<Producto, Long > {
}
