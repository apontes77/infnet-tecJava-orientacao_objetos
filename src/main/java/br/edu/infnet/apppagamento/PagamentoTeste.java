package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.domain.Consumo;
import br.edu.infnet.apppagamento.model.domain.Conta;
import br.edu.infnet.apppagamento.model.domain.Extra;
import br.edu.infnet.apppagamento.model.domain.Pagamento;
import br.edu.infnet.apppagamento.model.domain.Tributo;
import br.edu.infnet.apppagamento.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.ConjuntoDeContasInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.CpfOuCnpjInvalidoException;
import br.edu.infnet.apppagamento.model.service.PagamentoService;
import org.apache.catalina.startup.ContextConfig;
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
	public void run(ApplicationArguments args) {

		System.out.println("# Pagamento #");
		System.out.println("\n");
		
		String dir = "src/main/resources/files/";
		String arq = "pagamento.txt";

		try {

			FileReader fileReader = new FileReader(dir+arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			List<Pagamento> pagamentos = new ArrayList<>();
			Set<Conta> contas = null;
			while(linha != null) {
				String[] campos = linha.split(";");

				switch (campos[0].toUpperCase()) {

					case "P" -> {
						try {
							contas = new HashSet<>();
							Cliente cliente = new Cliente();
							cliente.setId(Integer.valueOf(campos[4]));
							cliente.setNome(campos[5]);
							cliente.setEmail(campos[6]);
							cliente.setCpfOuCpnj(campos[7]);

							Pagamento pagamento = new Pagamento(cliente, contas);
							pagamento.setNumeroCartao(campos[1]);
							pagamento.setBandeira(campos[2]);
							pagamento.setValor(BigDecimal.valueOf(Double.parseDouble(campos[3])));
							pagamentos.add(pagamento);
						}  catch (ConjuntoDeContasInvalidoException | ClienteInvalidoException e) {
							throw new RuntimeException(e);
						}
					}

					case "C" -> {
						 Consumo consumo = new Consumo();
						 consumo.setItem(campos[1]);
						 consumo.setQuantidadeDeItens(Integer.valueOf(campos[2]));
						 consumo.setIndividualOuGrupo(campos[3]);
						assert contas != null;
						contas.add(consumo);
					}

					case "E" -> {
						Extra extra = new Extra();
						extra.setId(Integer.valueOf(campos[1]));
						extra.setPagamentoLote(Boolean.parseBoolean(campos[2]));
						extra.setPagamentoUnico(Boolean.parseBoolean(campos[3]));

						assert contas != null;
						contas.add(extra);
					}

					case "T" -> {

						Tributo tributo = new Tributo();
						tributo.setICMS(BigDecimal.valueOf(Double.parseDouble(campos[1])));
						tributo.setIOF(BigDecimal.valueOf(Double.parseDouble(campos[2])));
						tributo.setISS(BigDecimal.valueOf(Double.parseDouble(campos[3])));
						assert contas != null;
						contas.add(tributo);
					}

					default -> System.out.println();
				}
				linha = leitura.readLine();

			}

			for (Pagamento p: pagamentos) {
				service.incluir(p);

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
