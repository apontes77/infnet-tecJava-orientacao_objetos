package br.edu.infnet.apppagamento;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Extra;

@Component
public class ExtraTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Extra e1 = new Extra();
		e1.numeroDeParcelas = 2;
		System.out.println(e1);

		Extra e2 = new Extra();
		e2.numeroDeParcelas = 4;
		System.out.println(e2);

		Extra e3 = new Extra();
		e3.numeroDeParcelas = 6;
		System.out.println(e3);

	}

}
