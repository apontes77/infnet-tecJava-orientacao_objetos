package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Consumo;
import br.edu.infnet.apppagamento.model.domain.Conta;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import ch.qos.logback.core.util.COWArrayList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContaService {

	private TributoService tributoService;
	private ExtraService extraService;
	private ConsumoService consumoService;

	public ContaService(TributoService tributoService, ExtraService extraService, ConsumoService consumoService) {
		this.tributoService = tributoService;
		this.extraService = extraService;
		this.consumoService = consumoService;
	}

	public List<Conta> obterLista() {
		List<Conta> contas = new ArrayList<>();
		contas.addAll(tributoService.obterLista());
		contas.addAll(extraService.obterLista());
		contas.addAll(consumoService.obterLista());

		return contas;
	}
	
}
