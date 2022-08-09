package br.edu.infnet.apppagamento;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Consumo;

@Component
public class ConsumoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("# Consumo #");
		System.out.println("\n");

		Consumo c1 = new Consumo();
		c1.setItem("rodas 4x4");
		c1.setQuantidadeDeItens(4);
		c1.setIndividualOuGrupo("individual");
		c1.setContaAtiva(true);
		c1.setDescricao("conta presidencial");
		c1.setId(123);
		System.out.println(c1);

		Consumo c2 = new Consumo();
		c2.setItem("volante");
		c2.setQuantidadeDeItens(1);
		c2.setIndividualOuGrupo("individual");
		c2.setContaAtiva(true);
		c2.setDescricao("conta do deputado");
		c2.setId(321);
		System.out.println(c2);

		Consumo c3 = new Consumo();
		c3.setItem("amortecedor");
		c3.setQuantidadeDeItens(4);
		c3.setIndividualOuGrupo("individual");
		c3.setContaAtiva(true);
		c3.setDescricao("conta comum");
		c3.setId(222);
		System.out.println(c3);

	}

}