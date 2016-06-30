package Fachklassen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int sj;
	
	@ManyToOne
	private Schule schule;			//FS
	
	@ManyToOne
	private Lehrer klassenleiter;	//FS
	
	@ManyToOne
	private Lehrer stvklassenleiter;	//FS
	
	//Liste aller Zeugnisfächer
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="klasse_id")
	private List<Zeugnisfach> zeugnisfach = new ArrayList<Zeugnisfach>();
	
	//Liste aller Schüler der Klasse
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="klasse_id")
	private Set<Schueler> schuelerlist;// = new Set<Schueler>();
	
	
	public Klasse(){}
	
	public Klasse(int sid)
	{
		DBZugriff.lesen(this, sid);
	}
	
	public static ArrayList<Klasse> AlleLesen(Lehrer lehrer, Schule schule)
	{
		Integer schuleid = schule.getID();
		Integer lehrerid = lehrer.getId();
		System.out.println("lehrerid : "+lehrerid);
		System.out.println("Schuelid : "+schuleid);
		
		//vermutlich unnötig
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
				  +"WHERE ufl.lehrer.id = "+lehrerid
				  +" and k.schule.id = "+schuleid;
		
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
		
	
	public boolean speichern()
	{
		return DBZugriff.speichern(this);
	}
	public void loeschen()
	{
		DBZugriff.loeschen(this);
	}
		
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

	public int getSj() {
		return sj;
	}

	public void setSj(int sj) {
		this.sj = sj;
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
	
	public String toString()
	{
		return this.bez + " " + this.sj;
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
	
	
	public Set<Schueler> getSchueler()
	{
		return this.schuelerlist;
	}
	public List<Zeugnisfach> getZeugnisfaecher()
	{
		return this.zeugnisfach;
	}

}
