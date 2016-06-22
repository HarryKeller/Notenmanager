package Fachklassen;


import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.*;

import Persistenz.DBZugriff;

@Entity
public class Schueler 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 			// eindeutige Schüler-ID (index 0)
	
	// ---------------------------------------------------------------------------------
	
	private String nachname;	// (index 1)
	private String vorname;		// (index 2)
	private LocalDate gebdat;	// Geburtstag (index 3)
	private String geschl;		// Geschlecht (index 4)
	private String konfession;	// wegen Religion (index 5)
	private Klasse klasseid;	//Fremdschlüssel
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name="leistung_schueler") 
	private ArrayList<Leistung> leistung = new ArrayList<Leistung>();
	
	
	
	// ----- CONSTRUCTOR ---------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	
	public Schueler()
	{
	}
	
	public Schueler(int id)
	{
		DBZugriff.lesen(this, id);
	}
	
	public Schueler(String vorname, String nachname, LocalDate gebdat, String geschl, String konfession)
	{
		this.nachname = nachname;
		this.vorname = vorname;
		this.gebdat = gebdat;
		this.geschl = geschl;
		this.konfession = konfession;
	}
	
	
	// --------- GETTER AND SETTER ------------------------------------------------------
	// ------------------------------------------------------------------------------------
	
	public String getNachname()
	{
		return nachname;
	}
	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}
	public String getVorname()
	{
		return vorname;
	}
	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}
	public LocalDate getGebdat()
	{
		return gebdat;
	}
	public void setGebdat(LocalDate gebdat)
	{
		this.gebdat = gebdat;
	}
	public String getGeschl()
	{
		return geschl;
	}
	public void setGeschl(String geschl)
	{
		this.geschl = geschl;
	}
	public String getKonfession()
	{
		return konfession;
	}
	public void setKonfession(String konfession)
	{
		this.konfession = konfession;
	}
	public int getId()
	{
		return id;
	}
	
	
	// --- Override-METHODS ----------------------------------------------------
	// --------------------------------------------------------------------------
	
	public String toString()
	{
		return this.vorname + " " + this.nachname + " " + this.gebdat + " " + this.geschl + " " + this.konfession;
	}
	
	
	// --- DATABASE -------------------------------------------------------------
	// ---------------------------------------------------------------------------
	
	public void speichern() // Speichern des Satzes
	{
		DBZugriff.speichern(this);
	}
	
	public void loeschen() 	// Löschen des Satzes
	{
		DBZugriff.speichern(this);
	}

	public Klasse getKlasseid() {
		return klasseid;
	}

	public void setKlasseid(Klasse klasseid) {
		this.klasseid = klasseid;
	}
	
	
}
