package br.edu.infnet.model.domain;

public class Consumo extends Conta {
	private String item;
	private Integer quantidadeDeItens;
	private String individualOuGrupo;

	@Override
	public String toString() {
		return "Item: " + item + "\n Quantidade de Itens: " + quantidadeDeItens + "\n Individual ou Grupo: "
				+ individualOuGrupo + "\n" + super.toString();
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getQuantidadeDeItens() {
		return quantidadeDeItens;
	}

	public void setQuantidadeDeItens(Integer quantidadeDeItens) {
		this.quantidadeDeItens = quantidadeDeItens;
	}

	public String getIndividualOuGrupo() {
		return individualOuGrupo;
	}

	public void setIndividualOuGrupo(String individualOuGrupo) {
		this.individualOuGrupo = individualOuGrupo;
	}

}
