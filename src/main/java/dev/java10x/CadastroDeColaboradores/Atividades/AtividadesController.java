package dev.java10x.CadastroDeColaboradores.Atividades;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atividades")
public class AtividadesController {

    private final AtividadesService atividadesService;

    public AtividadesController(AtividadesService atividadesService) {
        this.atividadesService = atividadesService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Criação de atividade",  description = "Esta rota é responsável por criar uma atividade.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atividade criada com sucesso."),
    })
    public ResponseEntity<AtividadesDTO> criarAtividade(@RequestBody AtividadesDTO atividade) {
        atividadesService.criarAtividade(atividade);
        return ResponseEntity.ok(atividade);
    }

    @GetMapping("/listar")
    @Operation(summary = "Listagem de atividades",  description = "Esta rota é responsável por listar as atividades cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atividades listadas com sucesso."),
    })
    public ResponseEntity<List<AtividadesDTO>> listarAtividades() {
        List<AtividadesDTO> atividades = atividadesService.listarAtividades();
        return ResponseEntity.ok(atividades);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listagem de atividade específica",  description = "Esta rota é responsável por listar uma atividade cadastrada através do ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atividade listada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Não foi encontrada nenhuma atividade com o ID informado."),
    })
    public ResponseEntity<?> listarAtividadePorId(@PathVariable Long id) {
        AtividadesDTO atividade = atividadesService.listarAtividadePorId(id);
        if (atividade != null) {
            return ResponseEntity.ok(atividade);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma atividade com ID " + id);
        }
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Edição de atividade",  description = "Esta rota é responsável por editar uma atividade cadastrada através do ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atividade editada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Não foi encontrada nenhuma atividade com o ID informado."),
    })
    public ResponseEntity<?> editarAtividade(
            @Parameter(description = "Usuário informa o id no caminho da requisição.")  @PathVariable Long id,
            @Parameter(description = "Usuário informa a atividade a ser atualizado no corpo da requisição.") @RequestBody AtividadesDTO atividadeDTO
    ) {
        AtividadesDTO atividade = atividadesService.listarAtividadePorId(id);
        if(atividade != null) {
            atividadesService.editarAtividade(id, atividadeDTO);
            return ResponseEntity.ok(atividadeDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma atividade com ID " + id);
        }
    }
}
