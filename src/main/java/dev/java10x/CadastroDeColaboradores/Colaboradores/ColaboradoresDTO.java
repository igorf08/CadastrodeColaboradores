package dev.java10x.CadastroDeColaboradores.Colaboradores;

import dev.java10x.CadastroDeColaboradores.Atividades.AtividadesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradoresDTO {

    private Long id;
    private String nome;
    private String email;
    private String funcao;
    private AtividadesModel atividades;
    private String modeloContratacao;
    private String imgUrl;

}
