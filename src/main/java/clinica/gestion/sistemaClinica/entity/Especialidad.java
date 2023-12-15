package clinica.gestion.sistemaClinica.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Especialidad 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidad;
    @Column(nullable = false, length = 255)
    private String nombre;
}