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
import javax.persistence.OneToMany;

import Persistenz.DBZugriff;

@Entity
public class Klasse 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String bez;
	private int sj;
	private int idSchule;
	private int idKlassenleiter;
	private int idStvKlassenleiter;
	
	//Liste aller Zeugnisfächer
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="klasse_id")
	private List<Zeugnisfach> zeugnisfach = new ArrayList<Zeugnisfach>();
	
	//Liste aller Schüler der Klasse
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="klasse_id")
	private List<Schueler> schuelerlist = new ArrayList<Schueler>();
	
	
	public Klasse(){}
	
	public Klasse(int s_id)
	{
		DBZugriff.lesen(this, s_id);
	}
	
		
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	public void laden(int s_id)
	{
		DBZugriff.lesen(this, s_id);
	}
	
	
	public int getid()
	{
		return id;
	}
	
	public String getBez() {
		return bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

	public int getSj() {
		return sj;
	}

	public void setSj(int sj) {
		this.sj = sj;
	}

	public int getIdSchule() {
		return idSchule;
	}

	public void setIdSchule(int idSchule) {
		this.idSchule = idSchule;
	}

	public int getIdKlassenleiter() {
		return idKlassenleiter;
	}

	public void setIdKlassenleiter(int idKlassenleiter) {
		this.idKlassenleiter = idKlassenleiter;
	}

	public int getIdStvKlassenleiter() {
		return idStvKlassenleiter;
	}

	public void setIdStvKlassenleiter(int idStvKlassenleiter) {
		this.idStvKlassenleiter = idStvKlassenleiter;
	}
	
	public String toString()
	{
		return this.id + " "+ this.bez + " " + this.sj + " " + this.idKlassenleiter + " " + this.idStvKlassenleiter;
	}

}
