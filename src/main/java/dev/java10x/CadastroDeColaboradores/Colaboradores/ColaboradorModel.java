package dev.java10x.CadastroDeColaboradores.Colaboradores;

import dev.java10x.CadastroDeColaboradores.Atividades.AtividadesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ColaboradorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String funcao;

    @Column(name = "modelo_contratacao")
    private String modeloContratacao;

    @Column(name = "img_url")
    private String imgUrl;

    // @ManyToOne - Um colaborador só pode ter uma missão.
    @ManyToOne
    @JoinColumn(name = "atividades_id") // Foreign Key
    private AtividadesModel atividades;

}
