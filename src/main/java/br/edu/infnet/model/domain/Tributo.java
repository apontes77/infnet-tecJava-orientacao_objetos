package br.edu.infnet.model.domain;

import java.math.BigDecimal;

public class Tributo extends Conta {
	public BigDecimal ICMS;
	public BigDecimal IOF;
	public BigDecimal ISS;

	@Override
	public String toString() {
		return "ICMS: R$ " + ICMS + ", IOF: R$ " + IOF + ", ISS: R$ " + ISS;
	}
}
