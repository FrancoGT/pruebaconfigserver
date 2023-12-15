package clinica.gestion.sistemaClinica.service.paciente;
import clinica.gestion.sistemaClinica.entity.Paciente;
import clinica.gestion.sistemaClinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService 
{
    private final PacienteRepository pacienteRepository;
    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) 
    {
        this.pacienteRepository = pacienteRepository;
    }
    @Override
    public List<Paciente> obtenerTodosPacientes() 
    {
        return pacienteRepository.findAll();
    }
    @Override
    public Optional<Paciente> obtenerPacientePorId(Long id) 
    {
        return pacienteRepository.findById(id);
    }
    @Override
    public Paciente guardarPaciente(Paciente paciente) 
    {
        return pacienteRepository.save(paciente);
    }
    @Override
    public void eliminarPaciente(Long id) 
    {
        pacienteRepository.deleteById(id);
    }
    @Override
    public Paciente actualizarPaciente(Long id, Paciente paciente) 
    {
        Optional<Paciente> pacienteExistente = pacienteRepository.findById(id);
        if (pacienteExistente.isPresent()) 
        {
            Paciente pacienteActualizado = pacienteExistente.get();
            pacienteActualizado.setNombres(paciente.getNombres());
            pacienteActualizado.setApellidos(paciente.getApellidos());
            pacienteActualizado.setDni(paciente.getDni());
            pacienteActualizado.setDireccion(paciente.getDireccion());
            pacienteActualizado.setTelefono(paciente.getTelefono());
            pacienteActualizado.setEmail(paciente.getEmail());
            return pacienteRepository.save(pacienteActualizado);
        } 
        else 
        {
            // pendiente: crear excepcion que no existe el paciente
            return null;
        }
    }
}