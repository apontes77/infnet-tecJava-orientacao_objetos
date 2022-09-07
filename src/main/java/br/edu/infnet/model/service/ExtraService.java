package br.edu.infnet.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.model.domain.Extra;
import br.edu.infnet.model.test.AppImpressao;

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