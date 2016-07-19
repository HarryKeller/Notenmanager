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

import Persistenz.DBZugriff;

@Entity
public class Ausbildungszweig
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	private String ausbidldungsart;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL ,mappedBy="ausbildungszweig", fetch=FetchType.EAGER)
	private Set<Zeugnisfach> lstZeugnisfach = new HashSet<Zeugnisfach>();

	
	
	public Set<Zeugnisfach> getLstzeugnisfach()
	{
		return lstZeugnisfach;
	}
	public void addAusbildungszweig(Zeugnisfach az)
	{
		lstZeugnisfach.add(az);
	}
	
	
	public Ausbildungszweig()
	{
		
	}
	public Ausbildungszweig(int id)
	{
		DBZugriff.lesen(this, id);
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
	public String toString()
	{
		return this.ausbidldungsart;
	}
}
