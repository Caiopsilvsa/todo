package com.todo.todo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="TODO_LIST")
public class Todo {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer ID;
	
	@NotNull
	private String Titulo;
	
	@NotNull
	private String Descricao;
	
	@NotNull
	private boolean finalizacao;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date DataParaFinalizar;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public boolean isFinalizacao() {
		return finalizacao;
	}

	public void setFinalizacao(boolean finalizacao) {
		this.finalizacao = finalizacao;
	}

	public Date getDataParaFinalizar() {
		return DataParaFinalizar;
	}

	public void setDataParaFinalizar(Date dataParaFinalizar) {
		DataParaFinalizar = dataParaFinalizar;
	}

	public Todo(Integer iD, String titulo, String descricao, boolean finalizacao, Date dataParaFinalizar) {
		super();
		ID = iD;
		Titulo = titulo;
		Descricao = descricao;
		this.finalizacao = finalizacao;
		DataParaFinalizar = dataParaFinalizar;
	}
	
	public Todo() {
		
	};
	
	
}
