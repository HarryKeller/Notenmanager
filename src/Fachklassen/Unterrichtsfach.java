package Fachklassen;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Persistenz.DBZugriff;

@Entity
public class Unterrichtsfach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String bez;
	private int stunden;
	private int pos;
	private int gewichtungSchriftlich;
	
	@ManyToOne
	private Zeugnisfach zfach;
	
	//-------------------------------------------
	
	//Konstruktoren
	//-------------------------------------------
	public Unterrichtsfach(){}
	
	public Unterrichtsfach(int id)
	{
		DBZugriff.lesen(this, id);
	}
	/**
	 * Kopierkonstruktor
	 * @param uf
	 */
	public Unterrichtsfach(Unterrichtsfach uf)
	{
		this.id = uf.getId();	//int
		this.bez = new String(uf.getBez());
		this.stunden = uf.getStunden();	//int
		this.pos = uf.getPos();		//int
		this.gewichtungSchriftlich = uf.getGewichtungSchriftlich();	//int
	}
	//-------------------------------------------
	
	//Db-Methoden
	//-------------------------------------------
	public void speichern()
	{
		DBZugriff.speichern(this);
	}	
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
		
	
	//-------------------------------------------
	
	//AlleLesen Methoden
	//-------------------------------------------
	public static ArrayList<Unterrichtsfach>alleLesen(Lehrer lehrer , Klasse klasse, LocalDate ausgangsdatum)
	{
		String hql= " uf "	//Alle Unterrichtsfächer einer Klasse
				+"INNER JOIN UFachLehrer ufl "
				+"ON ufl.ufach.id = uf.id "
				+"AND ufl.lehrer.id = "+lehrer.getId()+" "
				+"WHERE ufl.austrittsdatum > '"+ausgangsdatum+"' ";
		
		ArrayList<Object[]>al = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Unterrichtsfach", al, hql);
		ArrayList<Unterrichtsfach>ret = new ArrayList<Unterrichtsfach>();
			
		for(Object[]o : al)
		{
				
			
			for(Zeugnisfach zf:klasse.getlstzeugnisfach())
			{
				//System.out.println(  zf.getId()+"           "+((Unterrichtsfach)o[0]).getZfach().getId() );
				if(zf.equals(((Unterrichtsfach)o[0]).getZfach()))
				{
					ret.add((Unterrichtsfach) o[0]);
				}
			}
			
		}
		
		
		return ret;
	}
			
	public static ArrayList<Unterrichtsfach>alleLesen(Schueler s)
	{
		
		
		//SQL:
//		SELECT DISTINCT (Unterrichtsfach.bez)
//		FROM Unterrichtsfach
//		INNER JOIN Schueler
//		ON Schueler.id = 4/*Parameter*/
//		INNER JOIN Klasse
//		ON Klasse.id = Schueler.klasse_id
//		INNER JOIN zeugnisfach_klasse
//		ON zeugnisfach_klasse.klasse_id = Klasse.id
//		INNER JOIN Zeugnisfach
//		ON zeugnisfach_klasse.zeugnisfach_id = Zeugnisfach.id
//		WHERE Unterrichtsfach.zfach_id = Zeugnisfach.id
		
		
		
//		String hql = "uf "
//				+"INNER JOIN Schueler s "
//				+"ON s.id = "+s.getId()+" "
//				+"INNER JOIN Klasse k "
//				+"ON k.id = s.klasse.id ";	
		
		//Dieser hql befehl bringt mir die Klasse des Schuelers
		String hql2 = " k "
				+"INNER JOIN k.lstzeugnisfach lst "
				+"INNER JOIN Zeugnisfach zf "
				+"ON zf.id = lst.id "
				+"INNER JOIN Unterrichtsfach uf "
				+"ON uf.zfach.id = zf.id "
				+"WHERE k.id = "+s.getKlasse().getId();
				
				
				
		ArrayList<Object[]>al = new ArrayList<Object[]>();		
		DBZugriff.alleLesen("Klasse", al, hql2);
		
		ArrayList<Unterrichtsfach>ret = new ArrayList<Unterrichtsfach>();
		for(Object[]o :al)
		{
			ret.add((Unterrichtsfach)o[3]);
		}
				
		return ret;
	}
	
	public static ArrayList<Unterrichtsfach>alleLesen(Zeugnisfach zf)
	{
		String hql = " uf WHERE uf.zfach.id = "+zf.getId();
		ArrayList<Unterrichtsfach>al = new ArrayList<Unterrichtsfach>();
		DBZugriff.alleLesen("Unterrichtsfach", al, hql);
		return al;
	}
	
	public static ArrayList<Unterrichtsfach>alleLesen(Lehrer lehrer,LocalDate ausgangsdatum)
	{
		String hql= "uf "
				+"INNER JOIN UFachLehrer ufl "
				+"ON ufl.lehrer.id = "+lehrer.getId()+" "
				+"WHERE uf.id = ufl.ufach.id "
				+"AND ufl.austrittsdatum > "+ "'"+ausgangsdatum+"'";
				
		
		ArrayList<Object[]>ob = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Unterrichtsfach", ob, hql);
		ArrayList<Unterrichtsfach>al = new ArrayList<Unterrichtsfach>();
		for(Object[]o:ob)
		{
			al.add((Unterrichtsfach)o[0]);
		}
	
		
		return al;
	}
	
	public static ArrayList<Unterrichtsfach> AlleLesen()
	{
		ArrayList<Unterrichtsfach> al = new ArrayList<Unterrichtsfach>();
		DBZugriff.alleLesen("Unterrichtsfach", al, "");
		
		return al;
	}
	
	public static ArrayList<Unterrichtsfach> AlleLesen(Lehrer lehrer)
	{
		String hql= "uf "
				+"INNER JOIN UFachLehrer ufl "
				+"ON ufl.lehrer.id = "+lehrer.getId()+" "
				+"WHERE uf.id = ufl.ufach.id";
		
		ArrayList<Object[]>ob = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Unterrichtsfach", ob, hql);
		ArrayList<Unterrichtsfach>al = new ArrayList<Unterrichtsfach>();
		for(Object[]o:ob)
		{
			al.add((Unterrichtsfach)o[0]);
		}
	
		
		return al;
	}
	//-------------------------------------------
	
	//Override-Methoden
	//-------------------------------------------
	public boolean equals(Unterrichtsfach uf)
	{
		if(uf.id == this.getId())
		{
			return true;
		}
		return false;
	}
	public String toString()
	{
		return this.bez;
	}	
	//-------------------------------------------
	
	//Get-Set-Add Methoden	
	//-------------------------------------------
	
	public int getGewichtungSchriftlich() {
		return gewichtungSchriftlich;
	}
	public void setGewichtungSchriftlich(int gewichtungSchriftlich) {
		this.gewichtungSchriftlich = gewichtungSchriftlich;
	}

	public Zeugnisfach getZfach() {
		return zfach;
	}
	public void setZfach(Zeugnisfach zfach) {
		this.zfach = zfach;
	}
	public String getBez() {
		return bez;
	}
	public void setBez(String bez) {
		this.bez = bez;
	}
	public int getStunden() {
		return stunden;
	}
	public void setStunden(int stunden) {
		this.stunden = stunden;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getId() {
		return id;
	}
	
	
	
}
