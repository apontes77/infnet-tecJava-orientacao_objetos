package br.edu.infnet.apppagamento.model.domain;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

public class Usuario implements IPrinter {
	private String nome;
	private String email;
	private String senha;
	

	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}



	public String getSenha() {
		return senha;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public void impressao() {
		System.out.println("#usuario");
		System.out.println(this);
		
	}
	

}
