package com.filmovi.sboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="REZISERI")

public class Reziser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReziser;

	@Column(name="IME",nullable=false)
	private String ime;

	@Column(name="PREZIME" ,nullable=false)
	private String prezime;

	@Column(name="EMAIL" ,nullable=false)
	private String email;
	
	@OneToMany(mappedBy="reziser" ,orphanRemoval = true , cascade={CascadeType.ALL})
	private List<Film> filmovi;
	
	public Reziser() {
		this.filmovi = new ArrayList<>();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Film> getFilmovi() {
		return filmovi;
	}

	public void setFilmovi(List<Film> filmovi) {
		this.filmovi = filmovi;
	}

	@Override
	public String toString() {
		return "Reziser [id=" + idReziser + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", filmovi="
				+ filmovi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((filmovi == null) ? 0 : filmovi.hashCode());
		result = prime * result + (int) (idReziser ^ (idReziser >>> 32));
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
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
		Reziser other = (Reziser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (filmovi == null) {
			if (other.filmovi != null)
				return false;
		} else if (!filmovi.equals(other.filmovi))
			return false;
		if (idReziser != other.idReziser)
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}


	
	
	
}
