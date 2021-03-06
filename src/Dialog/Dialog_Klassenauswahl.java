package Dialog;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Fachklassen.Klasse;
import Fachklassen.Lehrer;
import Fachklassen.Schule;
import Fachklassen.Unterrichtsfach;
import Persistenz.DBZugriff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;




@SuppressWarnings("serial")
public class Dialog_Klassenauswahl extends JFrame implements ActionListener//, ItemListener

{
	//Instanzen sämtlicher Dialoge
	
	public static Dialog_adm_FachAnlegen dlg_adm_FachAnlegen = null;		
	public static Dialog_adm_KlasseAnsicht dlg_adm_KlasseAnsicht = null;	
	public static Dialog_adm_KlasseBearbeiten dlg_adm_KlasseBearbeiten = null;	
	public static Dialog_adm_Lehrer_Bearbeiten dlg_adm_LehrerBearbeiten = null;	
	public static Dialog_adm_Lehrer dlg_adm_Lehrer = null;		
	public static Dialog_adm_Schueler_Bearbeiten dlg_adm_SchuelerBearbeiten = null;	
	public static Dialog_adm_Schueler dlg_adm_Schueler = null;	
	public static Dialog_adm_Unterrichtsfach_bearbeiten dlg_adm_unterrichtsfach_bearbeiten= null;	
	public static Dialog_adm_Unterrichtsfach dlg_adm_unterrichtsfach = null;	
	public static Dialog_adm_UnterrichtsfachZuweisen dlg_adm_UnterrichtsfachZuweisen = null;	
	public static Dialog_adm_Zeugnisfach_Bearbeiten dlg_adm_ZeugnisfachBearbeiten = null;	
	public static Dialog_adm_Zeugnisfach dlg_adm_Zeugnisfach = null;	
	public static Dialog_adm_ZeugnisfachZurKlasseUebersicht dlg_adm_ZeugnisfachZurKlasseUebersicht = null;
	public static Dialog_Druckansicht dlg_druckansicht = null;		
	public static Dialog_Klassenauswahl dlg_Klassenauswahl = null;			
	public static Dialog_KlassenWechseln dlg_KlassenWechsel = null;		
	public static Dialog_LeistungNeu dlg_LeistungNeu = null;		
	public static Dialog_NotenausgabeKlasse dlg_NotenausgabeKlasse = null;	
	public static Dialog_Notenblatt dlg_Notenblatt = null;	
	public static Dialog_Schuelerwahl dlg_Schuelerwahl = null;	
	public static Dialog_ZeugnisBemerkung dlg_Zeugnisbemerkung = null;	
	public static Dialog_ZeugnisDrucken dlg_ZeugnisDrucken = null;		
	public static Dialog_ZeugnisnotenZumSchueler dlg_ZeugnisnotenZumSchueler = null;
	//--------------------------------------------------------------------------------------
	
	
	
	
	private JPanel panel_combobox;
	private JPanel panel_button;
	private JPanel panel_klassenleiter;
	private JLabel lblSchuleauswahl;
	private JLabel lblKlassenauswahl;
	private JComboBox<Schule> comboBox_Schule;	
	private JComboBox<Klasse> comboBox_Klassen;
	private JComboBox<Unterrichtsfach> comboBox_Faecher;
	private JLabel lblFcherauswahl;
	private JButton btnFachuebersicht;
	private JButton btnKlassenuebersicht;
	private JButton btnSchließen;
	private JLabel lblKlassenleiter;
	private JSeparator separator;
	private JSeparator separator_1;
	private Lehrer lehrer;
	Klasse klasse = new Klasse();
	private JMenuBar menuBar;
	private JMenu menuBenutzer;
	private JMenuItem mitemBenutzerWechseln;
	private JMenu menuStammdaten;
	private JMenuItem mitemSchuelerBearbeiten;
	private JMenuItem mitemLehrerBearbeiten;
	private JMenuItem mitemKlassenBearbeiten;
	private JMenuItem mitemFaecherAnlegen;
	private JMenuItem mitemUnterrichtsfaecherZuweisen;
	private JButton btnKlassenWechseln;
	private JMenuItem mntmZeugnisnoteBearbeiten;

