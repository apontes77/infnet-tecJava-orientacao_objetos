package br.edu.infnet.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Extra;
import br.edu.infnet.model.service.ExtraService;

@Controller
public class ExtraController {
	
	@Autowired
	private ExtraService service;

    @GetMapping(value = "/extra/lista")
    public String telaExtra(Model model) {
        model.addAttribute("listagem", service.obterLista());
    	return "extra/lista";
    }
    
    @PostMapping(value = "/extra/incluir")
	public String inclusao(Extra extra) {
		
    	service.incluir(extra);
		
		return "redirect:/";
	}
    
    @GetMapping(value = "/extra/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
    	service.excluir(id);
    
    	return "redirect:/extra/lista";
    }
}
