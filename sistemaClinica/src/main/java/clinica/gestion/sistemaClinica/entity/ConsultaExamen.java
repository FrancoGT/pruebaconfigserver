package clinica.gestion.sistemaClinica.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "consulta_examen")
public class ConsultaExamen 
{
    @Id
    private String id;
    private String idConsulta;
    private String idExamen;
}