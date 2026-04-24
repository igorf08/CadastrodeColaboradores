package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    private ColaboradoresRepository colaboradoresRepository;

    public ColaboradorService(ColaboradoresRepository colaboradoresRepository) {
        this.colaboradoresRepository = colaboradoresRepository;
    }

    public List<ColaboradorModel> listarColaboradores(){
        return colaboradoresRepository.findAll();
    }

    public ColaboradorModel listarColaboradores(Long id){
        Optional<ColaboradorModel> colaboradorPorId = colaboradoresRepository.findById(id);
        return colaboradorPorId.orElse(null);
    }

    public ColaboradorModel criarColaborador(ColaboradorModel colaborador){
        return colaboradoresRepository.save(colaborador);
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
