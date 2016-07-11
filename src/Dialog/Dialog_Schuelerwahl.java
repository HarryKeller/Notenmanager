package Dialog;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Fachklassen.Klasse;
import Fachklassen.Lehrer;
import Fachklassen.Schueler;
import Persistenz.DBZugriff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Dialog_Schuelerwahl extends JFrame implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Lehrer;
	private JTextField textField_Klasse;
	
	DefaultListModel<Schueler> dlm = new DefaultListModel<Schueler>();
	JList<Schueler> list_Schueler;
	JButton button_Notenblatt;
	JButton button_Zeugnisnoten;
	JButton button_Zeugnis;
	
	Lehrer lehrer;
	Klasse klasse;
	private JButton btnZurck;
	
	public Dialog_Schuelerwahl() 
	{
		initGUI();
	}
	public Dialog_Schuelerwahl(Lehrer lehrer, Klasse klasse) 
	{
		initGUI();
		this.lehrer = lehrer;
		this.klasse = klasse;
		setDatenInMaske();
	}
	private void initGUI() 
	{
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 560, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 267, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 10, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{50, 0, 25, 50, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel label_Lehrer = new JLabel("Lehrer");
				GridBagConstraints gbc_label_Lehrer = new GridBagConstraints();
				gbc_label_Lehrer.fill = GridBagConstraints.HORIZONTAL;
				gbc_label_Lehrer.insets = new Insets(0, 0, 0, 5);
				gbc_label_Lehrer.gridx = 0;
				gbc_label_Lehrer.gridy = 0;
				panel.add(label_Lehrer, gbc_label_Lehrer);
			}
			{
				textField_Lehrer = new JTextField();
				textField_Lehrer.setEditable(false);
				GridBagConstraints gbc_textField_Lehrer = new GridBagConstraints();
				gbc_textField_Lehrer.insets = new Insets(0, 0, 0, 5);
				gbc_textField_Lehrer.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Lehrer.gridx = 1;
				gbc_textField_Lehrer.gridy = 0;
				panel.add(textField_Lehrer, gbc_textField_Lehrer);
				textField_Lehrer.setColumns(10);
			}
			{
				JLabel label_Klasse = new JLabel("Klasse");
				GridBagConstraints gbc_label_Klasse = new GridBagConstraints();
				gbc_label_Klasse.insets = new Insets(0, 0, 0, 5);
				gbc_label_Klasse.gridx = 3;
				gbc_label_Klasse.gridy = 0;
				panel.add(label_Klasse, gbc_label_Klasse);
			}
			{
				textField_Klasse = new JTextField();
				textField_Klasse.setEditable(false);
				GridBagConstraints gbc_textField_Klasse = new GridBagConstraints();
				gbc_textField_Klasse.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Klasse.gridx = 4;
				gbc_textField_Klasse.gridy = 0;
				panel.add(textField_Klasse, gbc_textField_Klasse);
				textField_Klasse.setColumns(10);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 2;
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 2;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				list_Schueler = new JList(dlm);
				scrollPane.setViewportView(list_Schueler);
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 0, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				button_Notenblatt = new JButton("Notenblatt anzeigen");
				button_Notenblatt.addActionListener(this);
				GridBagConstraints gbc_button_Notenblatt = new GridBagConstraints();
				gbc_button_Notenblatt.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Notenblatt.insets = new Insets(0, 0, 0, 5);
				gbc_button_Notenblatt.gridx = 0;
				gbc_button_Notenblatt.gridy = 0;
				panel.add(button_Notenblatt, gbc_button_Notenblatt);
			}
			{
				button_Zeugnisnoten = new JButton("Zeugnisnoten festlegen");
				button_Zeugnisnoten.addActionListener(this);
				GridBagConstraints gbc_button_Zeugnisnoten = new GridBagConstraints();
				gbc_button_Zeugnisnoten.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Zeugnisnoten.insets = new Insets(0, 0, 0, 5);
				gbc_button_Zeugnisnoten.gridx = 1;
				gbc_button_Zeugnisnoten.gridy = 0;
				panel.add(button_Zeugnisnoten, gbc_button_Zeugnisnoten);
			}
			{
				button_Zeugnis = new JButton("Zeugnis anzeigen");
				button_Zeugnis.addActionListener(this);
				GridBagConstraints gbc_button_Zeugnis = new GridBagConstraints();
				gbc_button_Zeugnis.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Zeugnis.gridx = 2;
				gbc_button_Zeugnis.gridy = 0;
				panel.add(button_Zeugnis, gbc_button_Zeugnis);
			}
		}
		{
			btnZurck = new JButton("Zur\u00FCck");
			btnZurck.addActionListener(this);
			GridBagConstraints gbc_btnZurck = new GridBagConstraints();
			gbc_btnZurck.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnZurck.gridx = 2;
			gbc_btnZurck.gridy = 3;
			contentPanel.add(btnZurck, gbc_btnZurck);
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(this.button_Notenblatt.getActionCommand()))
		{
//			try
//			{
				Dialog_Notenblatt dlg_notenblatt = new Dialog_Notenblatt((Schueler)this.list_Schueler.getSelectedValue(), this);
				this.setVisible(false);
				dlg_notenblatt.setVisible(true);
//			}
//			catch(Exception ex)
//			{
//				System.out.println(ex.getMessage());
//				JOptionPane.showMessageDialog(null, "Es wurde kein Schueler ausgewählt oder ein anderer Fehler ist aufgetreten!", "Warnung!", JOptionPane.OK_OPTION);
//			}
		}
		if(e.getActionCommand().equals(this.button_Zeugnisnoten.getActionCommand()))
		{
			try
			{
				Dialog_ZeugnisnotenZumSchueler dlg_zeugnisnoten = new Dialog_ZeugnisnotenZumSchueler(((Schueler)this.list_Schueler.getSelectedValue()),this);
				this.setVisible(false);
				dlg_zeugnisnoten.setVisible(true);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Es wurde kein Schueler ausgewählt oder ein anderer Fehler ist aufgetreten!", "Warnung!", JOptionPane.OK_OPTION);
			}
		}
		if(e.getActionCommand().equals(this.button_Zeugnis.getActionCommand()))
		{
			try
			{
				Dialog_Zeugnis dlg_zeugnis = new Dialog_Zeugnis();
				this.setVisible(false);
				dlg_zeugnis.setVisible(true);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Es wurde kein Schueler ausgewählt oder ein anderer Fehler ist aufgetreten!", "Warnung!", JOptionPane.OK_OPTION);
			}
		}
		if(e.getActionCommand().equals(this.btnZurck.getActionCommand()))
		{
			this.dispose();
		}
	}
	
	public void setDatenInMaske()
	{		
		this.textField_Lehrer.setText(this.lehrer.getNachname() + " " + this.lehrer.getVorname());
		this.textField_Klasse.setText(this.klasse.getBez());
		
		setDatenInListbox();
	}
	
	public void setDatenInListbox()
	{
		ArrayList<Schueler> al = new ArrayList<Schueler>();
        DBZugriff.alleLesen("Schueler", al, "WHERE klasse_id= " + klasse.getid());
        for(Schueler s : al)
        {
        	this.dlm.addElement(s);
        }
	}
}
