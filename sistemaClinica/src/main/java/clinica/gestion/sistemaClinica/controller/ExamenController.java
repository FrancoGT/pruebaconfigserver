package clinica.gestion.sistemaClinica.controller;
import clinica.gestion.sistemaClinica.entity.Examen;
import clinica.gestion.sistemaClinica.service.examen.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/examenes")
public class ExamenController 
{
    private final ExamenService examenService;
    @Autowired
    public ExamenController(ExamenService examenService) 
    {
        this.examenService = examenService;
    }
    @GetMapping
    public ResponseEntity<List<Examen>> obtenerTodosExamenes() 
    {
        List<Examen> examenes = examenService.obtenerTodosExamenes();
        return new ResponseEntity<>(examenes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Examen> obtenerExamenPorId(@PathVariable Long id) 
    {
        Optional<Examen> examen = examenService.obtenerExamenPorId(id);
        return examen.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen) 
    {
        Examen nuevoExamen = examenService.guardarExamen(examen);
        return new ResponseEntity<>(nuevoExamen, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Examen> actualizarExamen(@PathVariable Long id, @RequestBody Examen examen) 
    {
        Examen examenActualizado = examenService.actualizarExamen(id, examen);
        if (examenActualizado != null) 
        {
            return new ResponseEntity<>(examenActualizado, HttpStatus.OK);
        } 
        else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarExamen(@PathVariable Long id) 
    {
        examenService.eliminarExamen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}