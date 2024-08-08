package com.ista.api_full.repository;

import com.ista.api_full.entity.RolCompetencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RolCompetenciaRepository extends JpaRepository<RolCompetencia, Long > {
}
