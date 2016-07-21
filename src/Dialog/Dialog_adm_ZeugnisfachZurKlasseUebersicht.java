package Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fachklassen.Klasse;
import Fachklassen.Zeugnisfach;

import java.awt.GridBagLayout;

import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;

public class Dialog_adm_ZeugnisfachZurKlasseUebersicht extends JFrame implements ActionListener 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Zeugnisfach> tmp_zfaecher = new ArrayList<Zeugnisfach>();
	private JList<Zeugnisfach> list_zfaecher;
	private DefaultListModel<Zeugnisfach> listmodel_zfaecher = new DefaultListModel<Zeugnisfach>();
	private JComboBox<Zeugnisfach> comboBox_neuzfaecher;
	private Klasse klasse;

	public Dialog_adm_ZeugnisfachZurKlasseUebersicht(Klasse k)
	{
		setTitle("Dialog - Zeugnisf\u00E4cher der Klasse bearbeiten");
		setKlasse(k);
		initGUI();
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public void initGUI() 
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{47, 95, 128, 147, 151, 151, 39, 0};
		gbl_contentPane.rowHeights = new int[]{39, 424, 42, 37, 67, 46, 35, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Zeugnisfächer der Klasse " + getKlasse().getBez(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{424, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		list_zfaecher = new JList<Zeugnisfach>();
		list_zfaecher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(list_zfaecher);
		
		comboBox_neuzfaecher = new JComboBox<Zeugnisfach>();
		comboBox_neuzfaecher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 5;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		contentPane.add(comboBox_neuzfaecher, gbc_comboBox);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnZurck.addActionListener(this);
		GridBagConstraints gbc_btnZurck = new GridBagConstraints();
		gbc_btnZurck.fill = GridBagConstraints.BOTH;
		gbc_btnZurck.insets = new Insets(0, 0, 5, 5);
		gbc_btnZurck.gridx = 1;
		gbc_btnZurck.gridy = 5;
		contentPane.add(btnZurck, gbc_btnZurck);
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHinzufgen.addActionListener(this);
		GridBagConstraints gbc_btnHinzufgen = new GridBagConstraints();
		gbc_btnHinzufgen.fill = GridBagConstraints.BOTH;
		gbc_btnHinzufgen.insets = new Insets(0, 0, 5, 5);
		gbc_btnHinzufgen.gridx = 2;
		gbc_btnHinzufgen.gridy = 5;
		contentPane.add(btnHinzufgen, gbc_btnHinzufgen);
		
		JButton btnVerwerfen = new JButton("Verwerfen");
		btnVerwerfen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVerwerfen.addActionListener(this);
		GridBagConstraints gbc_btnVerwerfen = new GridBagConstraints();
		gbc_btnVerwerfen.fill = GridBagConstraints.BOTH;
		gbc_btnVerwerfen.insets = new Insets(0, 0, 5, 5);
		gbc_btnVerwerfen.gridx = 3;
		gbc_btnVerwerfen.gridy = 5;
		contentPane.add(btnVerwerfen, gbc_btnVerwerfen);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLschen.addActionListener(this);
		GridBagConstraints gbc_btnLschen = new GridBagConstraints();
		gbc_btnLschen.fill = GridBagConstraints.BOTH;
		gbc_btnLschen.insets = new Insets(0, 0, 5, 5);
		gbc_btnLschen.gridx = 4;
		gbc_btnLschen.gridy = 5;
		contentPane.add(btnLschen, gbc_btnLschen);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSpeichern.addActionListener(this);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.fill = GridBagConstraints.BOTH;
		gbc_btnSpeichern.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpeichern.gridx = 5;
		gbc_btnSpeichern.gridy = 5;
		contentPane.add(btnSpeichern, gbc_btnSpeichern);
		setDatenInMaske();
	}
	
	public void setDatenInMaske()
	{
		listmodel_zfaecher.clear();
		for(Zeugnisfach z: getKlasse().getlstzeugnisfach())
		{
			listmodel_zfaecher.addElement(z);
		}
		list_zfaecher.setModel(listmodel_zfaecher);
		
		comboBox_neuzfaecher.removeAllItems();
		ArrayList<Zeugnisfach> tmp_zlist = Zeugnisfach.alleLesen();
		for(Zeugnisfach tmp_z:tmp_zlist)
		{
			boolean found = false;
			for(int i = 0; i<listmodel_zfaecher.size(); i++)
			{
				if(tmp_z.getId()==listmodel_zfaecher.getElementAt(i).getId())
				{
					found = true;
				}
			}
			if(found!=true)
			{
				comboBox_neuzfaecher.addItem(tmp_z);
			}
		}
	}




	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="Zur\u00FCck")
		{
			this.dispose();
			Dialog_adm_KlasseBearbeiten dia = new Dialog_adm_KlasseBearbeiten(getKlasse());
			dia.pack();
			dia.setVisible(true);
		}
		else if(e.getActionCommand()=="Verwerfen")
		{
			tmp_zfaecher.removeAll(tmp_zfaecher);
			setDatenInMaske();
		}
		else if(e.getActionCommand()=="L\u00F6schen")
		{
			listmodel_zfaecher.remove(list_zfaecher.getSelectedIndex());
		}
		else if(e.getActionCommand()=="Hinzuf\u00FCgen")
		{
			tmp_zfaecher.add((Zeugnisfach)comboBox_neuzfaecher.getSelectedItem());
			listmodel_zfaecher.addElement((Zeugnisfach)comboBox_neuzfaecher.getSelectedItem());
			comboBox_neuzfaecher.removeItemAt(comboBox_neuzfaecher.getSelectedIndex());
			list_zfaecher.setModel(listmodel_zfaecher);
		}
		else if(e.getActionCommand()=="Speichern")
		{
			Set<Zeugnisfach> zfach = new HashSet<Zeugnisfach>();
			for(int i = 0; i<listmodel_zfaecher.size();i++)
			{
				zfach.add(listmodel_zfaecher.getElementAt(i));
			}
			getKlasse().setLstzeugnisfach(zfach);
			getKlasse().speichern();
			this.dispose();
			Dialog_adm_KlasseBearbeiten dia = new Dialog_adm_KlasseBearbeiten(getKlasse());
			dia.pack();
			dia.setDatenToMaske();
			dia.setVisible(true);
		}
		
	}




	public Klasse getKlasse() {
		return klasse;
	}




	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}




	public DefaultListModel<Zeugnisfach> getListmodel_zfaecher() {
		return listmodel_zfaecher;
	}




	public void setListmodel_zfaecher(DefaultListModel<Zeugnisfach> listmodel_zfaecher) {
		this.listmodel_zfaecher = listmodel_zfaecher;
	}




	public List<Zeugnisfach> getTmp_zfaecher() {
		return tmp_zfaecher;
	}




	public void setTmp_zfaecher(List<Zeugnisfach> tmp_zfaecher) {
		this.tmp_zfaecher = tmp_zfaecher;
	}

}
