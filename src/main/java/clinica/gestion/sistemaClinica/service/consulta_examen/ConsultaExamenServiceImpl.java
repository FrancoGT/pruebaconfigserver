package clinica.gestion.sistemaClinica.service.consulta_examen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clinica.gestion.sistemaClinica.entity.ConsultaExamen;
import clinica.gestion.sistemaClinica.repository.ConsultaExamenRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaExamenServiceImpl implements ConsultaExamenService 
{
    private final ConsultaExamenRepository consultaExamenRepository;
    @Autowired
    public ConsultaExamenServiceImpl(ConsultaExamenRepository consultaExamenRepository) 
    {
        this.consultaExamenRepository = consultaExamenRepository;
    }
    @Override
    public List<ConsultaExamen> getAllConsultaExamenes() 
    {
        return consultaExamenRepository.findAll();
    }
    @Override
    public Optional<ConsultaExamen> getConsultaExamenById(String id) 
    {
        return consultaExamenRepository.findById(id);
    }
    @Override
    public ConsultaExamen saveConsultaExamen(ConsultaExamen consultaExamen) 
    {
        return consultaExamenRepository.save(consultaExamen);
    }
    @Override
    public void deleteConsultaExamen(String id) 
    {
        consultaExamenRepository.deleteById(id);
    }
}
