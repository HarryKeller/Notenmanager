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
	
	private LocalDate eintrittsdatum;
	private LocalDate austrittsdatum;
	private int stunden;
	@ManyToOne
	private Unterrichtsfach ufach;
	@ManyToOne
	private Lehrer lehrer;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public LocalDate geteintrittsdatum() {
		return eintrittsdatum;
	}
	public void seteintrittsdatum(LocalDate edatum) {
		this.eintrittsdatum = edatum;
	}
	public LocalDate getaustrittsdatum() {
		return austrittsdatum;
	}
	public void setaustrittsdatum(LocalDate adatum) {
		this.austrittsdatum = adatum;
	}
	public int getstunden() {
		return stunden;
	}
	public void setstunden(int stunden) {
		this.stunden = stunden;
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
