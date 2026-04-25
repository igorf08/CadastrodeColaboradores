package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.stereotype.Component;

@Component
public class ColaboradoresMapper {

    public ColaboradorModel map(ColaboradoresDTO colaboradoresDTO) {

        ColaboradorModel colaboradorModel = new ColaboradorModel();
        colaboradorModel.setId(colaboradoresDTO.getId());
        colaboradorModel.setNome(colaboradoresDTO.getNome());
        colaboradorModel.setEmail(colaboradoresDTO.getEmail());
        colaboradorModel.setFuncao(colaboradoresDTO.getFuncao());
        colaboradorModel.setModeloContratacao(colaboradoresDTO.getModeloContratacao());
        colaboradorModel.setAtividades(colaboradoresDTO.getAtividades());

        return colaboradorModel;
    }

    public ColaboradoresDTO map(ColaboradorModel colaboradorModel) {

        ColaboradoresDTO colaboradoresDTO = new ColaboradoresDTO();
        colaboradoresDTO.setId(colaboradorModel.getId());
        colaboradoresDTO.setNome(colaboradorModel.getNome());
        colaboradoresDTO.setEmail(colaboradorModel.getEmail());
        colaboradoresDTO.setFuncao(colaboradorModel.getFuncao());
        colaboradoresDTO.setModeloContratacao(colaboradorModel.getModeloContratacao());
        colaboradoresDTO.setAtividades(colaboradorModel.getAtividades());

        return colaboradoresDTO;
    }
}
