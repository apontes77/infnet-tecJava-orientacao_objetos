package br.edu.infnet.apppagamento.model.domain;

import br.edu.infnet.apppagamento.model.exceptions.ConsumoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.ImpostoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.QuantidadeDeParcelasInvalidaException;

public class Extra extends Conta {
	private Integer numeroDeParcelas;
	private boolean pagamentoLote;
	private boolean pagamentoUnico;

	public Extra() {
	}

	public Extra(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public boolean isPagamentoLote() {
		return pagamentoLote;
	}

	public void setPagamentoLote(boolean pagamentoLote) {
		this.pagamentoLote = pagamentoLote;
	}

	public boolean isPagamentoUnico() {
		return pagamentoUnico;
	}

	public void setPagamentoUnico(boolean pagamentoUnico) {
		this.pagamentoUnico = pagamentoUnico;
	}

	@Override
	public void impressao() {
		System.out.println("#Extra");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Quantidade de Parcelas: " + numeroDeParcelas + "\n é pagamento em lote? " + pagamentoLote
				+ "\n é pagamento único? " + pagamentoUnico + "\n" + super.toString();
	}

	@Override
	public boolean mostraContaAtiva() throws ConsumoInvalidoException, ImpostoInvalidoException, QuantidadeDeParcelasInvalidaException {
		if(numeroDeParcelas==0) {
			throw new QuantidadeDeParcelasInvalidaException("a quantidade de parcelas deve ser maior que zero");
		}
		return true;
	}

	

}