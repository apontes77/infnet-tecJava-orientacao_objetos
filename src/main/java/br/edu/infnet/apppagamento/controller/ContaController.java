package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.service.ContaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContaController {
	private ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @GetMapping(value = "/conta/lista")
    public String telaConta(Model model) {
    	model.addAttribute("listagem", service.obterLista());
        return "conta/lista";
    }
}
