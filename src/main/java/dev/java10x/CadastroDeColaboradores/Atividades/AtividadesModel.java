package dev.java10x.CadastroDeColaboradores.Atividades;

import dev.java10x.CadastroDeColaboradores.Colaboradores.ColaboradorModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_atividades")

public class AtividadesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    // @OneToMany - Uma atividade pode conter vários colaboradores.
    @OneToMany(mappedBy = "missoes")
    private List<ColaboradorModel> colaborador;


}
