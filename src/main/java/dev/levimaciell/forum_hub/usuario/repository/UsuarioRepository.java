package dev.levimaciell.forum_hub.usuario.repository;

import dev.levimaciell.forum_hub.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Boolean existsByUsuario(String Usuario);

    UserDetails findByUsuario(String username);
}
