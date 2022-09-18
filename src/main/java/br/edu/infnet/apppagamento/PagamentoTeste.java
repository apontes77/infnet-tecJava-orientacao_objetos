package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.domain.Consumo;
import br.edu.infnet.apppagamento.model.domain.Conta;
import br.edu.infnet.apppagamento.model.domain.Extra;
import br.edu.infnet.apppagamento.model.domain.Pagamento;
import br.edu.infnet.apppagamento.model.domain.Tributo;
import br.edu.infnet.apppagamento.model.exceptions.CpfOuCnpjInvalidoException;
import br.edu.infnet.apppagamento.model.service.PagamentoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Order(1)
public class PagamentoTeste implements ApplicationRunner {
	private PagamentoService service;

	public PagamentoTeste(PagamentoService service) {
		this.service = service;
	}

	@Override
	public void run(ApplicationArguments args) throws FileNotFoundException{

		System.out.println("# Pagamento #");
		System.out.println("\n");
		
		String dir = "src/main/resources/files/";
		String arq = "pagamento.txt";

		try {

			FileReader fileReader = new FileReader(dir+arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			List<Pagamento> pagamentos = new ArrayList<>();
			Pagamento pagamento = null;
			Cliente cliente = null;
			Consumo consumo = null;
			Extra extra = null;
			Tributo tributo = null;
			Set<Conta> contas = new HashSet<>();
			while(linha != null) {
				try {
					String[] campos = linha.split(";");

					switch (campos[0].toUpperCase()) {

						case "P" -> {
							pagamento  = new Pagamento();
							pagamento.setNumeroCartao(campos[1]);
							pagamento.setBandeira(campos[2]);
							pagamento.setValor(BigDecimal.valueOf(Double.parseDouble(campos[3])));
						}

						case "CL" -> {
							 cliente = new Cliente(Integer.valueOf(campos[1]),campos[2],campos[3], campos[4]);
							 pagamento.setCliente(cliente);
						}

						case "C" -> {
							 consumo = new Consumo(campos[1], Integer.valueOf(campos[2]), campos[3]);
							 contas.add(consumo);
							 pagamento.setContas(contas);
						}

						case "E" -> {
							extra = new Extra(Integer.valueOf(campos[1]),
									Boolean.parseBoolean(campos[2]),
									Boolean.parseBoolean(campos[3]));

							contas.add(extra);
							pagamento.setContas(contas);
						}

						case "T" -> {
							tributo = new Tributo(
									BigDecimal.valueOf(Double.parseDouble(campos[1])),
									BigDecimal.valueOf(Double.parseDouble(campos[2])),
									BigDecimal.valueOf(Double.parseDouble(campos[3]))
							);
							contas.add(tributo);
							pagamento.setContas(contas);

						}

						default -> pagamentos.add(pagamento);
					}

				} catch (CpfOuCnpjInvalidoException e) {
					throw new RuntimeException(e);
				}
				linha = leitura.readLine();
			}

			for (Pagamento p: pagamentos) {
				service.incluir(pagamento);

				System.out.println(">>>>>>>>>>> "+p.getId());
				System.out.println(">>>>>>>> "+p.getCliente().getNome());
				System.out.println(">>>>> "+p.getContas().size());
			}
			leitura.close();
			fileReader.close();
			
		} catch (IOException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}
