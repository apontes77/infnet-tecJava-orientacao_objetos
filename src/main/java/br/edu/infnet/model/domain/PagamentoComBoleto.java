package br.edu.infnet.model.domain;

import java.time.LocalDate;

public class PagamentoComBoleto extends Pagamento{
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private String codigo;
}
