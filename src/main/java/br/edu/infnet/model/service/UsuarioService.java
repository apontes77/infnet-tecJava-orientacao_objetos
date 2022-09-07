package br.edu.infnet.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.test.AppImpressao;

@Service
public class UsuarioService {
	
	private static Map<String, Usuario> mapaUsuario = new HashMap<>();
	
	public Usuario validar(String email, String senha) {
		
		Usuario u = mapaUsuario.get(email);
		
		if(u != null && senha.equals(u.getSenha())) {
			return u;
		}
		
		return null;
	}
	
	
	public void incluir(Usuario usuario) {
		mapaUsuario.put(usuario.getEmail(), usuario);
		AppImpressao.relatorio("Usuario: ", usuario);
	}
	
	public void excluir(String email) {
		mapaUsuario.remove(email);

	}
	
	
	public Collection<Usuario> obterLista() {
		return mapaUsuario.values();
	}

}
