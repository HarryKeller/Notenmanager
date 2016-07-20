import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import Fachklassen.DatumSJ;
import Fachklassen.Leistung;
import Fachklassen.Leistungsart;
import Fachklassen.Schueler;
import Fachklassen.Zeugnisnote;
import Persistenz.DBZugriff;
import Persistenz.EXCELZugriff;


public class TestMain
{

	
	public static void main(String[] args)
	{
		DBZugriff.initDB();
		DBZugriff.closeDB();
	}
	
	
}
