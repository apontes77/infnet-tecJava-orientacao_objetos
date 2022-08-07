package br.edu.infnet.apppagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Tributo;

@Component
public class TributoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("# Tributo #");
		System.out.println("\n");

		Tributo t1 = new Tributo();

		t1.setICMS(new BigDecimal(23.90).setScale(2, RoundingMode.DOWN));
		t1.setIOF(new BigDecimal(9.90).setScale(2, RoundingMode.DOWN));
		t1.setISS(new BigDecimal(4.87).setScale(2, RoundingMode.DOWN));
		t1.setContaAtiva(true);
		t1.setDescricao("conta para experts");
		t1.setId(100);
		System.out.println(t1);

		Tributo t2 = new Tributo();

		t2.setICMS(new BigDecimal(25.90).setScale(2, RoundingMode.DOWN));
		t2.setIOF(new BigDecimal(7.90).setScale(2, RoundingMode.DOWN));
		t2.setISS(new BigDecimal(6.87).setScale(2, RoundingMode.DOWN));
		t2.setContaAtiva(true);
		t2.setDescricao("conta para day traders");
		t2.setId(200);
		System.out.println(t2);

		Tributo t3 = new Tributo();

		t3.setICMS(new BigDecimal(27.90).setScale(2, RoundingMode.DOWN));
		t3.setIOF(new BigDecimal(11.90).setScale(2, RoundingMode.DOWN));
		t3.setISS(new BigDecimal(8.87).setScale(2, RoundingMode.DOWN));
		t3.setContaAtiva(true);
		t3.setDescricao("conta para estudantes");
		t3.setId(300);
		System.out.println(t3);
	}

}
