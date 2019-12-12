package com.casamento.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "convidado")
@SuppressWarnings("serial")
public class Convidado extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(name = "nome", nullable = false)
	private String nome;
	
	private String familia;
	
	
	@NotNull
	private int mesa;

	@OneToOne
	private Presente presente;
	
	@ManyToOne
	private Festa festa;


	public Festa getFesta() {
		return festa;
	}

	public void setFesta(Festa festa) {
		this.festa = festa;
	}

	public Presente getPresente() {
		return presente;
	}

	public void setPresente(Presente presente) {
		this.presente = presente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}


	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}
	
}
