package br.com.digitalRepository.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@Entity
public class EducationLevel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long levelId;
	private String name;
	private String components; 
	
	public long getLevelId() {
		return levelId;
	}

	public void setLevelId(long levelId) {
		this.levelId = levelId;
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
