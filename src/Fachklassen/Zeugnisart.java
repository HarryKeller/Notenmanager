package Fachklassen;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Persistenz.DBZugriff;

@Entity
public class Zeugnisart
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Zeugnisart;
	
	public int getId()
	{
		return id;
	}
	//----------------------------------------------
	
	//Alle Lesen
	//----------------------------------------------
	/**
	 * Liest stumpf alle Zeugnisarten die in der Db Existieren
	 * @return
	 */
	public static ArrayList<Zeugnisart> alleLesen()
	{
		ArrayList<Zeugnisart> al= new ArrayList<Zeugnisart>();
		DBZugriff.alleLesen("Zeugnisart", al, "");
		return al;
	}
	//----------------------------------------------
	
	//get-Set-Add
	//----------------------------------------------
	public void setId(int id)
	{
		this.id = id;
	}

	public String getZeugnisart()
	{
		return Zeugnisart;
	}

	public void setZeugnisart(String zeugnisart)
	{
		Zeugnisart = zeugnisart;
	}
	
	
	
}
