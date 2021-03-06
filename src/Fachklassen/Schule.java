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
public class Schule 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //ID soll selbst generiert werden, aber nur in der Tabelle Schule
	private int id;
	private String bez;

	//EAGER -> beim Laden einer Schule sofort alle Klassen dazu laden
	// Je nach Anwendungsfall (--> Klassen in ListBox --> LAZY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="schule_id")
	private List<Klasse> klassenlist = new ArrayList<Klasse>();
	
	private String schulleiter;
	private String stvSchulleiter;
	//-----------------------------------------------------
	
	//Konstruktoren
	//-----------------------------------------------------
	public Schule(){}
		
	public Schule(int s_id)
	{
		DBZugriff.lesen(this, s_id);
	}
	
	public Schule(String neu_name)
	{
		setBez(neu_name);
	}
	//-----------------------------------------------------
	

	public String toString()
	{
		return this.bez;
	}
		
	//-----------------------------------------------------

	//DB-Methoden
	//-----------------------------------------------------

	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	
	
	public List<Klasse> getKlassen()
	{
		return klassenlist;
	}
	/**
	 * Liest stumpf alle Schulen, die in der DB existieren
	 * @return
	 */
	public static ArrayList<Schule> alleLesen()
	{
		ArrayList<Schule> al = new ArrayList<Schule>();
		DBZugriff.alleLesen("Schule", al, "");
		return al;
	}
	//-----------------------------------------------------
	
	
	
	//Get-Set-Add
	//-----------------------------------------------------
	public int getID() //R�ckgabe der ID der Schule
	{
		return id;
	}
	
	//Getter und Setter f�r die Schulbezeichnung
	public String getBez() 
	{
		return bez;
	}
	public void setBez(String bez) 
	{
		this.bez = bez;
	}
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public List<Klasse> getKlassenlist()
	{
		return klassenlist;
	}

	public void setKlassenlist(List<Klasse> klassenlist)
	{
		this.klassenlist = klassenlist;
	}

	public String getSchulleiter()
	{
		return schulleiter;
	}

	public void setSchulleiter(String schulleiter)
	{
		this.schulleiter = schulleiter;
	}

	public String getStvSchulleiter()
	{
		return stvSchulleiter;
	}

	public void setStvSchulleiter(String stvSchulleiter)
	{
		this.stvSchulleiter = stvSchulleiter;
	}
	


	
	
}
