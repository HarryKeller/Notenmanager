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
	 * @param Unterrichtsfach uf
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
	/**
	 * 
	 * Liest alle Unterrichtsfächer, die der Lehrer zum angegeben Datum unterrichtet
	 * @param lehrer
	 * @param klasse
	 * @param ausgangsdatum
	 * @return
	 */
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
				if(zf.equals(((Unterrichtsfach)o[0]).getZfach()))
				{
					ret.add((Unterrichtsfach) o[0]);
				}
			}
			
		}
		
		
		return ret;
	}
	/**
	 * Es werden alle Unterrichtsfächer des Schülers gelesen, dass dieser in der aktuellen klasse hat
	 * Wenn z.B. ein Schüler in der 10Klasse office hatte und jetzt in der 11 ist und dieses fach jetzt nciht mehr aht,
	 * wird office nicht in der Liste zufinden sein.
	 * 
	 * @param Schueler s
	 * @return
	 */
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
	/**
	 * Liest alle Unterrichtsfächer, welche zu einem zeugnisfach gehören
	 * @param Zeugnisfach zf
	 * @return
	 */
	public static ArrayList<Unterrichtsfach>alleLesen(Zeugnisfach zf)
	{
		String hql = " uf WHERE uf.zfach.id = "+zf.getId();
		ArrayList<Unterrichtsfach>al = new ArrayList<Unterrichtsfach>();
		DBZugriff.alleLesen("Unterrichtsfach", al, hql);
		return al;
	}
	
	/**
	 * Liefert alle Unterrichtsfächer zurück, welcher der Lehrer zum angegebenen Zeitpunkt unterrichtet
	 * @param lehrer
	 * @param ausgangsdatum
	 * @return
	 */
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
	/**
	 * Liest stump alle Unterrichtsfächer, welche in der DB Existieren
	 * @return
	 */
	public static ArrayList<Unterrichtsfach> alleLesen()
	{
		ArrayList<Unterrichtsfach> al = new ArrayList<Unterrichtsfach>();
		DBZugriff.alleLesen("Unterrichtsfach", al, "");
		
		return al;
	}
	
	/**
	 * Liest alle Unterrichtsfächer, welche ein Lehrer zurzeit Unterrichtet bzw unterrichtet hat
	 * Diese Methode ist mit vorsicht zu geniesen, da auch Unterrichtfächer die der Lehrer iwann
	 * einmal unterrichtet hat zurückgegeben werden.
	 * alleLesen(Lehrer l, LocalDate ausgangsdatum) ist in i.d.R. die besser Wahl
	 * @param lehrer
	 * @return
	 */
	public static ArrayList<Unterrichtsfach> alleLesen(Lehrer lehrer)
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
	/**Vergleich zwei Unterrichtsfächer anhand ihrer id
	 * Zwei neu angelegte unterrichtsfächer zu vergleichen ist da bei diesen die id 0 wäre nicht sinvoll
	 * @param Unterrichtsfach uf
	 * @return
	 */
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
