package br.edu.infnet.apppagamento;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Consumo;

@Component
public class ConsumoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Consumo c1 = new Consumo();
		c1.item = "rodas 4x4";
		c1.quantidadeDeItens = 4;
		System.out.println(c1);

		Consumo c2 = new Consumo();
		c2.item = "volante";
		c2.quantidadeDeItens = 1;
		System.out.println(c2);

		Consumo c3 = new Consumo();
		c3.item = "amortecedor";
		c3.quantidadeDeItens = 4;
		System.out.println(c3);

	}

}
