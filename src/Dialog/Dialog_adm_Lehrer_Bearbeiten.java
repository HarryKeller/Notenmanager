package Dialog;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Fachklassen.Lehrer;
import Fachklassen.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class Dialog_adm_Lehrer_Bearbeiten extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Lehrer_Vorname;
	private JTextField textField_Lehrer_Nachname;
	private JTextField textField_Lehrer_Dienstbezeichnung;
	private JTextField textField_Lehrer_Kuerzel;
	
	private JButton button_Lehrer_Speichern;
	private JButton button_Lehrer_Verwerfen;
	private JButton button_Lehrer_Leeren;
	private JButton btnZurck;
	private Lehrer lehrer;
	private JLabel lblAdmin;
	private JCheckBox chkBox_adm;
	private Login login;
	private boolean gesichert;
	
	public Dialog_adm_Lehrer_Bearbeiten()
	{
		initGUI();
	}

	public Dialog_adm_Lehrer_Bearbeiten(Lehrer lehrer)
	{
		this.lehrer = lehrer;
		login = new Login(lehrer);				
	}

	public void initGUI()
	{
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.lehrer = new Lehrer();
		login = new Login(lehrer);
		
		
		setTitle("Lehrer - Bearbeiten");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 270);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 0, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 0, 0, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridheight = 2;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblVorname = new JLabel("Vorname :");
				GridBagConstraints gbc_lblVorname = new GridBagConstraints();
				gbc_lblVorname.anchor = GridBagConstraints.EAST;
				gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
				gbc_lblVorname.gridx = 0;
				gbc_lblVorname.gridy = 0;
				panel.add(lblVorname, gbc_lblVorname);
			}
			{
				textField_Lehrer_Vorname = new JTextField();
				GridBagConstraints gbc_textField_Lehrer_Vorname = new GridBagConstraints();
				gbc_textField_Lehrer_Vorname.insets = new Insets(0, 0, 5, 0);
				gbc_textField_Lehrer_Vorname.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Lehrer_Vorname.gridx = 1;
				gbc_textField_Lehrer_Vorname.gridy = 0;
				panel.add(textField_Lehrer_Vorname, gbc_textField_Lehrer_Vorname);
				textField_Lehrer_Vorname.setColumns(10);
			}
			{
				JLabel lblNachname = new JLabel("Nachname :");
				GridBagConstraints gbc_lblNachname = new GridBagConstraints();
				gbc_lblNachname.anchor = GridBagConstraints.EAST;
				gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
				gbc_lblNachname.gridx = 0;
				gbc_lblNachname.gridy = 1;
				panel.add(lblNachname, gbc_lblNachname);
			}
			{
				textField_Lehrer_Nachname = new JTextField();
				GridBagConstraints gbc_textField_Lehrer_Nachname = new GridBagConstraints();
				gbc_textField_Lehrer_Nachname.insets = new Insets(0, 0, 5, 0);
				gbc_textField_Lehrer_Nachname.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Lehrer_Nachname.gridx = 1;
				gbc_textField_Lehrer_Nachname.gridy = 1;
				panel.add(textField_Lehrer_Nachname, gbc_textField_Lehrer_Nachname);
				textField_Lehrer_Nachname.setColumns(10);
			}
			{
				JLabel lblDienstbezeichnung = new JLabel("Dienstbezeichnung :");
				GridBagConstraints gbc_lblDienstbezeichnung = new GridBagConstraints();
				gbc_lblDienstbezeichnung.anchor = GridBagConstraints.EAST;
				gbc_lblDienstbezeichnung.insets = new Insets(0, 0, 5, 5);
				gbc_lblDienstbezeichnung.gridx = 0;
				gbc_lblDienstbezeichnung.gridy = 2;
				panel.add(lblDienstbezeichnung, gbc_lblDienstbezeichnung);
			}
			{
				textField_Lehrer_Dienstbezeichnung = new JTextField();
				GridBagConstraints gbc_textField_Lehrer_Dienstbezeichnung = new GridBagConstraints();
				gbc_textField_Lehrer_Dienstbezeichnung.insets = new Insets(0, 0, 5, 0);
				gbc_textField_Lehrer_Dienstbezeichnung.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Lehrer_Dienstbezeichnung.gridx = 1;
				gbc_textField_Lehrer_Dienstbezeichnung.gridy = 2;
				panel.add(textField_Lehrer_Dienstbezeichnung, gbc_textField_Lehrer_Dienstbezeichnung);
				textField_Lehrer_Dienstbezeichnung.setColumns(10);
			}
			{
				JLabel lblKrzel = new JLabel("K\u00FCrzel :");
				GridBagConstraints gbc_lblKrzel = new GridBagConstraints();
				gbc_lblKrzel.anchor = GridBagConstraints.EAST;
				gbc_lblKrzel.insets = new Insets(0, 0, 5, 5);
				gbc_lblKrzel.gridx = 0;
				gbc_lblKrzel.gridy = 3;
				panel.add(lblKrzel, gbc_lblKrzel);
			}
			{
				textField_Lehrer_Kuerzel = new JTextField();
				GridBagConstraints gbc_textField_Lehrer_Kuerzel = new GridBagConstraints();
				gbc_textField_Lehrer_Kuerzel.insets = new Insets(0, 0, 5, 0);
				gbc_textField_Lehrer_Kuerzel.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Lehrer_Kuerzel.gridx = 1;
				gbc_textField_Lehrer_Kuerzel.gridy = 3;
				panel.add(textField_Lehrer_Kuerzel, gbc_textField_Lehrer_Kuerzel);
				textField_Lehrer_Kuerzel.setColumns(10);
			}
			{
				this.lblAdmin = new JLabel("Admin :");
				GridBagConstraints gbc_lblAdmin = new GridBagConstraints();
				gbc_lblAdmin.anchor = GridBagConstraints.EAST;
				gbc_lblAdmin.insets = new Insets(0, 0, 0, 5);
				gbc_lblAdmin.gridx = 0;
				gbc_lblAdmin.gridy = 4;
				panel.add(this.lblAdmin, gbc_lblAdmin);
			}
			{
				this.chkBox_adm = new JCheckBox("");
				GridBagConstraints gbc_chkBox_adm = new GridBagConstraints();
				gbc_chkBox_adm.anchor = GridBagConstraints.WEST;
				gbc_chkBox_adm.gridx = 1;
				gbc_chkBox_adm.gridy = 4;
				panel.add(this.chkBox_adm, gbc_chkBox_adm);
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 2;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{100, 100, 100};
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				btnZurck = new JButton("Zur\u00FCck");
				btnZurck.addActionListener(this);
				{
					button_Lehrer_Speichern = new JButton("Speichern");
					button_Lehrer_Speichern.addActionListener(this);
					GridBagConstraints gbc_button_Lehrer_Speichern = new GridBagConstraints();
					gbc_button_Lehrer_Speichern.fill = GridBagConstraints.HORIZONTAL;
					gbc_button_Lehrer_Speichern.insets = new Insets(0, 0, 5, 5);
					gbc_button_Lehrer_Speichern.gridx = 0;
					gbc_button_Lehrer_Speichern.gridy = 0;
					panel.add(button_Lehrer_Speichern, gbc_button_Lehrer_Speichern);
				}
				{
					button_Lehrer_Verwerfen = new JButton("Verwerfen");
					button_Lehrer_Verwerfen.addActionListener(this);
					GridBagConstraints gbc_button_Lehrer_Verwerfen = new GridBagConstraints();
					gbc_button_Lehrer_Verwerfen.fill = GridBagConstraints.HORIZONTAL;
					gbc_button_Lehrer_Verwerfen.insets = new Insets(0, 0, 5, 5);
					gbc_button_Lehrer_Verwerfen.gridx = 1;
					gbc_button_Lehrer_Verwerfen.gridy = 0;
					panel.add(button_Lehrer_Verwerfen, gbc_button_Lehrer_Verwerfen);
				}
				{
					button_Lehrer_Leeren = new JButton("Leeren");
					button_Lehrer_Leeren.addActionListener(this);
					GridBagConstraints gbc_button_Lehrer_Leeren = new GridBagConstraints();
					gbc_button_Lehrer_Leeren.fill = GridBagConstraints.HORIZONTAL;
					gbc_button_Lehrer_Leeren.insets = new Insets(0, 0, 5, 0);
					gbc_button_Lehrer_Leeren.gridx = 2;
					gbc_button_Lehrer_Leeren.gridy = 0;
					panel.add(button_Lehrer_Leeren, gbc_button_Lehrer_Leeren);
				}
				GridBagConstraints gbc_btnZurck = new GridBagConstraints();
				gbc_btnZurck.gridwidth = 3;
				gbc_btnZurck.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnZurck.gridx = 0;
				gbc_btnZurck.gridy = 1;
				panel.add(btnZurck, gbc_btnZurck);
			}
		}
	}
	private void setDatenInMaske()
	{
		this.textField_Lehrer_Vorname.setText(this.lehrer.getVorname());
		this.textField_Lehrer_Nachname.setText(this.lehrer.getNachname());
		this.textField_Lehrer_Dienstbezeichnung.setText(this.lehrer.getDienstbezeichnung());
		this.textField_Lehrer_Kuerzel.setText(this.lehrer.getKuerzel());
		if(new Login(lehrer).isAdmin())
		{
			this.chkBox_adm.setSelected(true);
		}
		else
		{
			this.chkBox_adm.setSelected(false);
		}
		
	}
	private void getDatenInMaske()
	{
		this.lehrer.setVorname(this.textField_Lehrer_Vorname.getText());
		this.lehrer.setNachname(this.textField_Lehrer_Nachname.getText());
		this.lehrer.setDienstbezeichnung(this.textField_Lehrer_Dienstbezeichnung.getText());
		this.lehrer.setKuerzel(this.textField_Lehrer_Kuerzel.getText());
		this.login.setAdmin(chkBox_adm.isSelected());
		
	}
	public boolean ShowDialog()
	{
		initGUI();
		if(!Login.isMehrAlsEinLehrerAdmin()&& login.isAdmin())
		{
			chkBox_adm.setEnabled(false);
		}
		setDatenInMaske();
		
		this.setVisible(true);
		
		return this.gesichert;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getActionCommand().equals(this.button_Lehrer_Speichern.getActionCommand()))
		{
			try
			{				
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Wollen sie den Lehrer wirklich speichern?", "Achtung!", JOptionPane.YES_NO_OPTION))
				{
					getDatenInMaske();
					lehrer.setArbeitetAnDieserSchule(true);
					lehrer.speichern();
					login.speichern();
					
					this.gesichert = true;
					
					this.dispose();
				}
				else
				{
				
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Lehrer konnte nicht gespeichert werden");
			}

		}
		if(arg0.getActionCommand().equals(this.button_Lehrer_Verwerfen.getActionCommand()))
		{
			setDatenInMaske();
		}
		if(arg0.getActionCommand().equals(this.button_Lehrer_Leeren.getActionCommand()))
		{
			this.textField_Lehrer_Vorname.setText("");
			this.textField_Lehrer_Nachname.setText("");
			this.textField_Lehrer_Dienstbezeichnung.setText("");
			this.textField_Lehrer_Kuerzel.setText("");
		}
		if(arg0.getActionCommand().equals(this.btnZurck.getActionCommand()))
		{
			this.dispose();
		}
	}
}
