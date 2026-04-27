package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarColaborador(@RequestBody ColaboradoresDTO colaborador) {
        ColaboradoresDTO novoColaborador = colaboradorService.criarColaborador(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Colaborador criado com sucesso.\n" + "ID: " + novoColaborador.getId() + " Nome: " + novoColaborador.getNome());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ColaboradoresDTO>> listarColaboradores() {
        List<ColaboradoresDTO> colaboradores = colaboradorService.listarColaboradores();
        return ResponseEntity.ok(colaboradores);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarColaboradorPorId(@PathVariable Long id) {

        ColaboradoresDTO colaborador = colaboradorService.listarColaboradorPorId(id);

        if (colaborador != null) {
            return ResponseEntity.status(HttpStatus.OK).body(colaborador);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum colaborador com este ID.");
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarColaboradorPorId(@PathVariable Long id, @RequestBody ColaboradoresDTO colaboradorAtualizado) {

        ColaboradoresDTO colaborador = colaboradorService.editarColaborador(id, colaboradorAtualizado);

        if (colaborador != null) {
            return ResponseEntity.ok(colaboradorAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um colaborador com id " + id + ".");
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarColaborador(@PathVariable Long id) {

        ColaboradoresDTO colaborador = colaboradorService.listarColaboradorPorId(id);

        if (colaborador != null) {
            colaboradorService.deletarColaborador(id);
            return ResponseEntity.ok("Seu colaborador foi excluído.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um colaborador com id " + id + ".");
        }
    }

}