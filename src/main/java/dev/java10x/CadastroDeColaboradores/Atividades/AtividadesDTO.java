package dev.java10x.CadastroDeColaboradores.Atividades;
import dev.java10x.CadastroDeColaboradores.Colaboradores.ColaboradorModel;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtividadesDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<ColaboradorModel> colaborador;

}
