package br.edu.infnet.apppagamento;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Cliente;

@Component
public class ClienteTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("# Cliente #");
		System.out.println("\n");
		Cliente c1 = new Cliente(1, "Arnold", "arnold@mail.com", "224.314.760-22");
		System.out.println(c1);

		Cliente c2 = new Cliente(2, "Martin", "martin@mail.com", "380.335.400-52");
		System.out.println(c2);

		Cliente c3 = new Cliente(3, "Isabel", "isabel@mail.com", "478.635.810-01");
		System.out.println(c3);

	}

}
