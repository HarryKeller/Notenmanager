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

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Fachklassen.DatumSJ;
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
import java.util.Properties;
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
	private LocalDate erhebungsdatum;
	private JPanel panel_buttons;
	private JButton btn_anlegen;
	private JButton btn_abbrechen;	
	private Dialog_NotenausgabeKlasse notenausgabe;
	private JDatePickerImpl datePicker;
	
	private DefaultComboBoxModel model_tables;
	private DefaultComboBoxModel model_leistungsart;	
	
	private Dialog_LeistungNeu(Dialog_NotenausgabeKlasse n)
	{		
		this.notenausgabe = n;
		initGUI();
		
		this.setTitle("Leistung �ndern");
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
		
		this._label_1 = new JLabel("Erhebungsdatum (Datepicker)");
		this._label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 6;
		getContentPane().add(this._label_1, gbc_label_1);
		
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setText(LocalDate.now().toString());
		
		GridBagConstraints gbc_datepicker = new GridBagConstraints();
		gbc_datepicker.gridx = 0;
		gbc_datepicker.gridy = 7;
		gbc_datepicker.fill = GridBagConstraints.BOTH;
		gbc_datepicker.anchor = GridBagConstraints.NORTH;
		gbc_datepicker.insets = new Insets(0, 0, 5, 0);
		this.getContentPane().add(datePicker, gbc_datepicker);		
		
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
		
	}
	
	private void setDateninMaske()
	{
		this.model_tables.addElement("Erstes Halbjahr/M�ndlich");
		this.model_tables.addElement("Erstes Halbjahr/Schriftlich");
		this.model_tables.addElement("Zweites Halbjahr/M�ndlich");
		this.model_tables.addElement("Zweites Halbjahr/Schriftlich");
		
		for(Leistungsart l: Leistungsart.AlleLesen())
		{
			this.model_leistungsart.addElement(l.getBez());
		}			
	}
	
	//Legt neue Leistungen f�r jeweilige Tabellen an und f�gt Dummy-Objekte ein f�r die 1:1 Abbildung der jeweiligen Tabelle
	private void getDatenAusMaske()
	{
		int i = this.cmbbox_tables.getSelectedIndex();
		
		NotenTableModel model;
		NotenTableHeader header;
		
		if(this.checkDate(i))
		{
			if(i == 0)
			{
				model = (NotenTableModel) this.notenausgabe.table_tab1_muendl.getModel();
				model.addColumn((String) this.cmbBox_Leistungsart.getSelectedItem());
				header = (NotenTableHeader) this.notenausgabe.table_tab1_muendl.getTableHeader();
				header.addColumnTooltip(this.erhebungsdatum.toString());		
				
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
				header.addColumnTooltip(this.erhebungsdatum.toString());
				
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
				header.addColumnTooltip(this.erhebungsdatum.toString());
				
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
				header.addColumnTooltip(this.erhebungsdatum.toString());
				
				for(Vector<Object> v : model.getSaveVector())
				{
					Leistung l = new Leistung();
					
					l.setNotenstufe(0);
					l.setTendenz('o');
					v.add(l);
				}
			}
			
			this.dispose();
		}		
	}
	
	//�berpr�ft ob das Leistungserhebungsdatum der neuen Leistung nicht leer ist, richtiges Format hat usw.
	private boolean checkDate(int selectedIndex)
	{		
		DatumSJ sj = new DatumSJ(LocalDate.now());
		
		boolean ret = false;
		CharSequence cs = new StringBuffer('-');		
		
		String s = this.datePicker.getJFormattedTextField().getText();		
		String[] datumteile = s.split("-");
		
		LocalDate dt = null;
		
		try
		{
			dt = LocalDate.parse(s);	
		}
		catch(Exception e)
		{		
				
		}
		
		if(s.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Kein Datum eingegeben!");				
		}
		else if(s.length() != 10)
		{
			JOptionPane.showMessageDialog(this, "Datum muss im Format yyyy-mm-dd geschrieben sein!");
		}
		else if(!s.contains(cs))
		{
			JOptionPane.showMessageDialog(this, "Datum muss im Format yyyy-mm-dd geschrieben sein!");
		}
		else if(datumteile[0].length() != 4 || datumteile[1].length() != 2 || datumteile[2].length() != 2)
		{
			JOptionPane.showMessageDialog(this, "Datum muss im Format yyyy-mm-dd geschrieben sein!");
		}
		else if(dt != null && dt.isBefore(sj.getBeginn()) || dt.isAfter(sj.getEnde()))
		{
			JOptionPane.showMessageDialog(this, "Datum muss im Schuljahr liegen.");
		}		
		else if(selectedIndex == 0 || selectedIndex == 1)
		{
			if(dt.isBefore(sj.getBeginn()) || dt.isAfter(sj.getHalbjahr()))
				JOptionPane.showMessageDialog(this, "Sie haben Erstes Halbjahr gew�hlt, aber ihr Erhebungsdatum liegt nicht in diesem.");
			else
			{
				ret = true;
				this.erhebungsdatum = dt;
			}
				
		}
		else if(selectedIndex == 2 || selectedIndex == 3)
		{
			if(dt.isBefore(sj.getHalbjahr()) || dt.isAfter(sj.getEnde()))
				JOptionPane.showMessageDialog(this, "Sie haben Zweites Halbjahr gew�hlt, aber ihr Erhebungsdatum liegt nicht in diesem.");
			else
			{
				ret = true;
				this.erhebungsdatum = dt;
			}
		}		
		
		return ret;
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
		}
	}
	
	public void itemStateChanged(ItemEvent arg0) 
	{
		char c = ' ';
		
		//M�ndliche noten ausgew�hlt
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
	public static void initGui(Dialog_NotenausgabeKlasse n)
	{
		if(Dialog_Klassenauswahl.dlg_LeistungNeu == null)
			Dialog_Klassenauswahl.dlg_LeistungNeu = new Dialog_LeistungNeu(n);
		
		Dialog_Klassenauswahl.dlg_LeistungNeu.setVisible(true);
		Dialog_Klassenauswahl.dlg_LeistungNeu.toFront();
	}
	
}
