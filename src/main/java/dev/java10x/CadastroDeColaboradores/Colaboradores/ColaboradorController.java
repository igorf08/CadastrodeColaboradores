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
    public ColaboradoresDTO criarColaborador(@RequestBody ColaboradoresDTO colaborador) {
        return colaboradorService.criarColaborador(colaborador);
    }

    @GetMapping("/todos")
    public List<ColaboradoresDTO> listarColaboradores() {
        return colaboradorService.listarColaboradores();
    }

    @GetMapping("/listar/{id}")
    public ColaboradoresDTO listarColaboradoresPorId(@PathVariable Long id) {
        return colaboradorService.listarColaboradores(id);
    }

    @PutMapping("/alterar/{id}")
    public ColaboradoresDTO alterarColaboradorPorId(@PathVariable Long id, @RequestBody ColaboradoresDTO colaboradorAtualizado) {
        return colaboradorService.editarColaborador(id, colaboradorAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarColaboradorPorId(@PathVariable Long id) {
        colaboradorService.deletarColaborador(id);
    }

}