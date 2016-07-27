package Dialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fachklassen.Lehrer;
import Fachklassen.Schueler;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Properties;

@SuppressWarnings("serial")
public class Dialog_adm_Schueler_Bearbeiten extends JFrame implements ActionListener
{

	private Schueler schueler;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblVorname;
	private JLabel lblNachname;
	private JLabel lblGeschlecht;
	private JLabel lblKonfession;
	private JLabel lblAnschrift;
	private JTextField textField_Vorname;
	private JTextField textField_Nachname;
	private JRadioButton radio_geschl_m;
	private JRadioButton radio_geschl_w;
	private JTextField textField_Konfession;
	private JTextField textField_Anschrift;
	private JPanel panel_1;
	private JButton btnSpeichern;
	private JButton btnVerwerfen;
	private JLabel lblTelefon;
	private JLabel lblErziehungsberechtiger;
	private JTextField textField_Telefon;
	private JTextField textField_erzber;
	private JLabel lblGeburtsdatum;
	private UtilDateModel model;
	private JDatePickerImpl datePicker;




	//Konstruktor für Schüler neuanlegen
	private Dialog_adm_Schueler_Bearbeiten()

	{
		schueler = new Schueler();
		initGUI();	
	}
	



	//Konstruktor für Schüler Bearbeiten
	private Dialog_adm_Schueler_Bearbeiten(Schueler schueler)
	{
		this.schueler = schueler;
		initGUI();
		setDatenInMaske();
	}
	
