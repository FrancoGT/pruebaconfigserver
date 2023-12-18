package clinica.gestion.sistemaClinica.service.detalle_consulta;
import java.util.List;
import java.util.Optional;
import clinica.gestion.sistemaClinica.entity.DetalleConsulta;

public interface DetalleConsultaService 
{
    List<DetalleConsulta> getAllDetallesConsulta();
    Optional<DetalleConsulta> getDetalleConsultaById(String id);
    DetalleConsulta saveDetalleConsulta(DetalleConsulta detalleConsulta);
    void deleteDetalleConsulta(String id);
}