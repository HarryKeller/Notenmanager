package Dialog;

import java.awt.*;
import java.awt.event.*;
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

public class Dialog_NotenausgabeKlasse extends JFrame implements ActionListener, WindowFocusListener
{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Klasse;
	private JTextField textField_Fach;
	private JTextField textField_LehrerIn;
	private JTable table_muendl;
	private DefaultTableModel model_muendlich;
	private DefaultTableModel model_schriftl;
	private Lehrer lehrer;
	private Klasse klasse;
	private Unterrichtsfach fach;
	private JTable table_schriftl;
	
	
	/*public static void main(String[] args)
	{
		DBZugriff.initDB();
		Dialog_NotenausgabeKlasse d = new Dialog_NotenausgabeKlasse(new Lehrer(1), new Klasse(1), new Unterrichtsfach(1));
		d.setVisible(true);
		DBZugriff.closeDB();
	}
	/**
	 * Create the dialog.
	 */
	public Dialog_NotenausgabeKlasse()
	{
		this.setExtendedState(MAXIMIZED_BOTH);
		this.initGUI();
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
		addWindowFocusListener(this);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 60, 0, 25, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel_Head = new JPanel();
			GridBagConstraints gbc_panel_Head = new GridBagConstraints();
			gbc_panel_Head.insets = new Insets(0, 0, 5, 5);
			gbc_panel_Head.fill = GridBagConstraints.BOTH;
			gbc_panel_Head.gridx = 1;
			gbc_panel_Head.gridy = 1;
			contentPanel.add(panel_Head, gbc_panel_Head);
			GridBagLayout gbl_panel_Head = new GridBagLayout();
			gbl_panel_Head.columnWidths = new int[]{0, 0, 0};
			gbl_panel_Head.rowHeights = new int[]{0, 0};
			gbl_panel_Head.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel_Head.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_Head.setLayout(gbl_panel_Head);
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 0, 5);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel_Head.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 125, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel label_Klasse = new JLabel("Klasse");
					label_Klasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
					GridBagConstraints gbc_label_Klasse = new GridBagConstraints();
					gbc_label_Klasse.anchor = GridBagConstraints.EAST;
					gbc_label_Klasse.insets = new Insets(0, 0, 5, 5);
					gbc_label_Klasse.gridx = 0;
					gbc_label_Klasse.gridy = 0;
					panel_1.add(label_Klasse, gbc_label_Klasse);
				}
				{
					textField_Klasse = new JTextField();
					textField_Klasse.setEditable(false);
					GridBagConstraints gbc_textField_Klasse = new GridBagConstraints();
					gbc_textField_Klasse.insets = new Insets(0, 0, 5, 0);
					gbc_textField_Klasse.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_Klasse.gridx = 1;
					gbc_textField_Klasse.gridy = 0;
					panel_1.add(textField_Klasse, gbc_textField_Klasse);
					textField_Klasse.setColumns(10);
				}
				{
					JLabel label_Fach = new JLabel("Fach");
					label_Fach.setFont(new Font("Tahoma", Font.PLAIN, 14));
					GridBagConstraints gbc_label_Fach = new GridBagConstraints();
					gbc_label_Fach.anchor = GridBagConstraints.EAST;
					gbc_label_Fach.insets = new Insets(0, 0, 0, 5);
					gbc_label_Fach.gridx = 0;
					gbc_label_Fach.gridy = 1;
					panel_1.add(label_Fach, gbc_label_Fach);
				}
				{
					textField_Fach = new JTextField();
					textField_Fach.setEditable(false);
					GridBagConstraints gbc_textField_Fach = new GridBagConstraints();
					gbc_textField_Fach.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_Fach.gridx = 1;
					gbc_textField_Fach.gridy = 1;
					panel_1.add(textField_Fach, gbc_textField_Fach);
					textField_Fach.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 0;
				panel_Head.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 125, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0};
				gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel label_LehrerIn = new JLabel("Lehrer/in");
					label_LehrerIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
					GridBagConstraints gbc_label_LehrerIn = new GridBagConstraints();
					gbc_label_LehrerIn.insets = new Insets(0, 0, 0, 5);
					gbc_label_LehrerIn.anchor = GridBagConstraints.EAST;
					gbc_label_LehrerIn.gridx = 0;
					gbc_label_LehrerIn.gridy = 0;
					panel_1.add(label_LehrerIn, gbc_label_LehrerIn);
				}
				{
					textField_LehrerIn = new JTextField();
					textField_LehrerIn.setEditable(false);
					GridBagConstraints gbc_textField_LehrerIn = new GridBagConstraints();
					gbc_textField_LehrerIn.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_LehrerIn.gridx = 1;
					gbc_textField_LehrerIn.gridy = 0;
					panel_1.add(textField_LehrerIn, gbc_textField_LehrerIn);
					textField_LehrerIn.setColumns(10);
				}
			}
		}		
		{
			JPanel panel_table_muendl = new JPanel();
			GridBagConstraints gbc_panel_table_muendl = new GridBagConstraints();
			gbc_panel_table_muendl.ipady = 50;
			gbc_panel_table_muendl.ipadx = 50;
			gbc_panel_table_muendl.insets = new Insets(0, 0, 5, 5);
			gbc_panel_table_muendl.fill = GridBagConstraints.BOTH;
			gbc_panel_table_muendl.gridx = 1;
			gbc_panel_table_muendl.gridy = 2;
			gbc_panel_table_muendl.weightx = 50;
			gbc_panel_table_muendl.weighty = 50;
			contentPanel.add(panel_table_muendl, gbc_panel_table_muendl);
			GridBagLayout gbl_panel_table_muendl = new GridBagLayout();
			gbl_panel_table_muendl.columnWidths = new int[]{0, 0};
			gbl_panel_table_muendl.rowHeights = new int[]{0, 0};
			gbl_panel_table_muendl.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_table_muendl.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			
			panel_table_muendl.setLayout(gbl_panel_table_muendl);
			{
				this.model_muendlich = new DefaultTableModel();
				{
					JPanel panel = new JPanel();
					panel.setToolTipText("");
					panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "M\u00FCndliche Noten", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					GridBagConstraints gbc_panel = new GridBagConstraints();
					gbc_panel.fill = GridBagConstraints.BOTH;
					gbc_panel.gridx = 0;
					gbc_panel.gridy = 0;
					panel_table_muendl.add(panel, gbc_panel);
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
						table_muendl = new JTable();
						scrollPane.setViewportView(this.table_muendl);
						table_muendl.setModel(this.model_muendlich);
					}
				}
			}
		}
		{
			JPanel panel_table_schriftl = new JPanel();
			GridBagConstraints gbc_panel_table_schriftl = new GridBagConstraints();
			gbc_panel_table_schriftl.ipady = 50;
			gbc_panel_table_schriftl.ipadx = 50;
			gbc_panel_table_schriftl.insets = new Insets(0, 0, 5, 0);
			gbc_panel_table_schriftl.fill = GridBagConstraints.BOTH;
			gbc_panel_table_schriftl.gridx = 2;
			gbc_panel_table_schriftl.gridy = 2;
			gbc_panel_table_schriftl.weightx = 50;
			gbc_panel_table_schriftl.weighty = 50;
			contentPanel.add(panel_table_schriftl, gbc_panel_table_schriftl);
			GridBagLayout gbl_panel_table_schriftl = new GridBagLayout();
			gbl_panel_table_schriftl.columnWidths = new int[]{0, 0};
			gbl_panel_table_schriftl.rowHeights = new int[]{0, 0};
			gbl_panel_table_schriftl.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_table_schriftl.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_table_schriftl.setLayout(gbl_panel_table_schriftl);
			{
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Schriftliche Noten", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 0;
				panel_table_schriftl.add(panel, gbc_panel);
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
						this.model_schriftl = new DefaultTableModel();
						this.table_schriftl = new JTable();						
						scrollPane.setViewportView(this.table_schriftl);
						this.table_schriftl.setModel(this.model_schriftl);
					}
				}				
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
			{
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{65, 0};
				gbl_panel.rowHeights = new int[]{23, 0};
				gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
			}
			JButton button_Zurueck = new JButton("Zur\u00FCck");
			button_Zurueck.addActionListener(this);
			GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
			gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Zurueck.anchor = GridBagConstraints.NORTHWEST;
			gbc_button_Zurueck.gridx = 0;
			gbc_button_Zurueck.gridy = 0;
			panel.add(button_Zurueck, gbc_button_Zurueck);
			}
		}
	}
	
	private int isColumnRequiered(DefaultTableModel model, Leistung l) //Prüft ob Spalten benötigt werden
	{		
		return model.findColumn(l.getErhebungsdatum().toString());
	}
	
	private void setGradesInTable() //Tabellen mit Noten befüllen, geteilt nach Schriftl. & Mündl.
	{
		this.model_muendlich.addColumn("Name");
		this.model_muendlich.addColumn("Vorname");	
		
		/*this.model_schriftl.addColumn("Name");
		this.model_schriftl.addColumn("Vorname");*/
		
		Set<Schueler> schueler = this.klasse.getSchueler();
		
		for(Schueler s : schueler)
		{
			Object[] rowData = {s.getNachname(),s.getVorname()};
			this.model_muendlich.addRow(rowData);
			
			for(Leistung l : s.getMuendlich(this.fach))
			{			
				int col = this.isColumnRequiered(model_muendlich, l);
				
				if(col == -1)
				{					
					this.model_muendlich.addColumn(l.getErhebungsdatum().toString());		
					this.model_muendlich.setValueAt(l.getNotenstufe(), this.model_muendlich.getRowCount() - 1, 
																	   this.model_muendlich.getColumnCount() - 1);
				}	
				else if(col >= 0)
				{
					this.model_muendlich.setValueAt(l.getNotenstufe(), this.model_muendlich.getRowCount() - 1 , col);
				}				
			}			
			
			for(Leistung l : s.getSchriftlich(this.fach))
			{
				int col = this.isColumnRequiered(model_schriftl, l);
				this.model_schriftl.addRow(new Object[]{""});
				
				if(col == -1)
				{
					this.model_schriftl.addColumn(l.getErhebungsdatum().toString());
					this.model_schriftl.setValueAt(l.getNotenstufe(), this.model_schriftl.getRowCount() - 1 , 
																	  this.model_schriftl.getColumnCount() - 1);										
				}
				else if(col >= 0)
				{
					this.model_schriftl.setValueAt(l.getNotenstufe(), this.model_schriftl.getRowCount() - 1 , col);
				}
			}
		}
	}
	
	public void setDatenInMaske()
	{		
		this.textField_Fach.setText(this.fach.getBez());
		this.textField_Klasse.setText(this.klasse.getBez());
		this.textField_LehrerIn.setText(this.lehrer.getNachname());
		
		this.setGradesInTable();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		this.dispose();
	}
	public void windowGainedFocus(WindowEvent e) 
	{
		
	}
	public void windowLostFocus(WindowEvent e) 
	{
		this.requestFocus();
	}
}
