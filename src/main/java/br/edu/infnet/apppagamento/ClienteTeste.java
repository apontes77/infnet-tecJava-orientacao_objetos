package br.edu.infnet.apppagamento;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppagamento.controller.ClienteController;
import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.domain.exceptions.CpfOuCnpjInvalidoException;

@Component
public class ClienteTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("# Cliente #");
		System.out.println("\n");
		
		try {
			Cliente c1 = new Cliente(1, "Arnold", "arnold@mail.com", "224.314.760-22");
			ClienteController.incluir(c1);
		} catch (CpfOuCnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			Cliente c2 = new Cliente(2, "Martin", "martin@mail.com", "380.335.400-52");
			ClienteController.incluir(c2);
		} catch (CpfOuCnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			Cliente c3 = new Cliente(3, "Isabel", "isabel@mail.com", "478.635.810-01");
			ClienteController.incluir(c3);
		} catch (CpfOuCnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Cliente c4 = new Cliente(3, "Isabel", "isabel@mail.com", "");
			ClienteController.incluir(c4);
		} catch (CpfOuCnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Cliente c5 = new Cliente(3, "Isabel", "isabel@mail.com", null);
			ClienteController.incluir(c5);
		} catch (CpfOuCnpjInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
