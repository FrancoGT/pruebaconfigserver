package clinica.gestion.sistemaClinica.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import clinica.gestion.sistemaClinica.entity.ConsultaExamen;
import clinica.gestion.sistemaClinica.service.consulta_examen.ConsultaExamenService;
import java.util.List;

@RestController
@RequestMapping("/api/consulta-examenes")
public class ConsultaExamenController 
{
    private final ConsultaExamenService consultaExamenService;
    @Autowired
    public ConsultaExamenController(ConsultaExamenService consultaExamenService) 
    {
        this.consultaExamenService = consultaExamenService;
    }
    @GetMapping
    public ResponseEntity<List<ConsultaExamen>> getAllConsultaExamenes() 
    {
        List<ConsultaExamen> consultaExamenes = consultaExamenService.getAllConsultaExamenes();
        return new ResponseEntity<>(consultaExamenes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaExamen> getConsultaExamenById(@PathVariable String id) 
    {
        return consultaExamenService.getConsultaExamenById(id)
                .map(consultaExamen -> new ResponseEntity<>(consultaExamen, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<ConsultaExamen> saveConsultaExamen(@RequestBody ConsultaExamen consultaExamen) 
    {
        ConsultaExamen savedConsultaExamen = consultaExamenService.saveConsultaExamen(consultaExamen);
        return new ResponseEntity<>(savedConsultaExamen, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultaExamen(@PathVariable String id) 
    {
        consultaExamenService.deleteConsultaExamen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}