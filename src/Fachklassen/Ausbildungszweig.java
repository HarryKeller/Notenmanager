package Fachklassen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import Persistenz.DBZugriff;



 /**Der bestimmte Ausbildungszweig
 *	Gedacht zur Unterscheidung der Verschiedenen Zeugnisfächer
 *	Jetzt nurnoch eine Sicherheitsmasnahme, damit einer Kaufm. Klasse keine Anwendungsentwicklungunterrichtsfächer
 *	zugewiesen können
 * 
 * @author kellerh
 *
 */
@Entity
public class Ausbildungszweig
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	//Anwendung bzw. Kaufmann oder andere
	private String ausbidldungsart;
	
	
	//ManyToMany zwischen Zeugnisfach und Ausbildungszweig (also this)
	@ManyToMany(cascade = CascadeType.ALL ,mappedBy="ausbildungszweig", fetch=FetchType.EAGER)
	private Set<Zeugnisfach> lstZeugnisfach = new HashSet<Zeugnisfach>();

	/**
	 * Liest stumpf alle Ausbildungszweige, die in der DB Existieren
	 * @return
	 */
	public static ArrayList<Ausbildungszweig> alleLesen()
	{
		ArrayList<Ausbildungszweig>al = new ArrayList<Ausbildungszweig>();
		DBZugriff.alleLesen("Ausbildungszweig", al, "");
		return al;
	}
	
	//Konstruktoren
	//----------------------------------------------------------
	public Ausbildungszweig()
	{
		//Defaultkonstruktor
	}
	public Ausbildungszweig(int id)
	{
		DBZugriff.lesen(this, id);
	}
	//--------------------------------------------------------
	//Override Methods
	//--------------------------------------------------------
	public String toString()
	{
		return this.ausbidldungsart;
	}
	
	//----------------------------------------------------
	//Get- Set und Add
	//----------------------------------------------------
	public Set<Zeugnisfach> getLstzeugnisfach()
	{
		return lstZeugnisfach;
	}
	public void addAusbildungszweig(Zeugnisfach az)
	{
		lstZeugnisfach.add(az);
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getAusbidldungsart()
	{
		return ausbidldungsart;
	}
	public void setAusbidldungsart(String ausbidldungsart)
	{
		this.ausbidldungsart = ausbidldungsart;
	}
	
}
