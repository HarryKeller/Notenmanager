package Fachklassen;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Persistenz.DBZugriff;

@Entity 
public class Leistungsart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String bez;
	private double gewichtung;
	private char gruppe;	
	//------------------------------------------
	
	//Konstruktoren
	//------------------------------------------
	public Leistungsart()
	{
		
	}	
	public Leistungsart(int id)
	{
		DBZugriff.lesen(this,id);
	}
	//------------------------------------------
	
	//Db-Methoden
	//------------------------------------------
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	
	//------------------------------------------
	
	//Alle Lesen 
	//------------------------------------------
	
	public static ArrayList<Leistungsart>AlleLesen()
	{
		ArrayList<Leistungsart> al = new ArrayList<Leistungsart>();
		DBZugriff.alleLesen("Leistungsart", al, "" );
		return al;		
	}
	//------------------------------------------
	
	//Get-Set-Add
	//------------------------------------------
	
	public String getBez()
	{
		return bez;
	}
	public void setBez(String bez)
	{
		this.bez = bez;
	}
	
	public double getGewichtung()
	{
		return gewichtung;
	}
	public void setGewichtung(double gewichtung)
	{
		this.gewichtung = gewichtung;
	}
	
	public char getGruppe()
	{
		return gruppe;
	}
	public void setGruppe(char gruppe)
	{
		this.gruppe = gruppe;
	}
	
	public int getId()
	{
		return id;
	}
}
