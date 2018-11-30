package br.senai.sp.model;

import java.sql.Date;

public class Compromisso {
	private int cod_compromisso;
	private int cod_usuario;
	private String titulo;
	private String data;
	private String hora_inicio;
	private String hora_fim;
	private String descricao;
	private int prioridade;
	private int status;
	private Usuario usuario;
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public int getCod_compromisso() {
		return cod_compromisso;
	}

	public void setCod_compromisso(int cod_compromisso) {
		this.cod_compromisso = cod_compromisso;
	}

	public int getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(String hora_fim) {
		this.hora_fim = hora_fim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
