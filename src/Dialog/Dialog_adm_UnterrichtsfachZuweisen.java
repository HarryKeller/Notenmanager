package Dialog;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.JList;

import Fachklassen.Lehrer;
import Fachklassen.UFachLehrer;
import Fachklassen.Unterrichtsfach;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Dialog_adm_UnterrichtsfachZuweisen extends JFrame implements ActionListener, ItemListener
{

	private JPanel contentPane;
	private JPanel panel;
	private JComboBox<Lehrer> comboBox_Lehrer;
	private JLabel lblLehrer;
	private JLabel lblUFach;
	private JComboBox<Unterrichtsfach> comboBox_UFach;
	private JLabel lblListUFach1;
	private JLabel lblListUFach2;
	private JList<Unterrichtsfach> list_UFach;
	private JPanel panel_buttons;
	private JButton btnSpeichern;
	private JButton btnZurueck;
	private DefaultListModel<Unterrichtsfach> model = new DefaultListModel<Unterrichtsfach>();
	private JButton btnHinzufuegen;
	private JButton btnEntfernen;
	private JScrollPane scrollPane;
	private ArrayList<Unterrichtsfach> kopie = new ArrayList<Unterrichtsfach>();
	private ArrayList<Unterrichtsfach> ufach;

	/**
	 * Create the frame.
	 */
	private  Dialog_adm_UnterrichtsfachZuweisen()
	{	
		setExtendedState(MAXIMIZED_BOTH);
		initGUI();
		setDatenInMaske();		
	}
	
	private void initGUI() 
	{
		setTitle("Unterrichtsf\u00E4cher zuweisen");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 375);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 12, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 80.0;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.contentPane.add(this.panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		this.panel.setLayout(gbl_panel);
		
		this.lblLehrer = new JLabel("Lehrer : ");
		this.lblLehrer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLehrer = new GridBagConstraints();
		gbc_lblLehrer.insets = new Insets(5, 5, 5, 5);
		gbc_lblLehrer.anchor = GridBagConstraints.WEST;
		gbc_lblLehrer.gridx = 0;
		gbc_lblLehrer.gridy = 0;
		this.panel.add(this.lblLehrer, gbc_lblLehrer);
		
		this.comboBox_Lehrer = new JComboBox<Lehrer>();
		this.comboBox_Lehrer.addItemListener(this);
		this.comboBox_Lehrer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox_Lehrer = new GridBagConstraints();
		gbc_comboBox_Lehrer.gridwidth = 2;
		gbc_comboBox_Lehrer.insets = new Insets(5, 5, 5, 0);
		gbc_comboBox_Lehrer.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Lehrer.gridx = 1;
		gbc_comboBox_Lehrer.gridy = 0;
		this.panel.add(this.comboBox_Lehrer, gbc_comboBox_Lehrer);
		
		this.lblUFach = new JLabel("Unterrichtsfach : ");
		this.lblUFach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblUFach = new GridBagConstraints();
		gbc_lblUFach.anchor = GridBagConstraints.WEST;
		gbc_lblUFach.insets = new Insets(0, 5, 5, 5);
		gbc_lblUFach.gridx = 0;
		gbc_lblUFach.gridy = 1;
		this.panel.add(this.lblUFach, gbc_lblUFach);
		
		this.comboBox_UFach = new JComboBox<Unterrichtsfach>();
		this.comboBox_UFach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox_UFach = new GridBagConstraints();
		gbc_comboBox_UFach.gridwidth = 2;
		gbc_comboBox_UFach.insets = new Insets(5, 5, 5, 0);
		gbc_comboBox_UFach.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_UFach.gridx = 1;
		gbc_comboBox_UFach.gridy = 1;
		this.panel.add(this.comboBox_UFach, gbc_comboBox_UFach);
		
		this.lblListUFach1 = new JLabel("Unterrichtsf\u00E4cher des");
		GridBagConstraints gbc_lblListUFach1 = new GridBagConstraints();
		gbc_lblListUFach1.anchor = GridBagConstraints.WEST;
		gbc_lblListUFach1.insets = new Insets(0, 5, 5, 5);
		gbc_lblListUFach1.gridx = 0;
		gbc_lblListUFach1.gridy = 2;
		this.panel.add(this.lblListUFach1, gbc_lblListUFach1);
		
		this.lblListUFach2 = new JLabel("ausgew\u00E4hlten Lehrers :");
		GridBagConstraints gbc_lblListUFach2 = new GridBagConstraints();
		gbc_lblListUFach2.anchor = GridBagConstraints.WEST;
		gbc_lblListUFach2.insets = new Insets(0, 5, 5, 5);
		gbc_lblListUFach2.gridx = 0;
		gbc_lblListUFach2.gridy = 3;
		this.panel.add(this.lblListUFach2, gbc_lblListUFach2);
		
		this.scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 5, 5, 0);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		this.panel.add(this.scrollPane, gbc_scrollPane);
		
		this.list_UFach = new JList<Unterrichtsfach>(model);
		this.scrollPane.setViewportView(this.list_UFach);
		this.list_UFach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
		this.btnHinzufuegen.addActionListener(this);
		GridBagConstraints gbc_btnHinzufuegen = new GridBagConstraints();
		gbc_btnHinzufuegen.weightx = 50.0;
		gbc_btnHinzufuegen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHinzufuegen.insets = new Insets(5, 5, 0, 5);
		gbc_btnHinzufuegen.gridx = 1;
		gbc_btnHinzufuegen.gridy = 5;
		this.panel.add(this.btnHinzufuegen, gbc_btnHinzufuegen);
		
		this.btnEntfernen = new JButton("Entfernen");
		this.btnEntfernen.addActionListener(this);
		GridBagConstraints gbc_btnEntfernen = new GridBagConstraints();
		gbc_btnEntfernen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEntfernen.weightx = 50.0;
		gbc_btnEntfernen.insets = new Insets(5, 5, 0, 5);
		gbc_btnEntfernen.gridx = 2;
		gbc_btnEntfernen.gridy = 5;
		this.panel.add(this.btnEntfernen, gbc_btnEntfernen);
		
		this.panel_buttons = new JPanel();
		GridBagConstraints gbc_panel_buttons = new GridBagConstraints();
		gbc_panel_buttons.fill = GridBagConstraints.BOTH;
		gbc_panel_buttons.gridx = 0;
		gbc_panel_buttons.gridy = 1;
		this.contentPane.add(this.panel_buttons, gbc_panel_buttons);
		GridBagLayout gbl_panel_buttons = new GridBagLayout();
		gbl_panel_buttons.columnWidths = new int[]{0, 0, 0};
		gbl_panel_buttons.rowHeights = new int[]{0, 0};
		gbl_panel_buttons.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_buttons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
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
		gbc_btnZurueck.gridy = 0;
		this.panel_buttons.add(this.btnZurueck, gbc_btnZurueck);
	}

	public void setDatenInMaske()
	{
		for(Lehrer l : Lehrer.alleLesen())
		{
			comboBox_Lehrer.addItem(l);
		}		
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getActionCommand().equals(btnSpeichern.getActionCommand())) 
		{								
			entfernen();			
			speichern();
			this.dispose();			
		}
		if(arg0.getActionCommand().equals(btnZurueck.getActionCommand()))
		{
			this.dispose();
		}		
		if(arg0.getActionCommand().equals(btnHinzufuegen.getActionCommand())) 
		{
			model.addElement((Unterrichtsfach) comboBox_UFach.getSelectedItem());
			comboBox_UFach.removeItemAt(comboBox_UFach.getSelectedIndex());
		}		
		if(arg0.getActionCommand().equals(btnEntfernen.getActionCommand())) 
		{
			if(list_UFach.getSelectedValue() != null)
			{
				comboBox_UFach.addItem(list_UFach.getSelectedValue());
				model.removeElement(list_UFach.getSelectedValue());
			}			
		}
	}
	
	public void itemStateChanged(ItemEvent e) 
	{
		comboBox_UFach.removeAllItems();
		model.removeAllElements();
		
		ufach = Unterrichtsfach.alleLesen((Lehrer) comboBox_Lehrer.getSelectedItem(), LocalDate.now());
		
		for(Unterrichtsfach u : Unterrichtsfach.AlleLesen())
		{
			comboBox_UFach.addItem(u);	
			
			for(Unterrichtsfach uf : ufach)
			{
				if(u.equals(uf))
				{
					comboBox_UFach.removeItem(u);
				}
			}			
		}
		
		for(Unterrichtsfach uf : ufach)
		{
			model.addElement(uf);
		}
		kopie = klonen(ufach);
	}
	
	
	private void entfernen()
	{
		boolean entfernt = false;
		
		for(Unterrichtsfach u : kopie)	// Fächer in kopie
		{
			entfernt = true;
			for(int i = 0; i < model.getSize();i++) // Fächer in ufach
			{
				if(u.equals(model.getElementAt(i)))	// wenn beide Fächer gleich dann
				{
					entfernt = false;	// flag auf false setzen und for verlassen
					break;
				}
			}
			if(entfernt == true)	// wenn ein Fach entfernt wurde dann
			{
					try
					{
						UFachLehrer uflehrer = UFachLehrer.unterrichtetzurzeit((Lehrer)comboBox_Lehrer.getSelectedItem(), u, LocalDate.now());
						uflehrer.setaustrittsdatum(LocalDate.now());
						uflehrer.speichern();
					}
					catch (Exception e)
					{
					}																
			}
		}
	}
	
	private void speichern()
	{
		boolean unterrichtetfach = false;						
		
		for(int i=0 ; i<model.getSize();i++)
		{
			unterrichtetfach = UFachLehrer.unterrichtetLehrerZurzeitFach((Lehrer) comboBox_Lehrer.getSelectedItem(), model.getElementAt(i));
			if(unterrichtetfach == false)
			{
				UFachLehrer ufachl = new UFachLehrer();
				ufachl.setLehrer((Lehrer) comboBox_Lehrer.getSelectedItem());
				ufachl.setUfach(model.getElementAt(i));
				ufachl.seteintrittsdatum(LocalDate.now());				
				ufachl.setaustrittsdatum(LocalDate.parse("2300-01-01"));
				ufachl.setstunden(0);
				ufachl.speichern();
			}
		}
	}
	
	private  ArrayList<Unterrichtsfach> klonen(ArrayList<Unterrichtsfach> al) 
	{
		ArrayList<Unterrichtsfach> klon = new ArrayList<Unterrichtsfach>();
		for(Unterrichtsfach uf:al)
		{
			klon.add(new Unterrichtsfach(new Unterrichtsfach(uf)));
		}
	
		return klon;
	}
	public static void initGui()
	{
		if(Dialog_Klassenauswahl.dlg_adm_UnterrichtsfachZuweisen== null)
			Dialog_Klassenauswahl.dlg_adm_UnterrichtsfachZuweisen = new Dialog_adm_UnterrichtsfachZuweisen();
		
		Dialog_Klassenauswahl.dlg_adm_UnterrichtsfachZuweisen.setVisible(true);
		Dialog_Klassenauswahl.dlg_adm_UnterrichtsfachZuweisen.toFront();
	}

}
