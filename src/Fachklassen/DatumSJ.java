package Fachklassen;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Persistenz.DBZugriff;

@Entity
public class DatumSJ
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String sj;
	private LocalDate beginn;
	private LocalDate halbjahr;
	private LocalDate ende;
	
	
	//------------------------------------------------------------------------
	//Konstruktoren
	public DatumSJ(String sj,LocalDate beginn,LocalDate halbjahr,LocalDate ende)
	{
		this.sj = sj;
		this.beginn = beginn;
		this.halbjahr = halbjahr;
		this.ende = ende;
	}
	public DatumSJ(){/* Defaultkonstrucktor */}
	
	public DatumSJ(LocalDate aktuell)
	{
		String hql = " d "
		+"WHERE d.beginn < "+"'"+aktuell+"'"
		+"AND d.ende > "+"'"+aktuell+"'";
		
		ArrayList<DatumSJ>al = new ArrayList<DatumSJ>();
		DBZugriff.alleLesen("DatumSJ", al, hql);
		
		if(al.size()== 0) return;
		DatumSJ temp = new DatumSJ();
		temp = al.get(0);
		this.id = temp.getId();
		this.sj = temp.getsj();
		this.beginn = temp.beginn;
		this.halbjahr = temp.halbjahr;
		this.ende = temp.ende;
		
	
	}
	
	public DatumSJ (int id)
	{
		DBZugriff.lesen(this, id);
		
	}
	//---------------------------------------------------------------------
	//---------------------------------------------------------------------
	//get-Set
	public String getsj()
	{
		return sj;
	}
	public void setSJ(String sj)
	{
		this.sj = sj;
	}
	public void speichern()
	{
		DBZugriff.speichern(this);
	}
	
	public LocalDate getBeginn()
	{
		return beginn;
	}
	public void setBeginn(LocalDate beginn)
	{
		this.beginn = beginn;
	}
	public LocalDate getHalbjahr()
	{
		return halbjahr;
	}
	public void setHalbjahr(LocalDate halbjahr)
	{
		this.halbjahr = halbjahr;
	}
	public LocalDate getEnde()
	{
		return ende;
	}
	public void setEnde(LocalDate ende)
	{
		this.ende = ende;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	
	
}
