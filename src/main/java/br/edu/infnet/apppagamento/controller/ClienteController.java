package br.edu.infnet.apppagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.domain.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
    @GetMapping(value = "/cliente/lista")
    public String telaCliente(Model model) {

		model.addAttribute("listagem", service.obterLista());
        return "cliente/lista";
    }
    
    @PostMapping(value = "/cliente/incluir")
	public String inclusao(Cliente cliente) {
		
    	service.incluir(cliente);
		
		return "redirect:/";
	}
    
    @GetMapping(value = "/cliente/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
    	service.excluir(id);
    	return "redirect:/cliente/lista";
    }
}
