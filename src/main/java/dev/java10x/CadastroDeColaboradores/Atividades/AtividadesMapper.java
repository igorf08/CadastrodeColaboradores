package dev.java10x.CadastroDeColaboradores.Atividades;

import org.springframework.stereotype.Component;

@Component
public class AtividadesMapper {

    public AtividadesModel map(AtividadesDTO atividadesDTO) {
        AtividadesModel atividadesModel = new AtividadesModel();

        atividadesModel.setId(atividadesDTO.getId());
        atividadesModel.setNome(atividadesDTO.getNome());
        atividadesModel.setDificuldade(atividadesDTO.getDificuldade());

        return atividadesModel;
    }

    public AtividadesDTO map(AtividadesModel atividadesModel) {
        AtividadesDTO atividadesDTO = new AtividadesDTO();

        atividadesDTO.setId(atividadesModel.getId());
        atividadesDTO.setNome(atividadesModel.getNome());
        atividadesDTO.setDificuldade(atividadesModel.getDificuldade());

        return atividadesDTO;
    }
}
