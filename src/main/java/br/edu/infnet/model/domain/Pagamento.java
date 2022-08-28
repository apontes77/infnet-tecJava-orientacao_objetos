package br.edu.infnet.model.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import br.edu.infnet.apppagamento.interfaces.IPrinter;
import br.edu.infnet.model.domain.exceptions.ClienteInvalidoException;
import br.edu.infnet.model.domain.exceptions.ConjuntoDeContasInvalidoException;

public class Pagamento implements IPrinter {
	private Integer id;
	private String numeroCartao;
	private String bandeira;
	private BigDecimal valor;
	private Cliente cliente;
	private LocalDateTime data;
	private Set<Conta> contas;

	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}

	public Pagamento(Cliente cliente, Set<Conta> contas) throws ConjuntoDeContasInvalidoException, ClienteInvalidoException {
		if(cliente==null) {
			throw new ClienteInvalidoException("não é possível gerar um pagamento com um cliente nulo");
		}
		
		if(contas==null) {
			throw new ConjuntoDeContasInvalidoException("não é possível realizar um pagamento ser ter uma conta");
		}
		
		this.data = LocalDateTime.now();
		this.cliente = cliente;
		this.contas = contas;
	}

	@Override
	public String toString() {
		return "Número do Cartão: " + numeroCartao + "; Bandeira: " + bandeira + ";data: " + data + "; Valor: R$ "
				+ valor + " " + cliente + ";" + contas.size();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public void impressao() {
		System.out.println("#pagamento");
		System.out.println(this);

	}

}
