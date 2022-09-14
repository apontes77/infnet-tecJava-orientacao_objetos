package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.domain.Consumo;
import br.edu.infnet.apppagamento.model.exceptions.ConsumoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.CpfOuCnpjInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.ImpostoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.QuantidadeDeParcelasInvalidaException;
import br.edu.infnet.apppagamento.model.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ConsumoTeste implements ApplicationRunner {
	
	@Autowired
	private ConsumoService service;


	@Override
	public void run(ApplicationArguments args) {
		System.out.println("# Consumo #");
		System.out.println("\n");

		String dir = "src/main/resources/files/";
		String arq = "consumo.txt";

		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
				while(linha != null) {
					String[] campos = linha.split(";");

					Consumo c1 = new Consumo(campos[0], Integer.valueOf(campos[1]), campos[2]);
					service.incluir(c1);

					linha = leitura.readLine();
				}
				leitura.close();
				fileReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: "+e.getMessage());
			} catch(IOException e) {
				System.out.println("ERROR: "+e.getMessage());
			}
		} finally {
			System.out.println("TERMINOU!!!");
		}

	}

}
