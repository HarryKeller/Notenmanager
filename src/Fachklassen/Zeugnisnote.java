package Fachklassen;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;

import javax.persistence.Id;
<<<<<<< HEAD
=======
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
>>>>>>> refs/remotes/origin/master

import Persistenz.DBZugriff;



@Entity
public class Zeugnisnote 
{
	// Konstruktor
	//---------------------------------------------------------------------------------------------
	public Zeugnisnote()
	{
		
	}
	
	public Zeugnisnote(int noteZeugnis, int noteErrechnet, String bemerkung, LocalDate aenderungszeitpunkt)
	{
		this.noteZeugnis = noteZeugnis;
		this.noteErrechnet = noteErrechnet;
		this.bemerkung = bemerkung;
		this.aenderungszeitpunkt = aenderungszeitpunkt;
	}
	//---------------------------------------------------------------------------------------------
	
	// Instanzvariablen
	//---------------------------------------------------------------------------------------------
	@Id
	private int id;
	
	private int noteZeugnis;
	
	private double noteErrechnet;
	
	private String bemerkung;
	
	private LocalDate aenderungszeitpunkt;
	//---------------------------------------------------------------------------------------------

	
	// Instanzvariablen -> Fremdschlüssel
	//---------------------------------------------------------------------------------------------
	// private int idZeugnisfach;
	// private int idSchueler;
	// private int idZeugnis;
	//---------------------------------------------------------------------------------------------
	
	
	// Getter / Setter
	//---------------------------------------------------------------------------------------------
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getNoteZeugnis() 
	{
		return noteZeugnis;
	}
	public void setNoteZeugnis(int noteZeugnis) 
	{
		this.noteZeugnis = noteZeugnis;
	}
	
	public double getNoteErrechnet() 
	{
		return noteErrechnet;
	}
	public void setNoteErrechnet(double noteErrechnet) 
	{
		this.noteErrechnet = noteErrechnet;
	}
	
	public String getBemerkung() 
	{
		return bemerkung;
	}
	public void setBemerkung(String bemerkung) 
	{
		this.bemerkung = bemerkung;
	}
	
	public LocalDate getAenderungszeitpunkt() 
	{
		return aenderungszeitpunkt;
	}
	public void setAenderungszeitpunkt(LocalDate aenderungszeitpunkt) 
	{
		this.aenderungszeitpunkt = aenderungszeitpunkt;
	}
	//---------------------------------------------------------------------------------------------
	
	
	// Methoden
	//---------------------------------------------------------------------------------------------
	public void lesen(int id)
	{
		DBZugriff.lesen(this, id);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	public String toString()
	{
		return "";
	}
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	public double berechneNote(Unterrichtsfach uf)
	{
		double muendlich = 0;
		double schriftlich = 0;
		double note = 0;
		double i = 0;
		
		ArrayList<Leistung>leistungen = new ArrayList<Leistung>(Leistung.AlleLesen(schueler, uf));
		for (Leistung l : leistungen )
		{
			if(l.getLeistungsart().getBez() == "Schulaufgabe")
			{
				schriftlich = schriftlich + l.getNotenstufe();				
			}
			else
			{
				muendlich = muendlich + l.getNotenstufe();
			}
			i++;
		}
		note = ((schriftlich * 2) + muendlich) / i;	
		
		return note;
	}
	//---------------------------------------------------------------------------------------------
	
	
	// Methoden -> Static
	//---------------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------------------
}