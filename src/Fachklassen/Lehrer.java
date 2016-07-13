package Fachklassen;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Persistenz.DBZugriff;

@Entity
@Table(name = "Lehrer")
public class Lehrer 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	private String kuerzel;
	private String nachname;
	private String vorname;
	private String dienstbezeichnung;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKuerzel() {
		return kuerzel;
	}
	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getDienstbezeichnung() {
		return dienstbezeichnung;
	}
	public void setDienstbezeichnung(String dienstbezeichnung) {
		this.dienstbezeichnung = dienstbezeichnung;
	}
	
	public Lehrer(int id)
	{
		DBZugriff.lesen(this, id);
	}
	
	public Lehrer()
	{
		
	}
	
	public static  ArrayList<Lehrer> alleLesen()
	{
		ArrayList<Lehrer> al = new ArrayList<Lehrer>();
		DBZugriff.alleLesen("Lehrer", al, "");
		return al;
	}
	public String toString()
	{
		return this.nachname +" " + this.vorname;
	}
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
}
