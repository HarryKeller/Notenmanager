package Dialog;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import Fachklassen.Zeugnisfach;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Dialog_adm_Zeugnisfach_Bearbeiten extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Bezeichnung;
	private JTextField textField_Fachart;
	private JCheckBox checkBox_Vorrueckungsfach;
	private JCheckBox checkBox_AbschliessendesFach;

	private JButton button_Speichern;
	private JButton button_Verwerfen;
	private JButton button_Leeren;
	private JButton button_Zurueck;
	
	private Zeugnisfach zeugnisfach;
	

	public Dialog_adm_Zeugnisfach_Bearbeiten() 
	{
		initGUI();
		this.zeugnisfach = new Zeugnisfach();
	}
	public Dialog_adm_Zeugnisfach_Bearbeiten(Zeugnisfach zeugnisfach) 
	{
		initGUI();
		
		this.zeugnisfach = zeugnisfach;
		setDatenInMaske();
	}

	private void initGUI() 
	{
		setTitle("Zeugnisfach bearbeiten");
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
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			panel_2.add(textField_Bezeichnung, gbc_textField);
			textField_Bezeichnung.setColumns(10);
			
			JLabel label_Fachart = new JLabel("Fachart");
			GridBagConstraints gbc_label_Fachart = new GridBagConstraints();
			gbc_label_Fachart.anchor = GridBagConstraints.EAST;
			gbc_label_Fachart.insets = new Insets(0, 0, 5, 5);
			gbc_label_Fachart.gridx = 0;
			gbc_label_Fachart.gridy = 1;
			panel_2.add(label_Fachart, gbc_label_Fachart);
			
			textField_Fachart = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			panel_2.add(textField_Fachart, gbc_textField_1);
			textField_Fachart.setColumns(10);
			
			JCheckBox checkBox_Vorrueckungsfach = new JCheckBox("Vorr\u00FCckungsfach");
			GridBagConstraints gbc_checkBox_Vorrueckungsfach = new GridBagConstraints();
			gbc_checkBox_Vorrueckungsfach.fill = GridBagConstraints.HORIZONTAL;
			gbc_checkBox_Vorrueckungsfach.insets = new Insets(0, 0, 5, 0);
			gbc_checkBox_Vorrueckungsfach.gridx = 1;
			gbc_checkBox_Vorrueckungsfach.gridy = 2;
			panel_2.add(checkBox_Vorrueckungsfach, gbc_checkBox_Vorrueckungsfach);
			
			JCheckBox checkBox_AbschliessendesFach = new JCheckBox("Abschlie\u00DFendes Fach");
			GridBagConstraints gbc_checkBox_AbschliessendesFach = new GridBagConstraints();
			gbc_checkBox_AbschliessendesFach.fill = GridBagConstraints.HORIZONTAL;
			gbc_checkBox_AbschliessendesFach.gridx = 1;
			gbc_checkBox_AbschliessendesFach.gridy = 3;
			panel_2.add(checkBox_AbschliessendesFach, gbc_checkBox_AbschliessendesFach);
			
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
			
			JButton button_Speichern = new JButton("Speichern");
			button_Speichern.addActionListener(this);
			GridBagConstraints gbc_button_Speichern = new GridBagConstraints();
			gbc_button_Speichern.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Speichern.insets = new Insets(0, 0, 0, 5);
			gbc_button_Speichern.gridx = 0;
			gbc_button_Speichern.gridy = 0;
			panel_1.add(button_Speichern, gbc_button_Speichern);
			
			JButton button_Verwerfen = new JButton("Verwerfen");
			button_Verwerfen.addActionListener(this);
			GridBagConstraints gbc_button_Verwerfen = new GridBagConstraints();
			gbc_button_Verwerfen.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Verwerfen.insets = new Insets(0, 0, 0, 5);
			gbc_button_Verwerfen.gridx = 1;
			gbc_button_Verwerfen.gridy = 0;
			panel_1.add(button_Verwerfen, gbc_button_Verwerfen);
			
			JButton button_Leeren = new JButton("Leeren");
			button_Leeren.addActionListener(this);
			GridBagConstraints gbc_button_Leeren = new GridBagConstraints();
			gbc_button_Leeren.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Leeren.insets = new Insets(0, 0, 0, 5);
			gbc_button_Leeren.gridx = 2;
			gbc_button_Leeren.gridy = 0;
			panel_1.add(button_Leeren, gbc_button_Leeren);
			
			JButton button_Zurueck = new JButton("Zur\u00FCck");
			button_Zurueck.addActionListener(this);
			GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
			gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Zurueck.gridx = 3;
			gbc_button_Zurueck.gridy = 0;
			panel_1.add(button_Zurueck, gbc_button_Zurueck);
		}
	}

	private void setDatenInMaske() 
	{
		this.textField_Bezeichnung.setText(this.zeugnisfach.getBez());
		this.textField_Fachart.setText(this.zeugnisfach.getFachart());
		this.checkBox_Vorrueckungsfach.setSelected(this.zeugnisfach.isVorrueckungsfach());
		this.checkBox_AbschliessendesFach.setSelected(this.zeugnisfach.isAbschliessendesFach());
	}
	private void getDatenInMaske() 
	{
		this.zeugnisfach.setBez(this.textField_Bezeichnung.getText());
		this.zeugnisfach.setFachart(this.textField_Fachart.getText());
		this.zeugnisfach.setAbschliessendesFach(this.checkBox_AbschliessendesFach.isSelected());
		this.zeugnisfach.setVorrueckungsfach(this.checkBox_Vorrueckungsfach.isSelected());;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(this.button_Speichern.getActionCommand()))
		{
			if(!this.textField_Bezeichnung.getText().equals("") || this.textField_Bezeichnung.getText() != null ||
		       !this.textField_Fachart.getText().equals("") || this.textField_Bezeichnung.getText() != null)
			{
				getDatenInMaske();
				this.zeugnisfach.speichern();
				this.dispose();
			}
		}
		if(e.getActionCommand().equals(this.button_Verwerfen.getActionCommand()))
		{
			setDatenInMaske();
		}
		if(e.getActionCommand().equals(this.button_Leeren.getActionCommand()))
		{
			this.textField_Bezeichnung.setText("");
			this.textField_Fachart.setText("");
			this.checkBox_Vorrueckungsfach.setSelected(false);
			this.checkBox_AbschliessendesFach.setSelected(false);
		}
		if(e.getActionCommand().equals(this.button_Zurueck.getActionCommand()))
		{
			this.dispose();
		}
	}
}
