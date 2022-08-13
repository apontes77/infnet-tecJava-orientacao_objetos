package br.edu.infnet.model.test;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

public class AppImpressao {
	public static void relatorio(String mensagem, IPrinter printer) {
		System.out.println(mensagem);
		printer.impressao();
	}
}
