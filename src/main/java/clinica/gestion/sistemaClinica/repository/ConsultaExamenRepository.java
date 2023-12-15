package clinica.gestion.sistemaClinica.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import clinica.gestion.sistemaClinica.entity.ConsultaExamen;

public interface ConsultaExamenRepository extends MongoRepository<ConsultaExamen, String> 
{
}