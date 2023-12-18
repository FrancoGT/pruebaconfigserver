package clinica.gestion.sistemaClinica.service.examen;
import clinica.gestion.sistemaClinica.entity.Examen;
import java.util.List;
import java.util.Optional;

public interface ExamenService 
{
    List<Examen> obtenerTodosExamenes();
    Optional<Examen> obtenerExamenPorId(Long id);
    Examen guardarExamen(Examen examen);
    Examen actualizarExamen(Long id, Examen examen);
    void eliminarExamen(Long id);
}