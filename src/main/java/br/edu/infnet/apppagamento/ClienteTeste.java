package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.exceptions.CpfOuCnpjInvalidoException;
import br.edu.infnet.apppagamento.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ClienteTeste implements ApplicationRunner {
	
	@Autowired
	private ClienteService service;

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("# Cliente #");
		System.out.println("\n");

		String dir = "src/main/resources/files/";
		String arq = "cliente.txt";

		try {
			try {

				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();

				while(linha != null) {

					String[] campos = linha.split(";");

					try {
						Cliente cliente = new Cliente(Integer.valueOf(campos[0]), campos[1],campos[2],campos[3]);
						service.incluir(cliente);
					} catch (CpfOuCnpjInvalidoException e) {
						System.out.println(e.getMessage());
					}
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
