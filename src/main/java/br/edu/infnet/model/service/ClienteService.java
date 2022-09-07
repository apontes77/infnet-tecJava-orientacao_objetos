package br.edu.infnet.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.test.AppImpressao;

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
