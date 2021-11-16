package mx.com.gm.service;

import java.util.List;
import mx.com.gm.entities.Persona;

public interface PersonaService {
  

  
  public  List<Persona> listarPersonas();
  
  public void guardarPersona (Persona persona);
  
  public void eliminarPersona(Persona persona);
  
  public Persona encontrarPersona(Persona persona);

}
