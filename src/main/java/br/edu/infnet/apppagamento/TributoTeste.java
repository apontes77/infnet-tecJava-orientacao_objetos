package br.edu.infnet.apppagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppagamento.controller.TributoController;
import br.edu.infnet.model.domain.Tributo;
import br.edu.infnet.model.domain.exceptions.ConsumoInvalidoException;
import br.edu.infnet.model.domain.exceptions.ImpostoInvalidoException;

@Component
public class TributoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args){
		System.out.println("# Tributo #");
		System.out.println("\n");

		
		try {
			Tributo t1 = new Tributo();

			t1.setICMS(new BigDecimal(23.90).setScale(2, RoundingMode.DOWN));
			t1.setIOF(new BigDecimal(9.90).setScale(2, RoundingMode.DOWN));
			t1.setISS(new BigDecimal(4.87).setScale(2, RoundingMode.DOWN));
			t1.setContaAtiva(true);
			t1.setDescricao("conta para experts");
			t1.mostraContaAtiva();
			TributoController.incluir(t1);
		} catch (ConsumoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (ImpostoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		}
		
		try {
		Tributo t2 = new Tributo();

		t2.setICMS(new BigDecimal(25.90).setScale(2, RoundingMode.DOWN));
		t2.setIOF(new BigDecimal(7.90).setScale(2, RoundingMode.DOWN));
		t2.setISS(new BigDecimal(6.87).setScale(2, RoundingMode.DOWN));
		t2.setContaAtiva(true);
		t2.setDescricao("conta para day traders");
		t2.mostraContaAtiva();
		TributoController.incluir(t2);
		}catch (ConsumoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (ImpostoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		}

		
		try {
			Tributo t3 = new Tributo();

			t3.setICMS(new BigDecimal(27.90).setScale(2, RoundingMode.DOWN));
			t3.setIOF(new BigDecimal(11.90).setScale(2, RoundingMode.DOWN));
			t3.setISS(new BigDecimal(8.87).setScale(2, RoundingMode.DOWN));
			t3.setContaAtiva(true);
			t3.setDescricao("conta para estudantes");
			t3.mostraContaAtiva();

			TributoController.incluir(t3);
		} catch (ConsumoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (ImpostoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		}

	}

}
