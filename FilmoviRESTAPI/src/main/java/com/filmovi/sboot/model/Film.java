package com.filmovi.sboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="filmovi")
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String naziv;
	
	//izrazeno u minutima
	@Column(nullable=false)
	private double trajanje;
	
	@Column(nullable=false)
	private String zanr;
	
	@Column(name="godina_izdanja" , nullable = false)
	private int godinaIzdanja;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getGodinaIzdanja() {
		return godinaIzdanja;
	}
	public void setGodinaIzdanja(int godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}
	//private Reziser reziser;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(double trajanje) {
		this.trajanje = trajanje;
	}
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", trajanje=" + trajanje + ", zanr=" + zanr + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + godinaIzdanja;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		long temp;
		temp = Double.doubleToLongBits(trajanje);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((zanr == null) ? 0 : zanr.hashCode());
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
		Film other = (Film) obj;
		if (godinaIzdanja != other.godinaIzdanja)
			return false;
		if (id != other.id)
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (Double.doubleToLongBits(trajanje) != Double.doubleToLongBits(other.trajanje))
			return false;
		if (zanr == null) {
			if (other.zanr != null)
				return false;
		} else if (!zanr.equals(other.zanr))
			return false;
		return true;
	}
	
	
	
}
