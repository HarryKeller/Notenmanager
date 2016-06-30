package Dialog;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.JComboBox;

import Fachklassen.*;
import Persistenz.DBZugriff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Dialog_Klassenauswahl extends JFrame implements ActionListener, ItemListener
{

	private final JPanel contentPanel = new JPanel();

	JComboBox<Klasse> comboBox_Klassen;
	JComboBox<Unterrichtsfach> comboBox_Faecher;
	
	JButton button_Fortfahren;
	JButton button_Zurueck;
	
	Klasse klasse = new Klasse();
	private JLabel lblSchuleauswahl;
	private JComboBox<Schule> comboBox_Schule;
	private Lehrer lehrer;

	/**
	 * Create the dialog.
	 */
	public Dialog_Klassenauswahl(Lehrer lehrer)
	{
		this.lehrer = lehrer; 
		initGUI();
		SetDatenInMaske();
	}
	private void initGUI() {
		setMinimumSize(new Dimension(450, 300));
		setTitle("Klassenauswahl");
		setBounds(100, 100, 450, 320);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{261, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 350, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 150, 50, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				lblSchuleauswahl = new JLabel("Schule (Auswahl)");
				lblSchuleauswahl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				GridBagConstraints gbc_lblSchuleauswahl = new GridBagConstraints();
				gbc_lblSchuleauswahl.insets = new Insets(0, 0, 5, 0);
				gbc_lblSchuleauswahl.gridx = 0;
				gbc_lblSchuleauswahl.gridy = 0;
				panel.add(lblSchuleauswahl, gbc_lblSchuleauswahl);
			}
			{
				comboBox_Schule = new JComboBox();
				this.comboBox_Schule.addItemListener(this);
				GridBagConstraints gbc_comboBox_Schule = new GridBagConstraints();
				gbc_comboBox_Schule.ipady = 10;
				gbc_comboBox_Schule.anchor = GridBagConstraints.NORTH;
				gbc_comboBox_Schule.insets = new Insets(0, 0, 5, 0);
				gbc_comboBox_Schule.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_Schule.gridx = 0;
				gbc_comboBox_Schule.gridy = 1;
				panel.add(comboBox_Schule, gbc_comboBox_Schule);
			}
			{
				JLabel lblKlassenauswahl = new JLabel("Klassen (Auswahl)");
				lblKlassenauswahl.setHorizontalAlignment(SwingConstants.CENTER);
				lblKlassenauswahl.setVerticalAlignment(SwingConstants.BOTTOM);
				lblKlassenauswahl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				GridBagConstraints gbc_lblKlassenauswahl = new GridBagConstraints();
				gbc_lblKlassenauswahl.insets = new Insets(0, 0, 5, 0);
				gbc_lblKlassenauswahl.gridx = 0;
				gbc_lblKlassenauswahl.gridy = 2;
				panel.add(lblKlassenauswahl, gbc_lblKlassenauswahl);
			}
			{
				comboBox_Klassen = new JComboBox();
				comboBox_Klassen.setEnabled(false);
				GridBagConstraints gbc_comboBox_Klassen = new GridBagConstraints();
				gbc_comboBox_Klassen.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_Klassen.anchor = GridBagConstraints.NORTH;
				gbc_comboBox_Klassen.ipady = 10;
				gbc_comboBox_Klassen.insets = new Insets(0, 0, 5, 0);
				gbc_comboBox_Klassen.gridx = 0;
				gbc_comboBox_Klassen.gridy = 3;
				panel.add(comboBox_Klassen, gbc_comboBox_Klassen);
			}
			{
				JLabel lblFcherauswahl = new JLabel("F\u00E4cher (Auswahl)");
				lblFcherauswahl.setHorizontalAlignment(SwingConstants.CENTER);
				lblFcherauswahl.setVerticalAlignment(SwingConstants.BOTTOM);
				lblFcherauswahl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				GridBagConstraints gbc_lblFcherauswahl = new GridBagConstraints();
				gbc_lblFcherauswahl.insets = new Insets(0, 0, 5, 0);
				gbc_lblFcherauswahl.gridx = 0;
				gbc_lblFcherauswahl.gridy = 4;
				panel.add(lblFcherauswahl, gbc_lblFcherauswahl);
			}
			{
				comboBox_Faecher = new JComboBox();
				comboBox_Faecher.setEnabled(false);
				GridBagConstraints gbc_comboBox_Faecher = new GridBagConstraints();
				gbc_comboBox_Faecher.anchor = GridBagConstraints.NORTH;
				gbc_comboBox_Faecher.ipady = 10;
				gbc_comboBox_Faecher.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_Faecher.gridx = 0;
				gbc_comboBox_Faecher.gridy = 5;
				panel.add(comboBox_Faecher, gbc_comboBox_Faecher);
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 2;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				button_Fortfahren = new JButton("Fortfahren");
				button_Fortfahren.addActionListener(this);
				GridBagConstraints gbc_button_Fortfahren = new GridBagConstraints();
				gbc_button_Fortfahren.insets = new Insets(0, 0, 0, 5);
				gbc_button_Fortfahren.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Fortfahren.gridx = 0;
				gbc_button_Fortfahren.gridy = 0;
				panel.add(button_Fortfahren, gbc_button_Fortfahren);
			}
			{
				button_Zurueck = new JButton("Zur\u00FCck");
				button_Zurueck.addActionListener(this);
				GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
				gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Zurueck.gridx = 1;
				gbc_button_Zurueck.gridy = 0;
				panel.add(button_Zurueck, gbc_button_Zurueck);
			}
		}
	}

	public void SetDatenInMaske()
	{			
		//Combobox für Schule füllen
		for(Schule s :Schule.alleLesen() )
		{
			comboBox_Schule.addItem(s);	
		}
						
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(button_Fortfahren.getActionCommand())) // Abfrage auf Drücken des Login-Buttons "button_Login"
		{
			Dialog_NotenausgabeKlasse dlg_notenausgabeKlasse = new Dialog_NotenausgabeKlasse(lehrer,(Klasse)comboBox_Klassen.getSelectedItem(),(Unterrichtsfach)comboBox_Faecher.getSelectedItem());
			dlg_notenausgabeKlasse.setVisible(true);
		}		
		if(e.getActionCommand().equals(button_Zurueck.getActionCommand())) // Abfrage auf Drücken des Login-Buttons "button_Login"
		{
			this.dispose();
			Dialog_Login dlg_login = new Dialog_Login();
			dlg_login.setVisible(true);
		}
//		if(e.getActionCommand().equals(comboBox_Klassen.getActionCommand())) // Abfrage auf Drücken des Login-Buttons "button_Login"
//		{
//			ArrayList<Unterrichtsfach> faecher = new ArrayList<Unterrichtsfach>();
//			DBZugriff.alleLesen("Unterrichtsfach", faecher, "");
//			for(Unterrichtsfach fach : faecher)
//			{
//				this.comboBox_Faecher.addItem(fach);
//			}
//			comboBox_Faecher.setEnabled(true);
//		}
//		if(e.getActionCommand().equals(comboBox_Schule.getActionCommand())) // Abfrage auf Drücken des Login-Buttons "button_Login"
//		{
//			for(Klasse klasse : Klasse.AlleLesen(new Lehrer(1), ((Schule)this.comboBox_Schule.getSelectedItem())))
//			{
//				this.comboBox_Klassen.addItem(klasse);
//			}
//		}
	}
	public void itemStateChanged(ItemEvent arg0) 
	{
		comboBox_Faecher.removeAllItems();
		comboBox_Klassen.removeAllItems();
		comboBox_Klassen.setEnabled(true);
		
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
	}
}
