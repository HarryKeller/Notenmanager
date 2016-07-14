package Fachklassen;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	//Getter + Setter
	
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
	
	//Konstruktoren
	public Unterrichtsfach(){}
	
	public Unterrichtsfach(int id)
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
	public Unterrichtsfach(Unterrichtsfach uf)
	{
		this.id = uf.getId();	//int
		this.bez = new String(uf.getBez());
		this.stunden = uf.getStunden();	//int
		this.pos = uf.getPos();		//int
		this.gewichtungSchriftlich = uf.getGewichtungSchriftlich();	//int
	}
	
	public static ArrayList<Unterrichtsfach>AlleLesen(Lehrer lehrer , Klasse klasse,LocalDate ausgangsdatum)
	{

		
		String hql =
				"uf "
			    +"INNER JOIN Zeugnisfach zf "
				+"ON zf.id = uf.zfach.id "
			    +"INNER JOIN Klasse k "
			    +"ON k.id = zf.klasse.id "
			    +"INNER JOIN UFachLehrer ufl "
			    +"ON ufl.lehrer.id = "+lehrer.getId()+" "
			    +"AND ufl.ufach.id = uf.id "
			    +"Where k.id = "+klasse.getid()+" "
			    +" AND ufl.austrittsdatum > "+"'"+ausgangsdatum+"'";
		
		ArrayList<Object[]> al = new ArrayList<>();
		DBZugriff.alleLesen("Unterrichtsfach", al, hql);
		
		ArrayList<Unterrichtsfach>ret = new ArrayList<>();
		
		for(Object[] o:al)
		{
			ret.add((Unterrichtsfach)o[0]);
		}
		
		
		
		return ret;
	}
	
	public static ArrayList<Unterrichtsfach>AlleLesen(Zeugnisfach zf)
	{
		String hql = " uf WHERE uf.zfach.id = "+zf.getId();
		ArrayList<Unterrichtsfach>al = new ArrayList<Unterrichtsfach>();
		DBZugriff.alleLesen("Unterrichtsfach", al, hql);
		return al;
	}
	
	public static ArrayList<Unterrichtsfach>AlleLesen(Lehrer lehrer,LocalDate ausgangsdatum)
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
	public int getGewichtungSchriftlich() {
		return gewichtungSchriftlich;
	}
	public void setGewichtungSchriftlich(int gewichtungSchriftlich) {
		this.gewichtungSchriftlich = gewichtungSchriftlich;
	}
}
