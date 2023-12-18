package clinica.gestion.sistemaClinica.service.consulta;
import java.util.List;
import java.util.Optional;
import clinica.gestion.sistemaClinica.entity.Consulta;

public interface ConsultaService 
{
    List<Consulta> getAllConsultas();
    Optional<Consulta> getConsultaById(String id);
    Consulta saveConsulta(Consulta consulta);
    void deleteConsulta(String id);
}