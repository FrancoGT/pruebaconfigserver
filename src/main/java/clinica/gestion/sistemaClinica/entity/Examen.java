package clinica.gestion.sistemaClinica.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Examen
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExamen;
    @Column(nullable = false, length = 255)
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
}