package clinica.gestion.sistemaClinica.controller;
import clinica.gestion.sistemaClinica.entity.Medico;
import clinica.gestion.sistemaClinica.service.medico.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController 
{
    private final MedicoService medicoService;
    @Autowired
    public MedicoController(MedicoService medicoService) 
    {
        this.medicoService = medicoService;
    }
    @GetMapping
    public ResponseEntity<List<Medico>> obtenerTodosMedicos() 
    {
        List<Medico> medicos = medicoService.obtenerTodosMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerMedicoPorId(@PathVariable Long id) 
    {
        Optional<Medico> medico = medicoService.obtenerMedicoPorId(id);
        return medico.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Medico> guardarMedico(@RequestBody Medico medico) 
    {
        Medico nuevoMedico = medicoService.guardarMedico(medico);
        return new ResponseEntity<>(nuevoMedico, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizarMedico(@PathVariable Long id, @RequestBody Medico medico) 
    {
        Medico medicoActualizado = medicoService.actualizarMedico(id, medico);
        if (medicoActualizado != null) 
        {
            return new ResponseEntity<>(medicoActualizado, HttpStatus.OK);
        } 
        else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMedico(@PathVariable Long id) 
    {
        medicoService.eliminarMedico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}