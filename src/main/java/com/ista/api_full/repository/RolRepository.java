package com.ista.api_full.repository;
import com.ista.api_full.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RolRepository extends   JpaRepository<Rol, Long > {

      Rol findByNombreRol(String rol);
      Rol findByEstado(Boolean rol);
}
