package com.ista.api_full.repository;

import com.ista.api_full.entity.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long > {
}
