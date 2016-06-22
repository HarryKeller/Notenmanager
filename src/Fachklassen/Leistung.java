package Fachklassen;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Persistenz.DBZugriff;

@Entity 
public class Leistung 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private LocalDate erhebungsdatum;
	private int notenstufe;
	private char tendenz;
	
	@ManyToOne
	private Leistungsart art;
	@ManyToOne
	private UFachLehrer ufachlehrer;
	
	@ManyToOne
	private Schueler schueler;
	
	
	private LocalDate letzteaenderung;
	
	public Leistung()
	{
		
	}	
	public Leistung(int id)
	{
		DBZugriff.lesen(this,id);
	}
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	
	public static ArrayList<Leistung>AlleLesen()
	{
		ArrayList<Leistung> al = new ArrayList<Leistung>();
		DBZugriff.alleLesen("Leistung", al, "" );
		return al;	
	}
	
	public LocalDate getErhebungsdatum()
	{
		return erhebungsdatum;
	}
	public void setErhebungsdatum(LocalDate erhebungsdatum)
	{
		this.erhebungsdatum = erhebungsdatum;
	}
	
	public int getNotenstufe()
	{
		return notenstufe;
	}
	public void setNotenstufe(int notenstufe)
	{
		this.notenstufe = notenstufe;
	}
	
	public char getTendenz()
	{
		return tendenz;
	}
	public void setTendenz(char tendenz)
	{
		this.tendenz = tendenz;
	}
	
	public LocalDate getLetzteaenderung()
	{
		return letzteaenderung;
	}
	public void setLetzteaenderung(LocalDate letzteaenderung)
	{
		this.letzteaenderung = letzteaenderung;
	}
	
	public int getId()
	{
		return id;
	}
	public Leistungsart getArt()
	{
		return art;
	}
	public UFachLehrer getUfachlehrer()
	{
		return ufachlehrer;
	}
	
//	public int getIdart()
//	{
//		return idart;
//	}
//	public int getIdschuelerklasse()
//	{
//		return idschuelerklasse;
//	}
//	public int getIdfachlehrer()
//	{
//		return idfachlehrer;
//	}
	
	
}
