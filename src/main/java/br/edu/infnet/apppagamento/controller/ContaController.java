package br.edu.infnet.apppagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.model.domain.service.ContaService;

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
