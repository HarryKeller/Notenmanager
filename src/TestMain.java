import java.time.LocalDate;
import java.util.ArrayList;

import Fachklassen.Leistung;
import Fachklassen.Leistungsart;
import Fachklassen.Schueler;
import Fachklassen.Zeugnisnote;
import Persistenz.DBZugriff;


public class TestMain
{

	
	public static void main(String[] args)
	{
		DBZugriff.initDB();
		
//		erzeugeLeistung();
//    	erzeugeLeistungart();
		
		
		DBZugriff.closeDB();
		
		
		System.out.println("Fertig!");
	}
	
	public static void erzeugeLeistung()
	{
		Leistung l = new Leistung();
		l.setNotenstufe(2);
		l.setErhebungsdatum(LocalDate.now());
		l.setLetzteaenderung(LocalDate.now());
		l.setTendenz('+');
		l.speichern();	
	}	
	public static void erzeugeLeistungart()
	{
		Leistungsart la = new Leistungsart();
		la.setBez("schriftlich");
		la.setGewichtung(2);
		la.setGruppe('S');
		la.speichern();	
	}
	
}
