package com.casamento.demo.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@SuppressWarnings("serial")
public class Presente extends AbstractEntity<Long> {


	@NotBlank(message = "insira o local da compra do presente.")
	private String local_compra;
	
	@NotBlank(message = "insira a descrição do presente.")
	private String descricao;


	public String getLocal_compra() {
		return local_compra;
	}

	public void setLocal_compra(String local_compra) {
		this.local_compra = local_compra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
