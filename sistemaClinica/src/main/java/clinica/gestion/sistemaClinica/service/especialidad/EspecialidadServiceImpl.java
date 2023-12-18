package clinica.gestion.sistemaClinica.service.especialidad;
import clinica.gestion.sistemaClinica.entity.Especialidad;
import clinica.gestion.sistemaClinica.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService 
{
    private final EspecialidadRepository especialidadRepository;
    @Autowired
    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) 
    {
        this.especialidadRepository = especialidadRepository;
    }
    @Override
    public List<Especialidad> obtenerTodasEspecialidades() 
    {
        return especialidadRepository.findAll();
    }
    @Override
    public Optional<Especialidad> obtenerEspecialidadPorId(Long id) 
    {
        return especialidadRepository.findById(id);
    }

    @Override
    public Especialidad guardarEspecialidad(Especialidad especialidad) 
    {
        return especialidadRepository.save(especialidad);
    }
    @Override
    public Especialidad actualizarEspecialidad(Long id, Especialidad especialidad) 
    {
        if (especialidadRepository.existsById(id)) 
        {
            especialidad.setIdEspecialidad(id);
            return especialidadRepository.save(especialidad);
        }
        return null; //Pendiente: agregar exception
    }
    @Override
    public void eliminarEspecialidad(Long id) 
    {
        especialidadRepository.deleteById(id);
    }
}