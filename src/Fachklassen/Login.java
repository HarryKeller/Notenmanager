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
	private boolean admin;
	
	public Login()
	{
		
	}
	
	public Login(int id)
	{
		DBZugriff.lesen(this, id);
	}
	public Login(Lehrer l)
	{
		String hql = " l WHERE l.lehrer.id ="+l.getId();
		ArrayList<Login>al = new ArrayList<Login>();
		DBZugriff.alleLesen("Login", al, hql);
		
		if(al.size() == 0) return;
		this.id = (al.get(0).getId());
		this.kuerzel = (al.get(0).getKuerzel());
		this.pw = (al.get(0).getPw());
		this.lehrer = (al.get(0).getLehrer());
		this.admin = (al.get(0).isAdmin());	
	}
	
	public ArrayList<Lehrer> alleLesen(String kuerzel)
	{	
		ArrayList<Lehrer> al = new ArrayList<Lehrer>();
		DBZugriff.alleLesen("Lehrer", al, "WHERE kuerzel = '" + kuerzel + "'") ;
		return al;
	}
	public static boolean mehrAlsEinLehrerAdmin()
	{
		ArrayList<Login> al = new ArrayList<Login>();
		DBZugriff.alleLesen("Login", al, "");
		int anz = 0;
		for(Login l: al)
		{
			if(l.isAdmin()) anz++;
		}
		if(anz > 1) return true;	//Wenn mehr als ein Lehrer vorhanden ist
		
		else return false;
	}
	public void speichern()
	{
		DBZugriff.speichern(this);
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
	
	public boolean isAdmin()
	{
		return admin;
	}

	public void setAdmin(boolean admin)
	{
		this.admin = admin;
	}
	
}
