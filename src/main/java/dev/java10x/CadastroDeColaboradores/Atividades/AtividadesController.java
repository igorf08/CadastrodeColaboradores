package dev.java10x.CadastroDeColaboradores.Atividades;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atividades")
public class AtividadesController {

    private AtividadesService atividadesService;

    public AtividadesController(AtividadesService atividadesService) {
        this.atividadesService = atividadesService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarAtividade(@RequestBody AtividadesDTO novaAtividade) {
        AtividadesDTO atividade = atividadesService.criarAtividade(novaAtividade);
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
    public ResponseEntity<?> editarAtividade(@PathVariable Long id, @RequestBody AtividadesDTO atividadeEditada) {
        AtividadesDTO atividade = atividadesService.editarAtividade(id, atividadeEditada);
        if (atividade != null) {
            return ResponseEntity.ok(atividade);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma atividade com ID " + id);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarAtividade(@PathVariable Long id) {

        AtividadesDTO atividade = atividadesService.listarAtividadePorId(id);

        if (atividade != null) {
            atividadesService.deletarAtividade(id);
            return ResponseEntity.ok("Sua atividade foi excluída.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma atividade com ID " + id);
        }
    }

}
