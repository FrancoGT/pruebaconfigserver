package clinica.gestion.sistemaClinica.service.detalle_consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clinica.gestion.sistemaClinica.entity.DetalleConsulta;
import clinica.gestion.sistemaClinica.repository.DetalleConsultaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleConsultaServiceImpl implements DetalleConsultaService 
{
    private final DetalleConsultaRepository detalleConsultaRepository;
    @Autowired
    public DetalleConsultaServiceImpl(DetalleConsultaRepository detalleConsultaRepository) 
    {
        this.detalleConsultaRepository = detalleConsultaRepository;
    }
    @Override
    public List<DetalleConsulta> getAllDetallesConsulta() 
    {
        return detalleConsultaRepository.findAll();
    }
    @Override
    public Optional<DetalleConsulta> getDetalleConsultaById(String id) 
    {
        return detalleConsultaRepository.findById(id);
    }
    @Override
    public DetalleConsulta saveDetalleConsulta(DetalleConsulta detalleConsulta) 
    {
        return detalleConsultaRepository.save(detalleConsulta);
    }
    @Override
    public void deleteDetalleConsulta(String id) 
    {
        detalleConsultaRepository.deleteById(id);
    }
}