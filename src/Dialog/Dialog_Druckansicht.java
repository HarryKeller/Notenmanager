package Dialog;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;








import Fachklassen.Leistung;
import Fachklassen.Unterrichtsfach;
import Fachklassen.Zeugnisnote;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class Dialog_Druckansicht extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    Dialog_Notenblatt notenblatt;
    ArrayList<Unterrichtsfach> fach;
	
	public Dialog_Druckansicht(Dialog_Notenblatt notenblatt)
	{
		//Notenblatt DialogDaten der JTable �bernehmen, um an Daten f�r Notenblatt Jasperreport zu kommen
		this.notenblatt = notenblatt;
		this.fach = notenblatt.fach;
		//GUI erstellen
		initGUI();
		//Jasperprint f�r JRViewer erzeugen
		JasperPrint p = erzeugeBankenReport();
		//PDF-Datei mit gef�lltem Report anzeigen lassen
		JRViewer viewer = new JRViewer(p);
		contentPane.add(viewer);
	}
	public void initGUI()
	{
		this.setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}
	public JasperPrint erzeugeBankenReport()
	{
		try
		{
			//HashMap f�r Parameterbelegung im Report
			HashMap<String, Object> parameter = new HashMap<String, Object>();
			//Parameter belegen
			parameter.put("namevorname", this.notenblatt.schueler.getNachname() + " " + this.notenblatt.schueler.getVorname());
			parameter.put("geschlecht", this.notenblatt.schueler.getGeschl());
			parameter.put("klasse", this.notenblatt.schueler.getKlasseid().getBez());
			parameter.put("schuljahr", Dialog_Notenblatt.BEGINN_SCHULJAHR.getYear() + "/" + Dialog_Notenblatt.ENDE_SCHULJAHR.getYear());
			parameter.put("anschrift", "DLC f�r 19,99");
			parameter.put("tel", "DLC f�r 19,99");
			parameter.put("erziehung", "DLC f�r 19,99");
			parameter.put("gebdatum", ""+this.notenblatt.schueler.getGebdat());
			parameter.put("bekenntnis", this.notenblatt.schueler.getKonfession());
			parameter.put("fehl_z_t", "8");
			parameter.put("fehl_z_s", "2");
			parameter.put("fehl_z_u", "2");
			parameter.put("fehl_j_t", "12");
			parameter.put("fehl_j_s", "4");
			parameter.put("fehl_j_u", "2");
			//Arraylist f�r die Zusammenfassung aller Daten f�r die Notentabelle erzeugen
			ArrayList<Map<String, ?>> al = new ArrayList<Map<String, ?>>();
			//Einzelne Strings f�r jede m�gliche Note anlegen
			String m�ndl1j = "";
			String schula1j = "";
			String m�ndl2j = "";
			String schula2j = "";
		    Zeugnisnote zn = new Zeugnisnote(notenblatt.schueler);
		    Zeugnisnote zzn = new Zeugnisnote(notenblatt.schueler);
		    double zz = 0.00;
		    double jz = 0.00;
				for(Unterrichtsfach f : this.fach)
				{
					//Strings nach jedem abgefertigten Fach leeren, um Noten f�r das n�chste Fach zu speichern
					m�ndl1j = "";
					m�ndl2j = "";
					schula1j = "";
					schula2j = "";
					//HashMap f�r Felde im Report anlegen
					HashMap<String, String> hm = new HashMap<String, String>();
					hm.put("Fach", f.getBez());
					jz = zn.berechneNote(f);
					zz = zzn.berechneZZNote(f);
					if(jz!=0.00)
					{
						hm.put("jz", ""+zn.berechneNote(f));
					}
					if(zz!=0.00)
					{
						hm.put("zz", ""+zzn.berechneZZNote(f));
					}
					for(Leistung l : Leistung.AlleLesen(this.notenblatt.schueler, f))
					{
						//Logische �berpr�fung in welche Spalte die Noten kommen m�ssen
						if(f.getId() == l.getUfachlehrer().getUfach().getId())
						{
							if(l.getErhebungsdatum().isBefore(Dialog_Notenblatt.BEGINN_HALBJAHR))
							{
								if(l.getLeistungsart().getGewichtung() == 1)
								{
									m�ndl1j = m�ndl1j + "|" + l.getNotenstufe() + "|";
								}
								else if(l.getLeistungsart().getGewichtung() == 2)
								{
									schula1j = schula1j + "|" + l.getNotenstufe() + "|";
								}
							}
							else if(l.getErhebungsdatum().isAfter(Dialog_Notenblatt.BEGINN_HALBJAHR))
							{
								if(l.getLeistungsart().getGewichtung() == 1)
								{
									m�ndl2j = m�ndl2j + "|" + l.getNotenstufe() + "|";
								}
								else if(l.getLeistungsart().getGewichtung() == 2)
								{
									schula2j = schula2j + "|" + l.getNotenstufe() + "|";
								}
							}
						}
					}
					//Gesammelte Noten pro Fach in die ArrayList einspeichern
					hm.put("m1j", m�ndl1j);
					hm.put("m2j", m�ndl2j);
					hm.put("s1j", schula1j);
					hm.put("s2j", schula2j);
					al.add(hm);
				}
			//Nach erfolgreicher Datensammlung, wird die ArrayList f�r den Report vorbereitet
			JRMapCollectionDataSource ds = new JRMapCollectionDataSource(al);
			//Verteilung der Daten in den Report
			JasperPrint jp = JasperFillManager.fillReport("Notenblatt.jasper",
					parameter, ds);
			return jp;

		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return null;
	}

}
