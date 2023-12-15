package clinica.gestion.sistemaClinica.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import clinica.gestion.sistemaClinica.entity.DetalleConsulta;

public interface DetalleConsultaRepository extends MongoRepository<DetalleConsulta, String> 
{
}