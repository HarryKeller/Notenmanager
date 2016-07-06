package Dialog;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

import Fachklassen.Klasse;
import Fachklassen.Lehrer;
import Fachklassen.Leistung;
import Fachklassen.Schueler;
import Fachklassen.Unterrichtsfach;
import Persistenz.DBZugriff;

import java.util.*;

public class Dialog_NotenausgabeKlasse extends JFrame implements ActionListener {

	private static DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(
													   Locale.GERMAN);

	public final static LocalDate BEGINN_SCHULJAHR = LocalDate.parse("01.09.2015",germanFormatter);
	public final static LocalDate BEGINN_HALBJAHR = LocalDate.parse("01.02.2016",germanFormatter);
	public final static LocalDate ENDE_SCHULJAHR = LocalDate.parse("01.08.2016",germanFormatter);
	
	private Lehrer lehrer;
	private Klasse klasse;
	private Unterrichtsfach fach;
	
	private JPanel panel_head;
	private JLabel _label;
	private JTextField textField_LehrerIn;
	private JLabel _label_1;
	private JTextField textField_Klasse;
	private JLabel _label_2;
	private JTextField textField_Fach;
	private JPanel panel_buttons;
	private JButton btn_zurueck;
	private JButton btn_neuespalte;
	private JButton btn_aendern;
	private JButton btn_verwerfen;
	private JTabbedPane _tabbedPane;
	private JPanel tab1_contentPanel;
	private JPanel panel_tab1_muendl;
	private JPanel panel_tab1_schriftl;
	private JPanel _panel;
	private JPanel _panel_1;	
	private JScrollPane _scrollPane;	
	private JScrollPane _scrollPane_1;	
	private JPanel tab2_contentPanel;
	private JPanel _panel_3;
	private JPanel _panel_5;
	private JPanel _panel_6;	
	private JScrollPane _scrollPane_3;	
	private JScrollPane _scrollPane_2;	
	
	private NotenTable table_tab1_muendl;
	private NotenTable table_tab1_schriftl;
	private NotenTable table_tab2_muendl;
	private NotenTable table_tab2_schriftl;
	
	private DefaultTableModel model_tab1_muendlich;
	private DefaultTableModel model_tab1_schriftl;
	private DefaultTableModel model_tab2_muendlich;
	private DefaultTableModel model_tab2_schriftl;
	
	public Dialog_NotenausgabeKlasse() {
		
		initGUI();
	}
	
	public Dialog_NotenausgabeKlasse(Lehrer l, Klasse k, Unterrichtsfach f)
	{
		this.setExtendedState(MAXIMIZED_BOTH);
		
		this.lehrer = l;
		this.klasse = k;
		this.fach = f;
		
		initGUI();
		
		this.setDatenInMaske();
	}
	
