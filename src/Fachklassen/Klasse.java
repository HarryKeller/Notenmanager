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

import Persistenz.DBZugriff;

@Entity
public class Klasse 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String bez;
	private int sj;
	
	@ManyToOne
	private Schule schule;			//FS
	
	@ManyToOne
	private Lehrer klassenleiter;	//FS
	
	@ManyToOne
	private Lehrer stvklassenleiter;	//FS
	
	//Liste aller Zeugnisfächer
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="klasse_id")
	private List<Zeugnisfach> zeugnisfach = new ArrayList<Zeugnisfach>();
	
	//Liste aller Schüler der Klasse
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="klasse_id")
	private List<Schueler> schuelerlist = new ArrayList<Schueler>();
	
	
	public Klasse(){}
	
	public Klasse(int sid)
	{
		DBZugriff.lesen(this, sid);
	}
	
		
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
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

	public Schule getIdSchule() {
		return schule;
	}

	public void setIdSchule(Schule idSchule) {
		this.schule = idSchule;
	}

	public Lehrer getIdKlassenleiter() {
		return klassenleiter;
	}

	public void setIdKlassenleiter(Lehrer idKlassenleiter) {
		this.klassenleiter = idKlassenleiter;
	}

	public Lehrer getIdStvKlassenleiter() {
		return stvklassenleiter;
	}

	public void setIdStvKlassenleiter(Lehrer idStvKlassenleiter) {
		this.stvklassenleiter = idStvKlassenleiter;
	}
	
	public String toString()
	{
		return this.id + " "+ this.bez + " " + this.sj + " " + this.klassenleiter + " " + this.stvklassenleiter;
	}

}
