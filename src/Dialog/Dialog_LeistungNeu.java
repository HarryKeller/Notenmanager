package Dialog;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Fachklassen.Leistung;
import Fachklassen.Leistungsart;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Dialog_LeistungNeu extends JDialog implements ActionListener, ItemListener
{	
	private JLabel lbl_tables;
	private JComboBox cmbbox_tables;
	private JLabel _label;
	private JComboBox cmbBox_Leistungsart;
	private JLabel _label_1;
	private JTextField txt_erhebungsdatum;
	private JPanel panel_buttons;
	private JButton btn_anlegen;
	private JButton btn_abbrechen;
	private JButton btn_verwerfen;
	private Dialog_NotenausgabeKlasse notenausgabe;
	
	private DefaultComboBoxModel model_tables;
	private DefaultComboBoxModel model_leistungsart;	
	
	public Dialog_LeistungNeu(Dialog_NotenausgabeKlasse n)
	{		
		this.notenausgabe = n;
		initGUI();
		
		this.setTitle("Leistung ändern");
		this.setDateninMaske();		
		
	}
	private void initGUI() {		
		setBounds(100, 100, 450, 300);
		
		this.setModal(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		this.lbl_tables = new JLabel("Art/Halbjahr (Auswahl)");
		this.lbl_tables.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_tables = new GridBagConstraints();
		gbc_lbl_tables.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_tables.gridx = 0;
		gbc_lbl_tables.gridy = 0;
		getContentPane().add(this.lbl_tables, gbc_lbl_tables);
		
		this.cmbbox_tables = new JComboBox();				
		this.model_tables = new DefaultComboBoxModel();
		this.cmbbox_tables.setModel(this.model_tables);
		GridBagConstraints gbc_cmbbox_tables = new GridBagConstraints();
		gbc_cmbbox_tables.insets = new Insets(0, 0, 5, 0);
		gbc_cmbbox_tables.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbbox_tables.gridx = 0;
		gbc_cmbbox_tables.gridy = 1;
		getContentPane().add(this.cmbbox_tables, gbc_cmbbox_tables);
		
		this._label = new JLabel("Leistungsart (Auswahl)");
		this._label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 3;
		getContentPane().add(this._label, gbc_label);
		
		this.cmbBox_Leistungsart = new JComboBox();
		this.model_leistungsart = new DefaultComboBoxModel();
		this.cmbBox_Leistungsart.setModel(this.model_leistungsart);
		GridBagConstraints gbc_cmbBox_Leistungsart = new GridBagConstraints();
		gbc_cmbBox_Leistungsart.insets = new Insets(0, 0, 5, 0);
		gbc_cmbBox_Leistungsart.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbBox_Leistungsart.gridx = 0;
		gbc_cmbBox_Leistungsart.gridy = 4;
		getContentPane().add(this.cmbBox_Leistungsart, gbc_cmbBox_Leistungsart);		
		
		this.cmbbox_tables.addItemListener(this);
		
		this._label_1 = new JLabel("Erhebungsdatum (Eingabe)");
		this._label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 6;
		getContentPane().add(this._label_1, gbc_label_1);
		
		this.txt_erhebungsdatum = new JTextField();
		GridBagConstraints gbc_txt_erhebungsdatum = new GridBagConstraints();
		gbc_txt_erhebungsdatum.insets = new Insets(0, 0, 5, 0);
		gbc_txt_erhebungsdatum.anchor = GridBagConstraints.NORTH;
		gbc_txt_erhebungsdatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_erhebungsdatum.gridx = 0;
		gbc_txt_erhebungsdatum.gridy = 7;
		getContentPane().add(this.txt_erhebungsdatum, gbc_txt_erhebungsdatum);
		this.txt_erhebungsdatum.setColumns(10);
		
		this.panel_buttons = new JPanel();
		GridBagConstraints gbc_panel_buttons = new GridBagConstraints();
		gbc_panel_buttons.anchor = GridBagConstraints.SOUTH;
		gbc_panel_buttons.gridx = 0;
		gbc_panel_buttons.gridy = 8;
		getContentPane().add(this.panel_buttons, gbc_panel_buttons);
		GridBagLayout gbl_panel_buttons = new GridBagLayout();
		gbl_panel_buttons.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_buttons.rowHeights = new int[]{0, 0};
		gbl_panel_buttons.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_buttons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.panel_buttons.setLayout(gbl_panel_buttons);
		
		this.btn_anlegen = new JButton("Anlegen");
		this.btn_anlegen.addActionListener(this);
		GridBagConstraints gbc_btn_anlegen = new GridBagConstraints();
		gbc_btn_anlegen.insets = new Insets(0, 0, 0, 5);
		gbc_btn_anlegen.gridx = 0;
		gbc_btn_anlegen.gridy = 0;
		this.panel_buttons.add(this.btn_anlegen, gbc_btn_anlegen);
		
		this.btn_abbrechen = new JButton("Abbrechen");
		this.btn_abbrechen.addActionListener(this);
		GridBagConstraints gbc_btn_abbrechen = new GridBagConstraints();
		gbc_btn_abbrechen.insets = new Insets(0, 0, 0, 5);
		gbc_btn_abbrechen.gridx = 1;
		gbc_btn_abbrechen.gridy = 0;
		this.panel_buttons.add(this.btn_abbrechen, gbc_btn_abbrechen);
		
		this.btn_verwerfen = new JButton("Verwerfen");
		this.btn_verwerfen.addActionListener(this);
		GridBagConstraints gbc_btn_verwerfen = new GridBagConstraints();
		gbc_btn_verwerfen.gridx = 2;
		gbc_btn_verwerfen.gridy = 0;
		this.panel_buttons.add(this.btn_verwerfen, gbc_btn_verwerfen);
	}
	
	private void setDateninMaske()
	{
		this.model_tables.addElement("Erstes Halbjahr/Mündlich");
		this.model_tables.addElement("Erstes Halbjahr/Schriftlich");
		this.model_tables.addElement("Zweites Halbjahr/Mündlich");
		this.model_tables.addElement("Zweites Halbjahr/Schriftlich");
		
		for(Leistungsart l: Leistungsart.AlleLesen())
		{
			this.model_leistungsart.addElement(l.getBez());
		}		
		
		this.txt_erhebungsdatum.setText(LocalDate.now().toString());
	}
	
	private void getDatenAusMaske()
	{
		int i = this.cmbbox_tables.getSelectedIndex();
		
		NotenTableModel model;
		NotenTableHeader header;
		String s = this.txt_erhebungsdatum.getText();
		
		if(s.length() != 10)
		{
			JOptionPane.showMessageDialog(this, "Fehlerhafte eingabe des Datums! "
											  + "Bitte überprüfen Sie ob das Format yyyy-mm-tt ist.");				
		}
		
		if(i == 0)
		{
			model = (NotenTableModel) this.notenausgabe.table_tab1_muendl.getModel();
			model.addColumn((String) this.cmbBox_Leistungsart.getSelectedItem());
			header = (NotenTableHeader) this.notenausgabe.table_tab1_muendl.getTableHeader();
			header.addColumnTooltip(this.txt_erhebungsdatum.getText());		
			
			for(Vector<Object> v : model.getSaveVector())
			{
				Leistung l = new Leistung();
				
				l.setNotenstufe(0);
				l.setTendenz('o');
				v.add(l);
			}
		}
		else if(i == 1)
		{
			model = (NotenTableModel) this.notenausgabe.table_tab1_schriftl.getModel();
			model.addColumn((String) this.cmbBox_Leistungsart.getSelectedItem());
			header = (NotenTableHeader) this.notenausgabe.table_tab1_schriftl.getTableHeader();
			header.addColumnTooltip(this.txt_erhebungsdatum.getText());
			
			for(Vector<Object> v : model.getSaveVector())
			{
				Leistung l = new Leistung();
				
				l.setNotenstufe(0);
				l.setTendenz('o');
				v.add(l);
			}
		}
		else if(i == 2)
		{
			model = (NotenTableModel) this.notenausgabe.table_tab2_muendl.getModel();
			model.addColumn((String) this.cmbBox_Leistungsart.getSelectedItem());
			header = (NotenTableHeader) this.notenausgabe.table_tab2_muendl.getTableHeader();
			header.addColumnTooltip(this.txt_erhebungsdatum.getText());
			
			for(Vector<Object> v : model.getSaveVector())
			{
				Leistung l = new Leistung();
				
				l.setNotenstufe(0);
				l.setTendenz('o');
				v.add(l);
			}
		}
		else if(i == 3)
		{
			model = (NotenTableModel) this.notenausgabe.table_tab2_schriftl.getModel();
			model.addColumn((String) this.cmbBox_Leistungsart.getSelectedItem());
			header = (NotenTableHeader) this.notenausgabe.table_tab2_schriftl.getTableHeader();
			header.addColumnTooltip(this.txt_erhebungsdatum.getText());
			
			for(Vector<Object> v : model.getSaveVector())
			{
				Leistung l = new Leistung();
				
				l.setNotenstufe(0);
				l.setTendenz('o');
				v.add(l);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btn_abbrechen)
		{
			this.dispose();
		}
		else if(e.getSource() == this.btn_anlegen)
		{
			this.getDatenAusMaske();
			this.dispose();
		}
	}
	
	public void itemStateChanged(ItemEvent arg0) 
	{
		char c = ' ';
		
		//Mündliche noten ausgewählt
		if(this.cmbbox_tables.getSelectedIndex() == 0 || this.cmbbox_tables.getSelectedIndex() == 2)			
			c = 'M';
		else if(this.cmbbox_tables.getSelectedIndex() == 1 || this.cmbbox_tables.getSelectedIndex() == 3)
			c = 'S';
		
		this.model_leistungsart.removeAllElements();
		for(Leistungsart l: Leistungsart.AlleLesen())
		{
			if(l.getGruppe() == c)
			this.model_leistungsart.addElement(l.getBez());
		}
	}
}
