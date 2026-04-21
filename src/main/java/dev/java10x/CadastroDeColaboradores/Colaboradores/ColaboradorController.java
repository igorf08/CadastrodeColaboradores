package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {

    @PostMapping("/criar")
    public String criarColaborador() {
        return "Colaborador criado com sucesso.";
    }

    @GetMapping("/todos")
    public String listarColaboradores() {
        return "Colaboradores listados com sucesso.";
    }

    @GetMapping("/todosID")
    public String listarColaboradoresPorId() {
        return "Colaborador listado por ID com sucesso.";
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