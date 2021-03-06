package Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fachklassen.Ausbildungszweig;
import Fachklassen.DatumSJ;
import Fachklassen.Klasse;
import Fachklassen.Lehrer;
import Fachklassen.Schueler;
import Fachklassen.Schule;
import Fachklassen.Zeugnisfach;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
	private JComboBox<DatumSJ> comboBox_SJ = new JComboBox<DatumSJ>();
	private JTextField textField_bez;
	private JList<Schueler> list;
	private DefaultListModel<Schueler> klasse_schueler_model = new DefaultListModel<Schueler>();
	private JList<Zeugnisfach> list_zeugnisfach;
	private DefaultListModel<Zeugnisfach> klasse_zeugnisfach_model = new DefaultListModel<Zeugnisfach>();
	
	private Klasse klasse = null;
	
	/**
	 * Konstruktor, wenn eine neue Klasse erstellt werden soll.
	 */
	private  Dialog_adm_KlasseBearbeiten()
	{

		initFrame();
	}
	
	/**
	 * Konstruktor, wenn eine bereits vorhandene Klasse editiert werden soll.
	 * @param k
	 * type Klasse
	 */
	private  Dialog_adm_KlasseBearbeiten(Klasse k)
	{
		this.setKlasse(k);
		initFrame();
	}
	
	/**
	 * Zeig die GUI an.
	 */
	private void initFrame() 
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTitle("Admin - Klasse bearbeiten");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{41, 262, 336, 326, 330, 35, 0};
		gridBagLayout.rowHeights = new int[]{33, 42, 39, 41, 39, 39, 38, 250, 214, 37, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_comboBox_Schuljahr = new GridBagConstraints();
		gbc_comboBox_Schuljahr.gridwidth = 3;
		gbc_comboBox_Schuljahr.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Schuljahr.fill = GridBagConstraints.BOTH;
		gbc_comboBox_Schuljahr.gridx = 2;
		gbc_comboBox_Schuljahr.gridy = 1;
		getContentPane().add(comboBox_Schule, gbc_comboBox_Schuljahr);
		
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
		gbc_comboBox_1.gridwidth = 3;
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
		gbc_comboBox_2.gridwidth = 3;
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
		gbc_comboBox_Ausbildungsrichtung.gridwidth = 3;
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
		gbc_textField.gridwidth = 3;
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
		
		
		GridBagConstraints gbc_comboBox_SJ;
		gbc_comboBox_SJ = new GridBagConstraints();
		gbc_comboBox_SJ.gridwidth = 3;
		gbc_comboBox_SJ.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_SJ.fill = GridBagConstraints.BOTH;
		gbc_comboBox_SJ.gridx = 2;
		gbc_comboBox_SJ.gridy = 6;
		this.contentPane.add(comboBox_SJ, gbc_comboBox_SJ);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Schüler der Klasse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth = 4;
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Zeugnisfächer der Klasse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 8;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{403, 446, 426, 0};
		gbl_panel_1.rowHeights = new int[]{214, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		list_zeugnisfach = new JList<Zeugnisfach>();
		scrollPane_1.setViewportView(list_zeugnisfach);
		
		JButton btnVerwerfen = new JButton("Verwerfen");
		btnVerwerfen.addActionListener(this);
		
		JButton btnZeugnisfcherBearbeiten = new JButton("Zeugnisf\u00E4cher bearbeiten");
		btnZeugnisfcherBearbeiten.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnZeugnisfcherBearbeiten.addActionListener(this);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(this);
		btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpeichern.fill = GridBagConstraints.BOTH;
		gbc_btnSpeichern.gridx = 1;
		gbc_btnSpeichern.gridy = 9;
		getContentPane().add(btnSpeichern, gbc_btnSpeichern);
		GridBagConstraints gbc_btnZeugnisfcherBearbeiten = new GridBagConstraints();
		gbc_btnZeugnisfcherBearbeiten.fill = GridBagConstraints.BOTH;
		gbc_btnZeugnisfcherBearbeiten.insets = new Insets(0, 0, 5, 5);
		gbc_btnZeugnisfcherBearbeiten.gridx = 2;
		gbc_btnZeugnisfcherBearbeiten.gridy = 9;
		contentPane.add(btnZeugnisfcherBearbeiten, gbc_btnZeugnisfcherBearbeiten);
		btnVerwerfen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnVerwerfen = new GridBagConstraints();
		gbc_btnVerwerfen.fill = GridBagConstraints.BOTH;
		gbc_btnVerwerfen.insets = new Insets(0, 0, 5, 5);
		gbc_btnVerwerfen.gridx = 3;
		gbc_btnVerwerfen.gridy = 9;
		getContentPane().add(btnVerwerfen, gbc_btnVerwerfen);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(this);
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnZurck = new GridBagConstraints();
		gbc_btnZurck.fill = GridBagConstraints.BOTH;
		gbc_btnZurck.insets = new Insets(0, 0, 5, 5);
		gbc_btnZurck.gridx = 4;
		gbc_btnZurck.gridy = 9;
		getContentPane().add(btnZurck, gbc_btnZurck);
		
		setDatenToMaske();
	}
	
	
	/**
	 * Holt sich die Daten aus der Maske und füllt die Attribute der Klasse mit den Daten.
	 */
	public void getDatenFromMaske()
	{
		klasse.setIdSchule((Schule)comboBox_Schule.getSelectedItem());
		klasse.setIdKlassenleiter((Lehrer)comboBox_Klassenleiter_1.getSelectedItem());
		klasse.setIdStvKlassenleiter((Lehrer)comboBox_Klassenleiter_2.getSelectedItem());
		klasse.setAusbildungszweig((Ausbildungszweig)comboBox_Ausbildungszweig.getSelectedItem());
		klasse.setBez(textField_bez.getText());
		klasse.setSj((DatumSJ)comboBox_SJ.getSelectedItem());
	}
	
	/**
	 * Wenn eine Klasse gegeben ist, werden die Werte der Klasse selectiert und die restlichen Werte mit eingefügt. 
	 * Sollte die Klasse null sein, werden automatisch die Standartwerte selectiert.
	 */
	public void setDatenToMaske()
	{
		if(klasse!=null)
		{
			comboBox_Schule.removeAllItems();
			comboBox_Klassenleiter_1.removeAllItems();
			comboBox_Klassenleiter_2.removeAllItems();
			comboBox_Ausbildungszweig.removeAllItems();
			klasse_schueler_model.clear();
			klasse_zeugnisfach_model.clear();
			comboBox_SJ.removeAllItems();
			
			
			label_id.setText(Integer.toString(klasse.getid()));
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
			
			
			ArrayList<DatumSJ> dlist = DatumSJ.alleLesen();
			for(DatumSJ l: dlist)
			{
				comboBox_SJ.addItem(l);
			}
			for(int i=0; i< comboBox_SJ.getItemCount()-1;i++)
			{
				if(comboBox_SJ.getItemAt(i).getId() == klasse.getSj().getId())
				{
					comboBox_SJ.setSelectedIndex(i);
				}
			}
			
			
			for(Schueler s:klasse.getSchueler())
			{
				klasse_schueler_model.addElement(s);
			}
			list.setModel(klasse_schueler_model);
			
			
			for(Zeugnisfach z: Zeugnisfach.alleLesen(getKlasse()))
			{
				klasse_zeugnisfach_model.addElement(z);
			}
			list_zeugnisfach.setModel(klasse_zeugnisfach_model);
			
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

	/**
	 * Überschriebene Methode des ActionListeners, um auf Buttons zu reagieren.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="Zur\u00FCck")
		{
			this.dispose();
			Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.initGui();
			Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.pack();
			Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.setVisible(true);
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
				Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.initGui();
				Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.setDatenToMaske();
				Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.pack();
				Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.setVisible(true);
			}
			else
			{
				if(!klasse.getBez().equals("")&&klasse.getIdKlassenleiter()!=null&&klasse.getIdStvKlassenleiter()!=null&&klasse.getSj()!= null&&klasse.getAusbildungszweig()!=null&&klasse.getSchule()!=null)
				{
					klasse.speichern();
					this.dispose();
					Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.initGui();
					Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.setDatenToMaske();
					Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.pack();
					Dialog_Klassenauswahl.dlg_adm_KlasseAnsicht.setVisible(true);
				}
			}
		}
		else if(e.getActionCommand()=="Zeugnisf\u00E4cher bearbeiten")
		{
			if(klasse.getid()!=0)
			{
				this.dispose();
				Dialog_adm_ZeugnisfachZurKlasseUebersicht.initGui(getKlasse());
				Dialog_Klassenauswahl.dlg_adm_ZeugnisfachZurKlasseUebersicht.pack();
				Dialog_Klassenauswahl.dlg_adm_ZeugnisfachZurKlasseUebersicht.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Bitte erst die Klasse eintragen!", "Warnung!", JOptionPane.OK_OPTION);
			}
		}
	}


	public Klasse getKlasse() {
		return klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

	public DefaultListModel<Schueler> getKlasse_schueler_model() {
		return klasse_schueler_model;
	}

	public void setKlasse_schueler_model(DefaultListModel<Schueler> klasse_schueler_model) {
		this.klasse_schueler_model = klasse_schueler_model;
	}

	public DefaultListModel<Zeugnisfach> getKlasse_zeugnisfach_model() {
		return klasse_zeugnisfach_model;
	}

	public void setKlasse_zeugnisfach_model(DefaultListModel<Zeugnisfach> klasse_zeugnisfach_model) {
		this.klasse_zeugnisfach_model = klasse_zeugnisfach_model;
	}

	
	public static void initGui()
	{
		if(Dialog_Klassenauswahl.dlg_adm_KlasseBearbeiten == null)
			Dialog_Klassenauswahl.dlg_adm_KlasseBearbeiten = new Dialog_adm_KlasseBearbeiten();
		
		Dialog_Klassenauswahl.dlg_adm_KlasseBearbeiten.setVisible(true);
		Dialog_Klassenauswahl.dlg_adm_KlasseBearbeiten.toFront();
	}
	public static void initGui(Klasse k)
	{
		if(Dialog_Klassenauswahl.dlg_adm_KlasseBearbeiten == null)
			Dialog_Klassenauswahl.dlg_adm_KlasseBearbeiten = new Dialog_adm_KlasseBearbeiten(k);
		
		Dialog_Klassenauswahl.dlg_adm_KlasseBearbeiten.setVisible(true);
		Dialog_Klassenauswahl.dlg_adm_KlasseBearbeiten.toFront();
	}
	

}
