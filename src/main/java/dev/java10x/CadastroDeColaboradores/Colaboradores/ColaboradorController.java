package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ColaboradorController {

    @GetMapping("/")
    public String index() {
        return "Essa é minha index.";
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nesta rota.";
    }

    //Adicionar colaborador (Create)
    @PostMapping("/criar")
    public String criarColaborador() {
        return "Colaborador criado";
    }

    //Mostrar colaboradores (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsColaboradores() {
        return "Mostrar colaborador";
    }

    //Procurar colaborador Por Id (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsColaboradoresPorId() {
        return "Mostrar colaboradores Por Id";
    }

    //Alterar dados do colaborador (Update)
    @PutMapping("/alterarID")
    public String alterarColaboradorPorId() {
        return "Alterar colaboradores por Id";
    }

    //Deletar colaborador (Delete)
    @DeleteMapping("/deletarID")
    public String deletarColaboradorPorId() {
        return "Deletar colaborador por id";
    }

}