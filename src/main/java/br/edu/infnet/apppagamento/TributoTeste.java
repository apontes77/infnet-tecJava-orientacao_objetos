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
		Tributo t1 = new Tributo();

		t1.ICMS = new BigDecimal(23.90).setScale(2, RoundingMode.DOWN);
		t1.IOF = new BigDecimal(9.90).setScale(2, RoundingMode.DOWN);
		t1.ISS = new BigDecimal(4.87).setScale(2, RoundingMode.DOWN);
		System.out.println(t1);

		Tributo t2 = new Tributo();

		t2.ICMS = new BigDecimal(20.90).setScale(2, RoundingMode.DOWN);
		t2.IOF = new BigDecimal(7.90).setScale(2, RoundingMode.DOWN);
		t2.ISS = new BigDecimal(8.87).setScale(2, RoundingMode.DOWN);
		System.out.println(t2);

		Tributo t3 = new Tributo();

		t3.ICMS = new BigDecimal(26.90).setScale(2, RoundingMode.DOWN);
		t3.IOF = new BigDecimal(11.90).setScale(2, RoundingMode.DOWN);
		t3.ISS = new BigDecimal(9.87).setScale(2, RoundingMode.DOWN);
		System.out.println(t3);
	}

}