	private void initGUI() {
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		this.panel_head = new JPanel();
		GridBagConstraints gbc_panel_head = new GridBagConstraints();
		gbc_panel_head.anchor = GridBagConstraints.NORTH;
		gbc_panel_head.insets = new Insets(0, 0, 5, 0);
		gbc_panel_head.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_head.gridx = 0;
		gbc_panel_head.gridy = 0;
		getContentPane().add(this.panel_head, gbc_panel_head);
		GridBagLayout gbl_panel_head = new GridBagLayout();
		gbl_panel_head.columnWidths = new int[]{0, 0, 0};
		gbl_panel_head.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_head.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_head.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panel_head.setLayout(gbl_panel_head);
		
		this._label = new JLabel("Lehrer:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		this.panel_head.add(this._label, gbc_label);
		
		this.textField_LehrerIn = new JTextField();
		this.textField_LehrerIn.setEditable(false);
		GridBagConstraints gbc_textField_LehrerIn = new GridBagConstraints();
		gbc_textField_LehrerIn.insets = new Insets(0, 0, 5, 0);
		gbc_textField_LehrerIn.anchor = GridBagConstraints.WEST;
		gbc_textField_LehrerIn.gridx = 1;
		gbc_textField_LehrerIn.gridy = 0;
		this.panel_head.add(this.textField_LehrerIn, gbc_textField_LehrerIn);
		this.textField_LehrerIn.setColumns(10);
		
		this._label_1 = new JLabel("Klasse: ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		this.panel_head.add(this._label_1, gbc_label_1);
		
		this.textField_Klasse = new JTextField();
		this.textField_Klasse.setEditable(false);
		GridBagConstraints gbc_textField_Klasse = new GridBagConstraints();
		gbc_textField_Klasse.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Klasse.anchor = GridBagConstraints.WEST;
		gbc_textField_Klasse.gridx = 1;
		gbc_textField_Klasse.gridy = 1;
		this.panel_head.add(this.textField_Klasse, gbc_textField_Klasse);
		this.textField_Klasse.setColumns(10);
		
		this._label_2 = new JLabel("Fach: ");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		this.panel_head.add(this._label_2, gbc_label_2);
		
		this.textField_Fach = new JTextField();
		this.textField_Fach.setEditable(false);
		GridBagConstraints gbc_textField_Fach = new GridBagConstraints();
		gbc_textField_Fach.anchor = GridBagConstraints.WEST;
		gbc_textField_Fach.gridx = 1;
		gbc_textField_Fach.gridy = 2;
		this.panel_head.add(this.textField_Fach, gbc_textField_Fach);
		this.textField_Fach.setColumns(10);
		
		this._tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		getContentPane().add(this._tabbedPane, gbc_tabbedPane);
		
		this.tab1_contentPanel = new JPanel();
		this._tabbedPane.addTab("Erstes Halbjahr", null, this.tab1_contentPanel, null);
		GridBagLayout gbl_tab1_contentPanel = new GridBagLayout();
		gbl_tab1_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_tab1_contentPanel.rowHeights = new int[]{0, 0};
		gbl_tab1_contentPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_tab1_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.tab1_contentPanel.setLayout(gbl_tab1_contentPanel);
		
		this._panel = new JPanel();
		this._panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "M\u00FCndlich", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.tab1_contentPanel.add(this._panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this._panel.setLayout(gbl_panel);
		
		this.panel_tab1_muendl = new JPanel();
		GridBagConstraints gbc_panel_tab1_muendl = new GridBagConstraints();
		gbc_panel_tab1_muendl.fill = GridBagConstraints.BOTH;
		gbc_panel_tab1_muendl.gridx = 0;
		gbc_panel_tab1_muendl.gridy = 0;
		this._panel.add(this.panel_tab1_muendl, gbc_panel_tab1_muendl);
		GridBagLayout gbl_panel_tab1_muendl = new GridBagLayout();
		gbl_panel_tab1_muendl.columnWidths = new int[]{0, 0};
		gbl_panel_tab1_muendl.rowHeights = new int[]{0, 0};
		gbl_panel_tab1_muendl.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_tab1_muendl.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.panel_tab1_muendl.setLayout(gbl_panel_tab1_muendl);
		
		this._scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		this.panel_tab1_muendl.add(this._scrollPane, gbc_scrollPane);
		
		this.table_tab1_muendl = new NotenTable();		
		this.model_tab1_muendlich = new DefaultTableModel();
		this.table_tab1_muendl.setModel(this.model_tab1_muendlich);
		this._scrollPane.setViewportView(this.table_tab1_muendl);
		
		this._panel_1 = new JPanel();
		this._panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Schriftlich", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		this.tab1_contentPanel.add(this._panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this._panel_1.setLayout(gbl_panel_1);
		
		this.panel_tab1_schriftl = new JPanel();
		GridBagConstraints gbc_panel_tab1_schriftl = new GridBagConstraints();
		gbc_panel_tab1_schriftl.fill = GridBagConstraints.BOTH;
		gbc_panel_tab1_schriftl.gridx = 0;
		gbc_panel_tab1_schriftl.gridy = 0;
		this._panel_1.add(this.panel_tab1_schriftl, gbc_panel_tab1_schriftl);
		GridBagLayout gbl_panel_tab1_schriftl = new GridBagLayout();
		gbl_panel_tab1_schriftl.columnWidths = new int[]{0, 0};
		gbl_panel_tab1_schriftl.rowHeights = new int[]{0, 0};
		gbl_panel_tab1_schriftl.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_tab1_schriftl.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.panel_tab1_schriftl.setLayout(gbl_panel_tab1_schriftl);
		
		this._scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		this.panel_tab1_schriftl.add(this._scrollPane_1, gbc_scrollPane_1);
		
		this.table_tab1_schriftl = new NotenTable();
		this.model_tab1_schriftl = new DefaultTableModel();
		this.table_tab1_schriftl.setModel(this.model_tab1_schriftl);
		this._scrollPane_1.setViewportView(this.table_tab1_schriftl);
		
		this.tab2_contentPanel = new JPanel();
		this._tabbedPane.addTab("Zweites Halbjahr", null, this.tab2_contentPanel, null);
		GridBagLayout gbl_tab2_contentPanel = new GridBagLayout();
		gbl_tab2_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_tab2_contentPanel.rowHeights = new int[]{0, 0};
		gbl_tab2_contentPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_tab2_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.tab2_contentPanel.setLayout(gbl_tab2_contentPanel);
		
		this._panel_5 = new JPanel();
		this._panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "M\u00FCndlich", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.weighty = 50.0;
		gbc_panel_5.weightx = 50.0;
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		this.tab2_contentPanel.add(this._panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this._panel_5.setLayout(gbl_panel_5);
		
		this._panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.weighty = 50.0;
		gbc_panel_3.weightx = 50.0;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		this._panel_5.add(this._panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this._panel_3.setLayout(gbl_panel_3);
		
		this._scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 0;
		this._panel_3.add(this._scrollPane_3, gbc_scrollPane_3);
		
		this.table_tab2_muendl = new NotenTable();
		this.model_tab2_muendlich = new DefaultTableModel();
		this.table_tab2_muendl.setModel(model_tab2_muendlich);
		this._scrollPane_3.setViewportView(this.table_tab2_muendl);
		
		this._panel_6 = new JPanel();
		this._panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Schriftlich", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.weightx = 50.0;
		gbc_panel_6.weighty = 50.0;
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 0;
		this.tab2_contentPanel.add(this._panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this._panel_6.setLayout(gbl_panel_6);
		
		this._scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 0;
		this._panel_6.add(this._scrollPane_2, gbc_scrollPane_2);
		
		this.table_tab2_schriftl = new NotenTable();
		this.model_tab2_schriftl = new DefaultTableModel();
		this.table_tab2_schriftl.setModel(model_tab2_schriftl);
		this._scrollPane_2.setViewportView(this.table_tab2_schriftl);
		
		this.panel_buttons = new JPanel();
		GridBagConstraints gbc_panel_buttons = new GridBagConstraints();
		gbc_panel_buttons.anchor = GridBagConstraints.SOUTH;
		gbc_panel_buttons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_buttons.gridx = 0;
		gbc_panel_buttons.gridy = 2;
		getContentPane().add(this.panel_buttons, gbc_panel_buttons);
		
		this.btn_zurueck = new JButton("Zur\u00FCck");
		this.btn_zurueck.addActionListener(this);
		this.panel_buttons.add(this.btn_zurueck);
		
		this.btn_neuespalte = new JButton("Spalte anlegen");
		this.btn_neuespalte.addActionListener(this);
		this.panel_buttons.add(this.btn_neuespalte);
		
		this.btn_aendern = new JButton("Spalte \u00E4ndern");
		this.btn_aendern.addActionListener(this);
		this.panel_buttons.add(this.btn_aendern);
		
		this.btn_verwerfen = new JButton("Verwerfen");
		this.btn_verwerfen.addActionListener(this);
		this.panel_buttons.add(this.btn_verwerfen);
	}
	
	//Prüft ob Spalten benötigt werden -1 = keine Spalte gefunden, 0 + aufwärts = Spaltenindex
	private int isColumnRequiered(NotenTableHeader header, Leistung l) 
	{		
		return header.findColumnWithTooltip(l.getErhebungsdatum().toString());
	}
	
	//Verarbeitungsmethoder für Leistungen in beliebige Tabelle setzen
	private void fillOneTable(NotenTableHeader header, DefaultTableModel model, ArrayList<Leistung> leistungen)
	{
		for(Leistung l : leistungen)
		{			
			int col = this.isColumnRequiered(header, l);
			
			if(col == -1)
			{					
				header.addColumnTooltip(l.getErhebungsdatum().toString());
				model.addColumn(l.getLeistungsart().getBez());		
				model.setValueAt(l.getNotenstufe(), model.getRowCount() - 1, 
																   model.getColumnCount() - 1);
			}	
			else if(col >= 0)
			{
				model.setValueAt(l.getNotenstufe(), model.getRowCount() - 1 , col);
			}				
		}	
	}
	
	//Tabellen mit Noten befüllen, geteilt nach Schriftl. & Mündl., Erstes & Zweites Halbjahr
	private void setGradesInTable()
	{
		
		//Vorbereitung der Tabellen
		NotenTableHeader header_tab1_muendl = (NotenTableHeader) this.table_tab1_muendl.getTableHeader();
		this.model_tab1_muendlich.addColumn("Name");
		header_tab1_muendl.addColumnTooltip("");
		this.model_tab1_muendlich.addColumn("Vorname");	
		header_tab1_muendl.addColumnTooltip("");
		
		NotenTableHeader header_tab1_schriftl = (NotenTableHeader) this.table_tab1_schriftl.getTableHeader();		
		this.model_tab1_schriftl.addColumn("Name");
		header_tab1_schriftl.addColumnTooltip("");
		this.model_tab1_schriftl.addColumn("Vorname");
		header_tab1_schriftl.addColumnTooltip("");
		
		NotenTableHeader header_tab2_muendl = (NotenTableHeader) this.table_tab2_muendl.getTableHeader();
		this.model_tab2_muendlich.addColumn("Name");
		header_tab2_muendl.addColumnTooltip("");
		this.model_tab2_muendlich.addColumn("Vorname");	
		header_tab2_muendl.addColumnTooltip("");
		
		NotenTableHeader header_tab2_schriftl = (NotenTableHeader) this.table_tab2_schriftl.getTableHeader();		
		this.model_tab2_schriftl.addColumn("Name");
		header_tab2_schriftl.addColumnTooltip("");
		this.model_tab2_schriftl.addColumn("Vorname");
		header_tab2_schriftl.addColumnTooltip("");
		
		//Abarbeitung der Schueler in der Klasse		
		Set<Schueler> schueler = this.klasse.getSchueler();
		
		for(Schueler s : schueler)
		{
			//Ersten beiden spalten für jede Tabelle anlegen mit jeweiligem Schüler namen
			Object[] rowData = {s.getNachname(),s.getVorname()};
			this.model_tab1_muendlich.addRow(rowData);
			this.model_tab1_schriftl.addRow(rowData);
			this.model_tab2_muendlich.addRow(rowData);
			this.model_tab2_schriftl.addRow(rowData);
			
			//Jede Tabelle mit Noten füllen
			this.fillOneTable(header_tab1_muendl, model_tab1_muendlich, s.getMuendlich(this.fach,this.BEGINN_SCHULJAHR, this.BEGINN_HALBJAHR));					
			this.fillOneTable(header_tab1_schriftl, model_tab1_schriftl, s.getSchriftlich(this.fach,this.BEGINN_SCHULJAHR, this.BEGINN_HALBJAHR));			
			this.fillOneTable(header_tab2_muendl, model_tab2_muendlich, s.getMuendlich(this.fach, this.BEGINN_HALBJAHR, this.ENDE_SCHULJAHR));			
			this.fillOneTable(header_tab2_schriftl, model_tab2_schriftl, s.getSchriftlich(this.fach, this.BEGINN_HALBJAHR, this.ENDE_SCHULJAHR));
		}
	}
	
	public void setDatenInMaske()
	{		
		this.textField_Fach.setText(this.fach.getBez());
		this.textField_Klasse.setText(this.klasse.getBez());
		this.textField_LehrerIn.setText(this.lehrer.getNachname());
		
		this.setGradesInTable();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btn_zurueck)
		{
			this.dispose();
		}
	}
}
