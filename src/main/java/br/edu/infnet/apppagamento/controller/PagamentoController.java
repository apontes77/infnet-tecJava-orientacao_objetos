package br.edu.infnet.apppagamento.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Pagamento;
import br.edu.infnet.model.test.AppImpressao;

@Controller
public class PagamentoController {
	
	private static Map<Integer, Pagamento> mapaPagamento = new HashMap<>();

	private static Integer id = 1;
	
	public static Collection<Pagamento> obterLista() {
		return mapaPagamento.values();
	}

	public static void incluir(Pagamento pagamento) {
		pagamento.setId(id++);
		mapaPagamento.put(pagamento.getId(), pagamento);
		AppImpressao.relatorio("Pagamento: ", pagamento);
	}
	
	public static void excluir(Integer id) {
		mapaPagamento.remove(id);
	}

    @GetMapping(value = "/pagamento/lista")
    public String telaPagamento(Model model) {
    	model.addAttribute("listagem", obterLista());
    	
        return "pagamento/lista";
    }
    
    @PostMapping(value = "/pagamento/incluir")
	public String inclusao(Pagamento pagamento) {
		
		incluir(pagamento);
		
		return "redirect:/";
	}
    
    @GetMapping(value = "/pagamento/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
    	excluir(id);
    	return "redirect:/pagamento/lista";
    }
}
