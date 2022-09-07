package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Tributo;
import br.edu.infnet.apppagamento.model.exceptions.ConsumoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.ImpostoInvalidoException;
import br.edu.infnet.apppagamento.model.service.TributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class TributoTeste implements ApplicationRunner {

	@Autowired
	private TributoService service;


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
			service.incluir(t1);
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
		service.incluir(t2);
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

			service.incluir(t3);
		} catch (ConsumoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		} catch (ImpostoInvalidoException e) {
			System.out.println("[ERROR] "+e.getMessage());
		}

	}

}
