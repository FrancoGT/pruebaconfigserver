package clinica.gestion.sistemaClinica.service.paciente;
import clinica.gestion.sistemaClinica.entity.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteService 
{
    List<Paciente> obtenerTodosPacientes();
    Optional<Paciente> obtenerPacientePorId(Long id);
    Paciente guardarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
    Paciente actualizarPaciente(Long id, Paciente paciente);
}