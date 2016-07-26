package Dialog;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fachklassen.Ausbildungszweig;
import Fachklassen.DatumSJ;
import Fachklassen.Klasse;
import Fachklassen.Schueler;
import Fachklassen.Schule;
import Fachklassen.Zeugnisfach;
import Fachklassen.Zeugnisnote;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog_ZeugnisDrucken extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Schueler schueler;
	Dialog_Schuelerwahl schuelerwahl;
	private JButton btnZurck;
	String bemerkung = "";
	public ArrayList<Zeugnisfach> fach;
	Ausbildungszweig a = new Ausbildungszweig();
	Schule s = new Schule();
	String noteschriftl = "";
	public Dialog_ZeugnisDrucken(Schueler schueler, Dialog_Schuelerwahl Schuelerwahl, String bemerkung)
	{
		this.bemerkung = bemerkung;
		this.schueler = schueler;
		this.schuelerwahl = Schuelerwahl;
		initGUI();
		JasperPrint p = erzeugeReport();
		JRViewer viewer = new JRViewer(p);
		contentPane.add(viewer);
		btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(this);
		contentPane.add(btnZurck, BorderLayout.SOUTH);
	}
	
	public void initGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public JasperPrint erzeugeReport()
	{
		try
		{
			//HashMap für Parameterbelegung im Report
			HashMap<String, Object> parameter = new HashMap<String, Object>();
			//Parameter belegen
			parameter.put("name", this.schueler.getVorname() + " " + this.schueler.getNachname());
			parameter.put("gebdat", this.schueler.getGebdat().getDayOfMonth() + "." + this.schueler.getGebdat().getMonthValue() + "." + this.schueler.getGebdat().getYear());
			parameter.put("schuljahr", new DatumSJ(LocalDate.now()).getsj());
			parameter.put("klasse", this.schueler.getKlasse().getBez());
			parameter.put("ausbildungszweig", ""+this.schueler.getKlasse().getAusbildungszweig());
			parameter.put("bemerkung", this.bemerkung);
			parameter.put("datum", "");
			parameter.put("schulleiter", ""+s.getSchulleiter());
			parameter.put("lehrer", ""+this.schueler.getKlasse().getIdKlassenleiter());
			//Arraylist für die Zusammenfassung aller Daten für die Notentabelle erzeugen
			ArrayList<Map<String, ?>> al = new ArrayList<Map<String, ?>>();
			//Einzelne Strings für jede mögliche Note anlegen
		    ArrayList<Zeugnisnote> zn = Zeugnisnote.alleLesen(this.schueler, LocalDate.now());
		    fach = Zeugnisfach.alleLesen(new Klasse(this.schueler.getKlasse().getid()));
			for(Zeugnisfach f : this.fach)
			{	
				HashMap<String, String> hm = new HashMap<String, String>();
				hm.put("fach", ""+f.getBez());
				for(Zeugnisnote z : zn)
				{
					if(z.getZeugnisfach().getBez().equals(f.getBez()))
					{
						hm.put("note", ""+z.getNoteZeugnis());
					}
				}
				al.add(hm);
			}	
	
			//Nach erfolgreicher Datensammlung, wird die ArrayList für den Report vorbereitet
			JRMapCollectionDataSource ds = new JRMapCollectionDataSource(al);
			//Verteilung der Daten in den Report
			JasperPrint jp = JasperFillManager.fillReport("edvZeugnis12.jasper",
					parameter, ds);
			return jp;

		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return null;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		String action = arg0.getActionCommand();
		if(action.equals("Zurück"))
		{
			this.dispose();
			this.schuelerwahl.setVisible(true);
		}
	}
}
