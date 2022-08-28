package br.edu.infnet.apppagamento;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppagamento.controller.ExtraController;
import br.edu.infnet.model.domain.Extra;
import br.edu.infnet.model.domain.exceptions.ConsumoInvalidoException;
import br.edu.infnet.model.domain.exceptions.ImpostoInvalidoException;
import br.edu.infnet.model.domain.exceptions.QuantidadeDeParcelasInvalidaException;

@Component
public class ExtraTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args)  {

		System.out.println("# Extra #");
		System.out.println("\n");

		
		try {
			Extra e1 = new Extra();
			e1.setNumeroDeParcelas(2);
			e1.setPagamentoLote(false);
			e1.setPagamentoUnico(true);
			e1.setContaAtiva(true);
			e1.setDescricao("conta para experts");
			e1.mostraContaAtiva();
			ExtraController.incluir(e1);
		} catch (ConsumoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (ImpostoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (QuantidadeDeParcelasInvalidaException e) {
			System.out.println("[ERROR] "+e.getMessage());
		}
		

		
		try {
			Extra e2 = new Extra();
			e2.setNumeroDeParcelas(4);
			e2.setPagamentoLote(false);
			e2.setPagamentoUnico(true);
			e2.setContaAtiva(true);
			e2.setDescricao("conta para day traders");
			e2.mostraContaAtiva();
			ExtraController.incluir(e2);
		} catch (ConsumoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (ImpostoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (QuantidadeDeParcelasInvalidaException e) {
			System.out.println("[ERROR] "+e.getMessage());
		}
	
		
		try {
			Extra e3 = new Extra();
			e3.setNumeroDeParcelas(6);
			e3.setPagamentoLote(false);
			e3.setPagamentoUnico(true);
			e3.setContaAtiva(true);
			e3.setDescricao("conta para estudantes");
			e3.mostraContaAtiva();
			ExtraController.incluir(e3);
		} catch (ConsumoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (ImpostoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (QuantidadeDeParcelasInvalidaException e) {
			System.out.println("[ERROR] "+e.getMessage());
		}
		

	}

}
