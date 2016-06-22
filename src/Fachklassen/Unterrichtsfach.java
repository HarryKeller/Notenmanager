package Fachklassen;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Persistenz.DBZugriff;

@Entity
public class Unterrichtsfach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String bez;
	private int stunden;
	private int pos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Zeugnisfach zfach;
	
	//Getter + Setter
	
	public String getBez() {
		return bez;
	}
	public void setBez(String bez) {
		this.bez = bez;
	}
	public int getStunden() {
		return stunden;
	}
	public void setStunden(int stunden) {
		this.stunden = stunden;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getId() {
		return id;
	}
	public Zeugnisfach getZfach_id() {
		return zfach;
	}
	//Konstruktoren
	public Unterrichtsfach(){}
	
	public Unterrichtsfach(int id)
	{
		DBZugriff.lesen(this, id);
	}
	
	//Methoden
	public void speichern()
	{
		DBZugriff.speichern(this);
	}
	
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
}
