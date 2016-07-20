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
	
	public Leistung()
	{
		
	}	

	public Leistung(int id)
	{
		DBZugriff.lesen(this,id);
	}
	
	public boolean speichern(Lehrer lehrer)
	{
		return Historie.speichern(this, lehrer);
	}

	public void loeschen(Lehrer l)
	{
		Historie.loeschen(this, l);
	}
	
	public static ArrayList<Leistung>AlleLesen()
	{
		ArrayList<Leistung> al = new ArrayList<Leistung>();
		DBZugriff.alleLesen("Leistung", al, "" );
		return al;	
	}
	
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
	
	
	public static ArrayList<Leistung> AlleLesen(Schueler schueler,Unterrichtsfach ufach,DatumSJ sj )
	{
		String sql = 
				"l "
				+"INNER JOIN UFachLehrer ufl "
				+"ON ufl.ufach.id = "+ufach.getId()+" "
				+ "INNER JOIN Unterrichtsfach uf "
				+ "ON uf.id = ufl.id "
				+ "WHERE l.schueler.id = "+schueler.getId()+" "
				+ "AND l.ufachlehrer.id = ufl.id "
				+ "AND l.erhebungsdatum > "+ "'"+sj.getBeginn()+"'"
				+ "AND l.erhebungsdatum < "+ "'"+sj.getEnde()+"'"
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
	public boolean equals(Leistung l)
	{
		if(this.id == l.getId() && this.notenstufe == l.notenstufe && this.tendenz == l.tendenz)return true;
		return false;
	}
	
}
