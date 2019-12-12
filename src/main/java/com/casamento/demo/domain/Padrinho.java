package com.casamento.demo.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Padrinho extends AbstractEntity<Long> {
	
	private String nome;
	
	private String tipo_padrinho;
	
	private boolean padrinho;
	
	private boolean madrinha;
	
	@ManyToOne
	private Presente presente;
	
	private String mesa;
	
	@ManyToOne
	private Festa festa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo_padrinho() {
		return tipo_padrinho;
	}

	public void setTipo_padrinho(String tipo_padrinho) {
		this.tipo_padrinho = tipo_padrinho;
	}

	public boolean isPadrinho() {
		return padrinho;
	}

	public void setPadrinho(boolean padrinho) {
		this.padrinho = padrinho;
	}

	public boolean isMadrinha() {
		return madrinha;
	}

	public void setMadrinha(boolean madrinha) {
		this.madrinha = madrinha;
	}

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

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	
	
	
	
	
}
