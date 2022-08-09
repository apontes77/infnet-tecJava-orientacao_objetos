package br.edu.infnet.model.domain;

public abstract class Conta {
	private Integer id;
	private String descricao;
	private boolean contaAtiva;

	public String validaContaAtiva() {
		return "descrição da conta: " + this.descricao;
	}

	public abstract String descricaoEmCapsLock();

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

}
