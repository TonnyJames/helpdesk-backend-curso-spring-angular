package com.udemy.helpdesk.domain.enums;

public enum Status {
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

	private Integer codigo;
	private String descrição;

	private Status(Integer codigo, String descrição) {
		this.codigo = codigo;
		this.descrição = descrição;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescrição() {
		return descrição;
	}

	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (Status x : Status.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}
}
