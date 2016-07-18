package Fachklassen;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	private Lehrer idLehrer;		//Lehrerklasse 
	private LocalDate eintragszeitpunkt;
	
	
	public Historie()
	{
		//DefaultKonstruktor für hybernate
	}
	
	
	
	public void speichern(){
		DBZugriff.speichern(this);
	}
	
	public static boolean speichern(Leistung l,Lehrer lehrer)
	{
		Historie h = new Historie();
		h.setText("Text ohne genauere Funktion");
		h.setTabelleName("Leistung");
		h.setEintragszeitpunkt(LocalDate.now());
		if(l.getId() == 0)
		{
			h.setIdDatensatz(DBZugriff.speichernAndGetId(l));
			h.setIdLehere(lehrer);
			h.setVorgangsart("Anlegen");
		}
		else
		{
			h.setIdDatensatz(l.getId());
			h.setVorgangsart("Aendern");
			//l.speichern();
			DBZugriff.loeschen(l);
		}
		
		h.speichern();
		return true;
	}
	public static boolean loeschen(Leistung l,Lehrer lehrer)
	{
		Historie h = new Historie();
		h.setText("Text ohne genauere Funktion");
		h.setTabelleName("Leistung");
		h.setEintragszeitpunkt(LocalDate.now());	
		h.setIdLehere(lehrer);
		h.setVorgangsart("Loeschen");
		h.setIdDatensatz(0);
		try
		{
			DBZugriff.loeschen(l);
		}
		catch (Exception e)
		{
			//Random error ohne ahnung warum
		}
		
		h.speichern();
		return true;
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
	public LocalDate getEintragszeitpunkt() {
		return eintragszeitpunkt;
	}
	public void setEintragszeitpunkt(LocalDate localDate) {
		this.eintragszeitpunkt = localDate;
	}
	public int getId() {
		return id;
	}
	
	
}
