package clinica.gestion.sistemaClinica.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import clinica.gestion.sistemaClinica.entity.DetalleConsulta;
import clinica.gestion.sistemaClinica.service.detalle_consulta.DetalleConsultaService;
import java.util.List;

@RestController
@RequestMapping("/api/detalles-consulta")
public class DetalleConsultaController 
{
    private final DetalleConsultaService detalleConsultaService;
    @Autowired
    public DetalleConsultaController(DetalleConsultaService detalleConsultaService) 
    {
        this.detalleConsultaService = detalleConsultaService;
    }
    @GetMapping
    public ResponseEntity<List<DetalleConsulta>> getAllDetallesConsulta() 
    {
        List<DetalleConsulta> detallesConsulta = detalleConsultaService.getAllDetallesConsulta();
        return new ResponseEntity<>(detallesConsulta, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetalleConsulta> getDetalleConsultaById(@PathVariable String id) 
    {
        return detalleConsultaService.getDetalleConsultaById(id)
                .map(detalleConsulta -> new ResponseEntity<>(detalleConsulta, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<DetalleConsulta> saveDetalleConsulta(@RequestBody DetalleConsulta detalleConsulta) 
    {
        DetalleConsulta savedDetalleConsulta = detalleConsultaService.saveDetalleConsulta(detalleConsulta);
        return new ResponseEntity<>(savedDetalleConsulta, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleConsulta(@PathVariable String id) 
    {
        detalleConsultaService.deleteDetalleConsulta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}