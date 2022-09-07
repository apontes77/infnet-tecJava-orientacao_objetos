package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {
	
	private static Map<Integer, Cliente> mapaCliente = new HashMap<>();

	private static Integer id = 1;

	public void incluir(Cliente cliente) {
		cliente.setId(id++);
		mapaCliente.put(cliente.getId(), cliente);
		AppImpressao.relatorio("Cliente: ", cliente);
	}
	
	public Collection<Cliente> obterLista() {
		return mapaCliente.values();
	}
	
	public void excluir(Integer id) {
		mapaCliente.remove(id);
	}

}
