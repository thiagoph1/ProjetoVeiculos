package com.projeto.veiculos.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String login;
	private String senha;
	private String nome;
	private String tipoCNH;
	private String ValidadeCNH;

	@ManyToMany
	@JoinTable(name = "usuarios_roles",
				joinColumns = @JoinColumn(name = "usuario_nome",
				referencedColumnName = "login"),
				inverseJoinColumns = @JoinColumn(name = "role_nome",
				referencedColumnName = "nomeRole"))
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
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
		return ValidadeCNH;
	}

	public void setValidadeCNH(String validadeCNH) {
		ValidadeCNH = validadeCNH;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
