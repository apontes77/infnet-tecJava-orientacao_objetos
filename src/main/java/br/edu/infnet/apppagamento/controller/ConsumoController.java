package br.edu.infnet.apppagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Consumo;
import br.edu.infnet.model.domain.service.ConsumoService;

@Controller
public class ConsumoController {
	
	@Autowired
	private ConsumoService service;
	
    @GetMapping(value = "/consumo/lista")
    public String telaConsumo(Model model) {	
		model.addAttribute("listagem", service.obterLista());
        return "consumo/lista";
    }
    
    @PostMapping(value = "/consumo/incluir")
	public String inclusao(Consumo consumo) {
		
    	service.incluir(consumo);
		
		return "redirect:/";
	}
    
    @GetMapping(value = "/consumo/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
    	service.excluir(id);
    
    	return "redirect:/consumo/lista";
    }
}
