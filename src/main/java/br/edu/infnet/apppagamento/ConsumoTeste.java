package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Consumo;
import br.edu.infnet.apppagamento.model.service.ConsumoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ConsumoTeste implements ApplicationRunner {
	private ConsumoService service;

	public ConsumoTeste(ConsumoService service) {
		this.service = service;
	}


	@Override
	public void run(ApplicationArguments args) {
		System.out.println("# Consumo #");
		System.out.println("\n");

		String dir = "src/main/resources/files/";
		String arq = "conta.txt";

		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
					while (linha != null) {
						String[] campos = linha.split(";");
						if ("C".equalsIgnoreCase(campos[0])) {
						Consumo c1 = new Consumo(campos[1], Integer.valueOf(campos[2]), campos[3]);
						service.incluir(c1);
					}
					linha = leitura.readLine();
				}
				leitura.close();
				fileReader.close();
			} catch (IOException e) {
				System.out.println("ERROR: "+e.getMessage());
			}
		} finally {
			System.out.println("TERMINOU!!!");
		}

	}

}
