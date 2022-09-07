package br.edu.infnet.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.model.domain.Consumo;
import br.edu.infnet.model.test.AppImpressao;

@Service
public class ConsumoService {
	
	private static Map<Integer, Consumo> mapaConsumo = new HashMap<>();
	
	private static Integer id = 1;
	
	public void incluir(Consumo consumo) {
		consumo.setId(id++);
		mapaConsumo.put(consumo.getId(), consumo);
		AppImpressao.relatorio("Consumo: ", consumo);
	}
	
	
	public Collection<Consumo> obterLista() {
		return mapaConsumo.values();
	}
	
	public void excluir(Integer id) {
		mapaConsumo.remove(id);
	}
}
