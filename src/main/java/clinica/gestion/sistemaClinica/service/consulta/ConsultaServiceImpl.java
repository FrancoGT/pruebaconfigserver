package clinica.gestion.sistemaClinica.service.consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clinica.gestion.sistemaClinica.entity.Consulta;
import clinica.gestion.sistemaClinica.repository.ConsultaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService 
{
    private final ConsultaRepository consultaRepository;
    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository) 
    {
        this.consultaRepository = consultaRepository;
    }
    @Override
    public List<Consulta> getAllConsultas() 
    {
        return consultaRepository.findAll();
    }
    @Override
    public Optional<Consulta> getConsultaById(String id) 
    {
        return consultaRepository.findById(id);
    }
    @Override
    public Consulta saveConsulta(Consulta consulta) 
    {
        return consultaRepository.save(consulta);
    }
    @Override
    public void deleteConsulta(String id) 
    {
        consultaRepository.deleteById(id);
    }
}