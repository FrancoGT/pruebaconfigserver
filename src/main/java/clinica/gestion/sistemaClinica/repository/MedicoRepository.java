package clinica.gestion.sistemaClinica.repository;
import clinica.gestion.sistemaClinica.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> 
{
}