package Dialog;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Fachklassen.Unterrichtsfach;
import Fachklassen.Zeugnisfach;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class Dialog_adm_Unterrichtsfach_bearbeiten extends JDialog implements ActionListener {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Bezeichnung;
	private JTextField textField_Gewichtung;	

	private JButton button_Speichern;
	private JButton button_Verwerfen;
	private JButton button_Leeren;
	private JButton button_Zurueck;
	
	private Unterrichtsfach unterrichtsfach;
	private JLabel label_Stunden;
	private JTextField textField_Stunden;
	private JLabel label_Zeugnisfach;
	private JComboBox cmbBox_Zeugnisfach;
	private JScrollPane _scrollPane;
	

	public Dialog_adm_Unterrichtsfach_bearbeiten() 
	{
		this.unterrichtsfach = new Unterrichtsfach();
		setTitle("Unterrichtsfach anlegen");
		initGUI();
		
		this.fillComboBox();
	}
	public Dialog_adm_Unterrichtsfach_bearbeiten(Unterrichtsfach ufach) 
	{
		this.unterrichtsfach = ufach;
		
		setTitle("Unterrichtsfach bearbeiten");
		initGUI();
		setDatenInMaske();
	}

	private void initGUI() 
	{		
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 480, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 0, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 0, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
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
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JPanel panel_2 = new JPanel();
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.insets = new Insets(0, 0, 5, 0);
			gbc_panel_2.fill = GridBagConstraints.BOTH;
			gbc_panel_2.gridx = 0;
			gbc_panel_2.gridy = 0;
			panel.add(panel_2, gbc_panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{0, 0, 0};
			gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			
			JLabel lblBezeichnung = new JLabel("Bezeichnung");
			GridBagConstraints gbc_lblBezeichnung = new GridBagConstraints();
			gbc_lblBezeichnung.anchor = GridBagConstraints.EAST;
			gbc_lblBezeichnung.insets = new Insets(0, 0, 5, 5);
			gbc_lblBezeichnung.gridx = 0;
			gbc_lblBezeichnung.gridy = 0;
			panel_2.add(lblBezeichnung, gbc_lblBezeichnung);
			
			textField_Bezeichnung = new JTextField();
			GridBagConstraints gbc_textField_Stunden = new GridBagConstraints();
			gbc_textField_Stunden.insets = new Insets(0, 0, 5, 0);
			gbc_textField_Stunden.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Stunden.gridx = 1;
			gbc_textField_Stunden.gridy = 0;
			panel_2.add(textField_Bezeichnung, gbc_textField_Stunden);
			textField_Bezeichnung.setColumns(10);
			
			JLabel lblGewichtung = new JLabel("Gewichtung");
			GridBagConstraints gbc_lblGewichtung = new GridBagConstraints();
			gbc_lblGewichtung.anchor = GridBagConstraints.EAST;
			gbc_lblGewichtung.insets = new Insets(0, 0, 5, 5);
			gbc_lblGewichtung.gridx = 0;
			gbc_lblGewichtung.gridy = 1;
			panel_2.add(lblGewichtung, gbc_lblGewichtung);
			
			textField_Gewichtung = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			panel_2.add(textField_Gewichtung, gbc_textField_1);
			textField_Gewichtung.setColumns(10);			
			
			this.label_Stunden = new JLabel("Stunden");
			GridBagConstraints gbc_label_Stunden = new GridBagConstraints();
			gbc_label_Stunden.anchor = GridBagConstraints.EAST;
			gbc_label_Stunden.insets = new Insets(0, 0, 5, 5);
			gbc_label_Stunden.gridx = 0;
			gbc_label_Stunden.gridy = 2;
			panel_2.add(this.label_Stunden, gbc_label_Stunden);
			
			this.textField_Stunden = new JTextField();
			gbc_textField_Stunden = new GridBagConstraints();
			gbc_textField_Stunden.insets = new Insets(0, 0, 5, 0);
			gbc_textField_Stunden.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Stunden.gridx = 1;
			gbc_textField_Stunden.gridy = 2;
			panel_2.add(this.textField_Stunden, gbc_textField_Stunden);
			this.textField_Stunden.setColumns(10);
			
			this.label_Zeugnisfach = new JLabel("Zeugnisfach");
			GridBagConstraints gbc_label_Zeugnisfach = new GridBagConstraints();
			gbc_label_Zeugnisfach.anchor = GridBagConstraints.EAST;
			gbc_label_Zeugnisfach.insets = new Insets(0, 0, 0, 5);
			gbc_label_Zeugnisfach.gridx = 0;
			gbc_label_Zeugnisfach.gridy = 3;
			panel_2.add(this.label_Zeugnisfach, gbc_label_Zeugnisfach);
			
			this._scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 3;
			panel_2.add(this._scrollPane, gbc_scrollPane);
			
			this.cmbBox_Zeugnisfach = new JComboBox();
			this.cmbBox_Zeugnisfach.setModel(new DefaultComboBoxModel());
			this._scrollPane.setViewportView(this.cmbBox_Zeugnisfach);
			
			JPanel panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 1;
			panel.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{100, 100, 100, 100, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			
			button_Speichern = new JButton("Speichern");
			button_Speichern.addActionListener(this);
			GridBagConstraints gbc_button_Speichern = new GridBagConstraints();
			gbc_button_Speichern.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Speichern.insets = new Insets(0, 0, 0, 5);
			gbc_button_Speichern.gridx = 0;
			gbc_button_Speichern.gridy = 0;
			panel_1.add(button_Speichern, gbc_button_Speichern);
			
			button_Verwerfen = new JButton("Verwerfen");
			button_Verwerfen.addActionListener(this);
			GridBagConstraints gbc_button_Verwerfen = new GridBagConstraints();
			gbc_button_Verwerfen.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Verwerfen.insets = new Insets(0, 0, 0, 5);
			gbc_button_Verwerfen.gridx = 1;
			gbc_button_Verwerfen.gridy = 0;
			panel_1.add(button_Verwerfen, gbc_button_Verwerfen);
			
			button_Leeren = new JButton("Leeren");
			button_Leeren.addActionListener(this);
			GridBagConstraints gbc_button_Leeren = new GridBagConstraints();
			gbc_button_Leeren.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Leeren.insets = new Insets(0, 0, 0, 5);
			gbc_button_Leeren.gridx = 2;
			gbc_button_Leeren.gridy = 0;
			panel_1.add(button_Leeren, gbc_button_Leeren);
			
			button_Zurueck = new JButton("Zur\u00FCck");
			button_Zurueck.addActionListener(this);
			GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
			gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Zurueck.gridx = 3;
			gbc_button_Zurueck.gridy = 0;
			panel_1.add(button_Zurueck, gbc_button_Zurueck);
		}
	}
	
	private void fillComboBox()
	{
		DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbBox_Zeugnisfach.getModel();
		
		for(Zeugnisfach z : Zeugnisfach.alleLesen())
		{
			model.addElement(z);
		}
	}
	
	private void setDatenInMaske() 
	{
		this.textField_Bezeichnung.setText(this.unterrichtsfach.getBez());
		this.textField_Gewichtung.setText(String.valueOf(this.unterrichtsfach.getGewichtungSchriftlich()));		
		this.textField_Stunden.setText(String.valueOf(this.unterrichtsfach.getStunden()));
		
		this.fillComboBox();
		
		DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbBox_Zeugnisfach.getModel();
		model.setSelectedItem(this.unterrichtsfach.getZfach());
	}
	private void getDatenInMaske() 
	{
		this.unterrichtsfach.setBez(this.textField_Bezeichnung.getText());
		this.unterrichtsfach.setGewichtungSchriftlich(Integer.parseInt(this.textField_Gewichtung.getText()));	
		this.unterrichtsfach.setStunden(Integer.parseInt(this.textField_Stunden.getText()));
		this.unterrichtsfach.setZfach((Zeugnisfach) this.cmbBox_Zeugnisfach.getSelectedItem()); 
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(button_Speichern))
		{
			if(!this.textField_Bezeichnung.getText().equals("") && !this.textField_Gewichtung.getText().equals(""))
			{
				getDatenInMaske();
				this.unterrichtsfach.speichern();
				this.dispose();
				Dialog_adm_Unterrichtsfach dia = new Dialog_adm_Unterrichtsfach();
				dia.pack();
				dia.setVisible(true);
			}
		}
		else if(e.getSource().equals(button_Verwerfen))
		{
			this.cmbBox_Zeugnisfach.removeAllItems();
			setDatenInMaske();
		}
		else if(e.getSource().equals(button_Leeren))
		{
			textField_Bezeichnung.setText("");
			textField_Gewichtung.setText("");
			textField_Stunden.setText("");
			cmbBox_Zeugnisfach.setSelectedIndex(-1);
		}	
		else if(e.getSource()==button_Zurueck)
		{
			setVisible(false);
			Dialog_adm_Unterrichtsfach dia = new Dialog_adm_Unterrichtsfach();
			dia.pack();
			dia.setVisible(true);
		}
	}	
}



