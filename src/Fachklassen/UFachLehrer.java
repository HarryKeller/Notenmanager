package Fachklassen;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Persistenz.DBZugriff;

@Entity
@Table(name="UFachLehrer")
public class UFachLehrer 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int _id;
	
	private LocalDate _edatum;
	private LocalDate _adatum;
	private int _stunden;
	@ManyToOne
	private Unterrichtsfach ufach;
	@ManyToOne
	private Lehrer lehrer;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public LocalDate get_edatum() {
		return _edatum;
	}
	public void set_edatum(LocalDate _edatum) {
		this._edatum = _edatum;
	}
	public LocalDate get_adatum() {
		return _adatum;
	}
	public void set_adatum(LocalDate _adatum) {
		this._adatum = _adatum;
	}
	public int get_stunden() {
		return _stunden;
	}
	public void set_stunden(int _stunden) {
		this._stunden = _stunden;
	}
	
	public Unterrichtsfach getUfach() {
		return ufach;
	}
	public void setUfach(Unterrichtsfach ufach) {
		this.ufach = ufach;
	}
	public Lehrer getLehrer() {
		return lehrer;
	}
	public void setLehrer(Lehrer lehrer) {
		this.lehrer = lehrer;
	}
	public UFachLehrer(int id)
	{
		DBZugriff.lesen(this, id);
	}
	
	public UFachLehrer()
	{
		
	}
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}

}
