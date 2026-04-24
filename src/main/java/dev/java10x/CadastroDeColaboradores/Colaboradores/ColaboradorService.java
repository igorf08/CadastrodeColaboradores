package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    private ColaboradoresRepository colaboradoresRepository;
    private ColaboradoresMapper colaboradoresMapper;

    public ColaboradorService(ColaboradoresRepository colaboradoresRepository, ColaboradoresMapper colaboradoresMapper) {
        this.colaboradoresRepository = colaboradoresRepository;
        this.colaboradoresMapper = colaboradoresMapper;
    }

    public List<ColaboradorModel> listarColaboradores(){
        return colaboradoresRepository.findAll();
    }

    public ColaboradorModel listarColaboradores(Long id){
        Optional<ColaboradorModel> colaboradorPorId = colaboradoresRepository.findById(id);
        return colaboradorPorId.orElse(null);
    }

    public ColaboradoresDTO criarColaborador(ColaboradoresDTO colaboradorDTO){
        ColaboradorModel colaborador = colaboradoresMapper.map(colaboradorDTO);
        colaborador = colaboradoresRepository.save(colaborador);
        return colaboradoresMapper.map(colaborador);
    }

    public void deletarColaborador(Long id){
        colaboradoresRepository.deleteById(id);
    }

    public ColaboradorModel editarColaborador(Long id, ColaboradorModel colaboradorAtualizado){
        if (colaboradoresRepository.existsById(id)) {
            colaboradorAtualizado.setId(id);
            return colaboradoresRepository.save(colaboradorAtualizado);
        }
        return null;
    }



}
