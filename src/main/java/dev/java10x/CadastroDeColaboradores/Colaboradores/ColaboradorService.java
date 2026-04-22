package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    private ColaboradoresRepository colaboradoresRepository;

    public ColaboradorService(ColaboradoresRepository colaboradoresRepository) {
        this.colaboradoresRepository = colaboradoresRepository;
    }

    public List<ColaboradorModel> listarColaboradores(){
        return colaboradoresRepository.findAll();
    }
}
