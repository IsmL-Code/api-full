package com.ista.api_full.repository;
import com.ista.api_full.entity.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClasificacionRepository  extends JpaRepository<Clasificacion, Long >{
}
