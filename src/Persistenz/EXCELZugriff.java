package Persistenz;

import java.io.File;
import java.util.List;

import ExcelClasses.ExcelDB;

public class EXCELZugriff 
{
	private static String file;
	
	
	public static void setFile(String f) throws Exception
	{
		if(new File(f).exists())
		{
			file = f;
		}
		else
		{
			throw new Exception("File not found!");
		}
		
	}
	
	
	/**
	 * @param x1 
	 * Erste Koordinate, wo der gewünschte Datensatz beginnen soll! Gezählt wird ab 0!
	 * @param x2
	 * Letzte Koordinate des gewünschten Datensatzes. Leere Felder dazwischen werden mitgezählt!
	 * @param y1
	 * Erste Koordinate, gezählt wird die erste Spalte, wo ein Datensatz vorhanden ist!
	 * @param y2
	 * Letzte Koordinate, dazwischen komplett leere Spalten werden ausgelassen. 
	 * Spalten mit Datensätzen (selbst wenn nicht erwünscht), werden trotzdem mitgezählt und 
	 * müssen bei der Koordinatenwahl eingerechnet werden!
	 * @return
	 * Liefert eine Liste aller Daten, die erfolgreich gelesen werden konnten! 
	 * @throws Exception 
	 */
	public static List<String> Read(int x1, int x2, int y1, int y2) throws Exception
	{
		if(file!=null&&file!="")
		{
			ExcelDB db = new ExcelDB();
			try
			{
				
				db.setInputFile(file);
				db.setRow_anfang(x1);
				db.setRow_ende(x2);
				db.setColumn_anfang(y1);
				db.setColumn_ende(y2);
				db.read();
				return db.getDataList();
			}
			catch(Exception ex)
			{
				throw new Exception("Bei den Koordinaten ist ein Fehler aufgetreten!");
			}
			
		}
		else
		{
			throw new Exception("Die Datei konnte nicht gelesen werden!");
		}
		
	}
}
