package clinica.gestion.sistemaClinica.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "detalle_consulta")
public class DetalleConsulta 
{
    @Id
    private String idDetalle;
    private String diagnostico;
    private String tratamiento;
    private String idConsulta;
}