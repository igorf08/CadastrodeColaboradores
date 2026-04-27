package dev.java10x.CadastroDeColaboradores.Colaboradores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/colaboradores/ui")
public class ColaboradorControllerUi {
    private final ColaboradorService colaboradorService;

    public ColaboradorControllerUi(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping("/criar")
    public String criarColaborador(ColaboradoresDTO colaborador, Model model) {
        model.addAttribute("colaborador", new ColaboradoresDTO());
        return "adicionarColaborador";
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
          model.addAttribute("colaborador", colaborador);
          if (colaborador != null) {
            return "detalhesColaborador";
          } else {
              model.addAttribute("mensagem", "Colaborador não encontrado.");
              return "redirect:/colaboradores/ui/listar";
          }
    }

    @PostMapping("salvar")
    public String salvarColaborador(@ModelAttribute ColaboradoresDTO colaborador, RedirectAttributes redirectAttributes) {
        colaboradorService.criarColaborador(colaborador);
        redirectAttributes.addFlashAttribute("mensagem", "Colaborador cadastrado.");
        return "redirect:/colaboradores/ui/listar";
    }
}
