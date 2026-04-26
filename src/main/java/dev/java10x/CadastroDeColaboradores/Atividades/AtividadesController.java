package dev.java10x.CadastroDeColaboradores.Atividades;

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
    public AtividadesDTO criarAtividade(@RequestBody AtividadesDTO atividade) {
        return atividadesService.criarAtividade(atividade);
    }

    @GetMapping("/listar")
    public List<AtividadesDTO> listarAtividades() {
        return atividadesService.listarAtividades();
    }

    @GetMapping("/listar/{id}")
    public AtividadesDTO listarAtividadePorId(@PathVariable Long id) {
        return atividadesService.listarAtividadePorId(id);
    }


    @PutMapping("/editar/{id}")
    public AtividadesDTO editarAtividade(@PathVariable Long id, @RequestBody AtividadesDTO atividade) {
        return atividadesService.editarAtividade(id, atividade);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarAtividade(@PathVariable Long id) {
        atividadesService.deletarAtividade(id);
    }

}
