package dev.java10x.CadastroDeColaboradores.Atividades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtividadesDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<AtividadesModel> colaborador;

}