	/**
	 * Create the dialog.
	 */
	
	public Dialog_Klassenauswahl(Lehrer lehrer, boolean admin)
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		setTitle("Hauptmen\u00FC");
		
		this.lehrer = lehrer;					
		initGUI();
		
		ArrayList<Klasse> al = Klasse.alleLesen();
		boolean found = false;

		if(admin == true)
		{
			menuStammdaten.setVisible(true);
		}
		else
		{
			menuStammdaten.setVisible(false);
		}
		
		for(Klasse k : al)
		{
			if(k.getIdKlassenleiter().getId() == this.lehrer.getId())
			{
				panel_klassenleiter.setVisible(true);
				
				separator_1.setVisible(true);
				this.btnKlassenuebersicht.setEnabled(true);
				this.btnKlassenWechseln.setEnabled(true);
				found = true;
			}
			else if (k.getIdKlassenleiter().getId() != this.lehrer.getId() && found == false)
			{
				panel_klassenleiter.setVisible(false);
				separator_1.setVisible(false);
				this.btnKlassenuebersicht.setEnabled(false);
				this.pack();
			}
		}
		SetDatenInMaske();
	}	
	
	public void SetDatenInMaske()
	{			
		//Combobox für Schule füllen
		for(Schule s :Schule.alleLesen() )
		{
			comboBox_Schule.addItem(s);	
		}						
	}
	
	private void initGUI() 
	{
		setResizable(false);
		setBounds(100, 100, 525, 325);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{340, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{216, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		this.panel_combobox = new JPanel();
		GridBagConstraints gbc_panel_combobox = new GridBagConstraints();
		gbc_panel_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_panel_combobox.fill = GridBagConstraints.BOTH;
		gbc_panel_combobox.gridx = 0;
		gbc_panel_combobox.gridy = 0;
		getContentPane().add(this.panel_combobox, gbc_panel_combobox);
		GridBagLayout gbl_panel_combobox = new GridBagLayout();
		gbl_panel_combobox.columnWidths = new int[]{0, 0};
		gbl_panel_combobox.rowHeights = new int[]{0, 0, 0, 0, 0, 11, 0};
		gbl_panel_combobox.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_combobox.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		this.panel_combobox.setLayout(gbl_panel_combobox);
		
		this.lblSchuleauswahl = new JLabel("Schule");
		this.lblSchuleauswahl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSchuleauswahl = new GridBagConstraints();
		gbc_lblSchuleauswahl.insets = new Insets(5, 0, 5, 0);
		gbc_lblSchuleauswahl.gridx = 0;
		gbc_lblSchuleauswahl.gridy = 0;
		this.panel_combobox.add(this.lblSchuleauswahl, gbc_lblSchuleauswahl);
		
		this.comboBox_Schule = new JComboBox<Schule>();
		this.comboBox_Schule.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e)
			{
				
				comboBox_Klassen.removeAllItems();
				for(Klasse k:Klasse.alleLesen(lehrer, (Schule)comboBox_Schule.getSelectedItem()))
				{
					comboBox_Klassen.addItem(k);		
				}	
				
			}
		});
		GridBagConstraints gbc_comboBox_Schule = new GridBagConstraints();
		gbc_comboBox_Schule.insets = new Insets(5, 10, 5, 10);
		gbc_comboBox_Schule.fill = GridBagConstraints.BOTH;
		gbc_comboBox_Schule.gridx = 0;
		gbc_comboBox_Schule.gridy = 1;
		this.panel_combobox.add(this.comboBox_Schule, gbc_comboBox_Schule);
		
		this.lblKlassenauswahl = new JLabel("Klassen");
		this.lblKlassenauswahl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblKlassenauswahl = new GridBagConstraints();
		gbc_lblKlassenauswahl.insets = new Insets(0, 0, 5, 0);
		gbc_lblKlassenauswahl.gridx = 0;
		gbc_lblKlassenauswahl.gridy = 2;
		this.panel_combobox.add(this.lblKlassenauswahl, gbc_lblKlassenauswahl);
		
		this.comboBox_Klassen = new JComboBox<Klasse>();
		this.comboBox_Klassen.setEnabled(false);
		this.comboBox_Klassen.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e)
			{
				
				comboBox_Faecher.removeAllItems();
				if(comboBox_Klassen.getSelectedItem() != null)
				{
					
					for(Unterrichtsfach f : Unterrichtsfach.alleLesen(lehrer, (Klasse)comboBox_Klassen.getSelectedItem(),LocalDate.now()))
					{
						comboBox_Faecher.addItem(f);
					}			
				}
				if(comboBox_Faecher.getItemCount() == 0)
				{
					btnFachuebersicht.setEnabled(false);
				}
				else
				{
					btnFachuebersicht.setEnabled(true);
				}
				
				//Sollte der Lehrer nicht der Klassenleiter oder Stv Klassenleiter sein:
				if(comboBox_Klassen.getItemCount() == 0) return;
				if(((Klasse)comboBox_Klassen.getSelectedItem()).getKlassenleiter().getId() == lehrer.getId()
						|| ((Klasse)comboBox_Klassen.getSelectedItem()).getStvklassenleiter().getId() == lehrer.getId() )
				{
					btnKlassenuebersicht.setEnabled(true);
				}
				else
				{
					btnKlassenuebersicht.setEnabled(false);
				}
				
				
				
				comboBox_Faecher.setEnabled(true);
				comboBox_Klassen.setEnabled(true);
				
			}
		});
		GridBagConstraints gbc_comboBox_Klassen = new GridBagConstraints();
		gbc_comboBox_Klassen.insets = new Insets(5, 10, 5, 10);
		gbc_comboBox_Klassen.fill = GridBagConstraints.BOTH;
		gbc_comboBox_Klassen.gridx = 0;
		gbc_comboBox_Klassen.gridy = 3;
		this.panel_combobox.add(this.comboBox_Klassen, gbc_comboBox_Klassen);
		
		this.lblFcherauswahl = new JLabel("F\u00E4cher");
		this.lblFcherauswahl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblFcherauswahl = new GridBagConstraints();
		gbc_lblFcherauswahl.insets = new Insets(0, 0, 5, 0);
		gbc_lblFcherauswahl.gridx = 0;
		gbc_lblFcherauswahl.gridy = 4;
		this.panel_combobox.add(this.lblFcherauswahl, gbc_lblFcherauswahl);
		
		this.comboBox_Faecher = new JComboBox<Unterrichtsfach>();
		this.comboBox_Faecher.setEnabled(false);
		GridBagConstraints gbc_comboBox_Faecher = new GridBagConstraints();
		gbc_comboBox_Faecher.insets = new Insets(5, 10, 5, 10);
		gbc_comboBox_Faecher.fill = GridBagConstraints.BOTH;
		gbc_comboBox_Faecher.gridx = 0;
		gbc_comboBox_Faecher.gridy = 5;
		this.panel_combobox.add(this.comboBox_Faecher, gbc_comboBox_Faecher);
		
		this.separator_1 = new JSeparator();
		this.separator_1.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridheight = 2;
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 0;
		getContentPane().add(this.separator_1, gbc_separator_1);
		
		this.panel_klassenleiter = new JPanel();
		GridBagConstraints gbc_panel_klassenleiter = new GridBagConstraints();
		gbc_panel_klassenleiter.gridheight = 2;
		gbc_panel_klassenleiter.fill = GridBagConstraints.BOTH;
		gbc_panel_klassenleiter.gridx = 2;
		gbc_panel_klassenleiter.gridy = 0;
		getContentPane().add(this.panel_klassenleiter, gbc_panel_klassenleiter);
		GridBagLayout gbl_panel_klassenleiter = new GridBagLayout();
		gbl_panel_klassenleiter.columnWidths = new int[]{0, 0};
		gbl_panel_klassenleiter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_klassenleiter.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_klassenleiter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.panel_klassenleiter.setLayout(gbl_panel_klassenleiter);
		
		this.lblKlassenleiter = new JLabel("Klassenleiter");
		this.lblKlassenleiter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblKlassenleiter = new GridBagConstraints();
		gbc_lblKlassenleiter.insets = new Insets(5, 10, 5, 10);
		gbc_lblKlassenleiter.gridx = 0;
		gbc_lblKlassenleiter.gridy = 0;
		this.panel_klassenleiter.add(this.lblKlassenleiter, gbc_lblKlassenleiter);
		
		this.separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		this.panel_klassenleiter.add(this.separator, gbc_separator);
		
		this.btnKlassenuebersicht = new JButton("Klassen\u00FCbersicht");
		this.btnKlassenuebersicht.addActionListener(this);
		this.btnKlassenuebersicht.setEnabled(false);
		GridBagConstraints gbc_btnKlassenuebersicht = new GridBagConstraints();
		gbc_btnKlassenuebersicht.insets = new Insets(0, 5, 5, 5);
		gbc_btnKlassenuebersicht.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKlassenuebersicht.gridx = 0;
		gbc_btnKlassenuebersicht.gridy = 2;
		this.panel_klassenleiter.add(this.btnKlassenuebersicht, gbc_btnKlassenuebersicht);
		
		this.btnKlassenWechseln = new JButton("Klassen wechseln");
		this.btnKlassenWechseln.addActionListener(this);
		this.btnKlassenWechseln.setEnabled(false);
		GridBagConstraints gbc_btnKlassenWechseln = new GridBagConstraints();
		gbc_btnKlassenWechseln.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKlassenWechseln.insets = new Insets(0, 5, 5, 5);
		gbc_btnKlassenWechseln.gridx = 0;
		gbc_btnKlassenWechseln.gridy = 3;
		this.panel_klassenleiter.add(this.btnKlassenWechseln, gbc_btnKlassenWechseln);
		
		this.panel_button = new JPanel();
		GridBagConstraints gbc_panel_button = new GridBagConstraints();
		gbc_panel_button.insets = new Insets(0, 0, 0, 5);
		gbc_panel_button.fill = GridBagConstraints.BOTH;
		gbc_panel_button.gridx = 0;
		gbc_panel_button.gridy = 1;
		getContentPane().add(this.panel_button, gbc_panel_button);
		GridBagLayout gbl_panel_button = new GridBagLayout();
		gbl_panel_button.columnWidths = new int[]{0, 0, 0};
		gbl_panel_button.rowHeights = new int[]{0, 0};
		gbl_panel_button.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_button.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.panel_button.setLayout(gbl_panel_button);
		
		this.btnFachuebersicht = new JButton("Notenblatt");
		this.btnFachuebersicht.addActionListener(this);
		GridBagConstraints gbc_btnFachuebersicht = new GridBagConstraints();
		gbc_btnFachuebersicht.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFachuebersicht.insets = new Insets(5, 10, 5, 10);
		gbc_btnFachuebersicht.gridx = 0;
		gbc_btnFachuebersicht.gridy = 0;
		this.panel_button.add(this.btnFachuebersicht, gbc_btnFachuebersicht);
		
		this.btnSchließen = new JButton("Schlie\u00DFen");
		this.btnSchließen.setActionCommand("Schließen");
		this.btnSchließen.addActionListener(this);
		GridBagConstraints gbc_btnSchließen = new GridBagConstraints();
		gbc_btnSchließen.insets = new Insets(5, 10, 5, 10);
		gbc_btnSchließen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSchließen.gridx = 1;
		gbc_btnSchließen.gridy = 0;
		this.panel_button.add(this.btnSchließen, gbc_btnSchließen);
		
		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		
		this.menuBenutzer = new JMenu("Benutzer");
		this.menuBar.add(this.menuBenutzer);
		
		this.mitemBenutzerWechseln = new JMenuItem("Benutzer wechseln");
		this.mitemBenutzerWechseln.addActionListener(this);
		this.menuBenutzer.add(this.mitemBenutzerWechseln);
		
		this.menuStammdaten = new JMenu("Stammdaten");
		this.menuBar.add(this.menuStammdaten);
		
		this.mitemSchuelerBearbeiten = new JMenuItem("Sch\u00FCler bearbeiten");
		this.mitemSchuelerBearbeiten.addActionListener(this);
		this.menuStammdaten.add(this.mitemSchuelerBearbeiten);
		
		this.mitemLehrerBearbeiten = new JMenuItem("Lehrer bearbeiten");
		this.mitemLehrerBearbeiten.addActionListener(this);
		this.menuStammdaten.add(this.mitemLehrerBearbeiten);
		
		this.mitemKlassenBearbeiten = new JMenuItem("Klassen bearbeiten");
		this.mitemKlassenBearbeiten.addActionListener(this);
		this.menuStammdaten.add(this.mitemKlassenBearbeiten);
		
		this.mitemFaecherAnlegen = new JMenuItem("F\u00E4cher bearbeiten");
		this.mitemFaecherAnlegen.addActionListener(this);
		this.menuStammdaten.add(this.mitemFaecherAnlegen);
		
		this.mitemUnterrichtsfaecherZuweisen = new JMenuItem("Unterrichtsf\u00E4cher zuweisen");
		this.mitemUnterrichtsfaecherZuweisen.addActionListener(this);
		this.menuStammdaten.add(this.mitemUnterrichtsfaecherZuweisen);
		
		this.mntmZeugnisnoteBearbeiten = new JMenuItem("Zeugnisf\u00E4cher bearbeiten");
		this.mntmZeugnisnoteBearbeiten.addActionListener(this);
		this.menuStammdaten.add(this.mntmZeugnisnoteBearbeiten);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getActionCommand().equals(btnFachuebersicht.getActionCommand())) // Abfrage auf Drücken des Login-Buttons "button_Login"
		{
			
			Dialog_NotenausgabeKlasse.initDialog(lehrer,(Klasse)comboBox_Klassen.getSelectedItem(),(Unterrichtsfach)comboBox_Faecher.getSelectedItem());		
			
		}		
		else if(e.getActionCommand().equals(btnKlassenuebersicht.getActionCommand())) // Abfrage ob Button Klassenuebersicht gedrückt wurde
		{
			
			Dialog_Schuelerwahl.initDialog(lehrer,(Klasse)comboBox_Klassen.getSelectedItem()); 
			Dialog_Klassenauswahl.dlg_Schuelerwahl.setVisible(true);
			
		}
		else if(e.getActionCommand().equals(btnKlassenWechseln.getActionCommand()))
		{
		
			Dialog_KlassenWechseln.initGui(lehrer); 
			Dialog_Klassenauswahl.dlg_KlassenWechsel.setVisible(true); 
		}				
		else if(e.getActionCommand().equals(mitemBenutzerWechseln.getActionCommand())) // Abfrage ob Menueitem gedrückt wurde
		{
			this.dispose();
			Dialog_Login dlg_login = new Dialog_Login();
			dlg_login.setVisible(true);
		}
		else if(e.getActionCommand().equals( "Fächer bearbeiten"))
		{
			Dialog_adm_Unterrichtsfach.initGui();
		}
		else if(e.getActionCommand().equals("Lehrer bearbeiten"))
		{

			Dialog_adm_Lehrer.initGui(); 
			Dialog_Klassenauswahl.dlg_adm_Lehrer.setVisible(true);
			
		}
		else if(e.getActionCommand().equals("Klassen bearbeiten"))
		{
			
			Dialog_adm_KlasseAnsicht.initGui(); 
			Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.setVisible(true);
		}
		else if(e.getActionCommand().equals("Schüler bearbeiten"))
		{
			
			Dialog_adm_Schueler.initGui(); 
			Dialog_Klassenauswahl.dlg_adm_Schueler.setVisible(true);
		}
		else if(e.getActionCommand().equals("Unterrichtsfächer zuweisen"))
		{
			Dialog_adm_UnterrichtsfachZuweisen.initGui(); 
			Dialog_Klassenauswahl.dlg_adm_UnterrichtsfachZuweisen.setVisible(true);
		}
		else if(e.getActionCommand().equals("Zeugnisfächer bearbeiten"))
		{
			
			Dialog_adm_Zeugnisfach.initGui();
			Dialog_Klassenauswahl.dlg_adm_Zeugnisfach.setVisible(true);
		}
		else if( e.getActionCommand().equals("Schließen"))
		{
			DBZugriff.closeDB();
			this.dispose();	
		}

		
	}

}
