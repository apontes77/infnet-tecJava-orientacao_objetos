package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Tributo;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TributoService {
	
	private static Map<Integer, Tributo> mapaTributo = new HashMap<>();

	private static Integer id = 1;

	public void incluir(Tributo tributo) {
		tributo.setId(id++);
		mapaTributo.put(tributo.getId(), tributo);
		AppImpressao.relatorio("Tributo: ", tributo);
	}
	
	public Collection<Tributo> obterLista(){
		return mapaTributo.values();
	}
	
	public void excluir(Integer id) {
		mapaTributo.remove(id);
	}
}
