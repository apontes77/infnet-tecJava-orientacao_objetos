package br.edu.infnet.model.domain.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.model.domain.Conta;
import br.edu.infnet.model.test.AppImpressao;

@Service
public abstract class ContaService {
	
	private static Map<Integer, Conta> mapaConta = new HashMap<>();

	private static Integer id = 1;

	public void incluir(Conta conta) {
		conta.setId(id++);
		mapaConta.put(conta.getId(), conta);
		AppImpressao.relatorio("Conta: ", conta);
	}
	
	public Collection<Conta> obterLista() {
		return mapaConta.values();
	}
	
}
