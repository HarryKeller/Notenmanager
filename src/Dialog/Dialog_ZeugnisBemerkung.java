package Dialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import Fachklassen.Schueler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog_ZeugnisBemerkung extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JLabel lblZeugnisbemerkung;
	private JLabel lblBitteGebenSie;
	private JTextField textField;
	private JButton btnWeiter;
	private JButton btnAbbrechen;
	String bemerkung = "";
	Schueler schueler;
	Dialog_Schuelerwahl schuelerwahl;

	public Dialog_ZeugnisBemerkung(Schueler schueler, Dialog_Schuelerwahl Schuelerwahl)
	{
		this.schueler = schueler;
		this.schuelerwahl = Schuelerwahl;
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		lblZeugnisbemerkung = new JLabel("Zeugnisbemerkung");
		lblZeugnisbemerkung.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 24));
		GridBagConstraints gbc_lblZeugnisbemerkung = new GridBagConstraints();
		gbc_lblZeugnisbemerkung.gridwidth = 2;
		gbc_lblZeugnisbemerkung.insets = new Insets(0, 0, 5, 5);
		gbc_lblZeugnisbemerkung.gridx = 0;
		gbc_lblZeugnisbemerkung.gridy = 0;
		contentPane.add(lblZeugnisbemerkung, gbc_lblZeugnisbemerkung);
		lblBitteGebenSie = new JLabel("Bitte geben sie eine Zugnisbemerkung ein:");
		lblBitteGebenSie.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 13));
		GridBagConstraints gbc_lblBitteGebenSie = new GridBagConstraints();
		gbc_lblBitteGebenSie.gridwidth = 2;
		gbc_lblBitteGebenSie.insets = new Insets(0, 0, 5, 5);
		gbc_lblBitteGebenSie.gridx = 0;
		gbc_lblBitteGebenSie.gridy = 1;
		contentPane.add(lblBitteGebenSie, gbc_lblBitteGebenSie);
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		btnWeiter = new JButton("Weiter");
		btnWeiter.addActionListener(this);
		GridBagConstraints gbc_btnWeiter = new GridBagConstraints();
		gbc_btnWeiter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWeiter.insets = new Insets(0, 0, 0, 5);
		gbc_btnWeiter.gridx = 0;
		gbc_btnWeiter.gridy = 3;
		contentPane.add(btnWeiter, gbc_btnWeiter);
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(this);
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbbrechen.gridx = 1;
		gbc_btnAbbrechen.gridy = 3;
		contentPane.add(btnAbbrechen, gbc_btnAbbrechen);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		String action = arg0.getActionCommand();
		if(action.equals("Weiter"))
		{
			this.bemerkung = this.textField.getText();
			Dialog_ZeugnisDrucken dzd = new Dialog_ZeugnisDrucken(schueler, schuelerwahl, bemerkung);
			dzd.setVisible(true);
			this.dispose();
		}
		else if(action.equals("Abbrechen"))
		{
			this.schuelerwahl.setVisible(true);
			this.dispose();
		}
	}
}
