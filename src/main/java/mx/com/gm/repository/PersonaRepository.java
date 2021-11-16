package mx.com.gm.repository;

import org.springframework.data.repository.CrudRepository;
import mx.com.gm.entities.Persona;

//indicamos especficar que entidad va a manejar y el tipo de clave primaria
public interface PersonaRepository extends CrudRepository<Persona, Long>{

}
