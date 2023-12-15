package clinica.gestion.sistemaClinica.controller;
import clinica.gestion.sistemaClinica.entity.Paciente;
import clinica.gestion.sistemaClinica.service.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController 
{

    private final PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) 
    {
        this.pacienteService = pacienteService;
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodosPacientes() 
    {
        List<Paciente> pacientes = pacienteService.obtenerTodosPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long id) 
    {
        Optional<Paciente> paciente = pacienteService.obtenerPacientePorId(id);
        return paciente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente) 
    {
        Paciente nuevoPaciente = pacienteService.guardarPaciente(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) 
    {
        Paciente pacienteActualizado = pacienteService.actualizarPaciente(id, paciente);
        if (pacienteActualizado != null) 
        {
            return new ResponseEntity<>(pacienteActualizado, HttpStatus.OK);
        } 
        else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) 
    {
        pacienteService.eliminarPaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}