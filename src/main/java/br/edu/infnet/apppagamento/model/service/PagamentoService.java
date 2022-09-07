package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Pagamento;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PagamentoService {
	private static Map<Integer, Pagamento> mapaPagamento = new HashMap<>();

	private static Integer id = 1;
	
	public Collection<Pagamento> obterLista() {
		return mapaPagamento.values();
	}

	public void incluir(Pagamento pagamento) {
		pagamento.setId(id++);
		mapaPagamento.put(pagamento.getId(), pagamento);
		AppImpressao.relatorio("Pagamento: ", pagamento);
	}
	
	public void excluir(Integer id) {
		mapaPagamento.remove(id);
	}
}
