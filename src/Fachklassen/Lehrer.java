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
	private int _id;
	
	private String _kürzel;
	private String _nachname;
	private String _vorname;
	private String _dienstbezeichnung;
	
	public int get_Id() {
		return _id;
	}
	public void set_Id(int _id) {
		this._id = _id;
	}
	public String get_Kürzel() {
		return _kürzel;
	}
	public void set_Kürzel(String _kürzel) {
		this._kürzel = _kürzel;
	}
	public String get_Nachname() {
		return _nachname;
	}
	public void set_Nachname(String _nachname) {
		this._nachname = _nachname;
	}
	public String get_Vorname() {
		return _vorname;
	}
	public void set_Vorname(String _vorname) {
		this._vorname = _vorname;
	}
	public String get_Dienstbezeichnung() {
		return _dienstbezeichnung;
	}
	public void set_Dienstbezeichnung(String _dienstbezeichnung) {
		this._dienstbezeichnung = _dienstbezeichnung;
	}
	
	public Lehrer(int id)
	{
		
	}
	
	public Lehrer()
	{
		
	}
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
}
