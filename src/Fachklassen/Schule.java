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
	
	
	
	//Konstruktoren -----------------------------------------------------
	public Schule(){}
	
	public Schule(int s_id)
	{
		DBZugriff.lesen(this, s_id);
	}
	
	public Schule(String neu_name)
	{
		setBez(neu_name);
	}
	
	//Methoden ----------------------------------------------------------
	
	
	
	
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
	
	
	
	public int getID() //Rückgabe der ID der Schule
	{
		return id;
	}
	
	//Getter und Setter für die Schulbezeichnung
	public String getBez() 
	{
		return bez;
	}
	public void setBez(String bez) 
	{
		this.bez = bez;
	}

}
