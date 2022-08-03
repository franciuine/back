package br.com.digitalRepository.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@Entity
public class EducationLevel {
	
	@Id
	private long id;
	private String name;
	private String components; 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getComponents() {
		return components;
	}
	
	public void setComponents(String components) {
		this.components = components;
	}
	
	

}
