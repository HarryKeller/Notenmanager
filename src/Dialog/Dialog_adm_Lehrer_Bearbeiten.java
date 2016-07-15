package Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton button_Zurueck;
	
	Lehrer lehrer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			Dialog_adm_Lehrer_Bearbeiten dialog = new Dialog_adm_Lehrer_Bearbeiten();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_adm_Lehrer_Bearbeiten()
	{
		this.lehrer = new Lehrer();
		initGUI();
		setDatenInMaske();
	}

	public Dialog_adm_Lehrer_Bearbeiten(Lehrer lehrer)
	{
		this.lehrer = lehrer;
		initGUI();
		setDatenInMaske();
	}

	public void initGUI()
	{
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
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel label_Lehrer_Vorname = new JLabel("Vorname");
				GridBagConstraints gbc_label_Lehrer_Vorname = new GridBagConstraints();
				gbc_label_Lehrer_Vorname.anchor = GridBagConstraints.EAST;
				gbc_label_Lehrer_Vorname.insets = new Insets(0, 0, 5, 5);
				gbc_label_Lehrer_Vorname.gridx = 0;
				gbc_label_Lehrer_Vorname.gridy = 0;
				panel.add(label_Lehrer_Vorname, gbc_label_Lehrer_Vorname);
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
				JLabel label_Lehrer_Nachname = new JLabel("Nachname");
				GridBagConstraints gbc_label_Lehrer_Nachname = new GridBagConstraints();
				gbc_label_Lehrer_Nachname.anchor = GridBagConstraints.EAST;
				gbc_label_Lehrer_Nachname.insets = new Insets(0, 0, 5, 5);
				gbc_label_Lehrer_Nachname.gridx = 0;
				gbc_label_Lehrer_Nachname.gridy = 1;
				panel.add(label_Lehrer_Nachname, gbc_label_Lehrer_Nachname);
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
				JLabel label_Lehrer_Dienstbezeichnung = new JLabel("Dienstbezeichnung");
				GridBagConstraints gbc_label_Lehrer_Dienstbezeichnung = new GridBagConstraints();
				gbc_label_Lehrer_Dienstbezeichnung.anchor = GridBagConstraints.EAST;
				gbc_label_Lehrer_Dienstbezeichnung.insets = new Insets(0, 0, 5, 5);
				gbc_label_Lehrer_Dienstbezeichnung.gridx = 0;
				gbc_label_Lehrer_Dienstbezeichnung.gridy = 2;
				panel.add(label_Lehrer_Dienstbezeichnung, gbc_label_Lehrer_Dienstbezeichnung);
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
				JLabel label_Lehrer_Kuerzel = new JLabel("K\u00FCrzel");
				GridBagConstraints gbc_label_Lehrer_Kuerzel = new GridBagConstraints();
				gbc_label_Lehrer_Kuerzel.anchor = GridBagConstraints.EAST;
				gbc_label_Lehrer_Kuerzel.insets = new Insets(0, 0, 0, 5);
				gbc_label_Lehrer_Kuerzel.gridx = 0;
				gbc_label_Lehrer_Kuerzel.gridy = 3;
				panel.add(label_Lehrer_Kuerzel, gbc_label_Lehrer_Kuerzel);
			}
			{
				textField_Lehrer_Kuerzel = new JTextField();
				GridBagConstraints gbc_textField_Lehrer_Kuerzel = new GridBagConstraints();
				gbc_textField_Lehrer_Kuerzel.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Lehrer_Kuerzel.gridx = 1;
				gbc_textField_Lehrer_Kuerzel.gridy = 3;
				panel.add(textField_Lehrer_Kuerzel, gbc_textField_Lehrer_Kuerzel);
				textField_Lehrer_Kuerzel.setColumns(10);
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
			gbl_panel.columnWidths = new int[]{100, 100, 100, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
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
			{
				button_Zurueck = new JButton("Zurueck");
				button_Zurueck.addActionListener(this);
				GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
				gbc_button_Zurueck.gridwidth = 3;
				gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Zurueck.gridx = 0;
				gbc_button_Zurueck.gridy = 1;
				panel.add(button_Zurueck, gbc_button_Zurueck);
			}
		}
	}
	private void setDatenInMaske()
	{
		this.textField_Lehrer_Vorname.setText(this.lehrer.getVorname());
		this.textField_Lehrer_Nachname.setText(this.lehrer.getNachname());
		this.textField_Lehrer_Dienstbezeichnung.setText(this.lehrer.getDienstbezeichnung());
		this.textField_Lehrer_Kuerzel.setText(this.lehrer.getKuerzel());
	}
	private void getDatenInMaske()
	{
		this.lehrer.setVorname(this.textField_Lehrer_Vorname.getText());
		this.lehrer.setNachname(this.textField_Lehrer_Nachname.getText());
		this.lehrer.setDienstbezeichnung(this.textField_Lehrer_Dienstbezeichnung.getText());
		this.lehrer.setKuerzel(this.textField_Lehrer_Kuerzel.getText());
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
					lehrer.speichern();
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
		if(arg0.getActionCommand().equals(this.button_Zurueck.getActionCommand()))
		{
			this.dispose();
		}
	}
}
