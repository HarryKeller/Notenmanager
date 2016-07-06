package Dialog;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Fachklassen.Klasse;
import Fachklassen.Lehrer;
import Fachklassen.Schule;
import Fachklassen.Unterrichtsfach;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Dialog_Klassenauswahl extends JFrame implements ActionListener, ItemListener

{
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
	private JButton btnZurueck;
	private JLabel lblKlassenleiter;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnZeugnisnotenAnlegen;
	private Lehrer lehrer;
	Klasse klasse = new Klasse();

	/**
	 * Create the dialog.
	 */
	
	public Dialog_Klassenauswahl(Lehrer lehrer)
	{
		this.lehrer = lehrer;	
		initGUI();
		ArrayList<Klasse> al = Klasse.alleLesen();
		boolean found = false;
		for(Klasse k : al)
		{
			if(k.getIdKlassenleiter().getId() == this.lehrer.getId())
			{
				this.btnKlassenuebersicht.setEnabled(true);
				this.btnZeugnisnotenAnlegen.setEnabled(true);
				found = true;
			}
			else if (k.getIdKlassenleiter().getId() != this.lehrer.getId() && found == false)
			{
				this.btnKlassenuebersicht.setEnabled(false);
				this.btnZeugnisnotenAnlegen.setEnabled(false);
			}
		}
		SetDatenInMaske();
	}
	
	public void SetDatenInMaske()
	{			
		//Combobox f�r Schule f�llen
		for(Schule s :Schule.alleLesen() )
		{
			comboBox_Schule.addItem(s);	
		}						
	}
	
	private void initGUI() 
	{
		setResizable(false);
		setBounds(100, 100, 525, 300);
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
		gbl_panel_combobox.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
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
		
		this.comboBox_Schule = new JComboBox();
		this.comboBox_Schule.addItemListener(this);
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
		
		this.comboBox_Klassen = new JComboBox();
		this.comboBox_Klassen.setEnabled(false);
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
		
		this.comboBox_Faecher = new JComboBox();
		this.comboBox_Faecher.setEnabled(false);
		this.comboBox_Faecher.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		gbl_panel_klassenleiter.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_klassenleiter.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_klassenleiter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_separator.insets = new Insets(0, 0, 10, 0);
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		this.panel_klassenleiter.add(this.separator, gbc_separator);
		
		this.btnKlassenuebersicht = new JButton("Klassen\u00FCbersicht");
		this.btnKlassenuebersicht.addActionListener(this);
		this.btnKlassenuebersicht.setEnabled(false);
		GridBagConstraints gbc_btnKlassenuebersicht = new GridBagConstraints();
		gbc_btnKlassenuebersicht.insets = new Insets(5, 5, 5, 5);
		gbc_btnKlassenuebersicht.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKlassenuebersicht.gridx = 0;
		gbc_btnKlassenuebersicht.gridy = 2;
		this.panel_klassenleiter.add(this.btnKlassenuebersicht, gbc_btnKlassenuebersicht);
		
		this.btnZeugnisnotenAnlegen = new JButton("Zeugnisnoten anlegen");
		this.btnZeugnisnotenAnlegen.addActionListener(this);
		this.btnZeugnisnotenAnlegen.setEnabled(false);
		GridBagConstraints gbc_btnZeugnisnotenAnlegen = new GridBagConstraints();
		gbc_btnZeugnisnotenAnlegen.insets = new Insets(5, 5, 5, 5);
		gbc_btnZeugnisnotenAnlegen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnZeugnisnotenAnlegen.gridx = 0;
		gbc_btnZeugnisnotenAnlegen.gridy = 3;
		this.panel_klassenleiter.add(this.btnZeugnisnotenAnlegen, gbc_btnZeugnisnotenAnlegen);
		
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
		
		this.btnFachuebersicht = new JButton("Fach\u00FCbersicht");
		this.btnFachuebersicht.addActionListener(this);
		GridBagConstraints gbc_btnFachuebersicht = new GridBagConstraints();
		gbc_btnFachuebersicht.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFachuebersicht.insets = new Insets(0, 10, 0, 10);
		gbc_btnFachuebersicht.gridx = 0;
		gbc_btnFachuebersicht.gridy = 0;
		this.panel_button.add(this.btnFachuebersicht, gbc_btnFachuebersicht);
		
		this.btnZurueck = new JButton("Zur\u00FCck");
		this.btnZurueck.addActionListener(this);
		GridBagConstraints gbc_btnZurueck = new GridBagConstraints();
		gbc_btnZurueck.insets = new Insets(0, 10, 0, 10);
		gbc_btnZurueck.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnZurueck.gridx = 1;
		gbc_btnZurueck.gridy = 0;
		this.panel_button.add(this.btnZurueck, gbc_btnZurueck);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(btnFachuebersicht.getActionCommand())) // Abfrage auf Dr�cken des Login-Buttons "button_Login"
		{
			Dialog_NotenausgabeKlasse dlg_notenausgabeKlasse = new Dialog_NotenausgabeKlasse(lehrer,(Klasse)comboBox_Klassen.getSelectedItem(),(Unterrichtsfach)comboBox_Faecher.getSelectedItem());
			dlg_notenausgabeKlasse.setVisible(true);
		}		
		if(e.getActionCommand().equals(btnZurueck.getActionCommand())) // Abfrage auf Dr�cken des Login-Buttons "button_Login"
		{
			this.dispose();
			Dialog_Login dlg_login = new Dialog_Login();
			dlg_login.setVisible(true);
		}
		if(e.getActionCommand().equals(btnKlassenuebersicht.getActionCommand())) // Abfrage ob 
		{
			
		}
	}
	public void itemStateChanged(ItemEvent arg0) 
	{
		comboBox_Faecher.removeAllItems();
		comboBox_Klassen.removeAllItems();
		comboBox_Klassen.setEnabled(true);
		btnFachuebersicht.setEnabled(false);
		
		for(Klasse k:Klasse.AlleLesen(lehrer, (Schule)comboBox_Schule.getSelectedItem()))
		{
			this.comboBox_Klassen.addItem(k);		
		}				
		
		if(comboBox_Klassen.getSelectedItem() != null)
		{
			comboBox_Faecher.setEnabled(true);
			for(Unterrichtsfach f : Unterrichtsfach.AlleLesen(lehrer, (Klasse)comboBox_Klassen.getSelectedItem()))
			{
				this.comboBox_Faecher.addItem(f);
			}			
		}
		if(comboBox_Faecher.getSelectedItem() != null)
		{
			btnFachuebersicht.setEnabled(true);
		}
	}
}
