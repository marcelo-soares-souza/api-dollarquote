package com.dollarquote.entity;

import java.util.List;

public class BCB {
	public List<Value> value;

	public static class Value {
		public Double cotacaoCompra;
		public Double cotacaoVenda;
		public String dataHoraCotacao;
	}

	public List<Value> getValue() {
		return value;
	}
}