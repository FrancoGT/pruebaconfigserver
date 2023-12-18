package clinica.gestion.sistemaClinica.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import clinica.gestion.sistemaClinica.entity.Consulta;

public interface ConsultaRepository extends MongoRepository<Consulta, String> 
{   
}