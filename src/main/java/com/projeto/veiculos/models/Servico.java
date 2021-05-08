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
	private float distancia;
	private float abastecimento;
	private float consumo;
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

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public float getAbastecimento() {
		return abastecimento;
	}

	public void setAbastecimento(float abastecimento) {
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

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	
	
	

}
