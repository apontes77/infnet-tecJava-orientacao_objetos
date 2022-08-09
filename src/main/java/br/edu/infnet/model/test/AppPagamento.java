package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Conta;

public class AppPagamento {
	private String mensagem;

	public AppPagamento(String mensagem) {
		this.mensagem = mensagem;
	}

	public void relatorio(Conta c) {
		System.out.println(mensagem);

		c.descricaoEmCapsLock();
	}

}
