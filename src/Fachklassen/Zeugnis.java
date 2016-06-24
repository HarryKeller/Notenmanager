package Fachklassen;

import javax.persistence.Entity;
import javax.persistence.Id;

import Persistenz.DBZugriff;


@Entity
public class Zeugnis
{
	// Konstruktor
	//---------------------------------------------------------------------------------------------
	public Zeugnis()
	{
		
	}
	
	public Zeugnis(String bemerkung, String zeugnisart, int fehltageGanztags,
			int fehltageGanztagsUnentschuldigt, int fehltageStundenweise,
			int fehltageStundenweiseUnentschuldigt)
	{
		this.bemerkung = bemerkung;
		this.zeugnisart = zeugnisart;
		this.fehltageGanztags = fehltageGanztags;
		this.fehltageGanztagsUnentschuldigt = fehltageGanztagsUnentschuldigt;
		this.fehltageStundenweise = fehltageStundenweise;
		this.fehltageStundenweiseUnentschuldigt = fehltageStundenweiseUnentschuldigt;
	}
	//---------------------------------------------------------------------------------------------
	
	
	// Instanzvariablen
	//---------------------------------------------------------------------------------------------
	@Id
	private int id;
	
	private String bemerkung;
	private String zeugnisart;
	
	private int fehltageGanztags;
	private int fehltageGanztagsUnentschuldigt;
	private int fehltageStundenweise;
	private int fehltageStundenweiseUnentschuldigt;
	//---------------------------------------------------------------------------------------------
	
	
	// Instanzvariablen -> Fremdschlüssel
	//---------------------------------------------------------------------------------------------
	// int idSchuelerKlasse;
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
	
	public String getBemerkung()
	{
		return bemerkung;
	}
	public void setBemerkung(String bemerkung)
	{
		this.bemerkung = bemerkung;
	}
	
	public String getZeugnisart()
	{
		return zeugnisart;
	}
	public void setZeugnisart(String zeugnisart)
	{
		this.zeugnisart = zeugnisart;
	}
	
	public int getFehltageGanztags()
	{
		return fehltageGanztags;
	}
	public void setFehltageGanztags(int fehltageGanztags)
	{
		this.fehltageGanztags = fehltageGanztags;
	}
	
	public int getFehltageGanztagsUnentschuldigt()
	{
		return fehltageGanztagsUnentschuldigt;
	}
	public void setFehltageGanztagsUnentschuldigt(int fehltageGanztagsUnentschuldigt)
	{
		this.fehltageGanztagsUnentschuldigt = fehltageGanztagsUnentschuldigt;
	}
	
	public int getFehltageStundenweise()
	{
		return fehltageStundenweise;
	}
	public void setFehltageStundenweise(int fehltageStundenweise)
	{
		this.fehltageStundenweise = fehltageStundenweise;
	}
	
	public int getFehltageStundenweiseUnentschuldigt()
	{
		return fehltageStundenweiseUnentschuldigt;
	}
	public void setFehltageStundenweiseUnentschuldigt(int fehltageStundenweiseUnentschuldigt)
	{
		this.fehltageStundenweiseUnentschuldigt = fehltageStundenweiseUnentschuldigt;
	}
	//---------------------------------------------------------------------------------------------
	
	
	// Methoden
	//---------------------------------------------------------------------------------------------
	public void lesen(int id)
	{
		DBZugriff.lesen(this, id);
	}
	public void speichern()
	{
		DBZugriff.speichern(this);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	public String toString()
	{
		return "";
	}
	//---------------------------------------------------------------------------------------------
	
	
	// Methoden -> Static
	//---------------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------------------
}
