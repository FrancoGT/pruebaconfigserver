package clinica.gestion.sistemaClinica.service.consulta_examen;
import java.util.List;
import java.util.Optional;
import clinica.gestion.sistemaClinica.entity.ConsultaExamen;

public interface ConsultaExamenService 
{
    List<ConsultaExamen> getAllConsultaExamenes();
    Optional<ConsultaExamen> getConsultaExamenById(String id);
    ConsultaExamen saveConsultaExamen(ConsultaExamen consultaExamen);
    void deleteConsultaExamen(String id);
}