package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {

    private ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @PostMapping("/criar")
    public String criarColaborador() {
        return "Colaborador criado com sucesso.";
    }

    @GetMapping("/todos")
    public List<ColaboradorModel> listarColaboradores() {
        return colaboradorService.listarColaboradores();
    }

    @GetMapping("/listar/{id}")
    public ColaboradorModel listarColaboradoresPorId(@PathVariable Long id) {
        return colaboradorService.listarColaboradores(id);
    }

    @PutMapping("/alterarID")
    public String alterarColaboradorPorId() {
        return "Colaborador alterado por ID com sucesso.";
    }

    @DeleteMapping("/deletarID")
    public String deletarColaboradorPorId() {
        return "Colaborador deletado por ID com sucesso.";
    }

}