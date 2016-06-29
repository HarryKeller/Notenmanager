package Fachklassen;

import java.time.LocalDate;
import java.util.ArrayList;

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
	private int noteZeugis;
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
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	
	public double berechneNote(Unterrichtsfach uf)
	{
		double muendlich = 0;
		double schriftlich = 0;
		double note = 0;
		double i = 0;
		ArrayList<Leistung>leistungen = new ArrayList<>(Leistung.AlleLesen(schueler, uf));
		for (Leistung l : leistungen )
		{
			if(l.getLeistungsart().getBez() == "Schulaufgabe")
			{
				schriftlich = schriftlich + l.getNotenstufe();				
			}
			else
			{
				muendlich = muendlich + l.getNotenstufe();
			}
			i++;
		}
		note = ((schriftlich * 2) + muendlich) / i;	
		
		return note;
	}
	
	
	//-----------------------------------
	
	public int getNoteZeugis() {
		return noteZeugis;
	}

	public void setNoteZeugis(int noteZeugis) {
		this.noteZeugis = noteZeugis;
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
