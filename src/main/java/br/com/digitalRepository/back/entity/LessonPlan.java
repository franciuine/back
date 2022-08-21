package br.com.digitalRepository.back.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
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
	private String educationLevel;
	private String author;
	private boolean enabled;
	private String tutorial;
	private String evaluation;
	private String hability;
	private String teacherLevel;
	private String pdfName;

	// @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "pdf_id", referencedColumnName = "id")
    // private Pdf pdf;
	//
	// public Pdf getPdf() {
	// 	return this.pdf;
	//}
    //
	//public void setPdf(Pdf pdf) {
	//	this.pdf = pdf;	
	//}

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
	
	public String getEducationLevel() {
		return educationLevel;
	}
	
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
    
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTutorial() {
		return tutorial;
	}

	public void setTutorial(String tutorial) {
		this.tutorial = tutorial;
	}
	
	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	
	public String getHability() {
		return hability;
	}

	public void setHability(String hability) {
		this.hability = hability;
	}
	
	public String getTeacherLevel() {
		return teacherLevel;
	}

	public void setTeacherLevel(String teacherLevel) {
		this.teacherLevel = teacherLevel;
	}

	public String getPdfName () {
		return pdfName;
	}

	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}

}
