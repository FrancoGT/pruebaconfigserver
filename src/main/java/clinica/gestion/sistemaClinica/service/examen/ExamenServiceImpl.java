package clinica.gestion.sistemaClinica.service.examen;

import clinica.gestion.sistemaClinica.entity.Examen;
import clinica.gestion.sistemaClinica.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements ExamenService 
{
    private final ExamenRepository examenRepository;
    @Autowired
    public ExamenServiceImpl(ExamenRepository examenRepository) 
    {
        this.examenRepository = examenRepository;
    }
    @Override
    public List<Examen> obtenerTodosExamenes() 
    {
        return examenRepository.findAll();
    }

    @Override
    public Optional<Examen> obtenerExamenPorId(Long id) 
    {
        return examenRepository.findById(id);
    }
    @Override
    public Examen guardarExamen(Examen examen) 
    {
        return examenRepository.save(examen);
    }
    @Override
    public Examen actualizarExamen(Long id, Examen examen) 
    {
        if (examenRepository.existsById(id)) 
        {
            examen.setIdExamen(id);
            return examenRepository.save(examen);
        }
        return null; // Pendiente: agregar exception
    }
    @Override
    public void eliminarExamen(Long id) 
    {
        examenRepository.deleteById(id);
    }
}