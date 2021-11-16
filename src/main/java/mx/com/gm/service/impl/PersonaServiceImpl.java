package mx.com.gm.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.com.gm.entities.Persona;
import mx.com.gm.repository.PersonaRepository;
import mx.com.gm.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{
  
  @Autowired
  private PersonaRepository personaRepository;

  @Override
  @Transactional(readOnly = true) //ya que es solo consulta, leer informacion
  public List<Persona> listarPersonas() {
    return (List<Persona>) personaRepository.findAll();
  }

  @Override
  @Transactional()
  public void guardarPersona(Persona persona) {
    personaRepository.save(persona);
  }

  @Override
  @Transactional()
  public void eliminarPersona(Persona persona) {
    personaRepository.delete(persona);
  }

  @Override
  @Transactional(readOnly = true)
  public Persona encontrarPersona(Persona persona) {
    //el metodo . orElse, significa que si no llegase a encontrar un valor, devuelve null (manejo de opcional)
    return personaRepository.findById(persona.getIdPersona()).orElse(null);
  }

}
