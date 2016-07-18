package Dialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Fachklassen.Klasse;
import Fachklassen.Lehrer;
import Fachklassen.Schueler;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Dialog_KlassenWechseln extends JFrame implements ItemListener, ActionListener
{

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblKlasse;
	private JLabel lblList1;
	private JLabel lblList2;
	private DefaultListModel<Schueler> model = new DefaultListModel<Schueler>();
	private JList<Schueler> list_schueler;
	private JLabel lblNeueKlasse;
	private JComboBox<Klasse> comboBox_Klassen;
	private JPanel panel_buttons;
	private JButton btnSpeichern;
	private JButton btnZurueck;
	private Klasse k;
	private Lehrer l;
	private JScrollPane scrollPane;
	private DefaultListModel<Schueler> model_neu = new DefaultListModel<Schueler>();
	private JList<Schueler> list_neueSchueler;
	private JScrollPane scrollPane_1;
	private JComboBox<Klasse> comboBox_alteKlasse;

	
	public Dialog_KlassenWechseln(Klasse k, Lehrer l)
	{
		this.k = k;	
		this.l = l;
		initGUI();
		setDatenInMaske();
	}
	private void initGUI() 
	{
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Klasse wechseln");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{783, 29, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.weighty = 95.0;
		gbc_panel.insets = new Insets(5, 5, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.contentPane.add(this.panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{182, 794, 655, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		this.panel.setLayout(gbl_panel);
		
		this.lblKlasse = new JLabel("alte Klasse :");
		GridBagConstraints gbc_lblKlasse = new GridBagConstraints();
		gbc_lblKlasse.weightx = 20.0;
		gbc_lblKlasse.anchor = GridBagConstraints.WEST;
		gbc_lblKlasse.insets = new Insets(5, 5, 5, 5);
		gbc_lblKlasse.gridx = 0;
		gbc_lblKlasse.gridy = 0;
		this.panel.add(this.lblKlasse, gbc_lblKlasse);
		
		this.comboBox_alteKlasse = new JComboBox<Klasse>();
		this.comboBox_alteKlasse.addItemListener(this);
		GridBagConstraints gbc_comboBox_alteKlasse = new GridBagConstraints();
		gbc_comboBox_alteKlasse.gridwidth = 2;
		gbc_comboBox_alteKlasse.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox_alteKlasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_alteKlasse.gridx = 1;
		gbc_comboBox_alteKlasse.gridy = 0;
		this.panel.add(this.comboBox_alteKlasse, gbc_comboBox_alteKlasse);
		
		this.lblNeueKlasse = new JLabel("neue Klasse :");
		GridBagConstraints gbc_lblNeueKlasse = new GridBagConstraints();
		gbc_lblNeueKlasse.anchor = GridBagConstraints.WEST;
		gbc_lblNeueKlasse.insets = new Insets(5, 5, 5, 5);
		gbc_lblNeueKlasse.gridx = 0;
		gbc_lblNeueKlasse.gridy = 1;
		this.panel.add(this.lblNeueKlasse, gbc_lblNeueKlasse);
		
		this.comboBox_Klassen = new JComboBox<Klasse>();
		this.comboBox_Klassen.addItemListener(this);
		GridBagConstraints gbc_comboBox_Klassen = new GridBagConstraints();
		gbc_comboBox_Klassen.gridwidth = 2;
		gbc_comboBox_Klassen.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox_Klassen.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Klassen.gridx = 1;
		gbc_comboBox_Klassen.gridy = 1;
		this.panel.add(this.comboBox_Klassen, gbc_comboBox_Klassen);
		
		this.lblList1 = new JLabel("Sch\u00FCler der alten Klasse");
		GridBagConstraints gbc_lblList1 = new GridBagConstraints();
		gbc_lblList1.insets = new Insets(5, 5, 5, 5);
		gbc_lblList1.gridx = 1;
		gbc_lblList1.gridy = 2;
		this.panel.add(this.lblList1, gbc_lblList1);
		
		this.lblList2 = new JLabel("Sch\u00FCler der neuen Klasse :");
		GridBagConstraints gbc_lblList2 = new GridBagConstraints();
		gbc_lblList2.anchor = GridBagConstraints.NORTH;
		gbc_lblList2.insets = new Insets(5, 5, 5, 0);
		gbc_lblList2.gridx = 2;
		gbc_lblList2.gridy = 2;
		this.panel.add(this.lblList2, gbc_lblList2);
		
		this.scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weightx = 40.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(5, 5, 0, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		this.panel.add(this.scrollPane, gbc_scrollPane);
		
		this.list_schueler = new JList<Schueler>(model);
		this.scrollPane.setViewportView(this.list_schueler);
		
		this.scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(5, 5, 0, 0);
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 3;
		this.panel.add(this.scrollPane_1, gbc_scrollPane_1);
		
		this.list_neueSchueler = new JList<Schueler>(model_neu);
		this.scrollPane_1.setViewportView(this.list_neueSchueler);
		
		this.panel_buttons = new JPanel();
		GridBagConstraints gbc_panel_buttons = new GridBagConstraints();
		gbc_panel_buttons.insets = new Insets(5, 5, 5, 5);
		gbc_panel_buttons.weighty = 5.0;
		gbc_panel_buttons.fill = GridBagConstraints.BOTH;
		gbc_panel_buttons.gridx = 0;
		gbc_panel_buttons.gridy = 1;
		this.contentPane.add(this.panel_buttons, gbc_panel_buttons);
		GridBagLayout gbl_panel_buttons = new GridBagLayout();
		gbl_panel_buttons.columnWidths = new int[]{0, 0};
		gbl_panel_buttons.rowHeights = new int[]{0, 0};
		gbl_panel_buttons.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_buttons.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.panel_buttons.setLayout(gbl_panel_buttons);
		
		this.btnSpeichern = new JButton("Speichern");
		this.btnSpeichern.addActionListener(this);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeichern.insets = new Insets(5, 5, 5, 5);
		gbc_btnSpeichern.gridx = 0;
		gbc_btnSpeichern.gridy = 0;
		this.panel_buttons.add(this.btnSpeichern, gbc_btnSpeichern);
		
		this.btnZurueck = new JButton("Zur\u00FCck");
		this.btnZurueck.addActionListener(this);
		GridBagConstraints gbc_btnZurueck = new GridBagConstraints();
		gbc_btnZurueck.insets = new Insets(5, 5, 5, 5);
		gbc_btnZurueck.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnZurueck.gridx = 1;
		gbc_btnZurueck.gridy = 1;
		this.contentPane.add(this.btnZurueck, gbc_btnZurueck);
	}

	private void setDatenInMaske()
	{
		for(Klasse kl : Klasse.alleLesen())
		{			
			comboBox_alteKlasse.addItem(kl);		
		}
		
		for(Klasse kl : Klasse.alleLesen())
		{
			if(!k.getBez().equals(kl.getBez()))
			{
				comboBox_Klassen.addItem(kl);
			}			
		}	
	}
	
	public void itemStateChanged(ItemEvent arg0) 
	{
		model.removeAllElements();
		model_neu.removeAllElements();	
		
		for(Schueler s : k.getSchueler())
		{
			model.addElement(s);
		}
		
		if(comboBox_Klassen.getSelectedItem() != null)
		{
			for(Schueler s : ((Klasse) comboBox_Klassen.getSelectedItem()).getSchueler())
			{
				model_neu.addElement(s);
			}
		}
		
		
		

		
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getActionCommand().equals(btnSpeichern.getActionCommand()))
		{
			List<Schueler> selectedSchueler = new ArrayList<Schueler>();			
			selectedSchueler = this.list_schueler.getSelectedValuesList();
			for(Schueler s : selectedSchueler)
			{
				s.setKlasseid((Klasse)comboBox_Klassen.getSelectedItem());
				s.speichern(l);		
			}
			setDatenInMaske();
			//this.dispose();
		}
		else
		{
			this.dispose();
		}
	}
}
