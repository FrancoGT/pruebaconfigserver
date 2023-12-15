package clinica.gestion.sistemaClinica.controller;
import clinica.gestion.sistemaClinica.entity.Especialidad;
import clinica.gestion.sistemaClinica.service.especialidad.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController 
{
    private final EspecialidadService especialidadService;
    @Autowired
    public EspecialidadController(EspecialidadService especialidadService) 
    {
        this.especialidadService = especialidadService;
    }
    @GetMapping
    public ResponseEntity<List<Especialidad>> obtenerTodasEspecialidades() 
    {
        List<Especialidad> especialidades = especialidadService.obtenerTodasEspecialidades();
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> obtenerEspecialidadPorId(@PathVariable Long id) 
    {
        Optional<Especialidad> especialidad = especialidadService.obtenerEspecialidadPorId(id);
        return especialidad.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Especialidad> guardarEspecialidad(@RequestBody Especialidad especialidad) 
    {
        Especialidad nuevaEspecialidad = especialidadService.guardarEspecialidad(especialidad);
        return new ResponseEntity<>(nuevaEspecialidad, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> actualizarEspecialidad(@PathVariable Long id, @RequestBody Especialidad especialidad) 
    {
        Especialidad especialidadActualizada = especialidadService.actualizarEspecialidad(id, especialidad);
        if (especialidadActualizada != null) 
        {
            return new ResponseEntity<>(especialidadActualizada, HttpStatus.OK);
        } 
        else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEspecialidad(@PathVariable Long id) 
    {
        especialidadService.eliminarEspecialidad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}