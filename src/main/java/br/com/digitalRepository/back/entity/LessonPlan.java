package br.com.digitalRepository.back.entity;

import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@Entity
public class LessonPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	private Pillar pillar;
	private Field field;
	private String component;
	@OneToOne
    @MapsId
	private EducationLevel educationLevel;
	private boolean enabled;

	// DEC = decomposição, PAT = reconhecimento de padrões, ABS = abstração, ALG = algoritmos
	public enum Pillar {
		DEC, PAT, ABS, ALG;
	}
	
	// MAT = matemática, LAN = linguagens, NAT = ciências da natureza, HUM = ciências humanas
	public enum Field {
		MAT, LAN, NAT, HUM;
	}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pillar getPillar() {
		return pillar;
	}

	public void setPillar(Pillar pillar) {
		this.pillar = pillar;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}
	
	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
