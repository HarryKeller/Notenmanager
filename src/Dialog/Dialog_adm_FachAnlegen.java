package Dialog;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Dialog_adm_FachAnlegen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtBezeichnung;
	private JTextField txtPosition;
	private JLabel Stunden;
	private JLabel lblNewLabel_2;
	private JTextField txtStunden;
	private JTextField txtGewichtung;
	private JLabel lblNewLabel_1;
	private JComboBox<Zeugnisfach> cbZeugnisfaecher;
	private JPanel panel;
	private JPanel panel_button;
	private JButton btnSpeichern;
	private JButton btnAbbrechen;


	private Dialog_adm_FachAnlegen() 
	{
		initGUI();
		fillDatenInMaske();
	}
	private void initGUI()
	{
		setTitle("Unterrichtsfach anlegen");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{419, 0};
		gbl_contentPane.rowHeights = new int[]{210, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 80.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.contentPane.add(this.panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panel.setLayout(gbl_panel);
		
		JLabel Bezeichnung = new JLabel("Bezeichnung :");
		GridBagConstraints gbc_Bezeichnung = new GridBagConstraints();
		gbc_Bezeichnung.anchor = GridBagConstraints.WEST;
		gbc_Bezeichnung.insets = new Insets(5, 5, 5, 5);
		gbc_Bezeichnung.gridx = 0;
		gbc_Bezeichnung.gridy = 0;
		this.panel.add(Bezeichnung, gbc_Bezeichnung);
		
		txtBezeichnung = new JTextField();
		GridBagConstraints gbc_txtBezeichnung = new GridBagConstraints();
		gbc_txtBezeichnung.insets = new Insets(0, 5, 5, 0);
		gbc_txtBezeichnung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBezeichnung.gridx = 1;
		gbc_txtBezeichnung.gridy = 0;
		this.panel.add(this.txtBezeichnung, gbc_txtBezeichnung);
		txtBezeichnung.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Position :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		this.panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtPosition = new JTextField();
		GridBagConstraints gbc_txtPosition = new GridBagConstraints();
		gbc_txtPosition.insets = new Insets(5, 5, 5, 0);
		gbc_txtPosition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPosition.gridx = 1;
		gbc_txtPosition.gridy = 1;
		this.panel.add(this.txtPosition, gbc_txtPosition);
		txtPosition.setColumns(10);
		
		Stunden = new JLabel("Stunden :\r\n");
		GridBagConstraints gbc_Stunden = new GridBagConstraints();
		gbc_Stunden.anchor = GridBagConstraints.WEST;
		gbc_Stunden.insets = new Insets(5, 5, 5, 5);
		gbc_Stunden.gridx = 0;
		gbc_Stunden.gridy = 2;
		this.panel.add(this.Stunden, gbc_Stunden);
		
		txtStunden = new JTextField();
		GridBagConstraints gbc_txtStunden = new GridBagConstraints();
		gbc_txtStunden.insets = new Insets(5, 5, 5, 0);
		gbc_txtStunden.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStunden.gridx = 1;
		gbc_txtStunden.gridy = 2;
		this.panel.add(this.txtStunden, gbc_txtStunden);
		txtStunden.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Gewichtung :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		this.panel.add(this.lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtGewichtung = new JTextField();
		GridBagConstraints gbc_txtGewichtung = new GridBagConstraints();
		gbc_txtGewichtung.insets = new Insets(5, 5, 5, 0);
		gbc_txtGewichtung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGewichtung.gridx = 1;
		gbc_txtGewichtung.gridy = 3;
		this.panel.add(this.txtGewichtung, gbc_txtGewichtung);
		txtGewichtung.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Zeugnisfach :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		this.panel.add(this.lblNewLabel_1, gbc_lblNewLabel_1);
		
		cbZeugnisfaecher = new JComboBox<Zeugnisfach>();
		GridBagConstraints gbc_cbZeugnisfaecher = new GridBagConstraints();
		gbc_cbZeugnisfaecher.insets = new Insets(5, 5, 5, 0);
		gbc_cbZeugnisfaecher.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbZeugnisfaecher.gridx = 1;
		gbc_cbZeugnisfaecher.gridy = 4;
		this.panel.add(this.cbZeugnisfaecher, gbc_cbZeugnisfaecher);
		
		this.panel_button = new JPanel();
		GridBagConstraints gbc_panel_button = new GridBagConstraints();
		gbc_panel_button.weighty = 20.0;
		gbc_panel_button.insets = new Insets(5, 0, 0, 0);
		gbc_panel_button.fill = GridBagConstraints.BOTH;
		gbc_panel_button.gridx = 0;
		gbc_panel_button.gridy = 1;
		this.contentPane.add(this.panel_button, gbc_panel_button);
		GridBagLayout gbl_panel_button = new GridBagLayout();
		gbl_panel_button.columnWidths = new int[]{230, 164, 0};
		gbl_panel_button.rowHeights = new int[]{0, 0};
		gbl_panel_button.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_button.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.panel_button.setLayout(gbl_panel_button);
		
		this.btnSpeichern = new JButton("Speichern");
		this.btnSpeichern.addActionListener(this);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.ipadx = 5;
		gbc_btnSpeichern.anchor = GridBagConstraints.SOUTH;
		gbc_btnSpeichern.insets = new Insets(5, 5, 5, 5);
		gbc_btnSpeichern.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeichern.gridx = 0;
		gbc_btnSpeichern.gridy = 0;
		this.panel_button.add(this.btnSpeichern, gbc_btnSpeichern);
		
		this.btnAbbrechen = new JButton("Abbrechen");
		this.btnAbbrechen.addActionListener(this);
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.ipadx = 80;
		gbc_btnAbbrechen.insets = new Insets(5, 5, 5, 5);
		gbc_btnAbbrechen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbbrechen.gridx = 1;
		gbc_btnAbbrechen.gridy = 0;
		this.panel_button.add(this.btnAbbrechen, gbc_btnAbbrechen);
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
		if(e.getActionCommand().equals("Speichern"))
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
				JOptionPane.showMessageDialog(null, "Fehler beim speichern \n vermutlich wurde ein Buchstabe anstatt einer Zahl eingegeben", "Fehler!", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getActionCommand().equals("Abbrechen"))
		{
			this.dispose();
		}							
	}
	public static void initGui()
	{
		if(Dialog_Klassenauswahl.dlg_adm_FachAnlegen == null)
			Dialog_Klassenauswahl.dlg_adm_FachAnlegen = new Dialog_adm_FachAnlegen();
		
		Dialog_Klassenauswahl.dlg_adm_FachAnlegen.setVisible(true);
		Dialog_Klassenauswahl.dlg_adm_FachAnlegen.toFront();
	}
	
}
