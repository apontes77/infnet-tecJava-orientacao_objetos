package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Conta;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ContaService {
	
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
