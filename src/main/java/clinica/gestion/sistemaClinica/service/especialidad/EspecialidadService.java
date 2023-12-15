package clinica.gestion.sistemaClinica.service.especialidad;
import clinica.gestion.sistemaClinica.entity.Especialidad;
import java.util.List;
import java.util.Optional;

public interface EspecialidadService 
{
    List<Especialidad> obtenerTodasEspecialidades();
    Optional<Especialidad> obtenerEspecialidadPorId(Long id);
    Especialidad guardarEspecialidad(Especialidad especialidad);
    Especialidad actualizarEspecialidad(Long id, Especialidad especialidad);
    void eliminarEspecialidad(Long id);
}