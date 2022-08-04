package br.edu.infnet.model.domain;

import java.time.LocalDate;

public class PagamentoComPix extends Pagamento{
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private String chavePixParaPagar;
}
