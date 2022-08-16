package br.edu.infnet.apppagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.domain.Conta;
import br.edu.infnet.model.domain.Pagamento;
import br.edu.infnet.model.test.AppImpressao;

@Component
@Order(1)
public class PagamentoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Cliente c1 = new Cliente(1, "Arnold", "arnold@mail.com", "224.314.760-22");
		Cliente c2 = new Cliente(2, "Martin", "martin@mail.com", "380.335.400-52");
		Cliente c3 = new Cliente(3, "Isabel", "isabel@mail.com", "478.635.810-01");

		Conta conta1 = new Conta(1, "conta 1", true);
		Conta conta2 = new Conta(2, "conta 2", true);

		System.out.println("# Pagamento #");
		System.out.println("\n");

		Set<Conta> s1 = new HashSet<>();
		s1.add(conta1);
		s1.add(conta1);
		s1.add(conta1);
		s1.add(conta1);
		s1.add(conta1);
		s1.add(conta2);

		Pagamento p1 = new Pagamento(c1);
		p1.setContas(s1);
		p1.setNumeroCartao("5399 5675 2557 4212");
		p1.setBandeira("mastercard");
		p1.setValor(new BigDecimal(24.90).setScale(2, RoundingMode.DOWN));

		AppImpressao.relatorio("Pagamento 1: ", p1);

		Conta conta3 = new Conta(3, "conta 3", true);
		Conta conta4 = new Conta(4, "conta 4", true);

		Pagamento p2 = new Pagamento(c2);
		p2.setContas(Set.of(conta3, conta4));
		p2.setNumeroCartao("4929 2722 6230 1620");
		p2.setBandeira("visa");
		p2.setValor(new BigDecimal(25.90).setScale(2, RoundingMode.DOWN));

		AppImpressao.relatorio("Pagamento 2: ", p2);

		Conta conta5 = new Conta(5, "conta 5", true);
		Conta conta6 = new Conta(6, "conta 6", true);

		Pagamento p3 = new Pagamento(c3);
		p3.setContas(Set.of(conta5, conta6));
		p3.setNumeroCartao("3025 990326 0269");
		p3.setBandeira("Dinners club");
		p3.setValor(new BigDecimal(25.90).setScale(2, RoundingMode.DOWN));

		AppImpressao.relatorio("Pagamento 3: ", p3);

	}
}
