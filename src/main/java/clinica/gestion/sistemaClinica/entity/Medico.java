package clinica.gestion.sistemaClinica.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medico 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;
    @Column(nullable = false, length = 255)
    private String nombres;
    @Column(nullable = false, length = 255)
    private String apellidos;
    @Column(nullable = false, length = 255)
    private String cmp;
}