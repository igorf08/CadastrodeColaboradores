package dev.java10x.CadastroDeColaboradores.Atividades;

import dev.java10x.CadastroDeColaboradores.Colaboradores.ColaboradorModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadesService {
    private AtividadesRepository atividadesRepository;

    public AtividadesService(AtividadesRepository atividadesRepository) {
        this.atividadesRepository = atividadesRepository;
    }

    public AtividadesModel criarAtividade(AtividadesModel atividade) {
        return atividadesRepository.save(atividade);
    }

    public List<AtividadesModel> listarAtividades() {
        return atividadesRepository.findAll();
    }

    public AtividadesModel listarAtividadePorId(Long id) {
        return atividadesRepository.findById(id).orElse(null);
    }

    public AtividadesModel editarAtividade(Long id, AtividadesModel atividade) {
        Optional<AtividadesModel> atividadeExistente = atividadesRepository.findById(id);
        if (atividadeExistente.isPresent()) {
            atividade.setId(id);
            return atividadesRepository.save(atividade);
        }
        return null;
    }

    public void deletarAtividade(Long id) {
        atividadesRepository.deleteById(id);
    }

}
