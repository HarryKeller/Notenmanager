package Fachklassen;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Persistenz.DBZugriff;

/**
 * @author kellerh
 *
 */
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
	
	//------------------------------------------
	//Konsturktoren
	
	//------------------------------------------
	public Login()
	{
		
	}
	
	public Login(int id)
	{
		DBZugriff.lesen(this, id);
	}
	
	/**
	 * Erstellt ein Login Objekt zu den �bergebenen Lehrer
	 * Es kracht wenn dieser Lehrer nicht in der Db Existiert
	 * Hybernate schmeist eine Object not found exception oder so. Diese wird nicht abgefangen :p
	 * @param l
	 */
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
	
	//------------------------------------------
	
	//DB-Methoden
	//------------------------------------------
	/**
	 * Speichert die Login Instanz in der Db
	 */
	public void speichern()
	{
		DBZugriff.speichern(this);
	}
	//------------------------------------------
	
	//Alle Lesen Methode	
	//------------------------------------------
	/**
	 * Liest den Lehrer zu dem Das k�rzel geh�rt, returnt null, wenn kein Lehrer zu diesem kr�zel vorhanden ist
	 * @param kuerzel
	 * @return
	 */
	public Lehrer getLehrerZuKuerzel(String kuerzel)
	{	
		ArrayList<Lehrer> al = new ArrayList<Lehrer>();
		DBZugriff.alleLesen("Lehrer", al, "WHERE kuerzel = '" + kuerzel + "'") ;
		if(al.size() == 0) return null;
		return al.get(0);
	}
	
	/**
	 * 
	 * �berpr�ft ob noch mindestens ein Lehrer als Admin eingetragen ist
	 * Ansonsten k�nne es passieren, dass kein Admin mehr da ist, welcher
	 * anderen Admins admin rechte geben kann -> Man sperrt sich selbst aus
	 * dem Programm aus
	 */
	public static boolean isMehrAlsEinLehrerAdmin()
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
	
	//------------------------------------------
	
	//Get-Set-Add
	//------------------------------------------
	
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
