package Fachklassen;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import Persistenz.DBZugriff;

@Entity
public class Zeugnisfach {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bez;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Klasse klasse;
	
	private boolean abschliessendesFach;
	private String fachart;
	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

	
	private boolean vorrueckungsfach;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "zfach_id")
	private List<Unterrichtsfach> unterrichtsfaecher = new ArrayList<Unterrichtsfach>();
	
	
	public static ArrayList<Zeugnisfach>alleLesen(Klasse k)
	{
		
		String hql="WHERE zf.klasse.id = "+k.getid();
		
		ArrayList<Zeugnisfach>al = new ArrayList<Zeugnisfach>();
		DBZugriff.alleLesen("Zeugnisfach zf", al, hql);
		return al;
	}
	
	
	public String toString()
	{
		return this.bez;
	}
	
	
	//Getter + Setter
	public String getBez() {
		return bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

	public boolean isAbschliessendesFach() {
		return abschliessendesFach;
	}

	public void setAbschliessendesFach(boolean abschliessendesFach) {
		this.abschliessendesFach = abschliessendesFach;
	}

	public String getFachart() {
		return fachart;
	}

	public void setFachart(String fachart) {
		this.fachart = fachart;
	}

	public boolean isVorrueckungsfach() {
		return vorrueckungsfach;
	}

	public void setVorrueckungsfach(boolean vorrueckungsfach) {
		this.vorrueckungsfach = vorrueckungsfach;
	}
		
	public List<Unterrichtsfach> getUnterrichtsfächer() {
		return unterrichtsfaecher;
	}	

	public int getId() {
		return id;
	}

	public Klasse getKlasse() {
		return klasse;
	}
	public void setUnterrichtsfächer(List<Unterrichtsfach> unterrichtsfächer) {
		this.unterrichtsfaecher = unterrichtsfächer;
	}

	
	//Konstruktoren
	public Zeugnisfach(){}
	
	public Zeugnisfach(int id)
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
	
	public void addUnterrichtsfach(Unterrichtsfach uf)
	{
		this.unterrichtsfaecher.add(uf);
	}
	
}
