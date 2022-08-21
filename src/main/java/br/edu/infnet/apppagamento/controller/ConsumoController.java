package br.edu.infnet.apppagamento.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.model.domain.Consumo;
import br.edu.infnet.model.test.AppImpressao;

@Controller
public class ConsumoController {
	
	private static Map<Integer, Consumo> mapaConsumo = new HashMap<>();
	
	private static Integer id = 1;
	
	public static void incluir(Consumo consumo) {
		consumo.setId(id++);
		mapaConsumo.put(consumo.getId(), consumo);
		AppImpressao.relatorio("Consumo: ", consumo);
	}
	
	
	public static Collection<Consumo> obterLista() {
		return mapaConsumo.values();
	}
	
    @GetMapping(value = "/consumo/lista")
    public String telaConsumo(Model model) {	
		model.addAttribute("listagem", obterLista());
        return "consumo/lista";
    }
}
