package br.edu.infnet.apppagamento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.domain.service.UsuarioService;

@Component
public class UsuarioTeste implements ApplicationRunner{
	
	@Autowired
	private UsuarioService service;
	
	private Usuario usuario;


	@Override
	public void run(ApplicationArguments args) throws Exception {
		usuario.setEmail("admin@admin.com");
		usuario.setNome("admin");
		usuario.setSenha("123");
		
		service.incluir(usuario);
		
		String dir = "/home/alexandre/";
		String arq = "usuarios.txt";
	
		try {
			try {
		
			FileReader fileReader = new FileReader(dir+arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			
			while(linha != null) {
				
					String[] campos = linha.split(";");
					
					usuario.setEmail(campos[0]);
					usuario.setNome(campos[1]);
					usuario.setSenha(campos[2]);
					
					service.incluir(usuario);
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
