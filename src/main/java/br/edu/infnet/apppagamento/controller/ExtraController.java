package br.edu.infnet.apppagamento.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.model.domain.Extra;
import br.edu.infnet.model.test.AppImpressao;

@Controller
public class ExtraController {
	
	private static Map<Integer, Extra> mapaExtra = new HashMap<>();

	private static Integer id = 1;

	public static void incluir(Extra extra) {
		extra.setId(id++);
		mapaExtra.put(extra.getId(), extra);
		AppImpressao.relatorio("Extra: ", extra);
	}
	
	public static Collection<Extra> obterLista() {
		return mapaExtra.values();
	}
	
	public static void excluir(Integer id) {
		mapaExtra.remove(id);
	}

    @GetMapping(value = "/extra/lista")
    public String telaExtra(Model model) {
        model.addAttribute("listagem", obterLista());
    	return "extra/lista";
    }
    
    @GetMapping(value = "/extra/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
    	excluir(id);
    
    	return "redirect:/extra/lista";
    }
}
