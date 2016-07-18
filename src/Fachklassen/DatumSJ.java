package Fachklassen;

import java.time.LocalDate;

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
<<<<<<< HEAD
	
=======

>>>>>>> 62679d3620fc6824893bcc10124a7d2c37fe4ad9
	private String sj;
	private LocalDate beginn;
	private LocalDate halbjahr;
	private LocalDate ende;
	
	public DatumSJ(String sj,LocalDate beginn,LocalDate halbjahr,LocalDate ende)
	{
		this.sj = sj;
		this.beginn = beginn;
		this.halbjahr = halbjahr;
		this.ende = ende;
	}
	public DatumSJ(){/* Defaultkonstrucktor */}
	
	
	public DatumSJ (int id)
	{
		DBZugriff.lesen(this, id);
		
	}
	
	//getSet
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
