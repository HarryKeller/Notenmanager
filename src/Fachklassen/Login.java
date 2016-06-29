package Fachklassen;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Persistenz.DBZugriff;

@Entity 
public class Login
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String kuerzel;
	private String pw;
	@ManyToOne
	private Lehrer lehrer;
	
	public Login()
	{
		
	}
	
	public Login(int id)
	{
		DBZugriff.lesen(this, id);
	}

	public ArrayList<Lehrer> alleLesen(String kuerzel)
	{	
		ArrayList<Lehrer> al = new ArrayList<Lehrer>();
		DBZugriff.alleLesen("Lehrer", al, "WHERE kuerzel = '" + kuerzel + "'") ;
		return al;
	}
	
	public String getKuerzel()
	{
		return kuerzel;
	}

	public void setKuerzel(String kuerzel)
	{
		this.kuerzel = kuerzel;
	}

	public String getPw()
	{
		return pw;
	}

	public void setPw(String pw)
	{
		this.pw = pw;
	}

	public Lehrer getLehrer()
	{
		return lehrer;
	}

	public void setLehrer(Lehrer lehrer)
	{
		this.lehrer = lehrer;
	}

	public int getId()
	{
		return id;
	}
	
	
}
