package br.edu.infnet.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Pagamento;
import br.edu.infnet.model.service.PagamentoService;

@Controller
public class PagamentoController {
	
	@Autowired
	private PagamentoService service;

    @GetMapping(value = "/pagamento/lista")
    public String telaPagamento(Model model) {
    	model.addAttribute("listagem", service.obterLista());
    	
        return "pagamento/lista";
    }
    
    @PostMapping(value = "/pagamento/incluir")
	public String inclusao(Pagamento pagamento) {
		
    	service.incluir(pagamento);
		
		return "redirect:/";
	}
    
    @GetMapping(value = "/pagamento/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
    	service.excluir(id);
    	return "redirect:/pagamento/lista";
    }
}
