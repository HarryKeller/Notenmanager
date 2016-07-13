package Dialog;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTable;

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

public class Dialog_Notenblatt extends JFrame implements ActionListener {
	Schueler schueler;
	Dialog_Schuelerwahl schuelerwahl;
	public final static LocalDate BEGINN_SCHULJAHR = LocalDate.parse("2015-09-01");
	public final static LocalDate BEGINN_HALBJAHR = LocalDate.parse("2016-02-25");
	public final static LocalDate ENDE_SCHULJAHR = LocalDate.parse("2016-08-01");
	private JLabel lblNotenblattDesSchlers;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblSchler;

	public Dialog_Notenblatt(Schueler schueler, Dialog_Schuelerwahl Schuelerwahl) 
	{
		getContentPane().setForeground(new Color(0, 128, 128));
		getContentPane().setFont(new Font("Nirmala UI Semilight", Font.BOLD, 23));
		this.schueler = schueler;
		this.schuelerwahl = Schuelerwahl;
		setTitle("Notenblatt");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		lblNotenblattDesSchlers.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 23));
		GridBagConstraints gbc_lblNotenblattDesSchlers = new GridBagConstraints();
		gbc_lblNotenblattDesSchlers.fill = GridBagConstraints.VERTICAL;
		gbc_lblNotenblattDesSchlers.anchor = GridBagConstraints.EAST;
		gbc_lblNotenblattDesSchlers.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotenblattDesSchlers.gridx = 1;
		gbc_lblNotenblattDesSchlers.gridy = 1;
		getContentPane().add(lblNotenblattDesSchlers, gbc_lblNotenblattDesSchlers);
		
		lblSchler = new JLabel("Sch\u00FCler");
		lblSchler.setForeground(new Color(0, 128, 128));
		lblSchler.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 23));
		GridBagConstraints gbc_lblSchler = new GridBagConstraints();
		gbc_lblSchler.fill = GridBagConstraints.VERTICAL;
		gbc_lblSchler.anchor = GridBagConstraints.WEST;
		gbc_lblSchler.insets = new Insets(0, 0, 5, 0);
		gbc_lblSchler.gridx = 2;
		gbc_lblSchler.gridy = 1;
		getContentPane().add(lblSchler, gbc_lblSchler);
	
		initGUI();
		this.setDatenInMaske();	
	}
	private void initGUI() {
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
	}
		
	public void actionPerformed(ActionEvent e) 
	{
		String action = e.getActionCommand();
		if(action.equals("Zurück"))
		{
			this.schuelerwahl.setVisible(true);
			this.dispose();
		}
	}
	private void setDatenInMaske()
	{
//		this.txt_schueler.setText(this.schueler.getNachname()+" "+this.schueler.getVorname());
//		this.txt_klasse.setText(this.schueler.getKlasseid().getBez());
//		this.txt_lehrer.setText(this.schueler.getKlasseid().getIdKlassenleiter().getNachname()+ " " + this.schueler.getKlasseid().getIdKlassenleiter().getVorname());
		filltable();
	}
	private void filltable()
	{			
		//Alle Noten Lesen
		ArrayList<Leistung> grades = Leistung.AlleLesen();
		//Alle Noten vom Schüler herausfiltern
		for(Leistung l : grades)
		{
			if(l.getSchueler().getId() != this.schueler.getId())
			{
       		    grades.remove(l.getSchueler());
			}
		}
		//Array mit Fächern füllen
		ArrayList<Unterrichtsfach> fach = Unterrichtsfach.AlleLesen();

		String[] spaltenNamen = { "Fach", "Mündlich 1. Halbjahr", "Mündlich 2. Halbjahr", "Schriftlich 1. Halbjahr", "Schriftlich 2. Halbjahr"};
		String[] zeile = new String[5];
		int i = 0;
		Object[][] daten = new Object[fach.size()][5];
		for(Unterrichtsfach f : fach)
		{
			zeile[0] = "";
			zeile[1] = "";
			zeile[2] = "";
			zeile[3] = "";
			zeile[4] = "";
			zeile[0] = f.getBez();
			for(Leistung l : grades)
			{
				if(f.getId() == l.getUfachlehrer().getUfach().getId())
				{
					if(l.getErhebungsdatum().isBefore(BEGINN_HALBJAHR))
					{
						if(l.getLeistungsart().getGewichtung() == 1)
						{
							zeile[1] += ""+l.getNotenstufe()+", ";
						}
						else if(l.getLeistungsart().getGewichtung() == 2)
						{
							zeile[3] += ""+l.getNotenstufe()+", ";
						}
					}
					else if(l.getErhebungsdatum().isAfter(BEGINN_HALBJAHR))
					{
						if(l.getLeistungsart().getGewichtung() == 1)
						{
							zeile[2] += ""+l.getNotenstufe()+", ";
						}
						else if(l.getLeistungsart().getGewichtung() == 2)
						{
							zeile[4] += ""+l.getNotenstufe()+", ";
						}
					}
				}
			}
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
		JTable table = new JTable(daten, spaltenNamen);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 2;
		getContentPane().add(table, gbc_table);
	}

}
