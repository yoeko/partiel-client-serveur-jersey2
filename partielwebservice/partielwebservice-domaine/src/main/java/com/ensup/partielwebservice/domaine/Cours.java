package com.ensup.partielwebservice.domaine;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String themeCourse;
	private int numberHours;
	@OneToMany(mappedBy = "cours")
	private Collection<Etudiant> etudiants;
	
		
	public Cours() {
		super();
	}

	public Cours(String themeCourse, int numberHours) {
		super();
		this.themeCourse = themeCourse;
		this.numberHours = numberHours;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getThemeCourse() {
		return themeCourse;
	}

	public void setThemeCourse(String themeCourse) {
		this.themeCourse = themeCourse;
	}

	public int getNumberHours() {
		return numberHours;
	}

	public void setNumberHours(int numberHours) {
		this.numberHours = numberHours;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
		
}
