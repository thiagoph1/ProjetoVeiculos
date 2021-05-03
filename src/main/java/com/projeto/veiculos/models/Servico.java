package com.projeto.veiculos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int distancia;
	private int abastecimento;
	private String dataInicial;
	private String dataFinal;
	
	@ManyToOne
	@JoinColumn(name ="veiculo_id")
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name ="usuario_id")
	private Usuario usuario;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getAbastecimento() {
		return abastecimento;
	}

	public void setAbastecimento(int abastecimento) {
		this.abastecimento = abastecimento;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
