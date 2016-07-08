package Persistenz;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class DBZugriff
{
	// Factory Pattern!!!

	// Die Session-Factory l�dt und h�lt alle O/R-Mappings. 
	// Eine Anwendung sollte nur eine Session-Factory enthalten
	
	private static SessionFactory sessionFactory=null;
	
	
	public static void initDB()
	{
		// Session-Factory existiert bereits
		if( sessionFactory != null )
		{
			return;
		}
		
		// Datenbankverbindung konfigurieren 
		// (hibernate.cfg.xml wird eingelesen)
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		
    // Mittels der Session-Factory k�nnen Sessions erzeugt werden
    // Eine (Hibernate)Session ist f�r den Entwickler die prim�re Schnittstelle
    // zu Hibernate. Mit der Session k�nnen wir Objekte aus der DB lesen,
    // sie speichern, aktualisieren oder l�schen. Seine wichtigsten Methoden sind:
    //	- session.load(Class, Object): Lesen eines Objektes mit Hilfe des Primary-Keys
    //	- session.createQuery(String): Erstellen einer Abfrage
    //	- session.save(Object): Speichern eines Objektes
    //	- session.update((Object): Aktualisieren eines Objektes
    //	- session.saveOrUpdate((Object): Speichern oder aktualisieren eines Objektes
    //	- session.delete(Object): L�schen eines Objektes
    //	- session.flush(): Synchronisation mit der DB
    
    //	Die (Hibernate)Session ist die Factory f�r Transaktionen
	}
	
	// schlie�t die SessionFactory
	public static void closeDB()
	{
		if(sessionFactory!=null)
		{
			sessionFactory.close();
			sessionFactory=null;
		}
	}
	
	// speichern eines Objektes
	public static boolean speichern(Object o)
	{
		Session session = null;
		
		try
		{
			// neue Sesseion beginnen
			session = sessionFactory.openSession();
			
			// Tranaktion beginnen
			Transaction t = session.beginTransaction();
			
			// erzeugt einen neuen Datensatz (falls die ID noch nicht in DB)
			// ODER
			// ver�ndert den bereits gespeicherten Datensatz
			session.saveOrUpdate(o);
			
			// Commit f�r die Transaktion
			t.commit();
			
			return true;
		}
		catch (HibernateException e)
		{
			System.out.println("Fehler beim Speichern!");
			Logger logger = Logger.getRootLogger();
			logger.error("Fehler beim Speichern!");
			e.printStackTrace();
			
			return false;
		}
		finally
		{
			session.close();
		}
	}

	
	public static void lesen(Object o, int id)
	{
		// Session �ffnen
		Session session = sessionFactory.openSession();
		
		// Lesen des Datensatzes mit der gegebenen ID
		session.load(o, id);
		
		// Session schlie�en
		session.close();
	}
	
	public static void loeschen(Object o)
	{
		Session session = null;
		Transaction t = null;
		
		try
		{
			// Session �ffnen
			session = sessionFactory.openSession();
			
			// Transaktion beginnen
			t = session.beginTransaction();
			
			// l�sche Satz
			session.delete(o);
			
			// schlie�e Transaktion ab
			t.commit();
		
		}
		catch( HibernateException e)
		{
			if(t!=null) t.rollback();
			throw e;
			
		}
		finally
		{
			if(session!=null) session.close();
		}
	}
	
	public static <T> boolean alleLesen(String klassenname,
										ArrayList<T> al,
										String hqlFilter)
	{
		Session session = null;
		try
		{
			//Session �ffnen
			session = sessionFactory.openSession();
			
			// Abfrage starten
			Query query = session.createQuery("from " +
										klassenname + " " +
										hqlFilter);
			
			for( Object o : query.list() )
			{
				al.add( (T) o );
			}
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			if( session!=null) session.close();
		}
	}
	
	public static int speichernAndGetId(Object o)
	{
		Session session = null;
		int ret = -1;
		try
		{
			// neue Sesseion beginnen
			session = sessionFactory.openSession();
		
			// Tranaktion beginnen
			Transaction t = session.beginTransaction();
		
			ret = (int) session.save(o);
			t.commit();
		}
		catch (HibernateException e)
		{
			System.out.println("Fehler beim Speichern!");
			Logger logger = Logger.getRootLogger();
			logger.error("Fehler beim Speichern!");
			e.printStackTrace();
		}
		return ret;
	}
}
