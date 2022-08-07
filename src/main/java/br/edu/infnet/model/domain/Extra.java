package br.edu.infnet.model.domain;

public class Extra extends Conta {
	public Integer numeroDeParcelas;

	@Override
	public String toString() {
		return "Quantidade de Parcelas: " + numeroDeParcelas;
	}
}
