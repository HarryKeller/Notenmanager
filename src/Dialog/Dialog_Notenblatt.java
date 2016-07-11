package Dialog;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;














import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Fachklassen.Leistung;
import Fachklassen.Schueler;
import Fachklassen.Unterrichtsfach;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dialog_Notenblatt extends JFrame implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_schueler;
	private JTextField txt_klasse;
	private JTextField txt_lehrer;
	Schueler schueler;
	private JTable notentabelle;
	private DefaultTableModel model = new DefaultTableModel();
	Dialog_Schuelerwahl schuelerwahl;
	private DefaultTableModel model_notentabelle;
	public final static LocalDate BEGINN_SCHULJAHR = LocalDate.parse("2015-09-01");
	public final static LocalDate BEGINN_HALBJAHR = LocalDate.parse("2016-02-25");
	public final static LocalDate ENDE_SCHULJAHR = LocalDate.parse("2016-08-01");

	public Dialog_Notenblatt(Schueler schueler, Dialog_Schuelerwahl Schuelerwahl) 
	{
		this.schueler = schueler;
		this.schuelerwahl = Schuelerwahl;
		setTitle("Notenblatt");
		initGUI();
		this.setDatenInMaske();	
	}
	private void initGUI() {
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 424, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 0, 5);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblSchlerin = new JLabel("Sch\u00FCler/in");
					GridBagConstraints gbc_lblSchlerin = new GridBagConstraints();
					gbc_lblSchlerin.insets = new Insets(0, 0, 5, 5);
					gbc_lblSchlerin.gridx = 0;
					gbc_lblSchlerin.gridy = 0;
					panel_1.add(lblSchlerin, gbc_lblSchlerin);
				}
				{
					txt_schueler = new JTextField();
					txt_schueler.setEditable(false);
					GridBagConstraints gbc_txt_schueler = new GridBagConstraints();
					gbc_txt_schueler.fill = GridBagConstraints.HORIZONTAL;
					gbc_txt_schueler.insets = new Insets(0, 0, 5, 0);
					gbc_txt_schueler.gridx = 1;
					gbc_txt_schueler.gridy = 0;
					panel_1.add(txt_schueler, gbc_txt_schueler);
					txt_schueler.setColumns(10);
				}
				{
					JLabel lblKlasse = new JLabel("Klasse");
					GridBagConstraints gbc_lblKlasse = new GridBagConstraints();
					gbc_lblKlasse.insets = new Insets(0, 0, 0, 5);
					gbc_lblKlasse.gridx = 0;
					gbc_lblKlasse.gridy = 1;
					panel_1.add(lblKlasse, gbc_lblKlasse);
				}
				{
					txt_klasse = new JTextField();
					txt_klasse.setEditable(false);
					GridBagConstraints gbc_txt_klasse = new GridBagConstraints();
					gbc_txt_klasse.fill = GridBagConstraints.HORIZONTAL;
					gbc_txt_klasse.gridx = 1;
					gbc_txt_klasse.gridy = 1;
					panel_1.add(txt_klasse, gbc_txt_klasse);
					txt_klasse.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblLehrer = new JLabel("Klassenleiter");
					GridBagConstraints gbc_lblLehrer = new GridBagConstraints();
					gbc_lblLehrer.insets = new Insets(0, 0, 0, 5);
					gbc_lblLehrer.anchor = GridBagConstraints.EAST;
					gbc_lblLehrer.gridx = 0;
					gbc_lblLehrer.gridy = 0;
					panel_1.add(lblLehrer, gbc_lblLehrer);
				}
				{
					txt_lehrer = new JTextField();
					txt_lehrer.setEditable(false);
					GridBagConstraints gbc_txt_lehrer = new GridBagConstraints();
					gbc_txt_lehrer.fill = GridBagConstraints.HORIZONTAL;
					gbc_txt_lehrer.gridx = 1;
					gbc_txt_lehrer.gridy = 0;
					panel_1.add(txt_lehrer, gbc_txt_lehrer);
					txt_lehrer.setColumns(10);
				}
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
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 0;
				panel.add(scrollPane, gbc_scrollPane);
				{
					notentabelle = new JTable();
					this.model_notentabelle = new DefaultTableModel();
					this.notentabelle.setModel(this.model_notentabelle);
					model.addColumn("Fach");
					model.addColumn("mündlich (1. Halbjahr)");
					model.addColumn("mündlich (2. Halbjahr)");
					model.addColumn("schriftlich (1. Halbjahr)");
					model.addColumn("schriftlich (2. Halbjahr)");
					notentabelle.setModel(model);
					scrollPane.setViewportView(notentabelle);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 0, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JButton btnZurck = new JButton("Zur\u00FCck");
				btnZurck.addActionListener(this);
				GridBagConstraints gbc_btnZurck = new GridBagConstraints();
				gbc_btnZurck.insets = new Insets(0, 0, 0, 5);
				gbc_btnZurck.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnZurck.gridx = 0;
				gbc_btnZurck.gridy = 0;
				panel.add(btnZurck, gbc_btnZurck);
			}
			{
				JButton btnNotenblattDrucken = new JButton("Notenblatt drucken");
				GridBagConstraints gbc_btnNotenblattDrucken = new GridBagConstraints();
				gbc_btnNotenblattDrucken.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnNotenblattDrucken.gridx = 1;
				gbc_btnNotenblattDrucken.gridy = 0;
				panel.add(btnNotenblattDrucken, gbc_btnNotenblattDrucken);
			}
		}
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
		this.txt_schueler.setText(this.schueler.getNachname()+" "+this.schueler.getVorname());
		this.txt_klasse.setText(this.schueler.getKlasseid().getBez());
		this.txt_lehrer.setText(this.schueler.getKlasseid().getIdKlassenleiter().getNachname()+ " " + this.schueler.getKlasseid().getIdKlassenleiter().getVorname());
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
		//Sortier ArrayListen anlegen

		for(Unterrichtsfach f : fach)
		{
//			ArrayList<Leistung> muendlicherstes = (this.schueler.getMuendlich(f, this.BEGINN_SCHULJAHR,this.BEGINN_HALBJAHR));
//			ArrayList<Leistung> muendlichzweites = (this.schueler.getMuendlich(f, this.BEGINN_HALBJAHR,this.ENDE_SCHULJAHR));
//			ArrayList<Leistung> schriftlicherstes = (this.schueler.getSchriftlich(f, this.BEGINN_SCHULJAHR,this.BEGINN_HALBJAHR));
//			ArrayList<Leistung> schriftlichzweites = (this.schueler.getSchriftlich(f, this.BEGINN_HALBJAHR,this.ENDE_SCHULJAHR));
			for (Leistung l : this.schueler.getMuendlich(f, this.BEGINN_SCHULJAHR,this.BEGINN_HALBJAHR))
			{
				//KEINEN PLAN!
			}

		}
	}

}
