package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContaController {
	
	@Autowired
	private ContaService service;

    @GetMapping(value = "/conta/lista")
    public String telaConta(Model model) {
    	model.addAttribute("listagem", service.obterLista());
        return "conta/lista";
    }
}
