package com.ista.api_full.repository;
import com.ista.api_full.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long > {

    Usuario findByNombreUsuarioAndContrasenaUsuario(String nombreUsuario, String contrasenaUsuario);
}
