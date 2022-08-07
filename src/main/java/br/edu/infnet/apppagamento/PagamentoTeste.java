package br.edu.infnet.apppagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Pagamento;

@Component
@Order(1)
public class PagamentoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("# Pagamento #");
		System.out.println("\n");
		Pagamento p1 = new Pagamento();
		p1.setNumeroCartao("5399 5675 2557 4212 ");
		p1.setBandeira("mastercard");
		p1.setValor(new BigDecimal(24.90).setScale(2, RoundingMode.DOWN));
		System.out.println(p1);

		Pagamento p2 = new Pagamento();
		p2.setNumeroCartao("4929 2722 6230 1620");
		p2.setBandeira("visa");
		p2.setValor(new BigDecimal(25.90).setScale(2, RoundingMode.DOWN));
		System.out.println(p2);

		Pagamento p3 = new Pagamento();
		p3.setNumeroCartao("3025 990326 0269");
		p3.setBandeira("Dinners club");
		p3.setValor(new BigDecimal(25.90).setScale(2, RoundingMode.DOWN));
		System.out.println(p3);

	}
}
