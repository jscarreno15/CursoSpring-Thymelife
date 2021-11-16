package mx.com.gm.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona implements Serializable{
  
  private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", unique = true, nullable = false)
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Double saldo;
}
