package br.edu.infnet.apppagamento.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Tributo;
import br.edu.infnet.model.test.AppImpressao;

@Controller
public class TributoController {

	private static Map<Integer, Tributo> mapaTributo = new HashMap<>();

	private static Integer id = 1;

	public static void incluir(Tributo tributo) {
		tributo.setId(id++);
		mapaTributo.put(tributo.getId(), tributo);
		AppImpressao.relatorio("Tributo: ", tributo);
	}
	
	public static Collection<Tributo> obterLista(){
		return mapaTributo.values();
	}
	
	public static void excluir(Integer id) {
		mapaTributo.remove(id);
	}

	@GetMapping(value = "/tributo/lista")
	public String telaTributo(Model model) {
		model.addAttribute("listagem", obterLista());
		return "tributo/lista";
	}
	
	@PostMapping(value = "/tributo/incluir")
	public String inclusao(Tributo tributo) {
		
		incluir(tributo);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/tributo/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		excluir(id);
		return "redirect:/tributo/lista";
	}
}