	//Aufbauen der GUI
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Sch\u00FCler verwalten");
		setBounds(100, 100, 450, 375);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{249, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 5, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.contentPane.add(this.panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 228, 176, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panel.setLayout(gbl_panel);
		
		this.lblVorname = new JLabel("Vorname :");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.EAST;
		gbc_lblVorname.insets = new Insets(5, 5, 5, 5);
		gbc_lblVorname.gridx = 0;
		gbc_lblVorname.gridy = 0;
		this.panel.add(this.lblVorname, gbc_lblVorname);
		
		this.textField_Vorname = new JTextField();
		GridBagConstraints gbc_textField_Vorname = new GridBagConstraints();
		gbc_textField_Vorname.gridwidth = 2;
		gbc_textField_Vorname.insets = new Insets(5, 5, 5, 5);
		gbc_textField_Vorname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Vorname.gridx = 1;
		gbc_textField_Vorname.gridy = 0;
		this.panel.add(this.textField_Vorname, gbc_textField_Vorname);
		this.textField_Vorname.setColumns(10);
		
		this.lblNachname = new JLabel("Nachname :");
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.anchor = GridBagConstraints.EAST;
		gbc_lblNachname.insets = new Insets(5, 5, 5, 5);
		gbc_lblNachname.gridx = 0;
		gbc_lblNachname.gridy = 1;
		this.panel.add(this.lblNachname, gbc_lblNachname);
		
		this.textField_Nachname = new JTextField();
		GridBagConstraints gbc_textField_Nachname = new GridBagConstraints();
		gbc_textField_Nachname.gridwidth = 2;
		gbc_textField_Nachname.insets = new Insets(5, 5, 5, 5);
		gbc_textField_Nachname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Nachname.gridx = 1;
		gbc_textField_Nachname.gridy = 1;
		this.panel.add(this.textField_Nachname, gbc_textField_Nachname);
		this.textField_Nachname.setColumns(10);
		
		this.lblGeschlecht = new JLabel("Geschlecht :");
		GridBagConstraints gbc_lblGeschlecht = new GridBagConstraints();
		gbc_lblGeschlecht.insets = new Insets(5, 5, 5, 5);
		gbc_lblGeschlecht.anchor = GridBagConstraints.EAST;
		gbc_lblGeschlecht.gridx = 0;
		gbc_lblGeschlecht.gridy = 2;
		this.panel.add(this.lblGeschlecht, gbc_lblGeschlecht);
		
		this.radio_geschl_m = new JRadioButton("m");
		GridBagConstraints gbc_radio_geschl_m = new GridBagConstraints();
		gbc_radio_geschl_m.insets = new Insets(0, 0, 5, 5);
		gbc_radio_geschl_m.gridx = 1;
		gbc_radio_geschl_m.gridy = 2;
		this.panel.add(this.radio_geschl_m, gbc_radio_geschl_m);
		
		this.radio_geschl_w = new JRadioButton("w");
		GridBagConstraints gbc_radio_geschl_w = new GridBagConstraints();
		gbc_radio_geschl_w.insets = new Insets(0, 0, 5, 0);
		gbc_radio_geschl_w.gridx = 2;
		gbc_radio_geschl_w.gridy = 2;
		this.panel.add(this.radio_geschl_w, gbc_radio_geschl_w);
		
		this.lblKonfession = new JLabel("Konfession :");
		GridBagConstraints gbc_lblKonfession = new GridBagConstraints();
		gbc_lblKonfession.anchor = GridBagConstraints.EAST;
		gbc_lblKonfession.insets = new Insets(5, 5, 5, 5);
		gbc_lblKonfession.gridx = 0;
		gbc_lblKonfession.gridy = 3;
		this.panel.add(this.lblKonfession, gbc_lblKonfession);
		
		this.textField_Konfession = new JTextField();
		GridBagConstraints gbc_textField_Konfession = new GridBagConstraints();
		gbc_textField_Konfession.gridwidth = 2;
		gbc_textField_Konfession.insets = new Insets(5, 5, 5, 5);
		gbc_textField_Konfession.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Konfession.gridx = 1;
		gbc_textField_Konfession.gridy = 3;
		this.panel.add(this.textField_Konfession, gbc_textField_Konfession);
		this.textField_Konfession.setColumns(10);
		
		this.lblAnschrift = new JLabel("Anschrift :");
		GridBagConstraints gbc_lblAnschrift = new GridBagConstraints();
		gbc_lblAnschrift.insets = new Insets(5, 5, 5, 5);
		gbc_lblAnschrift.anchor = GridBagConstraints.EAST;
		gbc_lblAnschrift.gridx = 0;
		gbc_lblAnschrift.gridy = 4;
		this.panel.add(this.lblAnschrift, gbc_lblAnschrift);
		
		this.textField_Anschrift = new JTextField();
		GridBagConstraints gbc_textField_Anschrift = new GridBagConstraints();
		gbc_textField_Anschrift.gridwidth = 2;
		gbc_textField_Anschrift.insets = new Insets(5, 5, 5, 5);
		gbc_textField_Anschrift.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Anschrift.gridx = 1;
		gbc_textField_Anschrift.gridy = 4;
		this.panel.add(this.textField_Anschrift, gbc_textField_Anschrift);
		this.textField_Anschrift.setColumns(10);
		
		this.lblTelefon = new JLabel("Telefon :");
		GridBagConstraints gbc_lblTelefon = new GridBagConstraints();
		gbc_lblTelefon.anchor = GridBagConstraints.EAST;
		gbc_lblTelefon.insets = new Insets(5, 5, 5, 5);
		gbc_lblTelefon.gridx = 0;
		gbc_lblTelefon.gridy = 5;
		this.panel.add(this.lblTelefon, gbc_lblTelefon);
		
		this.textField_Telefon = new JTextField();
		GridBagConstraints gbc_textField_Telefon = new GridBagConstraints();
		gbc_textField_Telefon.gridwidth = 2;
		gbc_textField_Telefon.insets = new Insets(5, 5, 5, 5);
		gbc_textField_Telefon.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Telefon.gridx = 1;
		gbc_textField_Telefon.gridy = 5;
		this.panel.add(this.textField_Telefon, gbc_textField_Telefon);
		this.textField_Telefon.setColumns(10);
		
		this.lblErziehungsberechtiger = new JLabel("Erz.ber. :");
		GridBagConstraints gbc_lblErziehungsberechtiger = new GridBagConstraints();
		gbc_lblErziehungsberechtiger.anchor = GridBagConstraints.EAST;
		gbc_lblErziehungsberechtiger.insets = new Insets(5, 5, 5, 5);
		gbc_lblErziehungsberechtiger.gridx = 0;
		gbc_lblErziehungsberechtiger.gridy = 6;
		this.panel.add(this.lblErziehungsberechtiger, gbc_lblErziehungsberechtiger);
		
		this.textField_erzber = new JTextField();
		GridBagConstraints gbc_textField_erzber = new GridBagConstraints();
		gbc_textField_erzber.gridwidth = 2;
		gbc_textField_erzber.insets = new Insets(5, 5, 5, 5);
		gbc_textField_erzber.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_erzber.gridx = 1;
		gbc_textField_erzber.gridy = 6;
		this.panel.add(this.textField_erzber, gbc_textField_erzber);
		this.textField_erzber.setColumns(10);
		
		this.panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(5, 5, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		this.contentPane.add(this.panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.panel_1.setLayout(gbl_panel_1);
		
		this.btnSpeichern = new JButton("Speichern");
		this.btnSpeichern.addActionListener(this);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeichern.insets = new Insets(5, 5, 5, 5);
		gbc_btnSpeichern.gridx = 0;
		gbc_btnSpeichern.gridy = 0;
		this.panel_1.add(this.btnSpeichern, gbc_btnSpeichern);
		
		this.btnVerwerfen = new JButton("Verwerfen");
		this.btnVerwerfen.addActionListener(this);
		GridBagConstraints gbc_btnVerwerfen = new GridBagConstraints();
		gbc_btnVerwerfen.insets = new Insets(5, 5, 5, 5);
		gbc_btnVerwerfen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVerwerfen.gridx = 1;
		gbc_btnVerwerfen.gridy = 0;
		this.panel_1.add(this.btnVerwerfen, gbc_btnVerwerfen);
		
		ButtonGroup group= new ButtonGroup();
		group.add(radio_geschl_m);
		group.add(radio_geschl_w);
		
		this.lblGeburtsdatum = new JLabel("Geburtsdatum :");
		GridBagConstraints gbc_lblGeburtsdatum = new GridBagConstraints();
		gbc_lblGeburtsdatum.insets = new Insets(5, 5, 5, 5);
		gbc_lblGeburtsdatum.gridx = 0;
		gbc_lblGeburtsdatum.gridy = 7;
		this.panel.add(this.lblGeburtsdatum, gbc_lblGeburtsdatum);
		
		model = new UtilDateModel();
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		GridBagConstraints gbc_datepicker = new GridBagConstraints();
		
		
		gbc_datepicker.insets = new Insets(5,5,5,5);
		gbc_datepicker.gridwidth = 2;
		gbc_datepicker.gridx = 1;
		gbc_datepicker.gridy = 7;
		gbc_datepicker.fill = GridBagConstraints.BOTH;
		gbc_datepicker.anchor = GridBagConstraints.NORTH;
		this.panel.add(datePicker, gbc_datepicker);
	}

	//Setzt alle Werte der Textfelder beim Schueler Bearbeiten
	private void setDatenInMaske()
	{
		this.textField_Vorname.setText(schueler.getVorname());
		this.textField_Nachname.setText(schueler.getNachname());
		this.textField_Konfession.setText(schueler.getKonfession());
		this.textField_Anschrift.setText(schueler.getAnschrift());
		this.textField_Telefon.setText(schueler.getTelnr());
		this.textField_erzber.setText(schueler.getErziehungsberechtigte());			
		datePicker.getJFormattedTextField().setText(schueler.getGebdat().toString());
		
		if(schueler.getGeschl().equals("m"))
		{
			radio_geschl_m.setSelected(true);
		}
		else
		{
			radio_geschl_w.setSelected(true);
		}
	}
	
	//holt sich alle Werte aus den Textfeldern
	private void getDatenAusMaske()
	{		
		this.schueler.setVorname(this.textField_Vorname.getText());
		this.schueler.setNachname(this.textField_Nachname.getText());
		this.schueler.setKonfession(this.textField_Konfession.getText());
		this.schueler.setAnschrift(this.textField_Anschrift.getText());
		this.schueler.setTelnr(this.textField_Telefon.getText());
		this.schueler.setErziehungsberechtigte(this.textField_erzber.getText());
		String day,month;
		
		day = ""+model.getDay();
		month = ""+model.getMonth();
		if(model.getMonth() < 10)
		{
			month = "0"+model.getMonth();
		}
		if(model.getDay()<10)
		{
			day = "0"+model.getDay();
		}		
		this.schueler.setGebdat(LocalDate.parse((model.getYear()+"-"+month+"-"+day)));						
		
		if(radio_geschl_m.isSelected())
		{
			schueler.setGeschl("m");
		}
		else
		{
			schueler.setGeschl("w");
		}
		
		
	}
	
	//Sobald event ausgelöst wird...
	public void actionPerformed(ActionEvent arg0) 
	{
		//...holt sich die Daten aus der Maske und speichert die Werte für den Schüler
		//	 ruft danach wieder Dialog Schüler auf
		if(arg0.getActionCommand().equals(btnSpeichern.getActionCommand()))
		{
			getDatenAusMaske();
			schueler.speichern(new Lehrer(1)); //  Lehrer wird nur zum Loggen benutzt daher wird hier irgentein Lehrer verwendet
			this.dispose();
			Dialog_adm_Schueler.initGui(); 
			Dialog_Klassenauswahl.dlg_adm_Schueler.setVisible(true);
		}
		//... schließt Dialog und ruft Dialog Schueler auf
		else
		{
			this.dispose();
			Dialog_adm_Schueler.initGui(); 
			Dialog_Klassenauswahl.dlg_adm_Schueler.setVisible(true);
		}
	}
	public static void initGui()
	{
		if(Dialog_Klassenauswahl.dlg_adm_SchuelerBearbeiten == null)
			Dialog_Klassenauswahl.dlg_adm_SchuelerBearbeiten = new Dialog_adm_Schueler_Bearbeiten();
		
		Dialog_Klassenauswahl.dlg_adm_SchuelerBearbeiten.setVisible(true);
		Dialog_Klassenauswahl.dlg_adm_SchuelerBearbeiten.toFront();
	}
	public static void initGui(Schueler s)
	{
		if(Dialog_Klassenauswahl.dlg_adm_SchuelerBearbeiten == null)
			Dialog_Klassenauswahl.dlg_adm_SchuelerBearbeiten = new Dialog_adm_Schueler_Bearbeiten(s);
		
		Dialog_Klassenauswahl.dlg_adm_SchuelerBearbeiten.setVisible(true);
		Dialog_Klassenauswahl.dlg_adm_SchuelerBearbeiten.toFront();
	}
}
