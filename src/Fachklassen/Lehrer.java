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
	private boolean arbeitetAnDieserSchule;

	//----------------------------------------
	
	//Konstruktoren
	//----------------------------------------
	public Lehrer(int id)
	{
		DBZugriff.lesen(this, id);
	}
	
	public Lehrer()
	{
		
	}
	//----------------------------------------
	
	//Alle Lesen Methoden
	//----------------------------------------
	/**
	 * Liest alle Lehrer, welche in der DB Existieren und noch arbeiten
	 * @param gekuendigt
	 * @return
	 */
	public static ArrayList<Lehrer> alleLesen(boolean gekuendigt)
	{
		
		String hql = "l WHERE l.arbeitetAnDieserSchule != "+gekuendigt;	
		ArrayList<Lehrer> al = new ArrayList<Lehrer>();
		DBZugriff.alleLesen("Lehrer", al, hql);
		return al;
		
	}
	
	/**
	 * Liest stumpf alle Lehrer, die in der DB existieren
	 * @return
	 */
	public static  ArrayList<Lehrer> alleLesen()
	{
		ArrayList<Lehrer> al = new ArrayList<Lehrer>();
		DBZugriff.alleLesen("Lehrer", al, "");
		return al;
	}
	//----------------------------------------
	
	//Override Methoden
	//----------------------------------------
	public String toString()
	{
		return this.nachname +" " + this.vorname;
	}
	public boolean equals(Lehrer l)
	{
		if(this.id == l.getId())return true;
		else return false;
	}
	
	//----------------------------------------
	
	//DB-Methoden des Lehrers
	//----------------------------------------
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	
	//----------------------------------------
	//Get-Set-add Methoden
	//----------------------------------------
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
	public boolean isArbeitetAnDieserSchule()
	{
		return arbeitetAnDieserSchule;
	}
	public void setArbeitetAnDieserSchule(boolean arbeitetAnDieserSchule)
	{
		this.arbeitetAnDieserSchule = arbeitetAnDieserSchule;
	}
	
}
