package clinica.gestion.sistemaClinica.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Data
@Document(collection = "consulta")
public class Consulta 
{
    @Id
    private String id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String idPaciente;
    private String idEspecialidad;
    private String idMedico;
}
