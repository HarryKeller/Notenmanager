import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import Fachklassen.DatumSJ;
import Fachklassen.Lehrer;
import Fachklassen.Leistung;
import Fachklassen.Leistungsart;
import Fachklassen.Schueler;
import Fachklassen.UFachLehrer;
import Fachklassen.Zeugnisnote;
import Persistenz.DBZugriff;
import Persistenz.EXCELZugriff;


public class TestMain
{

	
	public static void main(String[] args)
	{
		DBZugriff.initDB();
		
		for(Zeugnisnote zn : Zeugnisnote.alleLesen(new Schueler(4), new DatumSJ(LocalDate.now())))
		{
			System.out.println(zn);
		}
		
		
		
		System.out.println("Fertig");
		DBZugriff.closeDB();
	}
	
	
}
