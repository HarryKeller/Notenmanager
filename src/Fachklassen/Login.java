package Fachklassen;

import Persistenz.DBZugriff;

public class Login
{
	private int id;
	private String kuerzel;
	private String pw;
	
	private Lehrer lehrer;
	
	public Login()
	{
		
	}
	
	public Login(int id)
	{
		DBZugriff.lesen(this, id);
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
