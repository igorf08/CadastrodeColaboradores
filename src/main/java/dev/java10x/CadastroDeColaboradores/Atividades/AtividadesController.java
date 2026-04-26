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
    public AtividadesModel criarAtividade(@RequestBody AtividadesModel atividade) {
        return atividadesService.criarAtividade(atividade);
    }

    @GetMapping("/listar")
    public List<AtividadesModel> listarAtividades() {
        return atividadesService.listarAtividades();
    }

    @GetMapping("/listar/{id}")
    public AtividadesModel listarAtividadePorId(@PathVariable Long id) {
        return atividadesService.listarAtividadePorId(id);
    }


    @PutMapping("/editar/{id}")
    public AtividadesModel editarAtividade(@PathVariable Long id, @RequestBody AtividadesModel atividade) {
        return atividadesService.editarAtividade(id, atividade);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarAtividade(@PathVariable Long id) {
        atividadesService.deletarAtividade(id);
    }

}
