package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColaboradorService {

    private ColaboradoresRepository colaboradoresRepository;
    private ColaboradoresMapper colaboradoresMapper;

    public ColaboradorService(ColaboradoresRepository colaboradoresRepository, ColaboradoresMapper colaboradoresMapper) {
        this.colaboradoresRepository = colaboradoresRepository;
        this.colaboradoresMapper = colaboradoresMapper;
    }

    public List<ColaboradoresDTO> listarColaboradores(){
        List<ColaboradorModel> colaboradores = colaboradoresRepository.findAll();
        return colaboradores.stream()
                .map(colaboradoresMapper::map)
                .collect(Collectors.toList());
    }

    public ColaboradoresDTO listarColaboradores(Long id){
        Optional<ColaboradorModel> colaboradorPorId = colaboradoresRepository.findById(id);
        return colaboradorPorId.map(colaboradoresMapper::map).orElse(null);
    }

    public ColaboradoresDTO criarColaborador(ColaboradoresDTO colaboradorDTO){
        ColaboradorModel colaborador = colaboradoresMapper.map(colaboradorDTO);
        colaborador = colaboradoresRepository.save(colaborador);
        return colaboradoresMapper.map(colaborador);
    }

    public void deletarColaborador(Long id){
        colaboradoresRepository.deleteById(id);
    }

    public ColaboradoresDTO editarColaborador(Long id, ColaboradoresDTO colaboradorDTO){
        Optional<ColaboradorModel> colaborador = colaboradoresRepository.findById(id);
        if (colaborador.isPresent()) {
            ColaboradorModel colaboradorAtualizado = colaboradoresMapper.map(colaboradorDTO);
            colaboradorAtualizado.setId(id);
            ColaboradorModel colaboradorSalvo = colaboradoresRepository.save(colaboradorAtualizado);
            return colaboradoresMapper.map(colaboradorSalvo);
        }
        return null;
    }
}
