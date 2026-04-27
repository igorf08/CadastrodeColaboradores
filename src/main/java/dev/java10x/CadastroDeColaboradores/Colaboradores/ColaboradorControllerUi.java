package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/colaboradores/ui")
public class ColaboradorControllerUi {
    private final ColaboradorService colaboradorService;

    public ColaboradorControllerUi(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping("/listar")
    public String listarColaboradores(Model model) {
        List<ColaboradoresDTO> colaboradores = colaboradorService.listarColaboradores();
        model.addAttribute("colaboradores", colaboradores);
        return "listarColaboradores";
    }

    @GetMapping("/deletar/{id}")
    public String deletarColaborador(@PathVariable Long id) {
        colaboradorService.deletarColaborador(id);
        return "redirect:/colaboradores/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarColaboradorPorId(@PathVariable Long id, Model model) {

        ColaboradoresDTO colaborador = colaboradorService.listarColaboradorPorId(id);

          colaboradorService.listarColaboradorPorId(id);
          model.addAttribute("colaboradores", colaborador);
          if (colaborador != null) {
            return "detalhesColaborador";
          } else {
              model.addAttribute("mensagem", "Colaborador não encontrado.");
              return "redirect:/colaboradores/ui/listar";
          }
    }
}
