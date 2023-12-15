package clinica.gestion.sistemaClinica.service.medico;
import clinica.gestion.sistemaClinica.entity.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoService 
{
    List<Medico> obtenerTodosMedicos();
    Optional<Medico> obtenerMedicoPorId(Long id);
    Medico guardarMedico(Medico medico);
    Medico actualizarMedico(Long id, Medico medico);
    void eliminarMedico(Long id);
}