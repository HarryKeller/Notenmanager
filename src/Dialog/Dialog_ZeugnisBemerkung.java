package Dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.JTextArea;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class Dialog_ZeugnisBemerkung extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblZeugnisbemerkung;
	private JLabel lblBitteGebenSie;
	private JButton btnWeiter;
	private JButton btnAbbrechen;
	String bemerkung = "";
	Schueler schueler;
	private JTextField txtBsp;
	private JButton btnNewButton;
	private JLabel lblCode;
	String erg;
	private JTextArea textField;
	private JLabel lblDatum;
	private UtilDateModel model;
	private JDatePickerImpl datePicker;
	private String datum;
	private JLabel lblAushndigung;

	private Dialog_ZeugnisBemerkung(Schueler schueler )
	{
		this.schueler = schueler;
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 617, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		lblZeugnisbemerkung = new JLabel("Zeugnisbemerkung");
		lblZeugnisbemerkung.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 24));
		GridBagConstraints gbc_lblZeugnisbemerkung = new GridBagConstraints();
		gbc_lblZeugnisbemerkung.gridwidth = 3;
		gbc_lblZeugnisbemerkung.insets = new Insets(0, 0, 5, 0);
		gbc_lblZeugnisbemerkung.gridx = 1;
		gbc_lblZeugnisbemerkung.gridy = 0;
		contentPane.add(lblZeugnisbemerkung, gbc_lblZeugnisbemerkung);
		lblBitteGebenSie = new JLabel("Bitte geben sie eine Zeugnisbemerkung ein:");
		lblBitteGebenSie.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 13));
		GridBagConstraints gbc_lblBitteGebenSie = new GridBagConstraints();
		gbc_lblBitteGebenSie.gridwidth = 3;
		gbc_lblBitteGebenSie.insets = new Insets(0, 0, 5, 0);
		gbc_lblBitteGebenSie.gridx = 1;
		gbc_lblBitteGebenSie.gridy = 1;
		contentPane.add(lblBitteGebenSie, gbc_lblBitteGebenSie);
		lblCode = new JLabel("Code:");
		lblCode.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 13));
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 2;
		contentPane.add(lblCode, gbc_lblCode);
		txtBsp = new JTextField();
		txtBsp.setText("Beispiel: 011");
		GridBagConstraints gbc_txtBsp = new GridBagConstraints();
		gbc_txtBsp.insets = new Insets(0, 0, 5, 5);
		gbc_txtBsp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBsp.gridx = 1;
		gbc_txtBsp.gridy = 2;
		contentPane.add(txtBsp, gbc_txtBsp);
		txtBsp.setColumns(10);
		btnNewButton = new JButton("Einf\u00FCgen");
		btnNewButton.addActionListener(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnWeiter = new JButton("Weiter");
		btnWeiter.addActionListener(this);
		textField = new JTextArea();
		textField.setWrapStyleWord(true);
		textField.setLineWrap(true);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		lblDatum = new JLabel("Datum der");
		lblDatum.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 13));
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.anchor = GridBagConstraints.EAST;
		gbc_lblDatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatum.gridx = 0;
		gbc_lblDatum.gridy = 4;
		contentPane.add(lblDatum, gbc_lblDatum);
		
		model = new UtilDateModel();
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		GridBagConstraints gbc_datepicker = new GridBagConstraints();
				
		gbc_datepicker.insets = new Insets(5,5,5,5);
		gbc_datepicker.gridwidth = 2;
		gbc_datepicker.gridx = 1;
		gbc_datepicker.gridy = 5;
		gbc_datepicker.fill = GridBagConstraints.BOTH;
		gbc_datepicker.anchor = GridBagConstraints.NORTH;
		this.contentPane.add(datePicker, gbc_datepicker);
		lblAushndigung = new JLabel("Aush\u00E4ndigung:");
		lblAushndigung.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 13));
		GridBagConstraints gbc_lblAushndigung = new GridBagConstraints();
		gbc_lblAushndigung.insets = new Insets(0, 0, 5, 5);
		gbc_lblAushndigung.gridx = 0;
		gbc_lblAushndigung.gridy = 5;
		contentPane.add(lblAushndigung, gbc_lblAushndigung);
		
		
		GridBagConstraints gbc_btnWeiter = new GridBagConstraints();
		gbc_btnWeiter.gridwidth = 2;
		gbc_btnWeiter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWeiter.insets = new Insets(0, 0, 0, 5);
		gbc_btnWeiter.gridx = 0;
		gbc_btnWeiter.gridy = 6;
		contentPane.add(btnWeiter, gbc_btnWeiter);
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(this);
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.gridwidth = 2;
		gbc_btnAbbrechen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbbrechen.gridx = 2;
		gbc_btnAbbrechen.gridy = 6;
		contentPane.add(btnAbbrechen, gbc_btnAbbrechen);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		String action = arg0.getActionCommand();
		if(action.equals("Weiter"))
		{
			this.bemerkung = this.textField.getText();
			datum=model.getDay()+"."+(model.getMonth()+1)+"."+model.getYear();
			
			Dialog_ZeugnisDrucken.initGui(schueler, bemerkung, datum);
			Dialog_Klassenauswahl.dlg_ZeugnisDrucken.setVisible(true);
			this.dispose();
		}
		else if(action.equals("Abbrechen"))
		{
			this.dispose();
		}
		else if(action.equals("Einf�gen"))
		{
			 try 
			 {
		        @SuppressWarnings("resource")
				BufferedReader FileReader=new BufferedReader(new FileReader(new java.io.File("textbausteine.csv")));
		        
		            String zeile="";
		            String code = this.txtBsp.getText();
		            erg ="";
		           
		            while(null!=(zeile=FileReader.readLine()))
		            {         
		                String[] split=zeile.split(";");   	        		              
		                
		                if(split[0].equals(code))
		                {
		                	if(this.schueler.getGeschl().equals("m"))
		                	{
		                		erg=split[1];
		                		erg.substring(1);
		                	    this.textField.setText(this.textField.getText() + " " + split[1]);
		                	}
		                	else
		                	{
		                		erg=split[2];
		                		erg.substring(1);
		                		this.textField.setText(this.textField.getText() + " " + split[2]);
		                	}
		                }
		            }
		            if(this.erg.equals(""))
		            {
		            	JOptionPane.showMessageDialog(null, "Es wurde kein Eintrag f�r den eingegebenen Schl�ssel gefunden!");
		            }	     
		        } 
			 catch (Exception e) 
			 {
		        e.printStackTrace();
			 }
		}
	}
	public static void initGui(Schueler schueler )
	{
		
		Dialog_Klassenauswahl.dlg_Zeugnisbemerkung = new Dialog_ZeugnisBemerkung(schueler);
		
		Dialog_Klassenauswahl.dlg_Zeugnisbemerkung.setVisible(true);
		Dialog_Klassenauswahl.dlg_Zeugnisbemerkung.toFront();
	}
}
