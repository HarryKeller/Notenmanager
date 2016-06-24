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
	private int id;
	
	private LocalDate edatum;
	private LocalDate adatum;
	private int stunden;
	@ManyToOne
	private Unterrichtsfach ufach;
	@ManyToOne
	private Lehrer lehrer;
	
	public int get_id() {
		return id;
	}
	public void set_id(int _id) {
		this.id = _id;
	}
	public LocalDate get_edatum() {
		return edatum;
	}
	public void set_edatum(LocalDate _edatum) {
		this.edatum = _edatum;
	}
	public LocalDate get_adatum() {
		return adatum;
	}
	public void set_adatum(LocalDate _adatum) {
		this.adatum = _adatum;
	}
	public int get_stunden() {
		return stunden;
	}
	public void set_stunden(int _stunden) {
		this.stunden = _stunden;
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
