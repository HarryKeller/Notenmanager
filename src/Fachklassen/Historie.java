package Fachklassen;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Persistenz.DBZugriff;

@Entity
public class Historie {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tabelleName;	//Wie wird das gemacht???
	private int idDatensatz;	
	private String vorgangsart;
	private String text;
	private Lehrer idLehrer;		//Lehrerklasse 
	private Date eintragszeitpunkt;
	
	
	public Historie()
	{
		//DefaultKonstruktor für hybernate
	}
	
	
	
	public void speichern(){
		DBZugriff.speichern(this);
	}
	public static void speichern(Leistung l)
	{
		Historie h = new Historie();
		h.setTabelleName("Leistung");
		
		if(l.getId() == 0)
		{
			h.setIdDatensatz(DBZugriff.speichernAndGetID(l));
			
		}
		else
		{
			h.setIdDatensatz(l.getId());
		}
		h.speichern();
		
	}
	
	
	//Get-set
	public String getTabelleName() {
		return tabelleName;
	}
	public void setTabelleName(String tabelleName) {
		this.tabelleName = tabelleName;
	}
	public int getIdDatensatz() {
		return idDatensatz;
	}
	public void setIdDatensatz(int idDatensatz) {
		this.idDatensatz = idDatensatz;
	}
	public String getVorgangsart() {
		return vorgangsart;
	}
	public void setVorgangsart(String vorgangsart) {
		this.vorgangsart = vorgangsart;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Lehrer getIdLehere() {
		return idLehrer;
	}
	public void setIdLehere(Lehrer idLehere) {
		this.idLehrer = idLehere;
	}
	public Date getEintragszeitpunkt() {
		return eintragszeitpunkt;
	}
	public void setEintragszeitpunkt(Date eintragszeitpunkt) {
		this.eintragszeitpunkt = eintragszeitpunkt;
	}
	public int getId() {
		return id;
	}
	
	
}
