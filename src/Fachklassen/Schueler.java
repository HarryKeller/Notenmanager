package Fachklassen;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import Persistenz.DBZugriff;

@Entity
public class Schueler 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 			// eindeutige Schüler-ID (index 0)
	
	// ---------------------------------------------------------------------------------
	
	private String nachname;	// (index 1)
	private String vorname;		// (index 2)
	private LocalDate gebdat;	// Geburtstag (index 3)
	private String geschl;		// Geschlecht (index 4)
	private String konfession;	// wegen Religion (index 5)
	private String telnr;
	private String anschrift;
	

	private String erziehungsberechtigte;
	@ManyToOne
	private Klasse klasse;	//Fremdschlüssel
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="schueler_id")
	private List<Zeugnisnote> zeugnisnoten = new ArrayList<Zeugnisnote>();
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name="schueler_id") 
	private Set<Leistung> leistung = new HashSet<Leistung>();
	
	
	// ----- CONSTRUCTOR ---------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	


	
	public static ArrayList<Schueler>alleLesen()
	{
		ArrayList<Schueler>al = new ArrayList<Schueler>();
		DBZugriff.alleLesen("Schueler", al, "");
		return al;
	}
	
	@Deprecated
	public ArrayList<Leistung> getSchriftlich(Unterrichtsfach ufach)
	{
		//Alle Leistungen des Schülers für ein Fach lesen
		ArrayList<Leistung>lst = Leistung.AlleLesen(this, ufach);
		//Rausschmeissen aller Mündlichen arbeiten
		
		
		
		ArrayList<Leistung>ret = new ArrayList<Leistung>();
		for(Leistung l: lst)
		{
			if(l.getLeistungsart().getGruppe() == 'S' && l.getUfachlehrer().getUfach().equals(ufach))
				ret.add(l);
		}
		return ret;//Rückgabe der verbliebenen, also der Schriftlichen Arbeiten
	}
	@Deprecated
	public ArrayList<Leistung> getMuendlich(Unterrichtsfach ufach)
	{
		//Alle Leistungen des Schülers für ein Fach lesen
		ArrayList<Leistung>lst = Leistung.AlleLesen(this, ufach);
		//Rausschmiessen aller Schriftlichen arbeiten
		ArrayList<Leistung>ret = new ArrayList<Leistung>();
		for(Leistung l: lst)
		{
			if(l.getLeistungsart().getGruppe() == 'M' && l.getUfachlehrer().getUfach().equals(ufach))
				ret.add(l);
		}
		return ret;	//Rückgabe der verbliebenen, also der Mündlichen Arbeiten
	}
	
	
	
	
	public ArrayList<Leistung> getSchriftlich(Unterrichtsfach ufach,LocalDate von, LocalDate bis)
	{
			//Alle Leistungen des Schülers für ein Fach lesen
			//	ArrayList<Leistung>lst = new ArrayList<Leistung>(Leistung.AlleLesen(this, ufach));
		
		
				//Rausschmeissen aller Schriftlichen arbeiten
				ArrayList<Leistung>ret = new ArrayList<Leistung>();
				
				
				
				for(Leistung l: leistung)
				{
					if(l.getLeistungsart().getGruppe() == 'S' && l.getErhebungsdatum().isAfter(von) && l.getErhebungsdatum().isBefore(bis)&& l.getUfachlehrer().getUfach().equals(ufach))
						ret.add(l);
				}
				return ret;	//Rückgabe der verbliebenen, also der Mündlich
	}
	
	public ArrayList<Leistung> getMuendlich(Unterrichtsfach ufach,LocalDate von, LocalDate bis)
	{
			//Alle Leistungen des Schülers für ein Fach lesen
			//	ArrayList<Leistung>lst = Leistung.AlleLesen(this, ufach);
				//Rausschmeissen aller Schriftlichen arbeiten
				ArrayList<Leistung>ret = new ArrayList<Leistung>();
				
				
				
				for(Leistung l: leistung)
				{
					if(l.getLeistungsart().getGruppe() == 'M' && l.getErhebungsdatum().isAfter(von) && l.getErhebungsdatum().isBefore(bis) && l.getUfachlehrer().getUfach().equals(ufach))
						ret.add(l);
				}
				return ret;	//Rückgabe der verbliebenen, also der Mündlich
	}
	
	
	public Schueler()
	{
	}
	
	public Schueler(int id)
	{
		DBZugriff.lesen(this, id);
	}
	
	public Schueler(String vorname, String nachname, LocalDate gebdat, String geschl, String konfession)
	{
		this.nachname = nachname;
		this.vorname = vorname;
		this.gebdat = gebdat;
		this.geschl = geschl;
		this.konfession = konfession;
	}
	// --------- GETTER AND SETTER ------------------------------------------------------
	// ------------------------------------------------------------------------------------
	public String getNachname()
	{
		return nachname;
	}
	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}
	public String getVorname()
	{
		return vorname;
	}
	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}
	public LocalDate getGebdat()
	{
		return gebdat;
	}
	public void setGebdat(LocalDate gebdat)
	{
		this.gebdat = gebdat;
	}
	public String getGeschl()
	{
		return geschl;
	}
	public void setGeschl(String geschl)
	{
		this.geschl = geschl;
	}
	public String getKonfession()
	{
		return konfession;
	}
	public void setKonfession(String konfession)
	{
		this.konfession = konfession;
	}
	public int getId()
	{
		return id;
	}
	public void addLeistung(Leistung l)
	{
		this.leistung.add(l);
	}
	public void removeLeistung(Leistung l)
	{
		this.leistung.remove(l);
	}
	
	public String getTelnr()
	{
		return telnr;
	}

	public void setTelnr(String telnr)
	{
		this.telnr = telnr;
	}

	public String getAnschrift()
	{
		return anschrift;
	}

	public void setAnschrift(String anschrift)
	{
		this.anschrift = anschrift;
	}

	public String getErziehungsberechtigte()
	{
		return erziehungsberechtigte;
	}

	public void setErziehungsberechtigte(String erziehungsberechtigte)
	{
		this.erziehungsberechtigte = erziehungsberechtigte;
	}

	public Klasse getKlasse()
	{
		return klasse;
	}

	public void setKlasse(Klasse klasse)
	{
		this.klasse = klasse;
	}

	public List<Zeugnisnote> getZeugnisnoten()
	{
		return zeugnisnoten;
	}

	public void setZeugnisnoten(List<Zeugnisnote> zeugnisnoten)
	{
		this.zeugnisnoten = zeugnisnoten;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	// --- Override-METHODS ----------------------------------------------------
	// --------------------------------------------------------------------------
	
	public String toString()
	{
		return this.nachname +", "+this.vorname;
	}
	
	
	// --- DATABASE -------------------------------------------------------------
	// ---------------------------------------------------------------------------
	
	/**
	 * Speichert alle hinzugefügten Leistungen des Schuelers 
	 * und alle Änderungen die sonst an der Klasse gemacht wurden
	 * der Parameter des Lehrer wird benötigt um in der Hisotire zu loggen
	 */
	public void speichern(Lehrer lehrer) // Speichern des Satzes
	{
		/*Folgende Problemstellung:
			-Geänderte Leistungen sollen in der DB geloggt werden
			-Hibernate speichert jedoch ohne zwischenwege in die DB
			(Evntl bietet Hibernate eine eigene Log Funktion diese wurde jedoch nicht benutzt
			Lösung:
			-Alle hibzugefügten leistungen mit denen aus der Db vergleichen
			-Unterschiede "perHand" löschen bzw. speichern über die Historie Klasse
			-Wenn Hybernate danach die DbDaten mit denen in der leistungliste vergleicht
				wird es feststellen, dass alle Daten bereits vorhanden sind 
				->Hybernate speichert nichts selbstständig
		*/
		ArrayList<Leistung>al = new ArrayList<>();
		
		DBZugriff.alleLesen("Leistung", al, "l WHERE l.schueler.id = "+this.getId());
		
		
		for(Leistung l: leistung)
		{
			System.out.println(l.getNotenstufe());
		}
		
		boolean vorhanden = false;
		for(Leistung l:leistung)
		{
			vorhanden = false;
			for(Leistung lk:al)	//Die aktuelle Leistung aus der DB wird mit allen aktuellen verglichen
			{
				if(l.equals(lk))	//Wenn der Datensatz genau so bereits in der DB steht
				{
					vorhanden =  true;//Dann wird vorhanden auf true gesetzt
					break;		//Und die Schleife verlassen
				}
			}
			if(!vorhanden)	//Wenn dieser Datensatz nicht so vorhanden ist, so wird dieser gespeichert
			{
				System.out.println(l);
				Historie.speichern(l, lehrer);
			}
			
		}
		//Nachschaun ob eine Leistung in leistung nicht mehr vorhanden ist, die jedoch vorhanden sein sollte
		//Aktualisieren der DB einträge
		DBZugriff.alleLesen("Leistung", al, "l WHERE l.schueler.id = "+this.getId());
		boolean nochvorhanden = false;
		for(Leistung l: al)
		{
			nochvorhanden = false;
			for(Leistung l2 : leistung)
			{
				if(l.getId() == l2.getId())	
				{
					nochvorhanden = true;
					break;
				}
			}
			if(!nochvorhanden)
			{
				l.loeschen(lehrer);
			}
		}
		
		
		DBZugriff.speichern(this);	

			
	}
	
	/**
	 * Löscht den Schüler, sollte nicht benutzt werden!!!!
	 * Verursacht Inkonsistenz in der DB
	 * 
	 */
	@Deprecated
	public void loeschen() 	// Löschen des Satzes
	{
		DBZugriff.speichern(this);
	}

	//------------------------------------------
	
	//get-Set-Add
	//------------------------------------------
	
	public Klasse getKlasseid() {
		return klasse;
	}

	public void setKlasseid(Klasse klasse) {
		this.klasse = klasse;
	}
	public Set<Leistung> getLeistung() {
		return leistung;
	}

	public void setLeistung(Set<Leistung> leistung) {
		this.leistung = leistung;
	}

	
	
}
