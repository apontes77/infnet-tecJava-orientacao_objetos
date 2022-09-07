package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.domain.Consumo;
import br.edu.infnet.apppagamento.model.domain.Conta;
import br.edu.infnet.apppagamento.model.domain.Pagamento;
import br.edu.infnet.apppagamento.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.ConjuntoDeContasInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.CpfOuCnpjInvalidoException;
import br.edu.infnet.apppagamento.model.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

@Component
@Order(1)
public class PagamentoTeste implements ApplicationRunner {
	
	@Autowired
	private PagamentoService service;


	@Override
	public void run(ApplicationArguments args) throws FileNotFoundException{

		Cliente c1 = null;
		Cliente c3 = null;
		try {
			 c1 = new Cliente(1, "Arnold", "arnold@mail.com", "224.314.760-22");
		} catch (CpfOuCnpjInvalidoException e1) {
			System.out.println("[ERROR]: "+e1.getMessage());
		}
		
		try {
			 c3 = new Cliente(3, "Isabel", "isabel@mail.com", "478.635.810-01");
		} catch (CpfOuCnpjInvalidoException e3) {
			System.out.println("[ERROR]: "+e3.getMessage());
		}
		
		//---------------------------------------------------------------------//

		Conta conta1 = new Consumo("ITEM 1", 1, "INDIVIDUAL");
		Conta conta2 = new Consumo("ITEM 2", 2, "GRUPO");
		System.out.println("# Pagamento #");
		System.out.println("\n");
		
		String dir = "/home/alexandre/";
		String arq = "file.txt";
	
		try {

			FileReader fileReader = new FileReader(dir+arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			
			while(linha != null) {
				try {
					String[] campos = linha.split(";");
					Set<Conta> s1 = new HashSet<>();
					s1.add(conta1);
					s1.add(conta2);
					Pagamento p1  = new Pagamento(c1, s1);
					p1.setContas(s1);
					p1.setNumeroCartao(campos[0]);
					p1.setBandeira(campos[1]);
					p1.setValor(BigDecimal.valueOf(Double.valueOf(campos[2])));

					service.incluir(p1);	
				} catch (ConjuntoDeContasInvalidoException e) {
					System.out.println("ERROR: "+e.getMessage());
				} catch (ClienteInvalidoException e) {
					System.out.println("ERROR: "+e.getMessage());
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
		
		
		
		try {
			Set<Conta> s1 = new HashSet<>();
			s1.add(conta1);
			s1.add(conta2);

			Pagamento p2 = new Pagamento(null,s1);
			p2.setNumeroCartao("4929 2722 6230 1620");
			p2.setBandeira("visa");
			p2.setValor(new BigDecimal(25.90).setScale(2, RoundingMode.DOWN));

			service.incluir(p2);

		} catch(ClienteInvalidoException | ConjuntoDeContasInvalidoException e) {
			System.out.println("[ERROR: ]"+e.getMessage());	
		}
		

	}
}
