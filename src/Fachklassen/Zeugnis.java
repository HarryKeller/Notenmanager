package Fachklassen;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Persistenz.DBZugriff;


@Entity
public class Zeugnis
{
		// Instanzvariablen
		//---------------------------------------------------------------------------------------------
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		private int id;
		
		private String bemerkung;
		@ManyToOne
		private Zeugnisart zeugnisart;
		@ManyToOne
		private DatumSJ schuljahr;
		private int fehltageGanztags;
		private int fehltageGanztagsUnentschuldigt;
		private int fehltageStundenweise;
		private int fehltageStundenweiseUnentschuldigt;
		
		@ManyToOne
		private Schueler schueler;	//FS
	
	
	//------------------------------------------------------
		
	// Konstruktoren
	//------------------------------------------------------
	public Zeugnis()
	{
		
	}
	public Zeugnis(int id){
		DBZugriff.lesen(this, id);
	}
	
	public Zeugnis(String bemerkung, Zeugnisart zeugnisart, int fehltageGanztags,
			int fehltageGanztagsUnentschuldigt, int fehltageStundenweise,
			int fehltageStundenweiseUnentschuldigt)
	{
		this.bemerkung = bemerkung;
		this.zeugnisart = zeugnisart;
		this.fehltageGanztags = fehltageGanztags;
		this.fehltageGanztagsUnentschuldigt = fehltageGanztagsUnentschuldigt;
		this.fehltageStundenweise = fehltageStundenweise;
		this.fehltageStundenweiseUnentschuldigt = fehltageStundenweiseUnentschuldigt;
	}
	//---------------------------------------------------	
	
	//DB.Methoden
	//---------------------------------------------------
	
	public void speichern()
	{
		DBZugriff.speichern(this);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
	
	//---------------------------------------------------------------------------------------------
	//Override Methoden
	public String toString()
	{
		return "Zeugnis von: "+this.schueler+" im jahr: "+this.schuljahr;
	}
	
	
	//Alle-Lesen-Methoden
	
	public static ArrayList<Zeugnis> alleLesen(DatumSJ d, Schueler s)
	{
		//Zeugnisse des Schülers aus diesem Schuljahr
		//-noch machen
		String hql= " z "			
				+"WHERE z.schueler.id = "+s.getId()+" "
				+"AND z.schuljahr.id = "+d.getId();
		
		System.out.println(hql);
		ArrayList<Zeugnis>al = new ArrayList<Zeugnis>();
		DBZugriff.alleLesen("Zeugnis", al, hql);
		return al;
	}
	//---------------------------------------------------
	
	//Get-Set-Add
	//---------------------------------------------------
		
		public Schueler getSchueler() {
			return schueler;
		}

		public void setSchueler(Schueler schueler) {
			this.schueler = schueler;
		}


		public int getId()
		{
			return id;
		}
		public void setId(int id)
		{
			this.id = id;
		}
		
		public String getBemerkung()
		{
			return bemerkung;
		}
		public DatumSJ getSchuljahr()
		{
			return schuljahr;
		}
		public void setSchuljahr(DatumSJ schuljahr)
		{
			this.schuljahr = schuljahr;
		}
		public void setBemerkung(String bemerkung)
		{
			this.bemerkung = bemerkung;
		}
		
		public Zeugnisart getZeugnisart()
		{
			return zeugnisart;
		}
		public void setZeugnisart(Zeugnisart zeugnisart)
		{
			this.zeugnisart = zeugnisart;
		}
		
		public int getFehltageGanztags()
		{
			return fehltageGanztags;
		}
		public void setFehltageGanztags(int fehltageGanztags)
		{
			this.fehltageGanztags = fehltageGanztags;
		}
		
		public int getFehltageGanztagsUnentschuldigt()
		{
			return fehltageGanztagsUnentschuldigt;
		}
		public void setFehltageGanztagsUnentschuldigt(int fehltageGanztagsUnentschuldigt)
		{
			this.fehltageGanztagsUnentschuldigt = fehltageGanztagsUnentschuldigt;
		}
		
		public int getFehltageStundenweise()
		{
			return fehltageStundenweise;
		}
		public void setFehltageStundenweise(int fehltageStundenweise)
		{
			this.fehltageStundenweise = fehltageStundenweise;
		}
		
		public int getFehltageStundenweiseUnentschuldigt()
		{
			return fehltageStundenweiseUnentschuldigt;
		}
		public void setFehltageStundenweiseUnentschuldigt(int fehltageStundenweiseUnentschuldigt)
		{
			this.fehltageStundenweiseUnentschuldigt = fehltageStundenweiseUnentschuldigt;
		}
	
}
