package br.edu.infnet.apppagamento;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppagamento.controller.UsuarioController;
import br.edu.infnet.model.domain.Usuario;

@Component
public class UsuarioTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario u = new Usuario();
		u.setEmail("admin@admin.com");
		u.setNome("adsa");
		u.setSenha("123");
		
		UsuarioController.incluir(u);
		
	}

}
