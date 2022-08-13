package br.edu.infnet.model.domain;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

public abstract class Conta implements IPrinter {
	private Integer id;
	private String descricao;
	private boolean contaAtiva;

	public abstract String validaContaAtiva();

	@Override
	public String toString() {
		return "id: " + id + "\n" + "descrição: " + descricao + "\n" + "Conta Ativa? " + contaAtiva + "\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}

	@Override
	public void impressao() {
		System.out.println("#Conta");
		System.out.println(this);
	}

}
