package dev.java10x.CadastroDeColaboradores.Colaboradores;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Criação de colaborador", description = "Esta rota fica responsável pela criação de colaboradores")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Colaborador criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na criação do colaborador.")
    })

    public ResponseEntity<String> criarColaborador(@RequestBody ColaboradoresDTO colaborador) {
        ColaboradoresDTO novoColaborador = colaboradorService.criarColaborador(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Colaborador criado com sucesso.\n" + "ID: " + novoColaborador.getId() + " Nome: " + novoColaborador.getNome());
    }

    @GetMapping("/listar")
    @Operation(summary = "Listagem de todos os colaboradores", description = "Esta rota é responsável por listar todos os colaboradores cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Colaboradores listados com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na listagem dos colaboradores.")
    })
    public ResponseEntity<List<ColaboradoresDTO>> listarColaboradores() {
        List<ColaboradoresDTO> colaboradores = colaboradorService.listarColaboradores();
        return ResponseEntity.ok(colaboradores);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listagem de um colaborador específico",  description = "Esta rota é responsável por listar um colaborador cadastrado através do ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Colaborador listado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Não foi encontrado nenhum colaborador com o ID informado.")
    })
    public ResponseEntity<?> listarColaboradorPorId(@PathVariable Long id) {

        ColaboradoresDTO colaborador = colaboradorService.listarColaboradorPorId(id);

        if (colaborador != null) {
            return ResponseEntity.status(HttpStatus.OK).body(colaborador);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum colaborador com este ID.");
        }
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Edição de colaborador",  description = "Esta rota é responsável por editar um colaborador cadastrado através do ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Colaborador editado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Não foi encontrado nenhum colaborador com o ID informado.")
    })
    public ResponseEntity<?> editarColaboradorPorId(
            @Parameter(description = "Usuário informa o id no caminho da requisição.") @PathVariable Long id,
            @Parameter(description = "Usuário informa o colaborador a ser atualizado no corpo da requisição.") @RequestBody ColaboradoresDTO colaboradorAtualizado
    ) {

        ColaboradoresDTO colaborador = colaboradorService.editarColaborador(id, colaboradorAtualizado);

        if (colaborador != null) {
            return ResponseEntity.ok(colaboradorAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado um colaborador com id " + id + ".");
        }

    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleção de colaborador",  description = "Esta rota é responsável por deletar um colaborador cadastrado através do ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Colaborador deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Não foi encontrado nenhum colaborador com o ID informado.")
    })
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