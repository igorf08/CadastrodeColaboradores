package dev.java10x.CadastroDeColaboradores.Atividades;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class AtividadesController {


    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missões listadas com sucesso.";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso.";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso.";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletar com sucesso.";
    }

}
