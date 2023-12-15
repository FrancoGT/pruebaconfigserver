package clinica.gestion.sistemaClinica.repository;
import clinica.gestion.sistemaClinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> 
{
    // Métodos de consulta personalizados
    List<Paciente> findByNombres(String nombres);
    List<Paciente> findByApellidos(String apellidos);
    Paciente findByDni(String dni);
    // Método para buscar por ID (ya proporcionado por JpaRepository)
    // No es necesario agregar un método específico para buscar por ID
}
