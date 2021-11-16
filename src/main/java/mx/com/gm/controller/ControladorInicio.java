package mx.com.gm.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.entities.Persona;
import mx.com.gm.service.PersonaService;

@Controller
@Slf4j
public class ControladorInicio {

  @Value("${index.saludo}")
  private String saludo;
  
  @Autowired
  private PersonaService personaService;

 
  @GetMapping("/")
  public String inicio(Model model, @AuthenticationPrincipal User user){
      List<Persona> personas = personaService.listarPersonas();
      log.info("ejecutando el controlador Spring MVC");
      log.info("usuario que hizo login: " + user.getUsername());
      model.addAttribute("personas", personas);
      Double saldoTotal = 0D;
      for(Persona persona: personas){
          saldoTotal += persona.getSaldo();
          log.info("en el ciclo: " + saldoTotal);
      }
      log.info("saldoTotal: " + saldoTotal);
      model.addAttribute("saldoTotal", saldoTotal);
      model.addAttribute("totalClientes", personas.size());
      return "index";
  }
  
  
  @GetMapping("/agregar")
  public String agregar(Persona persona) {
    log.info("ejecutando endpint agregar");
    return "modificar";
  }
  
  @PostMapping("/guardar")
  public String guardar(Persona persona) {
    personaService.guardarPersona(persona);
    return "redirect:/";
  }
  
  @GetMapping("/editar/{idPersona}")
  public String editar(Persona persona , Model model){
    persona = personaService.encontrarPersona(persona);
    model.addAttribute("Persona" , persona);
    return "modificar";
  }
  
  @GetMapping("/eliminar")
  public String eliminar(Persona persona){
    personaService.eliminarPersona(persona);
    return "redirect:/";
  }
  


}
