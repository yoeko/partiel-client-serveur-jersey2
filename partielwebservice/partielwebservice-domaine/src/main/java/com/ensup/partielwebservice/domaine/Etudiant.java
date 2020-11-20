package com.ensup.partielwebservice.domaine;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("ETUDIANT")
public class Etudiant extends Personne {
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cours cours;
	

	public Etudiant(String first_name, String last_name, String mail, String address, String phone, Date dob) {
		super(first_name, last_name, mail, address, phone, dob);
	}

	public Etudiant(String first_name, String last_name, String mail, String address, String phone, Date dob, Cours cours) {
		super(first_name, last_name, mail, address, phone, dob);
		this.cours = cours;
	}

	public Etudiant() {
		super();
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Etudiant [cours=" + cours + ", getId()=" + getId() + ", getFirst_name()=" + getFirst_name()
				+ ", getLast_name()=" + getLast_name() + ", getMail()=" + getMail() + ", getAddress()=" + getAddress()
				+ ", getPhone()=" + getPhone() + ", getDob()=" + getDob() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
