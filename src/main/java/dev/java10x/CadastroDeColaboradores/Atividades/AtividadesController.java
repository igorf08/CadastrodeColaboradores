package dev.java10x.CadastroDeColaboradores.Atividades;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atividades")
public class AtividadesController {

    private final AtividadesService atividadesService;

    public AtividadesController(AtividadesService atividadesService) {
        this.atividadesService = atividadesService;
    }

    @PostMapping("/criar")
    public ResponseEntity<AtividadesDTO> criarAtividade(@RequestBody AtividadesDTO atividade) {
        atividadesService.criarAtividade(atividade);
        return ResponseEntity.ok(atividade);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AtividadesDTO>> listarAtividades() {
        List<AtividadesDTO> atividades = atividadesService.listarAtividades();
        return ResponseEntity.ok(atividades);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarAtividadePorId(@PathVariable Long id) {
        AtividadesDTO atividade = atividadesService.listarAtividadePorId(id);
        if (atividade != null) {
            return ResponseEntity.ok(atividade);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma atividade com ID " + id);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarAtividade(@PathVariable Long id, @RequestBody AtividadesDTO atividadeDTO) {
        AtividadesDTO atividade = atividadesService.listarAtividadePorId(id);
        if(atividade != null) {
            atividadesService.editarAtividade(id, atividadeDTO);
            return ResponseEntity.ok(atividadeDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma atividade com ID " + id);
        }
    }
}
