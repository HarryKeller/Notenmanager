package Dialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;







import Fachklassen.Leistung;
import Fachklassen.Unterrichtsfach;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class Dialog_Druckansicht extends JFrame
{

	private JPanel contentPane;
    Dialog_Notenblatt notenblatt;
    ArrayList<Unterrichtsfach> fach;
	
	public Dialog_Druckansicht(Dialog_Notenblatt notenblatt)
	{
		this.notenblatt = notenblatt;
		this.fach = notenblatt.fach;
		initGUI();
		JasperPrint p = erzeugeBankenReport();
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
			HashMap<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("namevorname", this.notenblatt.schueler.getNachname() + " " + this.notenblatt.schueler.getVorname());
			parameter.put("geschlecht", this.notenblatt.schueler.getGeschl());
			parameter.put("klasse", this.notenblatt.schueler.getKlasseid().getBez());
			parameter.put("schuljahr", ""+LocalDateTime.now().getYear());
			parameter.put("anschrift", "DLC für 19,99");
			parameter.put("tel", "DLC für 19,99");
			parameter.put("erziehung", "DLC für 19,99");
			parameter.put("gebdatum", ""+this.notenblatt.schueler.getGebdat());
			parameter.put("bekenntnis", this.notenblatt.schueler.getKonfession());
			parameter.put("fehl_z_t", "8");
			parameter.put("fehl_z_s", "2");
			parameter.put("fehl_z_u", "2");
			parameter.put("fehl_j_t", "12");
			parameter.put("fehl_j_s", "4");
			parameter.put("fehl_j_u", "2");
			// diese ArrayList wird später einen Eintrag pro Zeile haben
			// Achtung darf nicht mit HashMap angelegt werden (sondern mit Map)
			ArrayList<Map<String, ?>> al = new ArrayList<Map<String, ?>>();
			String mündl1j = "";
			String mündl2j = "";
			String schula1j = "";
			String schula2j = "";
				for(Unterrichtsfach f : this.fach)
				{
					mündl1j = "";
					mündl2j = "";
					schula1j = "";
					schula2j = "";
					HashMap<String, String> hm = new HashMap<String, String>();
					hm.put("Fach", f.getBez());
					for(Leistung l : Leistung.AlleLesen(this.notenblatt.schueler, f))
					{
						if(f.getId() == l.getUfachlehrer().getUfach().getId())
						{
							if(l.getErhebungsdatum().isBefore(this.notenblatt.BEGINN_HALBJAHR))
							{
								if(l.getLeistungsart().getGewichtung() == 1)
								{
									mündl1j = mündl1j + " | " + l.getNotenstufe() + " | ";
								}
								else if(l.getLeistungsart().getGewichtung() == 2)
								{
									schula1j = schula1j + " | " + l.getNotenstufe() + " | ";
								}
							}
							else if(l.getErhebungsdatum().isAfter(this.notenblatt.BEGINN_HALBJAHR))
							{
								if(l.getLeistungsart().getGewichtung() == 1)
								{
									mündl2j = mündl2j + " | " + l.getNotenstufe() + " | ";
								}
								else if(l.getLeistungsart().getGewichtung() == 2)
								{
									schula2j = schula2j + " | " + l.getNotenstufe() + " | ";
								}
							}
						}
					}
					hm.put("m1j", mündl1j);
					hm.put("m2j", mündl2j);
					hm.put("s1j", schula1j);
					hm.put("s2j", schula2j);
					al.add(hm);
				}

			JRMapCollectionDataSource ds = new JRMapCollectionDataSource(al);

			// Variante 2: vorcompilierte ".jasper"-Datei nehmen!
			JasperPrint jp = JasperFillManager.fillReport("H:/PROJEKT NOTENMANAGER/Notenblatt.jasper",
					parameter, ds);
			return jp;

		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return null;
	}

}
