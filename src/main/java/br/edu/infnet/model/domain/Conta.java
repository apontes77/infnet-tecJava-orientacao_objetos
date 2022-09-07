package br.edu.infnet.model.domain;

import java.util.Objects;

import br.edu.infnet.model.exceptions.ConsumoInvalidoException;
import br.edu.infnet.model.exceptions.ImpostoInvalidoException;
import br.edu.infnet.model.exceptions.QuantidadeDeParcelasInvalidaException;
import br.edu.infnet.model.interfaces.IPrinter;

public abstract class Conta implements IPrinter {
	private Integer id;
	private String descricao;
	private boolean contaAtiva;

	public Conta() {}
	
	public abstract boolean mostraContaAtiva() throws ConsumoInvalidoException, ImpostoInvalidoException, QuantidadeDeParcelasInvalidaException;

	public Conta(Integer id, String descricao, boolean contaAtiva) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.contaAtiva = contaAtiva;
	}

	@Override
	public String toString() {
		return "id: " + id + "\n" + "descrição: " + descricao + "\n" + "Conta Ativa? " + contaAtiva + "\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}

	@Override
	public void impressao() {
		System.out.println("#Conta");
		System.out.println(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}

}
