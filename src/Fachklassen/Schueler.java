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
	private int id; 			// eindeutige Sch�ler-ID (index 0)
	
	// ---------------------------------------------------------------------------------
	
	private String nachname;	// (index 1)
	private String vorname;		// (index 2)
	private LocalDate gebdat;	// Geburtstag (index 3)
	private String geschl;		// Geschlecht (index 4)
	private String konfession;	// wegen Religion (index 5)
	
	@ManyToOne
	private Klasse klasse;	//Fremdschl�ssel
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="schueler_id")
	private List<Zeugnisnote> zeugnisnoten = new ArrayList<Zeugnisnote>();
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name="schueler_id") 
	private Set<Leistung> leistung = new HashSet<Leistung>();
	
	
	// ----- CONSTRUCTOR ---------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	


	public Set<Leistung> getLeistung() {
		return leistung;
	}

	public void setLeistung(Set<Leistung> leistung) {
		this.leistung = leistung;
	}
	
	@Deprecated
	public ArrayList<Leistung> getSchriftlich(Unterrichtsfach ufach)
	{
		//Alle Leistungen des Sch�lers f�r ein Fach lesen
		ArrayList<Leistung>lst = Leistung.AlleLesen(this, ufach);
		//Rausschmeissen aller M�ndlichen arbeiten
		
		
		
		ArrayList<Leistung>ret = new ArrayList<Leistung>();
		for(Leistung l: lst)
		{
			if(l.getLeistungsart().getGruppe() == 'S' && l.getUfachlehrer().getUfach().equals(ufach))
				ret.add(l);
		}
		return ret;//R�ckgabe der verbliebenen, also der Schriftlichen Arbeiten
	}
	@Deprecated
	public ArrayList<Leistung> getMuendlich(Unterrichtsfach ufach)
	{
		//Alle Leistungen des Sch�lers f�r ein Fach lesen
		ArrayList<Leistung>lst = Leistung.AlleLesen(this, ufach);
		//Rausschmiessen aller Schriftlichen arbeiten
		ArrayList<Leistung>ret = new ArrayList<Leistung>();
		for(Leistung l: lst)
		{
			if(l.getLeistungsart().getGruppe() == 'M' && l.getUfachlehrer().getUfach().equals(ufach))
				ret.add(l);
		}
		return ret;	//R�ckgabe der verbliebenen, also der M�ndlichen Arbeiten
	}
	
	
	
	
	public ArrayList<Leistung> getSchriftlich(Unterrichtsfach ufach,LocalDate von, LocalDate bis)
	{
			//Alle Leistungen des Sch�lers f�r ein Fach lesen
			//	ArrayList<Leistung>lst = new ArrayList<Leistung>(Leistung.AlleLesen(this, ufach));
		
		
				//Rausschmeissen aller Schriftlichen arbeiten
				ArrayList<Leistung>ret = new ArrayList<Leistung>();
				
				
				
				for(Leistung l: leistung)
				{
					if(l.getLeistungsart().getGruppe() == 'S' && l.getErhebungsdatum().isAfter(von) && l.getErhebungsdatum().isBefore(bis)&& l.getUfachlehrer().getUfach().equals(ufach))
						ret.add(l);
				}
				return ret;	//R�ckgabe der verbliebenen, also der M�ndlich
	}
	
	public ArrayList<Leistung> getMuendlich(Unterrichtsfach ufach,LocalDate von, LocalDate bis)
	{
			//Alle Leistungen des Sch�lers f�r ein Fach lesen
			//	ArrayList<Leistung>lst = Leistung.AlleLesen(this, ufach);
				//Rausschmeissen aller Schriftlichen arbeiten
				ArrayList<Leistung>ret = new ArrayList<Leistung>();
				
				
				
				for(Leistung l: leistung)
				{
					if(l.getLeistungsart().getGruppe() == 'M' && l.getErhebungsdatum().isAfter(von) && l.getErhebungsdatum().isBefore(bis) && l.getUfachlehrer().getUfach().equals(ufach))
						ret.add(l);
				}
				return ret;	//R�ckgabe der verbliebenen, also der M�ndlich
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
	
	
	// --- Override-METHODS ----------------------------------------------------
	// --------------------------------------------------------------------------
	
	public String toString()
	{
		return this.nachname +", "+this.vorname;
	}
	
	
	// --- DATABASE -------------------------------------------------------------
	// ---------------------------------------------------------------------------
	
	public void speichern(Lehrer lehrer) // Speichern des Satzes
	{
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
		//Aktualisieren der DB eintr�ge
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
		
		//An dieser stelle werden alle Datens�tze die jetzt null sind gel�scht:
			
		
	
		System.out.println("check");
	}
	
	public void loeschen() 	// L�schen des Satzes
	{
		DBZugriff.speichern(this);
	}

	public Klasse getKlasseid() {
		return klasse;
	}

	public void setKlasseid(Klasse klasse) {
		this.klasse = klasse;
	}

	
	
}
