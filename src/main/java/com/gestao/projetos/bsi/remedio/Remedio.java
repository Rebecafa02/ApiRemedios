package com.gestao.projetos.bsi.remedio;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "remedios")
@Table(name = "Remedio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {
	
	public Remedio(DadosCadastroRemedio dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.validade = dados.validade();
		this.via = dados.via();
		this.quantidade = dados.quantidade();
		this.lote = dados.lote();
		this.laboratorio = dados.laboratorio();
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome; 
	
	@Enumerated(EnumType.STRING) 
	private Via via; 
	private String lote; 
	private int quantidade; 
	private LocalDate validade; 
	 
	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;

	private boolean ativo;
	
	public void atualizarInformacoes(@Valid DadosAtualizarRemedio dados) {
		if(dados.nome() !=null) {
			this.nome = dados.nome();
		}
		if(dados.via() !=null) {
			this.via = dados.via();
		}
		if(dados.laboratorio() !=null) {
			this.laboratorio = dados.laboratorio();
		}
	}

	public void inativar() {
		this.ativo = false;
	}

	public void reativar() {
		this.ativo = true;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
}
