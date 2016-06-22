import java.sql.Date;
import java.time.LocalDate;

import Fachklassen.Schueler;
import Persistenz.DBZugriff;


public class Anwendung {

	public static void main(String[] args) {
		DBZugriff.initDB();
		
		
		Schueler s = 
		new Schueler("TestVorname","TestNachname", LocalDate.now(),"M","Katholisch");
		s.speichern();
		
		DBZugriff.closeDB();
	}

}
