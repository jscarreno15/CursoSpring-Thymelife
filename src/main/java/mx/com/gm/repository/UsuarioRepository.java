package mx.com.gm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import mx.com.gm.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  
  Usuario findByUsername(String username);
}
