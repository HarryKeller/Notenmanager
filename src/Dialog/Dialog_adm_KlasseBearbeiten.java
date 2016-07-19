package Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fachklassen.Ausbildungszweig;
import Fachklassen.Klasse;
import Fachklassen.Lehrer;
import Fachklassen.Schueler;
import Fachklassen.Schule;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class Dialog_adm_KlasseBearbeiten extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JLabel label_id;
	private JComboBox<Schule> comboBox_Schule;
	private JComboBox<Lehrer> comboBox_Klassenleiter_1;
	private JComboBox<Lehrer> comboBox_Klassenleiter_2;
	private JComboBox<Ausbildungszweig> comboBox_Ausbildungszweig;
	private JTextField textField_bez;
	private JTextField textField_Schuljahr;
	private JList<Schueler> list;
	private DefaultListModel<Schueler> klasse_schueler_model = new DefaultListModel<Schueler>();
	
	private Klasse klasse = null;
	

	/**
	 * @wbp.parser.constructor
	 */
	public Dialog_adm_KlasseBearbeiten()
	{
		initFrame();
	}
	
	public Dialog_adm_KlasseBearbeiten(Klasse k)
	{
		this.setKlasse(k);
		initFrame();
	}
	
	public void initFrame() 
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTitle("Admin - Klasse bearbeiten");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{46, 403, 446, 426, 41, 0};
		gridBagLayout.rowHeights = new int[]{33, 42, 39, 41, 39, 39, 38, 58, 37, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("Klassen-ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.fill = GridBagConstraints.VERTICAL;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 0;
		getContentPane().add(lblId, gbc_lblId);
		
		label_id = new JLabel("");
		label_id.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSchuljahr = new GridBagConstraints();
		gbc_lblSchuljahr.anchor = GridBagConstraints.WEST;
		gbc_lblSchuljahr.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchuljahr.gridx = 2;
		gbc_lblSchuljahr.gridy = 0;
		contentPane.add(label_id, gbc_lblSchuljahr);
		
		JLabel lblSchule = new JLabel("Schule:");
		lblSchule.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSchule = new GridBagConstraints();
		gbc_lblSchule.anchor = GridBagConstraints.EAST;
		gbc_lblSchule.fill = GridBagConstraints.VERTICAL;
		gbc_lblSchule.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchule.gridx = 1;
		gbc_lblSchule.gridy = 1;
		getContentPane().add(lblSchule, gbc_lblSchule);
		
		comboBox_Schule = new JComboBox<Schule>();
		comboBox_Schule.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox_Schule, gbc_comboBox);
		
		JLabel lblKlasenleiter = new JLabel("1. Klassenleiter:");
		lblKlasenleiter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblKlasenleiter = new GridBagConstraints();
		gbc_lblKlasenleiter.anchor = GridBagConstraints.EAST;
		gbc_lblKlasenleiter.fill = GridBagConstraints.VERTICAL;
		gbc_lblKlasenleiter.insets = new Insets(0, 0, 5, 5);
		gbc_lblKlasenleiter.gridx = 1;
		gbc_lblKlasenleiter.gridy = 2;
		getContentPane().add(lblKlasenleiter, gbc_lblKlasenleiter);
		
		comboBox_Klassenleiter_1 = new JComboBox<Lehrer>();
		comboBox_Klassenleiter_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 2;
		getContentPane().add(comboBox_Klassenleiter_1, gbc_comboBox_1);
		
		JLabel lblKlassenleiter = new JLabel("2. Klassenleiter:");
		lblKlassenleiter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblKlassenleiter = new GridBagConstraints();
		gbc_lblKlassenleiter.anchor = GridBagConstraints.EAST;
		gbc_lblKlassenleiter.fill = GridBagConstraints.VERTICAL;
		gbc_lblKlassenleiter.insets = new Insets(0, 0, 5, 5);
		gbc_lblKlassenleiter.gridx = 1;
		gbc_lblKlassenleiter.gridy = 3;
		getContentPane().add(lblKlassenleiter, gbc_lblKlassenleiter);
		
		comboBox_Klassenleiter_2 = new JComboBox<Lehrer>();
		comboBox_Klassenleiter_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 2;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.BOTH;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 3;
		getContentPane().add(comboBox_Klassenleiter_2, gbc_comboBox_2);
		
		JLabel label = new JLabel("Ausbildungszweig:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 4;
		contentPane.add(label, gbc_label);
		
		comboBox_Ausbildungszweig = new JComboBox<Ausbildungszweig>();
		GridBagConstraints gbc_comboBox_Ausbildungsrichtung = new GridBagConstraints();
		gbc_comboBox_Ausbildungsrichtung.gridwidth = 2;
		gbc_comboBox_Ausbildungsrichtung.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Ausbildungsrichtung.fill = GridBagConstraints.BOTH;
		gbc_comboBox_Ausbildungsrichtung.gridx = 2;
		gbc_comboBox_Ausbildungsrichtung.gridy = 4;
		contentPane.add(comboBox_Ausbildungszweig, gbc_comboBox_Ausbildungsrichtung);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblBezeichnung = new GridBagConstraints();
		gbc_lblBezeichnung.anchor = GridBagConstraints.EAST;
		gbc_lblBezeichnung.fill = GridBagConstraints.VERTICAL;
		gbc_lblBezeichnung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBezeichnung.gridx = 1;
		gbc_lblBezeichnung.gridy = 5;
		getContentPane().add(lblBezeichnung, gbc_lblBezeichnung);
		
		textField_bez = new JTextField();
		textField_bez.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 5;
		getContentPane().add(textField_bez, gbc_textField);
		textField_bez.setColumns(10);
		
		JLabel lblSchuljahr = new JLabel("Schuljahr:");
		lblSchuljahr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSchuljahr1 = new GridBagConstraints();
		gbc_lblSchuljahr1.anchor = GridBagConstraints.EAST;
		gbc_lblSchuljahr1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchuljahr1.gridx = 1;
		gbc_lblSchuljahr1.gridy = 6;
		contentPane.add(lblSchuljahr, gbc_lblSchuljahr1);
		
		textField_Schuljahr = new JTextField();
		textField_Schuljahr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textField1 = new GridBagConstraints();
		gbc_textField1.gridwidth = 2;
		gbc_textField1.insets = new Insets(0, 0, 5, 5);
		gbc_textField1.fill = GridBagConstraints.BOTH;
		gbc_textField1.gridx = 2;
		gbc_textField1.gridy = 6;
		contentPane.add(textField_Schuljahr, gbc_textField1);
		textField_Schuljahr.setColumns(10);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Schüler der Klasse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{403, 446, 371, 0};
		gbl_panel.rowHeights = new int[]{58, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		list = new JList<Schueler>();
		scrollPane.setViewportView(list);
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnZurck = new GridBagConstraints();
		gbc_btnZurck.fill = GridBagConstraints.BOTH;
		gbc_btnZurck.insets = new Insets(0, 0, 5, 5);
		gbc_btnZurck.gridx = 1;
		gbc_btnZurck.gridy = 8;
		getContentPane().add(btnZurck, gbc_btnZurck);
		
		JButton btnVerwerfen = new JButton("Verwerfen");
		btnVerwerfen.addActionListener(this);
		btnVerwerfen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnVerwerfen = new GridBagConstraints();
		gbc_btnVerwerfen.fill = GridBagConstraints.BOTH;
		gbc_btnVerwerfen.insets = new Insets(0, 0, 5, 5);
		gbc_btnVerwerfen.gridx = 2;
		gbc_btnVerwerfen.gridy = 8;
		getContentPane().add(btnVerwerfen, gbc_btnVerwerfen);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(this);
		btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpeichern.fill = GridBagConstraints.BOTH;
		gbc_btnSpeichern.gridx = 3;
		gbc_btnSpeichern.gridy = 8;
		getContentPane().add(btnSpeichern, gbc_btnSpeichern);
		
		setDatenToMaske();
	}
	
	public void getDatenFromMaske()
	{
		klasse.setIdSchule((Schule)comboBox_Schule.getSelectedItem());
		klasse.setIdKlassenleiter((Lehrer)comboBox_Klassenleiter_1.getSelectedItem());
		klasse.setIdStvKlassenleiter((Lehrer)comboBox_Klassenleiter_2.getSelectedItem());
		klasse.setAusbildungszweig((Ausbildungszweig)comboBox_Ausbildungszweig.getSelectedItem());
		klasse.setBez(textField_bez.getText());
		klasse.setSj(Integer.parseInt(textField_Schuljahr.getText()));
	}
	
	
	public void setDatenToMaske()
	{
		if(klasse!=null)
		{
			label_id.setText(Integer.toString(klasse.getid()));
			comboBox_Schule.removeAllItems();
			int count =0;
			for(Schule s: Schule.alleLesen())
			{
				if(s.getID()==klasse.getIdSchule().getID())
				{	
					comboBox_Schule.addItem(s);
					comboBox_Schule.setSelectedIndex(count);
				}
				else
				{
					comboBox_Schule.addItem(s);
				}
				count++;
			}
			
			
			ArrayList<Lehrer> llist = Lehrer.alleLesen();
			comboBox_Klassenleiter_1.removeAllItems();
			for(Lehrer l: llist)
			{
				comboBox_Klassenleiter_1.addItem(l);
			}
			for(int i=0; i< comboBox_Klassenleiter_1.getItemCount()-1;i++)
			{
				if(comboBox_Klassenleiter_1.getItemAt(i).getId() == klasse.getIdKlassenleiter().getId())
				{
					comboBox_Klassenleiter_1.setSelectedIndex(i);
				}
			}
			comboBox_Klassenleiter_2.removeAllItems();
			for(Lehrer l: llist)
			{
				comboBox_Klassenleiter_2.addItem(l);
			}
			for(int i=0; i< comboBox_Klassenleiter_2.getItemCount()-1;i++)
			{
				if(comboBox_Klassenleiter_2.getItemAt(i).getId() == klasse.getIdStvKlassenleiter().getId())
				{
					comboBox_Klassenleiter_2.setSelectedIndex(i);
				}
			}
			
			ArrayList<Ausbildungszweig> alist = Ausbildungszweig.alleLesen();
			comboBox_Ausbildungszweig.removeAllItems();
			for(Ausbildungszweig l: alist)
			{
				comboBox_Ausbildungszweig.addItem(l);
			}
			for(int i=0; i< comboBox_Ausbildungszweig.getItemCount()-1;i++)
			{
				if(comboBox_Ausbildungszweig.getItemAt(i).getId() == klasse.getAusbildungszweig().getId())
				{
					comboBox_Ausbildungszweig.setSelectedIndex(i);
				}
			}
			
			textField_bez.setText(klasse.getBez());
			textField_Schuljahr.setText(Integer.toString(klasse.getSj()));
			klasse_schueler_model.clear();;
			for(Schueler s:klasse.getSchueler())
			{
				klasse_schueler_model.addElement(s);
			}
			list.setModel(klasse_schueler_model);
			
		}
		else
		{
			this.setKlasse(new Klasse());
			comboBox_Schule.removeAllItems();
			comboBox_Klassenleiter_1.removeAllItems();
			comboBox_Klassenleiter_2.removeAllItems();
			comboBox_Ausbildungszweig.removeAllItems();
			for(Schule s: Schule.alleLesen())
			{
				comboBox_Schule.addItem(s);
			}
			for(Lehrer l: Lehrer.alleLesen())
			{
				comboBox_Klassenleiter_1.addItem(l);
				comboBox_Klassenleiter_2.addItem(l);
			}
			for(Ausbildungszweig l: Ausbildungszweig.alleLesen())
			{
				comboBox_Ausbildungszweig.addItem(l);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="Zur\u00FCck")
		{
			this.dispose();
			Dialog_adm_KlasseAnsicht an = new Dialog_adm_KlasseAnsicht();
			an.pack();
			an.setVisible(true);
		}
		else if(e.getActionCommand()=="Verwerfen")
		{
			setDatenToMaske();
		}
		else if(e.getActionCommand()=="Speichern")
		{
			getDatenFromMaske();
			if(klasse.getid()!=0)
			{
				klasse.speichern();
				this.dispose();
				Dialog_adm_KlasseAnsicht an = new Dialog_adm_KlasseAnsicht();
				an.setDatenToMaske();
				an.pack();
				an.setVisible(true);
			}
			else
			{
				if(klasse.getBez()!=""&&klasse.getIdKlassenleiter()!=null&&klasse.getIdStvKlassenleiter()!=null&&klasse.getSj()!=0)
				{
					klasse.speichern();
					this.dispose();
					Dialog_adm_KlasseAnsicht an = new Dialog_adm_KlasseAnsicht();
					an.setDatenToMaske();
					an.pack();
					an.setVisible(true);
				}
			}
		}
	}


	public Klasse getKlasse() {
		return klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

	public JTextField getTextField_Schuljahr() {
		return textField_Schuljahr;
	}

	public void setTextField_Schuljahr(JTextField textField_Schuljahr) {
		this.textField_Schuljahr = textField_Schuljahr;
	}


	public DefaultListModel<Schueler> getKlasse_schueler_model() {
		return klasse_schueler_model;
	}

	public void setKlasse_schueler_model(DefaultListModel<Schueler> klasse_schueler_model) {
		this.klasse_schueler_model = klasse_schueler_model;
	}


}
