package br.edu.infnet.apppagamento.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping(value = "/pagamento/lista")
    public String telaPagamento(Model model) {
    	model.addAttribute("listagem", obterLista());
    	
        return "pagamento/lista";
    }
}
