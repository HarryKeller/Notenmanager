package Fachklassen;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Persistenz.DBZugriff;

@Entity
@Table(name = "Lehrer")
public class Lehrer 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	private String kürzel;
	private String nachname;
	private String vorname;
	private String dienstbezeichnung;
	
	public int get_Id() {
		return id;
	}
	public void set_Id(int _id) {
		this.id = _id;
	}
	public String get_Kürzel() {
		return kürzel;
	}
	public void set_Kürzel(String _kürzel) {
		this.kürzel = _kürzel;
	}
	public String get_Nachname() {
		return nachname;
	}
	public void set_Nachname(String _nachname) {
		this.nachname = _nachname;
	}
	public String get_Vorname() {
		return vorname;
	}
	public void set_Vorname(String _vorname) {
		this.vorname = _vorname;
	}
	public String get_Dienstbezeichnung() {
		return dienstbezeichnung;
	}
	public void set_Dienstbezeichnung(String _dienstbezeichnung) {
		this.dienstbezeichnung = _dienstbezeichnung;
	}
	
	public Lehrer(int id)
	{
		DBZugriff.lesen(this, id);
	}
	
	public Lehrer()
	{
		
	}
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
}
