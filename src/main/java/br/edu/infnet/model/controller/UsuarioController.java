package br.edu.infnet.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", service.obterLista());
		return "usuario/lista";
	}
	
	@GetMapping(value = "/usuario")
	public String telaCadastro(Usuario usuario) {
		return "usuario/cadastro";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String inclusao(Usuario usuario) {
		
		service.incluir(usuario);
		
		return "redirect:/";
	}
	
	@DeleteMapping(value = "/usuario/{email}/excluir")
	public String exclusao(@PathVariable String email) {
		
		service.excluir(email);
		
		return "redirect:/usuario/lista";
		
	}
}
