package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.domain.Tributo;
import br.edu.infnet.apppagamento.model.service.TributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TributoController {

	@Autowired
	private TributoService service;

	@GetMapping(value = "/tributo/lista")
	public String telaTributo(Model model) {
		model.addAttribute("listagem", service.obterLista());
		return "tributo/lista";
	}
	
	@PostMapping(value = "/tributo/incluir")
	public String inclusao(Tributo tributo) {
		
		service.incluir(tributo);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/tributo/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		service.excluir(id);
		return "redirect:/tributo/lista";
	}
}
