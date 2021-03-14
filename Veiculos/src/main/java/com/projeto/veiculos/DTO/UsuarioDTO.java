package com.projeto.veiculos.DTO;

import java.io.Serializable;
import java.util.List;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String login;
	private String senha;
	private String nome;
	private String tipoCNH;
	private String validadeCNH;
	private List<Long> roles;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoCNH() {
		return tipoCNH;
	}

	public void setTipoCNH(String tipoCNH) {
		this.tipoCNH = tipoCNH;
	}

	public String getValidadeCNH() {
		return validadeCNH;
	}

	public void setValidadeCNH(String validadeCNH) {
		this.validadeCNH = validadeCNH;
	}



}
