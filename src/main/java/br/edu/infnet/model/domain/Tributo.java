package br.edu.infnet.model.domain;

import java.math.BigDecimal;

public class Tributo extends Conta {
	private BigDecimal ICMS;
	private BigDecimal IOF;
	private BigDecimal ISS;

	public Tributo() {
	}

	@Override
	public String validaContaAtiva() {

		return super.validaContaAtiva() + "com ICMS: " + this.ICMS + "com IOF: " + this.IOF + "com ISS: " + this.ISS;
	}

	public Tributo(BigDecimal iCMS, BigDecimal iOF, BigDecimal iSS) {
		super();
		ICMS = iCMS;
		IOF = iOF;
		ISS = iSS;
	}

	@Override
	public String toString() {
		return "ICMS: R$ " + ICMS + ", IOF: R$ " + IOF + ", ISS: R$ " + ISS + "\n" + super.toString();
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
	public String descricaoEmCapsLock() {
		return "ICMS" + ICMS;
	}

}
