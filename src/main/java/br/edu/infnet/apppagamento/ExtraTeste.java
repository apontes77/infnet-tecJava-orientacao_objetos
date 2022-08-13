package br.edu.infnet.apppagamento;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Extra;
import br.edu.infnet.model.test.AppImpressao;

@Component
public class ExtraTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("# Extra #");
		System.out.println("\n");

		Extra e1 = new Extra();
		e1.setNumeroDeParcelas(2);
		e1.setPagamentoLote(false);
		e1.setPagamentoUnico(true);
		e1.setContaAtiva(true);
		e1.setDescricao("conta para experts");
		e1.setId(100);
		AppImpressao.relatorio("Extra 1: ", e1);
		System.out.println(e1);

		Extra e2 = new Extra();
		e2.setNumeroDeParcelas(4);
		e2.setPagamentoLote(false);
		e2.setPagamentoUnico(true);
		e2.setContaAtiva(true);
		e2.setDescricao("conta para day traders");
		e2.setId(200);
		AppImpressao.relatorio("Extra 2: ", e2);

		Extra e3 = new Extra();
		e3.setNumeroDeParcelas(6);
		e3.setPagamentoLote(false);
		e3.setPagamentoUnico(true);
		e3.setContaAtiva(true);
		e3.setDescricao("conta para estudantes");
		e3.setId(300);
		AppImpressao.relatorio("Extra 3: ", e3);

	}

}
