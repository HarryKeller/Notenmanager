import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Fachklassen.Klasse;
import Fachklassen.Lehrer;
import Fachklassen.Leistung;
import Fachklassen.Leistungsart;
import Fachklassen.Schueler;
import Fachklassen.Schule;
import Fachklassen.UFachLehrer;
import Fachklassen.Unterrichtsfach;
import Fachklassen.Zeugnis;
import Fachklassen.Zeugnisfach;
import Fachklassen.Zeugnisnote;
import Persistenz.DBZugriff;


public class Anwendung {

	public static void main(String[] args) {
		DBZugriff.initDB();
		
		
		for(Leistung l: Leistung.AlleLesen(new Schueler(1), new Unterrichtsfach(1)))
		{
			System.out.println(l+ l.getLeistungsart().toString());
		}
		
		
		
		DBZugriff.closeDB();
	}
	
	public static void ausgabeLeistungSchuelerEinesBestimmtenFaches(int idSchueler, int idUnterrichtsfach)	//Funktioniert
	{
			
		String sql = 
				"l "
				+"INNER JOIN UFachLehrer ufl "
				+ "ON l.ufachlehrer.id = ufl.id "
				+ "INNER JOIN Unterrichtsfach uf "
				+ "ON uf.id = ufl.id "
				+ "AND uf.id = "+idUnterrichtsfach+" "
				+ "WHERE l.schueler.id = "+idSchueler;
							
		ArrayList<Object[]>al = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Leistung", al,sql );
		
		ArrayList<Leistung>leistungliste = new ArrayList<Leistung>();
		
		for(Object[] k: al )
		{			
			leistungliste.add((Leistung)k[0]);
		}
		
		for(Leistung l:leistungliste)
		{
			System.out.println(l);
		}
			
				
	}
	
	public static void ausgabeKlassenEinesLehrers()
	{
		
		//Danke an Sven  
		
		String schuleid = "1";
		String lehrerid = "1";
		
		String sql =
					"k "
				  +"INNER JOIN Zeugnisfach zf "
				  +"ON k.id = zf.klasse.id "
				  +"INNER JOIN Unterrichtsfach uf "
				  +"ON zf.id = uf.zfach.id "			  
				  +"INNER JOIN UFachLehrer ufl "
				  +"ON ufl.id = uf.id "			  
				  +"INNER JOIN Schule s "
				  +"ON s.id = "+schuleid+" "
				  +"WHERE ufl.lehrer.id = "+lehrerid;
		
		
		ArrayList<Object[]> al = new ArrayList<Object[]>();
		DBZugriff.alleLesen("Klasse", al, sql );
		
		ArrayList<Klasse> klassenliste = new ArrayList<Klasse>();
		
		//Schleifen der Klassen in eine Liste und prüfen, ob Klassen
		//Doppelt vorkommen
		for(Object[] k: al )
		{	
			boolean doppelt = false;
			for(Klasse l: klassenliste )
			{
				if( ((Klasse)k[0]).equals(l)) 
				{
					doppelt = true;
					break;
				}				
			}		
			if(doppelt) continue;
				
			klassenliste.add((Klasse)k[0]);
		}
		
		//Testausgabe auf der Console
		for(Klasse k:klassenliste)
		{
			System.out.println(k);
		}
		
	}
	
	
	public static void initDBDaten()
	{
		
		//Schule s = new Schule();
				//s.setBez("EDV_SCHULEN");
				//s.speichern();
				
				Lehrer l1 = new Lehrer();
				l1.setKürzel("SIM");
				l1.setNachname("Simmerl");
				l1.setVorname("FFF");
				l1.speichern();
				
				
				Klasse k1 = new Klasse();
				k1.setBez("BFI10");
				k1.setSj(1);
				k1.setIdKlassenleiter(new Lehrer(1));
				k1.speichern();
				
				
				Klasse k2 = new Klasse();
				k2.setBez("BFI11");
				k2.setIdKlassenleiter(new Lehrer(1));
				k2.setSj(2);		
				k2.speichern();
				
				Schueler s1 = new Schueler();
				s1.setGebdat(LocalDate.now());
				s1.setGeschl("w");
				s1.setNachname("Annka");
				s1.setKlasseid(new Klasse(1));
				
						
				Schueler s2 = new Schueler();
				s2.setGebdat(LocalDate.now());
				s2.setGeschl("w");
				s2.setNachname("Bernhard");
				s2.setKlasseid(new Klasse(1));
				
				Schueler s3 = new Schueler();
				s3.setGebdat(LocalDate.now());
				s3.setGeschl("w");
				s3.setNachname("Leon");
				s3.setKlasseid(new Klasse(1));
				
				Schueler s4 = new Schueler();
				s4.setGebdat(LocalDate.now());
				s4.setGeschl("w");
				s4.setNachname("Stefan");
				s4.setKlasseid(new Klasse(2));
				
				Schueler s5 = new Schueler();
				s5.setGebdat(LocalDate.now());
				s5.setGeschl("w");
				s5.setNachname("Otto");
				s5.setKlasseid(new Klasse(2));
				
				s1.speichern();
				s2.speichern();
				s3.speichern();
				s4.speichern();
				s5.speichern();
				
				
				Zeugnisfach z = new Zeugnisfach();
				z.setBez("Deutsch");
				z.setAbschliessendesFach(true);
				z.setVorrueckungsfach(true);
				z.setFachart("Auch Deutsch?");
				z.speichern();
				
				
				Unterrichtsfach u = new Unterrichtsfach();
				u.setBez("Deutsch");
				u.setPos(1);
				u.setStunden(5);
				u.setZfach(new Zeugnisfach(1));
				u.speichern();
				
				
				UFachLehrer u1 = new UFachLehrer();
				u1.setaustrittsdatum(LocalDate.now());
				u1.seteintrittsdatum(LocalDate.now());
				u1.setstunden(5);
				u1.setLehrer(new Lehrer(1));
				u1.setUfach(new Unterrichtsfach(1));
				u1.speichern();
				
				Leistungsart la = new Leistungsart();
				la.setBez("Schulaufgabe");
				la.setGruppe('S');
				la.setGewichtung(2);
				la.speichern();
				
				Leistung l = new Leistung();
				l.setErhebungsdatum(LocalDate.now());
				l.setLeistungsart(new Leistungsart(1));
				l.setLetzteaenderung(LocalDate.now());
				l.setNotenstufe(2);
				l.setSchueler(new Schueler(1));
				l.setTendenz('+');
				l.setUfachlehrer(new UFachLehrer(1));//In Ufachlehrer steht in welchem 
													//unterrichtsfach und bei welchem lehrer
													//die leistung erhoben wurde
				l.speichern();

				
				Zeugnis z1 = new Zeugnis();
				z1.setBemerkung("Zeugnis für schüler mit id 1");
				z1.setFehltageGanztags(0);
				z1.setFehltageGanztagsUnentschuldigt(2);
				z1.setFehltageStundenweise(5);
				z1.setSchueler(new Schueler(1));
				z1.setZeugnisart("Jahreszeugnis");	//Zeugnisart als neue Db Tabelle?
				z1.speichern();
				
				
				Zeugnisnote zn = new Zeugnisnote();
				zn.setAenderungszeitpunkt(LocalDate.now());
				zn.setBemerkung("Eine zeugnisnote für deutsch");
				zn.setNoteErrechnet(1);
				zn.setNoteZeugnis(1);
				// zn.setZeugnis(new Zeugnis(1));
				// zn.setZeugnisfach(new Zeugnisfach(1));
				zn.speichern();
				
		
		
	}

}
