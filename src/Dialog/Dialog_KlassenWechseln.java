package Dialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
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
	private JLabel lblList1;
	private JLabel lblList2;
	
	private JList<Schueler> list_schueler;
	private JList<Schueler> list_neueSchueler;
	
	private DefaultListModel<Schueler> schuelermodel = new DefaultListModel<Schueler>();
	private DefaultListModel<Schueler> neuschuelermodel = new DefaultListModel<Schueler>();
	
	private JComboBox<Klasse> comboBox_rechts = new JComboBox<Klasse>();
	private DefaultComboBoxModel<Klasse> cmodel_rechts = new DefaultComboBoxModel<Klasse>();
	private JComboBox<Klasse> comboBox_links = new JComboBox<Klasse>();
	private DefaultComboBoxModel<Klasse> cmodel_links = new DefaultComboBoxModel<Klasse>();
	
	private JPanel panel_buttons;
	private JButton btnSpeichern;
	private Lehrer l;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnZurueck;
	
	private boolean schranke = false;
	
	public Dialog_KlassenWechseln(Lehrer l)
	{
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
		gbl_contentPane.columnWidths = new int[]{203, 161, 0};
		gbl_contentPane.rowHeights = new int[]{251, 17, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.weighty = 85.0;
		gbc_panel.insets = new Insets(5, 5, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.contentPane.add(this.panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{721, 700, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		this.panel.setLayout(gbl_panel);
		
		this.lblList1 = new JLabel("Sch\u00FCler der alten Klasse");
		GridBagConstraints gbc_lblList1 = new GridBagConstraints();
		gbc_lblList1.insets = new Insets(5, 5, 5, 5);
		gbc_lblList1.gridx = 0;
		gbc_lblList1.gridy = 0;
		this.panel.add(this.lblList1, gbc_lblList1);
		this.comboBox_rechts.addItemListener(this);
		this.comboBox_links.addItemListener(this);
		
		this.lblList2 = new JLabel("Sch\u00FCler der neuen Klasse :");
		GridBagConstraints gbc_lblList2 = new GridBagConstraints();
		gbc_lblList2.anchor = GridBagConstraints.NORTH;
		gbc_lblList2.insets = new Insets(5, 5, 5, 0);
		gbc_lblList2.gridx = 1;
		gbc_lblList2.gridy = 0;
		this.panel.add(this.lblList2, gbc_lblList2);
		GridBagConstraints gbc_comboBox_links = new GridBagConstraints();
		gbc_comboBox_links.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox_links.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_links.gridx = 0;
		gbc_comboBox_links.gridy = 1;
		this.panel.add(this.comboBox_links, gbc_comboBox_links);
		GridBagConstraints gbc_comboBox_rechts = new GridBagConstraints();
		gbc_comboBox_rechts.insets = new Insets(5, 5, 5, 0);
		gbc_comboBox_rechts.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_rechts.gridx = 1;
		gbc_comboBox_rechts.gridy = 1;
		this.panel.add(this.comboBox_rechts, gbc_comboBox_rechts);
		
		this.scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weightx = 50.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(5, 5, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		this.panel.add(this.scrollPane, gbc_scrollPane);
		
		this.list_schueler = new JList<Schueler>(schuelermodel);
		this.scrollPane.setViewportView(this.list_schueler);
		
		this.scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.weightx = 50.0;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(5, 5, 0, 0);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 2;
		this.panel.add(this.scrollPane_1, gbc_scrollPane_1);
		
		this.list_neueSchueler = new JList<Schueler>(neuschuelermodel);
		this.list_neueSchueler.setEnabled(false);
		this.scrollPane_1.setViewportView(this.list_neueSchueler);
		
		this.panel_buttons = new JPanel();
		GridBagConstraints gbc_panel_buttons = new GridBagConstraints();
		gbc_panel_buttons.gridwidth = 2;
		gbc_panel_buttons.insets = new Insets(5, 5, 5, 5);
		gbc_panel_buttons.weighty = 5.0;
		gbc_panel_buttons.fill = GridBagConstraints.BOTH;
		gbc_panel_buttons.gridx = 0;
		gbc_panel_buttons.gridy = 1;
		this.contentPane.add(this.panel_buttons, gbc_panel_buttons);
		GridBagLayout gbl_panel_buttons = new GridBagLayout();
		gbl_panel_buttons.columnWidths = new int[]{0, 0, 0};
		gbl_panel_buttons.rowHeights = new int[]{0, 0};
		gbl_panel_buttons.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
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
		gbc_btnZurueck.gridy = 0;
		this.panel_buttons.add(this.btnZurueck, gbc_btnZurueck);
	}

	private void setDatenInMaske()
	{
		schranke = false;
		schuelermodel.removeAllElements();
		neuschuelermodel.removeAllElements();
		cmodel_links.removeAllElements();
		cmodel_rechts.removeAllElements();
		
		for(Klasse ka : Klasse.alleLesen())
		{		
			cmodel_links.addElement(ka);
		}
		int i = cmodel_links.getSize();
		for(int count=0; count < i;count++)
		{
			if(!cmodel_links.getElementAt(count).equals(cmodel_links.getSelectedItem()))
			{
				cmodel_rechts.addElement(cmodel_links.getElementAt(count));
			}
		}
		comboBox_links.setModel(cmodel_links);
		comboBox_rechts.setModel(cmodel_rechts);
		setSchuelerLeftRight();
		schranke = true;
	}
	
	

	
	public void itemStateChanged(ItemEvent e) 
	{
			if(e.getSource().equals(comboBox_links)&&e.getStateChange()== ItemEvent.SELECTED&&schranke == true)
			{
					if(((Klasse)comboBox_rechts.getSelectedItem()).getid()==((Klasse)comboBox_links.getSelectedItem()).getId())
					{
						schranke = false;
						cmodel_rechts.removeAllElements();
						for(Klasse k: Klasse.alleLesen())
						{
							if(k.getId()!=((Klasse)cmodel_links.getSelectedItem()).getId())
							{
								cmodel_rechts.addElement(k);
							}
						}
						comboBox_rechts.setModel(cmodel_rechts);
						schranke = true;
						
					}	
					setSchuelerLeftRight();
			}
			else if(e.getSource().equals(comboBox_rechts)&&e.getStateChange()== ItemEvent.SELECTED&&schranke == true)
			{
					if(((Klasse)comboBox_rechts.getSelectedItem()).getid()==((Klasse)comboBox_links.getSelectedItem()).getId())
					{
						schranke = false;
						cmodel_links.removeAllElements();
						for(Klasse k: Klasse.alleLesen())
						{
							if(k.getId()!=((Klasse)cmodel_rechts.getSelectedItem()).getId())
							{
								cmodel_links.addElement(k);
							}
						}
						comboBox_links.setModel(cmodel_links);
						schranke = true;
						
					}
					setSchuelerLeftRight();
			}
		
	}
	
	private void setSchuelerLeftRight()
	{
		schranke = false;
		schuelermodel.clear();
		neuschuelermodel.clear();
		for(Schueler s:((Klasse)cmodel_links.getSelectedItem()).getSchuelerlist())
		{
			schuelermodel.addElement(s);
		}
		for(Schueler s:((Klasse)cmodel_rechts.getSelectedItem()).getSchuelerlist())
		{
			neuschuelermodel.addElement(s);
		}
		list_schueler.setModel(schuelermodel);
		list_neueSchueler.setModel(neuschuelermodel);
		schranke = true;
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(btnSpeichern.getActionCommand()))
		{	
			schranke = false;
			List<Schueler> selectedSchueler = new ArrayList<Schueler>();
			selectedSchueler = this.list_schueler.getSelectedValuesList();
			for(Schueler s : selectedSchueler)
			{
				s.setKlasseid((Klasse)comboBox_rechts.getSelectedItem());
				s.speichern(l);	
				((Klasse)comboBox_rechts.getSelectedItem()).getSchuelerlist().add(s);
				((Klasse)comboBox_links.getSelectedItem()).getSchuelerlist().remove(s);
			}
			schranke = true;
			setDatenInMaske();
		}
		else
		{
			this.dispose();
		}
	}

	public DefaultComboBoxModel<Klasse> getCmodel_rechts() {
		return cmodel_rechts;
	}

	public void setCmodel_rechts(DefaultComboBoxModel<Klasse> cmodel_rechts) {
		this.cmodel_rechts = cmodel_rechts;
	}

	public DefaultComboBoxModel<Klasse> getCmodel_links() {
		return cmodel_links;
	}

	public void setCmodel_links(DefaultComboBoxModel<Klasse> cmodel_links) {
		this.cmodel_links = cmodel_links;
	}
}
