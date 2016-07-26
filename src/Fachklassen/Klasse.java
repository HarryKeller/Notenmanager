package Fachklassen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;






import Persistenz.DBZugriff;

@Entity
public class Klasse 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 
	private String bez;
	@ManyToOne
	private DatumSJ datumSJ;
	
	@ManyToOne
	private Schule schule;			//FS
	
	@ManyToOne
	private Lehrer klassenleiter;	//FS
	
	@ManyToOne
	private Lehrer stvklassenleiter;	//FS
	
	@ManyToOne
	private Ausbildungszweig ausbildungszweig;
	
	//Liste aller Zeugnisfächer
	@ManyToMany(cascade=CascadeType.DETACH,fetch = FetchType.EAGER)
	@JoinTable(name="zeugnisfach_klasse",
				joinColumns = @JoinColumn(name="klasse_id"),
				inverseJoinColumns=@JoinColumn(name="zeugnisfach_id")	
			)
	private Set<Zeugnisfach> lstzeugnisfach = new HashSet<Zeugnisfach>();
	
	
	
	//Liste aller Schüler der Klasse
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="klasse_id")
	private Set<Schueler> schuelerlist;
	
	//--------------------------------------------------
	//--------------------------------------------------
	//--------------------------------------------------
	public void addZeugnisfach(Zeugnisfach zf)
	{
		lstzeugnisfach.add(zf);
	}
	
	//Konstruktoren
	//--------------------------------------------------
	public Klasse(){}
	
	public Klasse(int sid)
	{
		DBZugriff.lesen(this, sid);
	}
	
	//--------------------------------------------------
	//Alle Lesen methoden
	//--------------------------------------------------
	public static ArrayList<Klasse> alleLesen(Lehrer lehrer, Schule schule)
	{
		Integer schuleid = schule.getID();
		Integer lehrerid = lehrer.getId();
		System.out.println("lehrerid : "+lehrerid);
		System.out.println("Schuelid : "+schuleid);
		
		
//		SELECT DISTINCT Klasse.bez
//		FROM Klasse
//		INNER JOIN UFachLehrer
//		ON UFachLehrer.lehrer_id = 1
		
//		INNER JOIN Unterrichtsfach
//		ON UFachLehrer.ufach_id = Unterrichtsfach.id
		
//		INNER JOIN Zeugnisfach
//		ON Zeugnisfach.id = Unterrichtsfach.zfach_id
//		WHERE Klasse.schule_id = 2
		
		
		String sql =
					"k "
				  +"INNER JOIN UFachLehrer ufl "
				  +"ON ufl.lehrer.id = "+lehrerid+" "
				  +"INNER JOIN Unterrichtsfach uf "
				  +"ON uf.id = ufl.ufach.id "			  
				  +"INNER JOIN Zeugnisfach zf "
				  +"ON zf.id = uf.zfach.id "			  
				  +"WHERE k.schule.id = "+schuleid;
		
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
		
		return klassenliste;
	}
	
	public static ArrayList<Klasse> alleLesen()
	{
		ArrayList<Klasse> al = new ArrayList<Klasse>();
		DBZugriff.alleLesen("Klasse", al, "");
		return al;	
	}
	//--------------------------------------------------
	//Override Methoden
	//--------------------------------------------------
	public String toString()
	{
		return this.bez + " " + this.datumSJ;
	}
	public boolean equals(Klasse k)
	{
		if(k.getid() == this.getid())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//--------------------------------------------------	
	//Speichern und loeschen von Schuelern
	//--------------------------------------------------
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
			
	//--------------------------------------------------
	//get - set und add
	//--------------------------------------------------
	public int getid()
	{
		return id;
	}
	
	public String getBez() {
		return bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

	public DatumSJ getSj() {
		return datumSJ;
	}

	public void setSj(DatumSJ sj) {
		this.datumSJ = sj;
	}

	public Schule getIdSchule() {
		return schule;
	}

	public void setIdSchule(Schule idSchule) {
		this.schule = idSchule;
	}

	public Lehrer getIdKlassenleiter() {
		return klassenleiter;
	}

	public void setIdKlassenleiter(Lehrer idKlassenleiter) {
		this.klassenleiter = idKlassenleiter;
	}

	public Lehrer getIdStvKlassenleiter() {
		return stvklassenleiter;
	}

	public void setIdStvKlassenleiter(Lehrer idStvKlassenleiter) {
		this.stvklassenleiter = idStvKlassenleiter;
	}
	


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public Schule getSchule()
	{
		return schule;
	}


	public void setSchule(Schule schule)
	{
		this.schule = schule;
	}


	public Lehrer getKlassenleiter()
	{
		return klassenleiter;
	}


	public void setKlassenleiter(Lehrer klassenleiter)
	{
		this.klassenleiter = klassenleiter;
	}


	public Lehrer getStvklassenleiter()
	{
		return stvklassenleiter;
	}


	public void setStvklassenleiter(Lehrer stvklassenleiter)
	{
		this.stvklassenleiter = stvklassenleiter;
	}


	public Set<Schueler> getSchuelerlist()
	{
		return schuelerlist;
	}


	public void setSchuelerlist(Set<Schueler> schuelerlist)
	{
		this.schuelerlist = schuelerlist;
	}


	public Set<Zeugnisfach> getLstzeugnisfach()
	{
		return lstzeugnisfach;
	}


	public void setLstzeugnisfach(Set<Zeugnisfach> lstzeugnisfach)
	{
		this.lstzeugnisfach = lstzeugnisfach;
	}

	
	
	public Set<Schueler> getSchueler()
	{
		return this.schuelerlist;
	}
	public Set<Zeugnisfach> getlstzeugnisfach()
	{
		return this.lstzeugnisfach;
	}

	public Ausbildungszweig getAusbildungszweig()
	{
		return ausbildungszweig;
	}

	public void setAusbildungszweig(Ausbildungszweig ausbildungszweig)
	{
		this.ausbildungszweig = ausbildungszweig;
	}

}
