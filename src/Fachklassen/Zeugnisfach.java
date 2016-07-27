package Fachklassen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import Persistenz.DBZugriff;

@Entity
public class Zeugnisfach {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bez;
	
	private boolean abschliessendesFach;
	private String fachart;	
	private boolean vorrueckungsfach;
	
	@ManyToMany(cascade = CascadeType.ALL ,mappedBy="lstzeugnisfach", fetch=FetchType.EAGER)
	private Set<Klasse> lstklassen = new HashSet<Klasse>();

	@ManyToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name="zeugnisfach_ausbildungszweig",
				joinColumns = @JoinColumn(name="zeugnisfach_id"),
				inverseJoinColumns=@JoinColumn(name="ausbildungszweig_id")	
			)
	private List<Ausbildungszweig> ausbildungszweig = new ArrayList<Ausbildungszweig>();
	
	//----------------------------------------------
	
	//Konstruktoren
	//----------------------------------------------
	public Zeugnisfach(){}
		
	public Zeugnisfach(int id)
	{
		DBZugriff.lesen(this, id);		
	}
	


	
	//----------------------------------------------

	
	//------------------------------------------------------
	
	//Alle Lesen Methoden
	//------------------------------------------------------
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "zfach_id")
	private List<Unterrichtsfach> unterrichtsfaecher = new ArrayList<Unterrichtsfach>();
	
	/**
	 * Diese Methode liefert alle abschliesenden Fächer für alle angegeben Klassen zurück
	 * Dieser methode kann 1+n argumente übergeben werden
	 * z.B. Zeugnisfach.alleLesen(k1);
	 * ODER:
	 * z.B. Zeugnisfach.alleLesen(k1,k2,k3,k3);
	 * Ob es elegant ist diese Methode zu benutzen ist fraglich.
	 * Besser wäre es einfach alle Abschliessenden Fächer eines Schülers über den Ausbildungszweig zu holen,
	 * da dies jedoch ebenso unsicher ist, da die Architektur zurzeit nicht 100Prozentig steht, wird dieser 
	 * unelegante Weg empfohlen. 
	 * Hier ist es möglich die Klassen in denen nach abschliessenden Fächern gesucht werden soll anzugeben
	 * @param aktuelle
	 * @param values
	 * @return
	 */
	public static ArrayList<Zeugnisfach>alleLesenAbschliesendeFaecher(Klasse aktuelle,Klasse... values)
	{
		
		
		String hql =" zf "
				+"INNER JOIN zf.ausbildungszweig az "
				+"INNER JOIN zf.lstklassen lk " 
				+"WHERE az = 1 "					
				+"AND zf.abschliessendesFach = true "				
				+"OR lk.id = "+aktuelle.getid()+" ";
		
		String orbedingung = " ";
		
		for(Klasse k:values)
		{
			orbedingung += "OR lk.id = "+k.getid();		
		}
		hql += orbedingung;
				
		System.out.println(hql);
		
		ArrayList<Object[]>al = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Zeugnisfach", al, hql);
		
		ArrayList<Zeugnisfach> zf = new ArrayList<Zeugnisfach>();
		
		for(Object[] o : al)
		{
			zf.add((Zeugnisfach)o[0]);
		}
		
		
	
		return zf;
	}
	
	/**
	 * Liest alle Zeugnisfächer der übergebenen klasse
	 * @param k
	 * @return
	 */
	public static ArrayList<Zeugnisfach>alleLesen(Klasse k)
	{
		
		String hql="zf "
				+ "INNER JOIN zf.lstklassen k "
				+ "ON k.id = "+k.getid() ;
		
		ArrayList<Zeugnisfach>ret = new ArrayList<Zeugnisfach>();
		ArrayList<Object[]>al = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Zeugnisfach ", al, hql);
		
		for(Object[]o:al)
		{
			ret.add((Zeugnisfach)o[0]);
		}
		
		
		
		return ret;
	}
	/**
	 * Liest alle Zeugnisfächer, welche in der DB existieren
	 * @return
	 */
	public static ArrayList<Zeugnisfach>alleLesen()
	{
		ArrayList<Zeugnisfach>al = new ArrayList<Zeugnisfach>();
		DBZugriff.alleLesen("Zeugnisfach", al, "");
		return al;
	}
	//------------------------------------------------------
	
	
	//override-Methoden
	//------------------------------------------------------
	@Override
	public String toString()
	{
		return this.bez;
	}

	
	public boolean equals(Zeugnisfach zf)
	{
		if(zf.getId() == this.getId()) return true;
		else return false;
	}
		
	//------------------------------------------------------
	
	//DB-Methoden
	//------------------------------------------------------
	public void speichern()
	{
		DBZugriff.speichern(this);
	}
	
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	//------------------------------------------------------
	
	//Get-Set-Add-Methoden
	//------------------------------------------------------
		
	public void addUnterrichtsfach(Unterrichtsfach uf)
	{
		this.unterrichtsfaecher.add(uf);
	}
	
	public List<Unterrichtsfach> getUnterrichtsfaecher()
	{
		return unterrichtsfaecher;
	}
	
	public void setUnterrichtsfächer(List<Unterrichtsfach> unterrichtsfächer) {
		this.unterrichtsfaecher = unterrichtsfächer;
	}
	
	public void setLstklassen(Set<Klasse> lstklassen)
	{
		this.lstklassen = lstklassen;
	}
	//Getter + Setter
	public String getBez() {
		return bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

	public boolean isAbschliessendesFach() {
		return abschliessendesFach;
	}

	public void setAbschliessendesFach(boolean abschliessendesFach) {
		this.abschliessendesFach = abschliessendesFach;
	}

	public String getFachart() {
		return fachart;
	}

	public void setFachart(String fachart) {
		this.fachart = fachart;
	}

	public boolean isVorrueckungsfach() {
		return vorrueckungsfach;
	}

	public void setVorrueckungsfach(boolean vorrueckungsfach) {
		this.vorrueckungsfach = vorrueckungsfach;
	}
		
	public List<Unterrichtsfach> getUnterrichtsfächer() {
		return unterrichtsfaecher;
	}	

	public int getId() {
		return id;
	}
	public void setUnterrichtsfaecher(List<Unterrichtsfach> unterrichtsfaecher)
	{
		this.unterrichtsfaecher = unterrichtsfaecher;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Set<Klasse> getLstklassen()
	{
		return lstklassen;
	}
	
	public List<Ausbildungszweig> getAusbildungszweig()
	{
		return ausbildungszweig;
	}

	public void addAusbildungszweig(Ausbildungszweig az)
	{
		ausbildungszweig.add(az);
	}
	


	public void setAusbildungszweig(List<Ausbildungszweig> ausbildungszweig)
	{
		this.ausbildungszweig = ausbildungszweig;
	}


	
}
