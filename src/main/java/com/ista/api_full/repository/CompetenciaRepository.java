package com.ista.api_full.repository;
import com.ista.api_full.entity.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CompetenciaRepository  extends JpaRepository<Competencia, Long > {
    Competencia findByNombre(String nombre);
}
