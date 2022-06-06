package br.com.digitalRepository.back.entity;

import java.util.Collection;
import javax.persistence.Entity;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@Entity
public class EducationLevel {
	
	private long id;
	private String name;
	private Collection<Component> components;
	
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
	public Collection<Component> getComponents() {
		return components;
	}
	public void setComponents(Collection<Component> components) {
		this.components = components;
	}
	
	

}
