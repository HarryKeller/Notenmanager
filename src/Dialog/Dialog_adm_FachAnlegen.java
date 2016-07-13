package Dialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;

import Fachklassen.Unterrichtsfach;
import Fachklassen.Zeugnisfach;
import Persistenz.DBZugriff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog_adm_FachAnlegen extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtBezeichnung;
	private JTextField txtPosition;
	private JLabel Stunden;
	private JLabel lblNewLabel_2;
	private JTextField txtStunden;
	private JTextField txtGewichtung;
	private JLabel lblNewLabel_1;
	private JButton btnSpeichern;
	private JButton btnAbbrechen;
	private JComboBox<Zeugnisfach> cbZeugnisfaecher;


	public Dialog_adm_FachAnlegen() {
		setTitle("Unterrichtsfach anlegen");
		initGUI();
		fillDatenInMaske();
	}
	private void initGUI()
	{
		this.setModal(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Bezeichnung = new JLabel("Bezeichnung");
		GridBagConstraints gbc_Bezeichnung = new GridBagConstraints();
		gbc_Bezeichnung.insets = new Insets(0, 0, 5, 5);
		gbc_Bezeichnung.anchor = GridBagConstraints.EAST;
		gbc_Bezeichnung.gridx = 0;
		gbc_Bezeichnung.gridy = 0;
		contentPane.add(Bezeichnung, gbc_Bezeichnung);
		
		txtBezeichnung = new JTextField();
		GridBagConstraints gbc_txtBezeichnung = new GridBagConstraints();
		gbc_txtBezeichnung.insets = new Insets(0, 0, 5, 0);
		gbc_txtBezeichnung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBezeichnung.gridx = 1;
		gbc_txtBezeichnung.gridy = 0;
		contentPane.add(txtBezeichnung, gbc_txtBezeichnung);
		txtBezeichnung.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Position");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtPosition = new JTextField();
		GridBagConstraints gbc_txtPosition = new GridBagConstraints();
		gbc_txtPosition.insets = new Insets(0, 0, 5, 0);
		gbc_txtPosition.anchor = GridBagConstraints.NORTH;
		gbc_txtPosition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPosition.gridx = 1;
		gbc_txtPosition.gridy = 1;
		contentPane.add(txtPosition, gbc_txtPosition);
		txtPosition.setColumns(10);
		
		Stunden = new JLabel("Stunden");
		GridBagConstraints gbc_Stunden = new GridBagConstraints();
		gbc_Stunden.anchor = GridBagConstraints.EAST;
		gbc_Stunden.insets = new Insets(0, 0, 5, 5);
		gbc_Stunden.gridx = 0;
		gbc_Stunden.gridy = 2;
		contentPane.add(Stunden, gbc_Stunden);
		
		txtStunden = new JTextField();
		GridBagConstraints gbc_txtStunden = new GridBagConstraints();
		gbc_txtStunden.insets = new Insets(0, 0, 5, 0);
		gbc_txtStunden.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStunden.gridx = 1;
		gbc_txtStunden.gridy = 2;
		contentPane.add(txtStunden, gbc_txtStunden);
		txtStunden.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Gewichtung");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtGewichtung = new JTextField();
		GridBagConstraints gbc_txtGewichtung = new GridBagConstraints();
		gbc_txtGewichtung.insets = new Insets(0, 0, 5, 0);
		gbc_txtGewichtung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGewichtung.gridx = 1;
		gbc_txtGewichtung.gridy = 3;
		contentPane.add(txtGewichtung, gbc_txtGewichtung);
		txtGewichtung.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Zeugnisfach");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cbZeugnisfaecher = new JComboBox();
		GridBagConstraints gbc_cbZeugnisfaecher = new GridBagConstraints();
		gbc_cbZeugnisfaecher.insets = new Insets(0, 0, 5, 0);
		gbc_cbZeugnisfaecher.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbZeugnisfaecher.gridx = 1;
		gbc_cbZeugnisfaecher.gridy = 4;
		contentPane.add(cbZeugnisfaecher, gbc_cbZeugnisfaecher);
		
		btnSpeichern = new JButton("Speichern");
		this.btnSpeichern.addActionListener(this);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.insets = new Insets(0, 0, 0, 5);
		gbc_btnSpeichern.gridx = 0;
		gbc_btnSpeichern.gridy = 8;
		contentPane.add(btnSpeichern, gbc_btnSpeichern);
		
		btnAbbrechen = new JButton("Abbrechen");
		this.btnAbbrechen.addActionListener(this);
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.gridx = 1;
		gbc_btnAbbrechen.gridy = 8;
		contentPane.add(btnAbbrechen, gbc_btnAbbrechen);
	}
	private void fillDatenInMaske()
	{
		for(Zeugnisfach zf: Zeugnisfach.alleLesen())
		{
			cbZeugnisfaecher.addItem(zf);
		}
		
	}

	public void actionPerformed(ActionEvent e)
	{
		String befehl = e.getActionCommand();
		if(befehl.equals("Speichern"))
		{
			Unterrichtsfach f = new Unterrichtsfach();
			f.setBez(txtBezeichnung.getText());
				try
				{
					f.setGewichtungSchriftlich(Integer.parseInt(txtGewichtung.getText()));
					f.setStunden(Integer.parseInt(txtStunden.getText()));

					f.setPos(Integer.parseInt(txtPosition.getText()));
					
					f.setZfach((Zeugnisfach)cbZeugnisfaecher.getSelectedItem());
					f.speichern();
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "Fehler beim speichern \n vermutlich wurde ein Buchstabe anstatt einer Zahl eingegeben", "Fehler beim Speichern", JOptionPane.OK_CANCEL_OPTION);
				}
		
			
			
		}
		else if(befehl.equals("Abbrechen"))
		{
			this.setVisible(false);
		}
	}
}
