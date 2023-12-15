package clinica.gestion.sistemaClinica.service.medico;
import clinica.gestion.sistemaClinica.entity.Medico;
import clinica.gestion.sistemaClinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService 
{
    private final MedicoRepository medicoRepository;
    @Autowired
    public MedicoServiceImpl(MedicoRepository medicoRepository) 
    {
        this.medicoRepository = medicoRepository;
    }
    @Override
    public List<Medico> obtenerTodosMedicos() 
    {
        return medicoRepository.findAll();
    }
    @Override
    public Optional<Medico> obtenerMedicoPorId(Long id) 
    {
        return medicoRepository.findById(id);
    }
    @Override
    public Medico guardarMedico(Medico medico) 
    {
        return medicoRepository.save(medico);
    }
    @Override
    public Medico actualizarMedico(Long id, Medico medico) 
    {
        if (medicoRepository.existsById(id)) 
        {
            medico.setIdMedico(id);
            return medicoRepository.save(medico);
        }
        return null; // Pendiente: Agregar exception
    }
    @Override
    public void eliminarMedico(Long id) 
    {
        medicoRepository.deleteById(id);
    }
}