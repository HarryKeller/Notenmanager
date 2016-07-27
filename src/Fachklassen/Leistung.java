package Fachklassen;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Persistenz.DBZugriff;

@Entity 
public class Leistung 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private LocalDate erhebungsdatum;
	private int notenstufe;
	private char tendenz;
	
	@ManyToOne
	private Leistungsart leistungsart;
	
	@ManyToOne
	private UFachLehrer ufachlehrer;	
	
	@ManyToOne
	private Schueler schueler;
		
	private LocalDate letzteaenderung;
	//----------------------------------------
	
	//konstuktoren
	//----------------------------------------
	public Leistung()
	{
		
	}	

	public Leistung(int id)
	{
		DBZugriff.lesen(this,id);
	}
	//----------------------------------------
	
	//Db-Methoden der Leistung
	//----------------------------------------
	/**
	 * Speichert die Leistung und loggt diese in der DB zusammen mit dem übergebenen Lehrer
	 * (Der übergebene Lehrer sollte der Lehrer sein, welcher die Note ändert (offensichtlicher weise!!) )
	 * @param lehrer
	 * @return
	 */
	public boolean speichern(Lehrer lehrer)
	{
		return Historie.speichern(this, lehrer);
	}

	/**
	 * Löscht eine z.B. falsch angelegte leistung physisch aus der Db, allerdings wird dies in der historie 
	 * zusammen mit dem Lehrer der dies getan hat vermerkt
	 */
	public void loeschen(Lehrer l)
	{
		Historie.loeschen(this, l);
	}
	//----------------------------------------
	
	//Alle Lesen Methoden
	//----------------------------------------
	/**
	 * liest stump alle Leistungen die Existieren
	 * @return
	 */
	public static ArrayList<Leistung>AlleLesen()
	{
		ArrayList<Leistung> al = new ArrayList<Leistung>();
		DBZugriff.alleLesen("Leistung", al, "" );
		return al;	
	}
	/**
	 * Liest alle Leistungen, die ein Schüler in diesem Unterrichtsfach erbracht hat
	 * Diese Methode ist mit vorsicht zu geniesen, da z.B. beim wiederholen einer Klasse
	 * sich die Noten "vermischen" könnten
	 * @param schueler
	 * @param ufach
	 * @return
	 */
	public static ArrayList<Leistung> AlleLesen(Schueler schueler,Unterrichtsfach ufach )
	{
		String sql = 
				"l "
				+"INNER JOIN UFachLehrer ufl "
				+"ON ufl.ufach.id = "+ufach.getId()+" "
				+ "INNER JOIN Unterrichtsfach uf "
				+ "ON uf.id = ufl.id "
				+ "WHERE l.schueler.id = "+schueler.getId()+" "
				+ "AND l.ufachlehrer.id = ufl.id "
				+ "ORDER BY l.erhebungsdatum";
							
		ArrayList<Object[]>al = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Leistung", al,sql );
		
		ArrayList<Leistung>leistungliste = new ArrayList<Leistung>();
		
		for(Object[] k: al )
		{			
			leistungliste.add((Leistung)k[0]);
		}
		return leistungliste;
	}
	
	/**
	 * Sichere version von alleLesen(Schueler,Unterrichtsfach).
	 * Liest alle Leistungen, die ein Schüler in diesem Unterrichtsfach erbracht hat in diesem Schuljahr
	 * Damit können sich leistungen nicht "vermischen" falls ein Schüler die Klasse wiederholt
	 * @param schueler
	 * @param ufach
	 * @param sj
	 * @return
	 */
	public static ArrayList<Leistung> AlleLesen(Schueler schueler,Unterrichtsfach ufach,DatumSJ sj )
	{
		String sql = 
				"l "
				+"INNER JOIN UFachLehrer ufl "
				+"ON ufl.ufach.id = "+ufach.getId()+" "
				+"INNER JOIN Unterrichtsfach uf "
				+"ON uf.id = ufl.ufach.id "
				+"WHERE l.schueler.id = "+schueler.getId()+" "
				+"AND l.ufachlehrer.id = ufl.id "
				+"AND l.erhebungsdatum > "+ "'"+sj.getBeginn()+"'"
				+"AND l.erhebungsdatum < "+ "'"+sj.getEnde()+"'"
				+"ORDER BY l.erhebungsdatum";
							
		ArrayList<Object[]>al = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Leistung", al,sql );
		
		ArrayList<Leistung>leistungliste = new ArrayList<Leistung>();
		
		for(Object[] k: al )
		{			
			leistungliste.add((Leistung)k[0]);
		}
		return leistungliste;
	}
	
	//----------------------------------------
	
	
	//----------------------------------------
	
	//Override Methoden
	//----------------------------------------
	
	
	public String toString()
	{
		if(tendenz!='o')
		{
			return (String.valueOf(tendenz)+ String.valueOf(notenstufe));
		}
		else
		{
			return String.valueOf(notenstufe);
		}
		
	}
	/**
	 * vergleich zwei Leistungen anhand der Id -> zwei neu angelegte Leistungen zu vergleichen ist nicht Sinnvoll,
	 * da diese beide die id 0 haben
	 * @param l
	 * @return
	 */
	public boolean equals(Leistung l)
	{
		if(this.id == l.getId() && this.notenstufe == l.notenstufe && this.tendenz == l.tendenz)return true;
		return false;
	}
	//----------------------------------------
	//Get-Set-Add Methoden
	//----------------------------------------
	public LocalDate getErhebungsdatum()
	{
		return erhebungsdatum;
	}
	public void setErhebungsdatum(LocalDate erhebungsdatum)
	{
		this.erhebungsdatum = erhebungsdatum;
	}
	
	public int getNotenstufe()
	{
		return notenstufe;
	}
	public void setNotenstufe(int notenstufe)
	{
		this.notenstufe = notenstufe;
	}
	
	public char getTendenz()
	{
		return tendenz;
	}
	public void setTendenz(char tendenz)
	{
		this.tendenz = tendenz;
	}
	
	public LocalDate getLetzteaenderung()
	{
		return letzteaenderung;
	}
	public void setLetzteaenderung(LocalDate letzteaenderung)
	{
		this.letzteaenderung = letzteaenderung;
	}
	
	public int getId()
	{
		return id;
	}
	public Leistungsart getArt()
	{
		return leistungsart;
	}
	public UFachLehrer getUfachlehrer()
	{
		return ufachlehrer;
	}
	public Leistungsart getLeistungsart() {
		return leistungsart;
	}
	public void setLeistungsart(Leistungsart leistungsart) {
		this.leistungsart = leistungsart;
	}
	public Schueler getSchueler() {
		return schueler;
	}
	public void setSchueler(Schueler schueler) {
		this.schueler = schueler;
	}
	public void setUfachlehrer(UFachLehrer ufachlehrer) {
		this.ufachlehrer = ufachlehrer;
	}	
	
	
}
