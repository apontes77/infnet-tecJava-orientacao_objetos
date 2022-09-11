package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.app.Atributo;
import br.edu.infnet.apppagamento.model.domain.app.Classe;
import br.edu.infnet.apppagamento.model.domain.app.Projeto;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AppTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		String dir = "/home/alexandre/";
		String arq = "usuarios.txt";
	
		try {
			try {
		
			FileReader fileReader = new FileReader(dir+arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			
			while(linha != null) {
				
					String[] campos = linha.split(";");

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


		Classe cliente = new Classe();
		cliente.setNome("Cliente");
		cliente.setAtributos(List.of(new Atributo("nome", "tipo", "descricao")));

		Classe consumo = new Classe();
		cliente.setNome("consumo");
		cliente.setAtributos(List.of(new Atributo("nome", "tipo", "descricao")));

		Classe conta = new Classe();
		cliente.setNome("conta");
		cliente.setAtributos(List.of(new Atributo("nome", "tipo", "descricao")));

		Classe extra = new Classe();
		cliente.setNome("extra");
		cliente.setAtributos(List.of(new Atributo("nome", "tipo", "descricao")));

		Classe pagamento = new Classe();
		cliente.setNome("pagamento");
		cliente.setAtributos(List.of(new Atributo("nome", "tipo", "descricao")));

		Classe tributo = new Classe();
		cliente.setNome("tributo");
		cliente.setAtributos(List.of(new Atributo("nome", "tipo", "descricao")));

		Classe usuario = new Classe();
		cliente.setNome("usuario");
		cliente.setAtributos(List.of(new Atributo("nome", "tipo", "descricao")));

		List<Classe> classes = new ArrayList<>();
		classes.add(cliente);
		classes.add(consumo);
		classes.add(conta);
		classes.add(extra);
		classes.add(pagamento);
		classes.add(tributo);
		classes.add(usuario);


		Projeto projeto = new Projeto();
		projeto.setNome("AppPagamento");
		projeto.setDescricaoProjeto("Projeto de Pagamentos");
		projeto.setClasses(classes);
		projeto.impressao();
	}

}
