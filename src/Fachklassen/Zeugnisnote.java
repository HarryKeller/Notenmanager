package Fachklassen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import Persistenz.DBZugriff;

@Entity
public class Zeugnisnote 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private int noteZeugnis;
	private double noteErrechnet;
	private String bemerkung;
	
	@OneToOne		//nict sicht ob richtig
	private Zeugnisfach zeugnisfach;
	
	@ManyToOne
	private Schueler schueler;
	
	private LocalDate aenderungszeitpunkt;
	
	@ManyToOne
	private Zeugnis zeugnis;
	
	//------------------------------------------------------
	
	public Zeugnisnote(Schueler schueler)
	{
		this.schueler = schueler;
	}
	
	public Zeugnisnote(int id,Schueler schueler)
	{
		this.schueler = schueler;
		DBZugriff.lesen(this, id);
	}
	public Zeugnisnote() {}
	
	//------------------------------------------------------
	public static ArrayList<Zeugnisnote> alleLesen(Schueler s,LocalDate jahr)
	{
		
		
		int jbegin = jahr.getYear()-1;
		int jende = jahr.getYear();
		
	
		String hql =
				"zn "		
				+"INNER JOIN Zeugnis z "
				+"ON z.schueler.id = "+ s.getId()+" "
						//2015-10-10 > 2015-9-1
				+"WHERE zn.aenderungszeitpunkt between '"+jbegin+"-9-1 '"	//Ab September des vorherigen Jahres	
						//2015-10-10 < 2016-8-1
				+"AND '"+jende+"-8-1 '";		//Bis August des aktuellen Jahres
		
			System.out.println(hql);	
		
				
		ArrayList<Object[] >al = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Zeugnisnote", al,hql );
		ArrayList<Zeugnisnote>ret = new ArrayList<Zeugnisnote>();
		
		for(Object[] or: al)
		{
			ret.add((Zeugnisnote)or[0]);
		}
		
		
		
		return ret;
	}
	
	
	
	
	
	
	
	
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	
	public double berechneNote(Unterrichtsfach uf)
	{
		double muendlich = 0;
		double schriftlich = 0;
		double kurzarbeit = 0;
		double note = 0;
		double ki = 0;
		double mi = 0;
		double si = 0;
		ArrayList<Leistung>leistungen = new ArrayList<Leistung>(Leistung.AlleLesen(schueler, uf));
		for (Leistung l : leistungen )
		{
			if(l.getLeistungsart().getBez().equals("Schulaufgabe"))
			{
				schriftlich = schriftlich + l.getNotenstufe();	
				si++;
			}
			else if (l.getLeistungsart().getBez().equals("Kurzarbeit"))
			{
				kurzarbeit = kurzarbeit + l.getNotenstufe();
				ki++;
			}
			else
			{
				muendlich = muendlich + l.getNotenstufe();
				mi++;
			}
		}
		if(schriftlich != 0)
		{
			schriftlich = (schriftlich/si) * uf.getGewichtungSchriftlich();			
		}
		if(kurzarbeit != 0)
		{
			kurzarbeit = (kurzarbeit/ki);		
		}
		if(muendlich != 0)
		{
			muendlich = muendlich/mi;
		}
		
		note = (muendlich + kurzarbeit + schriftlich) / 3;
				
		return Math.round(note * 100)/100.0;
	}
	
	public double berechneNote(Zeugnisfach zf,Schueler schueler)
	{
		double muendlich = 0;
		double schriftlich = 0;
		double kurzarbeit = 0;
		double note = 0;
		double ki = 0;
		double mi = 0;
		double si = 0;
		double znote = 0;
		int gewichtung = 0;
		
		List<Unterrichtsfach> uf = zf.getUnterrichtsfächer();
		
		
		for(Unterrichtsfach ufach : uf)
		{
			note = 0;
			ArrayList<Leistung>leistungen = new ArrayList<Leistung>(Leistung.AlleLesen(schueler, ufach));
			for (Leistung l : leistungen )
			{
				if(l.getLeistungsart().getBez().equals("Schulaufgabe"))
				{
					schriftlich = schriftlich + l.getNotenstufe();	
					si++;
				}
				else if (l.getLeistungsart().getBez().equals("Kurzarbeit"))
				{
					kurzarbeit = kurzarbeit + l.getNotenstufe();
					ki++;
				}
				else
				{
					muendlich = muendlich + l.getNotenstufe();
					mi++;
				}
			}
			if(schriftlich != 0)
			{
				schriftlich = (schriftlich/si) * ufach.getGewichtungSchriftlich();			
			}
			if(kurzarbeit != 0)
			{
				kurzarbeit = (kurzarbeit/ki);		
			}
			if(muendlich != 0)
			{
				muendlich = muendlich/mi;
			}
			
			note = ((muendlich + kurzarbeit + schriftlich) / 3 ) * ufach.getStunden();
			
			gewichtung = gewichtung + ufach.getStunden();
			
			znote = znote + note;
		}
		
		return Math.round((znote / gewichtung * 100))/100.0;
	}
	
	//-------------------------
	
	public String toString()
	{
		return this.zeugnisfach.getBez()+" "+this.noteErrechnet;
	}
	
	
	//-----------------------------------
	
	public int getNoteZeugnis() {
		return noteZeugnis;
	}

	public void setNoteZeugnis(int noteZeugnis) {
		this.noteZeugnis = noteZeugnis;
	}

	public double getNoteErrechnet() {
		return noteErrechnet;
	}

	public void setNoteErrechnet(double noteErrechnet) {
		this.noteErrechnet = noteErrechnet;
	}

	public String getBemerkung() {
		return bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	public Zeugnisfach getZeugnisfach() {
		return zeugnisfach;
	}

	public void setZeugnisfach(Zeugnisfach zeugnisfach) {
		this.zeugnisfach = zeugnisfach;
	}

	public Schueler getSchueler() {
		return schueler;
	}

	public void setSchueler(Schueler schueler) {
		this.schueler = schueler;
	}

	public LocalDate getAenderungszeitpunkt() {
		return aenderungszeitpunkt;
	}

	public void setAenderungszeitpunkt(LocalDate aenderungszeitpunkt) {
		this.aenderungszeitpunkt = aenderungszeitpunkt;
	}

	public Zeugnis getZeugnis() {
		return zeugnis;
	}

	public void setZeugnis(Zeugnis zeugnis) {
		this.zeugnis = zeugnis;
	}

	public int getId() {
		return id;
	}

	
}
