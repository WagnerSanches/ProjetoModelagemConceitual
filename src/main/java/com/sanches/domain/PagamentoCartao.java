package com.sanches.domain;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcela;

	public PagamentoCartao() {}

	public PagamentoCartao(Integer id, Integer estado, Pedido pedido, Integer numeroParcelas) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub

		this.numeroParcela = numeroParcelas;
	}
	
	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	
}
