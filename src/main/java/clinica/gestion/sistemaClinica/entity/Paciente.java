package clinica.gestion.sistemaClinica.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Paciente 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String nombres;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
}