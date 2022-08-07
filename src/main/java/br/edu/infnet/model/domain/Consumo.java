package br.edu.infnet.model.domain;

public class Consumo extends Conta {
	public String item;
	public Integer quantidadeDeItens;

	@Override
	public String toString() {
		return "Item: " + item + ", Quantidade de Itens: " + quantidadeDeItens;
	}

}
