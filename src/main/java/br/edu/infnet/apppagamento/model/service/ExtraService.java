package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Extra;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExtraService {
	
	private static Map<Integer, Extra> mapaExtra = new HashMap<>();

	private static Integer id = 1;

	public void incluir(Extra extra) {
		extra.setId(id++);
		mapaExtra.put(extra.getId(), extra);
		AppImpressao.relatorio("Extra: ", extra);
	}
	
	public Collection<Extra> obterLista() {
		return mapaExtra.values();
	}
	
	public void excluir(Integer id) {
		mapaExtra.remove(id);
	}
}