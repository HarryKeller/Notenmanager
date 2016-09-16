package Fachklassen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	//Konsturktoren
	//------------------------------------------------------
	
	//WAS IST DAS?????ß
	public Zeugnisnote(Schueler schueler)
	{
		this.schueler = schueler;
	}
	/**
	 * Ich hab keine Ahnung zu was hier der schueler übergeben wird
	 * Er ist kein auswahlkriterium und durch das lesen über die id
	 * wird er sowieso überschrieben.
	 * Sollte dieser Konsturkor einen Sinn haben, so erschließt sich dieser mir nicht....
	 * @param id
	 * @param schueler
	 */
	public Zeugnisnote(int id,Schueler schueler)
	{
		this.schueler = schueler;
		DBZugriff.lesen(this, id);
	}
	
	public Zeugnisnote()
	{
		
	}
	
	//------------------------------------------------------
	/**
	 * Liest alle Zeugnisnoten eines Schülers für ein Ausgewähltes jahr
	 * diese Methode scheint zu funktioneren, sollte jedoch noch einmal getestet werden
	 * @param Schueler
	 * @param DatumSJ
	 * @return
	 */
	public static ArrayList<Zeugnisnote> alleLesen(Schueler s,DatumSJ jahr)
	{		
	
		String hql =
				"zn "		
						//2015-10-10 > 2015-9-1
				+"WHERE zn.aenderungszeitpunkt between '"+jahr.getBeginn()+ "'"	
						//2015-10-10 < 2016-8-1
				+"AND '"+jahr.getEnde()+"'"		
				+ "AND zn.schueler.id =	" +s.getId()+" ";
		
			System.out.println(hql);	
		
				
		ArrayList<Zeugnisnote >al = new ArrayList<Zeugnisnote>();
		DBZugriff.alleLesen("Zeugnisnote", al,hql );
	return al;
	}
	
	//------------------------------------------------------
	//Override Methoden
	//------------------------------------------------------
	public String toString()
	{
		return this.zeugnisfach.getBez()+" "+this.noteErrechnet;
	}
	
	public boolean equals(Zeugnisnote zn)
	{
		
		if(zn.getId() == this.getId()) 
		{
			return true;
		}	
		else
		{
			return false;
		}		
	}	
	//------------------------------------------------------
	
	//Db-Methoden
	//------------------------------------------------------
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	
	
	//------------------------------------------------------
	/**
	 * Berechnet die Note des übergebenen Unterrichtsfachs
	 * den dazugehörigen Schüler bekommt es aus den instanzvariablen genau wie alles andere
	 * Da Diese Methode mit LocalDate.now() arbeitet, können Leistungen,welche ein Schüler in einem Fach erbracht hat
	 * nicht im Jahr darauf(also in einem neuen Schuljahr) erneut berechnetn werden.
	 * hierfür wäre eine weiter übergabeparameter z.B. DatumSJ nötig. Dies sollte implementiert werden....
	 * @param Unterrichtsfach 
	 * @return
	 */
	public static double berechneNote(Unterrichtsfach uf, Schueler schueler)
	{
		ArrayList<Leistung> muendlich = schueler.getMuendlich(uf, new DatumSJ(LocalDate.now()).getBeginn(), new DatumSJ(LocalDate.now()).getEnde() );
		ArrayList<Leistung> schriftlich = schueler.getSchriftlich(uf, new DatumSJ(LocalDate.now()).getBeginn(),new DatumSJ(LocalDate.now()).getEnde());
		
		double durchschnittmuendlich = 0;
		double durchschnittschriftlich = 0;
		double anzmuendlichnoten = 0;
		double anzschriftlichnoten = 0;
		double muendlichsumme = 0;
		double schriftlichsumme = 0;
		double gesnote = 0;
		
		
		
		for(Leistung l:muendlich)
		{
			//Addiert alle muendliche Noten zusammen, Noten die Stärker gewichtet wurden zählen doppelt.
			muendlichsumme += l.getNotenstufe()*l.getLeistungsart().getGewichtung();
			anzmuendlichnoten += 1*l.getLeistungsart().getGewichtung();		
		}
		
		for(Leistung l:schriftlich)
		{
			//Addiert alle muendliche Noten zusammen, Noten die Stärker gewichtet wurden zählen doppelt.
			schriftlichsumme += l.getNotenstufe()*l.getLeistungsart().getGewichtung();
			anzschriftlichnoten += 1*l.getLeistungsart().getGewichtung();		
		}		
		if(anzmuendlichnoten == 0)anzmuendlichnoten = 1;
		durchschnittmuendlich = muendlichsumme/anzmuendlichnoten;	
		if(anzschriftlichnoten == 0) anzschriftlichnoten = 1;
		durchschnittschriftlich = schriftlichsumme/anzschriftlichnoten;
		
		gesnote = (uf.getGewichtungSchriftlich()*durchschnittschriftlich + durchschnittmuendlich)/(uf.getGewichtungSchriftlich()+1);
		
		return gesnote;
	}
	
	
	
	
	
	/**
	 * Berechnet die Zeugnisnote für ein Zeugnisfach aus den und den üebrgebene Schüler
	 * Da dies keine static Methode ist und zeugnisnote eine Schüler als instanvariable hat
	 * ergibt das übergeben eines Schülers heir keine Sinn!
	 * @param Zeugnisfach
	 * @param schueler
	 * @return
	 */
	public static double berechneNote(Zeugnisfach zf,Schueler schueler)
	{
		double teiler = 0;
		double summe = 0;
		double znote = 0;
		for(Unterrichtsfach uf : zf.getUnterrichtsfaecher())
		{
			summe += Zeugnisnote.berechneNote(uf, schueler) * uf.getStunden();
			teiler += uf.getStunden();
		}
		//Sollte keine einzige Note fpr das Zeugnisfach vorhanden sein
		if(teiler == 0) return 0;	
		znote = summe/teiler;
		
		System.out.println(znote);
		
		return znote;
	}
	
	/** 
	 * Aus dem Methodennamen geht nicht hervor was diese Methode macht, 
	 * deshalbt kann ich sie auch nicht weiter kommentieren...........Danny Lemke für mehr fragen
	 * genau wie bei allem anderen der Zeugnisnote
	 * @param Unterrichtsfach
	 * @return
	 */
	public double berechneZZNote(Unterrichtsfach uf)
	{
		final LocalDate BEGINN_SCHULJAHR = LocalDate.parse("2015-09-01");
		final LocalDate BEGINN_HALBJAHR = LocalDate.parse("2016-02-25");
		double muendlich = 0;
		double schriftlich = 0;
		double kurzarbeit = 0;
		double note = 0;
		double ki = 0;
		double mi = 0;
		double si = 0;
		ArrayList<Leistung> leistungenmuendlich = schueler.getMuendlich(uf, BEGINN_SCHULJAHR, BEGINN_HALBJAHR);
		ArrayList<Leistung> leistungenschriftlich = schueler.getSchriftlich(uf, BEGINN_SCHULJAHR, BEGINN_HALBJAHR);
		for (Leistung l : leistungenschriftlich )
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
		}
		for(Leistung l : leistungenmuendlich )
		{
			muendlich = muendlich + l.getNotenstufe();
			mi++;
		}
	
		if(schriftlich != 0)
		{
			schriftlich = (schriftlich/si); //* uf.getGewichtungSchriftlich();			
		}
		if(kurzarbeit != 0)
		{
			kurzarbeit = (kurzarbeit/ki);		
		}
		if(muendlich != 0)
		{
			muendlich = muendlich/mi;
		}
		
		
		
		if(muendlich == 0 && kurzarbeit == 0)
		{
			note = schriftlich;
		}
		else if(muendlich == 0 && schriftlich == 0)
		{
			note = kurzarbeit;
		}
		else if(kurzarbeit == 0 && schriftlich == 0)
		{
			note = muendlich;
		}
		else if(muendlich == 0)
		{
			note = ((kurzarbeit + schriftlich) / 2);
		}
		else if(schriftlich == 0)
		{
			note = ((kurzarbeit + muendlich) / 2);
		}
		else if(kurzarbeit == 0)
		{
			note = ((muendlich + schriftlich) / 2);
		}
		else
		{
			note = ((muendlich + kurzarbeit + schriftlich) / 3 );
		}	
				
		return Math.round(note * 100)/100.0;
	}
	
	//------------------------------------------------------
	
	
	
	//------------------------------------------------------
	
	//get-Set-Add
	//------------------------------------------------------
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
