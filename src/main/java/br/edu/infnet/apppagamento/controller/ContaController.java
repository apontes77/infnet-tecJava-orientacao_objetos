package br.edu.infnet.apppagamento.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.model.domain.Conta;
import br.edu.infnet.model.test.AppImpressao;

@Controller
public class ContaController {
	
	private static Map<Integer, Conta> mapaConta = new HashMap<>();

	private static Integer id = 1;

	public static void incluir(Conta conta) {
		conta.setId(id++);
		mapaConta.put(conta.getId(), conta);
		AppImpressao.relatorio("Conta: ", conta);
	}
	
	public static Collection<Conta> obterLista() {
		return mapaConta.values();
	}

    @GetMapping(value = "/conta/lista")
    public String telaConta(Model model) {
    	model.addAttribute("listagem", obterLista());
        return "conta/lista";
    }
}
