package br.edu.infnet.apppagamento.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.test.AppImpressao;

@Controller
public class UsuarioController {
	
	private static Map<String, Usuario> mapaUsuario = new HashMap<>();
	
	public static Usuario validar(String email, String senha) {
		
		Usuario u = mapaUsuario.get(email);
		
		if(u != null && senha.equals(u.getSenha())) {
			return u;
		}
		
		return null;
	}
	
	
	public static void incluir(Usuario usuario) {
		mapaUsuario.put(usuario.getEmail(), usuario);
		AppImpressao.relatorio("Consumo: ", usuario);
	}
	
	public static void excluir(String email) {
		mapaUsuario.remove(email);

	}
	
	
	public static Collection<Usuario> obterLista() {
		return mapaUsuario.values();
	}
	
	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", obterLista());
		return "usuario/lista";
	}
	
	@GetMapping(value = "/usuario")
	public String telaCadastro(Usuario usuario) {
		return "usuario/cadastro";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String inclusao(Usuario usuario) {
		
		incluir(usuario);
		
		return "redirect:/";
	}
	
	@DeleteMapping(value = "/usuario/{email}/excluir")
	public String exclusao(@PathVariable String email) {
		
		excluir(email);
		
		return "redirect:/usuario/lista";
		
	}
}
