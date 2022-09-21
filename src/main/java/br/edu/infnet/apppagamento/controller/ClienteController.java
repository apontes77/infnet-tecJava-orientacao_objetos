package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ClienteController {
	private final ClienteService clienteService;

	public ClienteController(ClienteService service) {
		this.clienteService = service;
	}

	@GetMapping(value = "/cliente/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario user) {
		model.addAttribute("listagem", clienteService.obterLista(user));
        return "cliente/lista";
    }

	@GetMapping(value = "/cliente")
	public String telaCadastro() {
		return "cliente/cadastro";
	}
    
    @PostMapping(value = "/cliente/incluir")
	public String inclusao(Cliente cliente, @SessionAttribute("user") Usuario usuario) {

		cliente.setUsuario(usuario);
		
    	clienteService.incluir(cliente);
		
		return "redirect:/cliente/lista";
	}
    
    @GetMapping(value = "/cliente/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
    	clienteService.excluir(id);
    	return "redirect:/cliente/lista";
    }
}
