package Fachklassen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zeugnisart
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Zeugnisart;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getZeugnisart()
	{
		return Zeugnisart;
	}

	public void setZeugnisart(String zeugnisart)
	{
		Zeugnisart = zeugnisart;
	}


	
}
