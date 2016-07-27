package Dialog;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTable;

import Fachklassen.DatumSJ;
import Fachklassen.Lehrer;
import Fachklassen.Leistung;
import Fachklassen.Schueler;
import Fachklassen.Unterrichtsfach;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.Font;

import javax.swing.JButton;

public class Dialog_Notenblatt extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Schueler schueler;
	private Lehrer lehrer;
	public DatumSJ date = new DatumSJ(LocalDate.now());
	private JLabel lblNotenblattDesSchlers;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblSchler;
	private JScrollPane scrollPane;
	private JButton btnNotenblattDrucken;
	private JButton btnZurck;
	private JLabel lbl_lehrer;
	private JLabel lbl_klasse;
	public ArrayList<Unterrichtsfach> fach = new ArrayList<Unterrichtsfach>();

	private Dialog_Notenblatt(Schueler schueler, Lehrer lehrer) 
	{
		//Fach-Array füllen und restliche Parameter in Klasse speichern
		fach = Unterrichtsfach.alleLesen(schueler);
		this.schueler = schueler;
		this.lehrer = lehrer;
		//GUI-Aufbauen
		initGUI();
		this.setDatenInMaske();	
	}
	private void initGUI() 
	{		
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		getContentPane().setForeground(new Color(0, 128, 128));
		getContentPane().setFont(new Font("Nirmala UI Semilight", Font.BOLD, 23));
		setTitle("Notenblatt");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		getContentPane().add(label, gbc_label);
		
		label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		getContentPane().add(label_1, gbc_label_1);
		
		lblNotenblattDesSchlers = new JLabel("Noten\u00FCbersicht von ");
		lblNotenblattDesSchlers.setForeground(Color.DARK_GRAY);
		lblNotenblattDesSchlers.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 30));
		GridBagConstraints gbc_lblNotenblattDesSchlers = new GridBagConstraints();
		gbc_lblNotenblattDesSchlers.fill = GridBagConstraints.VERTICAL;
		gbc_lblNotenblattDesSchlers.anchor = GridBagConstraints.EAST;
		gbc_lblNotenblattDesSchlers.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotenblattDesSchlers.gridx = 1;
		gbc_lblNotenblattDesSchlers.gridy = 1;
		getContentPane().add(lblNotenblattDesSchlers, gbc_lblNotenblattDesSchlers);
		
		lblSchler = new JLabel("Sch\u00FCler");
		lblSchler.setForeground(new Color(0, 128, 128));
		lblSchler.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 30));
		GridBagConstraints gbc_lblSchler = new GridBagConstraints();
		gbc_lblSchler.fill = GridBagConstraints.VERTICAL;
		gbc_lblSchler.anchor = GridBagConstraints.WEST;
		gbc_lblSchler.insets = new Insets(0, 0, 5, 0);
		gbc_lblSchler.gridx = 2;
		gbc_lblSchler.gridy = 1;
		getContentPane().add(lblSchler, gbc_lblSchler);
		lbl_lehrer = new JLabel("Lehrer:");
		lbl_lehrer.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 23));
		GridBagConstraints gbc_lbl_lehrer = new GridBagConstraints();
		gbc_lbl_lehrer.anchor = GridBagConstraints.WEST;
		gbc_lbl_lehrer.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_lehrer.gridx = 1;
		gbc_lbl_lehrer.gridy = 2;
		getContentPane().add(lbl_lehrer, gbc_lbl_lehrer);
		lbl_klasse = new JLabel("Klasse:");
		lbl_klasse.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 23));
		GridBagConstraints gbc_lbl_klasse = new GridBagConstraints();
		gbc_lbl_klasse.anchor = GridBagConstraints.WEST;
		gbc_lbl_klasse.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_klasse.gridx = 1;
		gbc_lbl_klasse.gridy = 3;
		getContentPane().add(lbl_klasse, gbc_lbl_klasse);
		btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(this);
		btnZurck.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 23));
		GridBagConstraints gbc_btnZurck = new GridBagConstraints();
		gbc_btnZurck.insets = new Insets(0, 0, 10, 0);
		gbc_btnZurck.gridx = 2;
		gbc_btnZurck.gridy = 5;
		getContentPane().add(btnZurck, gbc_btnZurck);
	}
		
	public void actionPerformed(ActionEvent e) 
	{
		//Button-Abfrage
		String action = e.getActionCommand();
		if(action.equals("Zurück"))
		{
			this.dispose();
		}
		else if(action.equals("noton"))
		{
			Dialog_Druckansicht.initGui(this);
			Dialog_Klassenauswahl.dlg_druckansicht.setVisible(true);
			this.setVisible(false);
		}
	}
	private void setDatenInMaske()
	{
		//Label mit Daten füllen
		this.lblSchler.setText(this.schueler.getNachname() + " " + this.schueler.getVorname());
		this.lbl_lehrer.setText("Lehrer: " + this.lehrer.getNachname() + " " + this.lehrer.getVorname());
		this.lbl_klasse.setText("Klasse: " + this.schueler.getKlasseid().getBez());
		filltable();
	}
	private void filltable()
	{			
		//Tabellenüberschriften erstellen (Multidimensionales String-Array)
		String[] spaltenNamen = { "Fach", "Mündlich 1. Halbjahr", "Schriftlich 1. Halbjahr", "Mündlich 2. Halbjahr", "Schriftlich 2. Halbjahr"};
		String[] zeile = new String[5];
		int i = 0;
		//Multidimensionales Object-Array erstellen, um Spalten der Tabelle zu füllen
		Object[][] daten = new Object[fach.size()][5];
		//Über jedes Fach schleifen
		for(Unterrichtsfach f : fach)
		{
			zeile[0] = "";
			zeile[1] = "";
			zeile[2] = "";
			zeile[3] = "";
			zeile[4] = "";
			zeile[0] = f.getBez();
			//Über jede Leistung, welche für den Schüler, bzw für das Fach vorhanden ist, schleifen
			for(Leistung l : Leistung.AlleLesen(schueler, f, date))
			{
				//Passendes Fach finden
				if(f.getId() == l.getUfachlehrer().getUfach().getId())
				{
					//Prüfen ob Note im ersten Halbjahr liegt
					if(l.getErhebungsdatum().isBefore(this.date.getHalbjahr()))
					{
						//Gewichtung prüfen
						if(l.getLeistungsart().getGewichtung() == 1)
						{
							zeile[1] += " | "+l.getNotenstufe()+" | ";
						}
						else if(l.getLeistungsart().getGewichtung() == 2)
						{
							zeile[2] += " | "+l.getNotenstufe()+" | ";
						}
					}
					//Prüfen ob Note im zweiten Halbjahr liegt
					else if(l.getErhebungsdatum().isAfter(this.date.getHalbjahr()))
					{
						//Gewichtung prüfen
						if(l.getLeistungsart().getGewichtung() == 1)
						{
							zeile[3] += " | "+l.getNotenstufe()+" | ";
						}
						else if(l.getLeistungsart().getGewichtung() == 2)
						{
							zeile[4] += " | "+l.getNotenstufe()+" | ";
						}
					}
				}
			}
			//Zeilen in Daten-Objekt speichern + Abfrage ob Noten vorhanden sind
			daten[i][0] = zeile[0];
			if(zeile[1] != "")
			{
				zeile[1].substring(0, zeile[1].length()-1);
			}
			daten[i][1] = zeile[1];
			if(zeile[2] != "")
			{
				zeile[2].substring(0, zeile[2].length()-1);
			}
			daten[i][2] = zeile[2];
			if(zeile[3] != "")
			{
				zeile[3].substring(0, zeile[3].length()-1);
			}
			daten[i][3] = zeile[3];
			if(zeile[4] != "")
			{
				zeile[4].substring(0, zeile[4].length()-1);
			}
			daten[i][4] = zeile[4];
			i++;
		}
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		getContentPane().add(scrollPane, gbc_scrollPane);
		JTable table = new JTable(daten,spaltenNamen);
		scrollPane.setViewportView(table);
		btnNotenblattDrucken = new JButton("Notenblatt Drucken");
		btnNotenblattDrucken.setActionCommand("noton");
		btnNotenblattDrucken.addActionListener(this);
		btnNotenblattDrucken.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 23));
		GridBagConstraints gbc_btnNotenblattDrucken = new GridBagConstraints();
		gbc_btnNotenblattDrucken.insets = new Insets(0, 0, 10, 5);
		gbc_btnNotenblattDrucken.gridx = 1;
		gbc_btnNotenblattDrucken.gridy = 5;
		getContentPane().add(btnNotenblattDrucken, gbc_btnNotenblattDrucken);
	}
	public static void initDialog (Schueler schueler, Lehrer lehrer)
	{
		if(Dialog_Klassenauswahl.dlg_Notenblatt == null)
		{
			Dialog_Klassenauswahl.dlg_Notenblatt = new Dialog_Notenblatt(schueler, lehrer);
		}
		Dialog_Klassenauswahl.dlg_Notenblatt.setVisible(true);
		Dialog_Klassenauswahl.dlg_Notenblatt.toFront();
	}
}
