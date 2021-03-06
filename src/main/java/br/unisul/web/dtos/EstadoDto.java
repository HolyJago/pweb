package br.unisul.web.dtos;

import java.io.Serializable;

import br.unisul.web.domain.Estado;

public class EstadoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	// Construtor vazio
	public EstadoDto() {
	}	
		
	// Construtor
	public EstadoDto(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public EstadoDto(Estado e) {
		id = e.getId();
		nome = e.getNome();
	}
	
	// hashCode() & equals() - id 	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoDto other = (EstadoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	// Getters & Setters - id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	// Getters & Setters - nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
