package br.edu.infnet.apppagamento;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.test.AppImpressao;

@Component
public class ClienteTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("# Cliente #");
		System.out.println("\n");
		Cliente c1 = new Cliente(1, "Arnold", "arnold@mail.com", "224.314.760-22");
		AppImpressao.relatorio("Cliente 1: ", c1);

		Cliente c2 = new Cliente(2, "Martin", "martin@mail.com", "380.335.400-52");
		AppImpressao.relatorio("Cliente 2: ", c2);

		Cliente c3 = new Cliente(3, "Isabel", "isabel@mail.com", "478.635.810-01");
		AppImpressao.relatorio("Cliente 3: ", c3);

	}

}
