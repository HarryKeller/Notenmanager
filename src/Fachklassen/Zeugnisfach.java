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
	
	
	
	@ManyToMany(cascade = CascadeType.ALL ,mappedBy="lstzeugnisfach", fetch=FetchType.EAGER)
	private Set<Klasse> lstklassen = new HashSet<Klasse>();

	
	
	public Set<Klasse> getLstklassen()
	{
		return lstklassen;
	}



	public void setLstklassen(Set<Klasse> lstklassen)
	{
		this.lstklassen = lstklassen;
	}



	@ManyToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name="zeugnisfach_ausbildungszweig",
				joinColumns = @JoinColumn(name="zeugnisfach_id"),
				inverseJoinColumns=@JoinColumn(name="ausbildungszweig_id")	
			)
	private List<Ausbildungszweig> ausbildungszweig = new ArrayList<Ausbildungszweig>();
	

	
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

	public List<Unterrichtsfach> getUnterrichtsfaecher()
	{
		return unterrichtsfaecher;
	}

	public void setUnterrichtsfaecher(List<Unterrichtsfach> unterrichtsfaecher)
	{
		this.unterrichtsfaecher = unterrichtsfaecher;
	}

	public void setId(int id)
	{
		this.id = id;
	}



	private boolean abschliessendesFach;
	private String fachart;

	
	
	private boolean vorrueckungsfach;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "zfach_id")
	private List<Unterrichtsfach> unterrichtsfaecher = new ArrayList<Unterrichtsfach>();
	
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
	
	public static ArrayList<Zeugnisfach>alleLesen(Klasse k)
	{
		
		String hql="WHERE zf.klasse.id = "+k.getid();
		
		ArrayList<Zeugnisfach>al = new ArrayList<Zeugnisfach>();
		DBZugriff.alleLesen("Zeugnisfach zf", al, hql);
		return al;
	}
	public static ArrayList<Zeugnisfach>alleLesen()
	{
		ArrayList<Zeugnisfach>al = new ArrayList<Zeugnisfach>();
		DBZugriff.alleLesen("Zeugnisfach zf", al, "");
		return al;
	}
	
	
	public String toString()
	{
		return this.bez;
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

//	public Klasse getKlasse() {
//		return klasse;
//	}
	public void setUnterrichtsfächer(List<Unterrichtsfach> unterrichtsfächer) {
		this.unterrichtsfaecher = unterrichtsfächer;
	}

	
	//Konstruktoren
	public Zeugnisfach(){}
	
	public Zeugnisfach(int id)
	{
		DBZugriff.lesen(this, id);		
	}
	
	//Methoden
	public void speichern()
	{
		DBZugriff.speichern(this);
	}
	
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	
	public void addUnterrichtsfach(Unterrichtsfach uf)
	{
		this.unterrichtsfaecher.add(uf);
	}
	
}
