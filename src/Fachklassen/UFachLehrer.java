package Fachklassen;
import java.time.LocalDate;
import java.util.ArrayList;

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
	public static boolean unterrichtetLehrerZurzeitFach(Lehrer lehrer,Unterrichtsfach ufach)
	{
		
		String hql =  " ufl"
				+" WHERE ufl.lehrer.id = "+lehrer.getId()+" "
				+" AND ufl.ufach.id = " +ufach.getId()+" "
				+" AND ufl.austrittsdatum > "+"'"+LocalDate.now()+"'";
		
		ArrayList<UFachLehrer>al = new ArrayList<UFachLehrer>();
		try
		{
			DBZugriff.alleLesen("UFachLehrer", al, hql);
		}	
		catch( org.hibernate.ObjectNotFoundException ex)
		{
			throw ex;
		}
		if (al.size() == 0) return false;
		else return true;
	
	}
	public static UFachLehrer unterrichtetzurzeit(Lehrer lehrer,Unterrichtsfach ufach,LocalDate aktuell) throws Exception
	{

		String hql =  " ufl"
				+" WHERE ufl.lehrer.id = "+lehrer.getId()+" "
				+" AND ufl.ufach.id = " +ufach.getId()+" "
				+" AND ufl.austrittsdatum > "+"'"+LocalDate.now()+"'";
		
		ArrayList<UFachLehrer>al = new ArrayList<UFachLehrer>();
		try
		{
			DBZugriff.alleLesen("UFachLehrer", al, hql);
		}	
		catch( org.hibernate.ObjectNotFoundException ex)
		{
			throw ex;
		}
		if(al.size() == 0)
		{
			throw new Exception("Dieser Lehrer unterichtet dieses Fach nicht bzw nicht mehr");
		}
		return al.get(0);
		
	}
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}

}
