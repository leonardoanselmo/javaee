package br.com.pluginformatica.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Agenda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	
	@Temporal(TemporalType.DATE)
	private Date dataRegistro;
	
	public Agenda(String nome, String telefone, Date dataRegistro) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataRegistro = dataRegistro;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public Date getDataRegistro() {
		return dataRegistro;
	}

}
