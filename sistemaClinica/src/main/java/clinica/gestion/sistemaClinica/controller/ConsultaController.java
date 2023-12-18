package clinica.gestion.sistemaClinica.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import clinica.gestion.sistemaClinica.entity.Consulta;
import clinica.gestion.sistemaClinica.service.consulta.ConsultaService;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController 
{
    private final ConsultaService consultaService;
    @Autowired
    public ConsultaController(ConsultaService consultaService) 
    {
        this.consultaService = consultaService;
    }
    @GetMapping
    public ResponseEntity<List<Consulta>> getAllConsultas() 
    {
        List<Consulta> consultas = consultaService.getAllConsultas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable String id) 
    {
        return consultaService.getConsultaById(id)
                .map(consulta -> new ResponseEntity<>(consulta, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Consulta> saveConsulta(@RequestBody Consulta consulta) 
    {
        Consulta savedConsulta = consultaService.saveConsulta(consulta);
        return new ResponseEntity<>(savedConsulta, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable String id) 
    {
        consultaService.deleteConsulta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}