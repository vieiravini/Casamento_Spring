package com.casamento.demo.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@SuppressWarnings("serial")
@Entity
public class Festa extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	private String local_festa;
	
	@NotBlank
	private String endereco;
	
	@NotNull
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime horario;
	
	@NotBlank
	private String local_casamento;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data_casamento;
	
	@NotBlank
	private String noivo;
	
	@NotBlank
	private String noiva;

	
	public String getLocal_festa() {
		return local_festa;
	}

	public void setLocal_festa(String local_festa) {
		this.local_festa = local_festa;
	}

	public String getLocal_casamento() {
		return local_casamento;
	}

	public void setLocal_casamento(String local_casamento) {
		this.local_casamento = local_casamento;
	}

	public String getNoivo() {
		return noivo;
	}

	public void setNoivo(String noivo) {
		this.noivo = noivo;
	}

	public String getNoiva() {
		return noiva;
	}

	public void setNoiva(String noiva) {
		this.noiva = noiva;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public LocalTime getHorario() {
		return horario;
	}

	public LocalDate getData_casamento() {
		return data_casamento;
	}

	public void setData_casamento(LocalDate data_casamento) {
		this.data_casamento = data_casamento;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
	
}
