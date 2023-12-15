package clinica.gestion.sistemaClinica.repository;
import clinica.gestion.sistemaClinica.entity.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<Examen, Long> 
{
}
