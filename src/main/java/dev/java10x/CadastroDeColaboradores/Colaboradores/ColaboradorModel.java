package dev.java10x.CadastroDeColaboradores.Colaboradores;

import dev.java10x.CadastroDeColaboradores.Atividades.AtividadesModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")

public class ColaboradorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String funcao;

    // @ManyToOne - Um colaborador só pode ter uma missão.
    @ManyToOne
    @JoinColumn(name = "atividades_id") // Foreign Key
    private AtividadesModel atividades;

    public ColaboradorModel(){
    }

    public ColaboradorModel(String nome, String email, String funcao) {
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
    }

}
