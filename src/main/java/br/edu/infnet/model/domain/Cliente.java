package br.edu.infnet.model.domain;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

public class Cliente implements IPrinter {
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCpnj;

	public Cliente(Integer id, String nome, String email, String cpfOuCpnj) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCpnj = cpfOuCpnj;
	}

	@Override
	public String toString() {
		return "id do cliente: " + id + ", nome: " + nome + ", email: " + email + ", CPF ou CNPJ: " + cpfOuCpnj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCpnj() {
		return cpfOuCpnj;
	}

	public void setCpfOuCpnj(String cpfOuCpnj) {
		this.cpfOuCpnj = cpfOuCpnj;
	}

	@Override
	public void impressao() {
		System.out.println("#cliente");
		System.out.println(this);
	}

}
