package br.edu.infnet.model.domain;

import java.math.BigDecimal;

import br.edu.infnet.model.exceptions.ConsumoInvalidoException;
import br.edu.infnet.model.exceptions.ImpostoInvalidoException;

public class Tributo extends Conta {
	private BigDecimal ICMS;
	private BigDecimal IOF;
	private BigDecimal ISS;

	public Tributo() {
	}

	public Tributo(BigDecimal iCMS, BigDecimal iOF, BigDecimal iSS) {
		super();
		ICMS = iCMS;
		IOF = iOF;
		ISS = iSS;
	}

	public BigDecimal getICMS() {
		return ICMS;
	}

	public void setICMS(BigDecimal iCMS) {
		ICMS = iCMS;
	}

	public BigDecimal getIOF() {
		return IOF;
	}

	public void setIOF(BigDecimal iOF) {
		IOF = iOF;
	}

	public BigDecimal getISS() {
		return ISS;
	}

	public void setISS(BigDecimal iSS) {
		ISS = iSS;
	}

	@Override
	public void impressao() {
		System.out.println("#Tributo");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "ICMS: R$ " + ICMS + ", IOF: R$ " + IOF + ", ISS: R$ " + ISS + "\n" + super.toString();
	}

	@Override
	public boolean mostraContaAtiva() throws ConsumoInvalidoException, ImpostoInvalidoException {
		if(ICMS==BigDecimal.ZERO) {
			throw new ImpostoInvalidoException("");
		}
		return true;
	}

}
