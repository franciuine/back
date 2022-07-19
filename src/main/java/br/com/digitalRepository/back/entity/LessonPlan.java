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
	private String pillar;
	private String component;
	@OneToOne
    @MapsId
	private EducationLevel educationLevel;
	@OneToOne
	@MapsId
	private User user;
	private boolean enabled;
	private String tutorial;
	
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

	public String getPillar() {
		return pillar;
	}

	public void setPillar(String pillar) {
		this.pillar = pillar;
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
    
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getTutorial() {
		return tutorial;
	}

	public void setTutorial(String tutorial) {
		this.tutorial = tutorial;
	}
	
	
	
}
