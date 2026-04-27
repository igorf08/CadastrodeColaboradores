package dev.java10x.CadastroDeColaboradores.Atividades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeColaboradores.Colaboradores.ColaboradorModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_atividades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
public class AtividadesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    // @OneToMany - Uma atividade pode conter vários colaboradores.
    @OneToMany(mappedBy = "atividades")
    @JsonIgnore
    private List<ColaboradorModel> colaborador;

}
