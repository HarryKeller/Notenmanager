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
	
	//----------------------------------------
	
	//Konstuktoren
	//-----------------------------------------------------
	
	public UFachLehrer(int id)
	{
		DBZugriff.lesen(this, id);
	}
	
	
	public UFachLehrer()
	{
		
	}

	//----------------------------------------
	/**
	 * Die Methode gibt einen boolean zur�ck, welcher besagt, ob der �bergebene lehrer das unterrichtsfach
	 * zurzeit unterrichtet
	 * ZURZEIT UNTERRICHTET, nicht iwann einmal unterrichtet hat. ZURZEIT UNTERRICHTET!!!!
	 * @param lehrer
	 * @param ufach
	 * @returnn true, wenn der Lehrer das unterrichtsfach zurzeit unterrichtet, ansonsten false
	 */
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
	/**
	 * Liest alle S�tze in der DB, in denen der �bergebene Lehrere ZURZEIT!!! unterrichtet
	 * 
	 * @param l	Lehrer
	 * @return	liste von Typ UFachLehrer
	 */
	public static ArrayList<UFachLehrer>alleLesen(Lehrer l)
	{
		String hql=" ufl "
				+"WHERE ufl.lehrer.id = "+l.getId() +" "
				+"AND ufl.austrittsdatum> '"+LocalDate.now()+"'";
		ArrayList<UFachLehrer>al = new ArrayList<UFachLehrer>();
		DBZugriff.alleLesen("UFachLehrer", al, hql);
		return al;
		
	}
	
	/**
	 * Gibt zur�ck, ob der Lehrer zurzeit noch ein Fach unterrichtet,
	 * sollte z.B. vor dem L�schen eines Lehrer gepr�ft werden, er noch unterrichtet,
	 * bietet sich diese Methode an
	 */
	public static boolean unterrichtetNoch(Lehrer lehrer)
	{
		
		String hql =  " ufl"
				+" WHERE ufl.lehrer.id = "+lehrer.getId()+" "
				+" AND ufl.austrittsdatum > "+"'"+LocalDate.now()+"'";	//Daten wo er noch unterrichtet
		
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
	
	//Alle-Lesen-Mehtoden
	//----------------------------------------
	/**
	 * Sollte der �bergebene Lehrer dieses  Fach zum angegebenen Zeitpunkt unterrichten,
	 *  wird das dazugeh�rige UFachLeher objekt zur�ckgegeben
	 * 
	 * @param lehrer
	 * @param ufach	
	 * @param aktuell	
	 * @return
	 * @throws Exception wird geworfen wenn der �bergebene Lehrer das gew�hlte Fach zurzeit nicht unterrichtet
	 * 		   Das ist eine der wenigen Exceptions, die zurzeit geworden werden, konsequenter im vergleich zu
	 * 			den anderen Fachklassen w�re in diesem Fall das zur�ckegeben von null.
	 */
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
	//-----------------------------------------
	
	//Override Methoden
	public String toString()
	{
		return ""+this.id;
	}
	
	
	//DB-Methoden
	//------------------------------------------
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	//----------------------------------------
	
	//get-set-add
	//----------------------------------------
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
	

}
