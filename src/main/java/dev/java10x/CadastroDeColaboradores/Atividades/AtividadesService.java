package dev.java10x.CadastroDeColaboradores.Atividades;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadesService {
    private AtividadesRepository atividadesRepository;
    private AtividadesMapper atividadesMapper;


    public AtividadesService(AtividadesRepository atividadesRepository, AtividadesMapper atividadesMapper) {
        this.atividadesRepository = atividadesRepository;
        this.atividadesMapper = atividadesMapper;
    }

    public AtividadesDTO criarAtividade(AtividadesDTO atividadeDTO) {
        AtividadesModel atividade = atividadesMapper.map(atividadeDTO);
        atividade = atividadesRepository.save(atividade);
        return atividadesMapper.map(atividade);
    }

    public List<AtividadesDTO> listarAtividades() {
        List<AtividadesModel> atividades = atividadesRepository.findAll();
        return atividades.stream()
                .map(atividadesMapper::map)
                .toList();
    }


    public AtividadesDTO listarAtividadePorId(Long id) {
        Optional<AtividadesModel> atividade = atividadesRepository.findById(id);
        return atividade.map(atividadesMapper::map).orElse(null);
    }

    public AtividadesDTO editarAtividade(Long id, AtividadesDTO atividade) {
        Optional<AtividadesModel> atividadeExistente = atividadesRepository.findById(id);
        if (atividadeExistente.isPresent()) {
            atividade.setId(id);
            AtividadesModel atividadeModel = atividadesMapper.map(atividade);
            atividadesRepository.save(atividadeModel);
            return atividadesMapper.map(atividadeModel);
        }
        return null;
    }


    public void deletarAtividade(Long id) {
        atividadesRepository.deleteById(id);
    }

}
