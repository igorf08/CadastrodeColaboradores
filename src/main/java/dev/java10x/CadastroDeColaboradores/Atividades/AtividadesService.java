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

    public AtividadesDTO criarAtividade(AtividadesDTO atividadesDTO){
        AtividadesModel atividade = atividadesMapper.map(atividadesDTO);
        atividade = atividadesRepository.save(atividade);
        return atividadesMapper.map(atividade);
    }

    public List<AtividadesDTO> listarAtividades(){
        List<AtividadesModel> atividades = atividadesRepository.findAll();
        return atividades.stream()
                .map(atividadesMapper::map)
                .toList();
    }

    public AtividadesDTO listarAtividadePorId(Long id){
        Optional<AtividadesModel> atividadePorId = atividadesRepository.findById(id);
        if (atividadePorId.isPresent()) {
            return atividadePorId.map(atividadesMapper::map).orElse(null);
        }
        return null;
    }

    public AtividadesDTO editarAtividade(Long id, AtividadesDTO atividadesDTO){
        Optional<AtividadesModel> atividade = atividadesRepository.findById(id);
        if (atividade.isPresent()) {
            AtividadesModel atividadeAtualizada = atividadesMapper.map(atividadesDTO);
            atividadeAtualizada.setId(id);
            AtividadesModel atividadeSalva = atividadesRepository.save(atividadeAtualizada);
            return atividadesMapper.map(atividadeAtualizada);
        }
        return null;
    }

    public void deletarAtividade(Long id){
        atividadesRepository.deleteById(id);
    }

}
