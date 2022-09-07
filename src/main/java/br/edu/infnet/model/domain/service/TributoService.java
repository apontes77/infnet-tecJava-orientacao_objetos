package br.edu.infnet.model.domain.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.model.domain.Tributo;
import br.edu.infnet.model.test.AppImpressao;

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
