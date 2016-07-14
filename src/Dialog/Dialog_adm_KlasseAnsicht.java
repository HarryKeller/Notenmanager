package Dialog;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fachklassen.Klasse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.Font;

public class Dialog_adm_KlasseAnsicht extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<Klasse> list = new JList<Klasse>();
	private DefaultListModel<Klasse> klistmodel = new DefaultListModel<Klasse>();
	private Dialog_Klassenauswahl dia;
	public Dialog_adm_KlasseAnsicht(){}
	public Dialog_adm_KlasseAnsicht(Dialog_Klassenauswahl d)
	{
		this.setDia(d);
		initFrame();
	}

	public  void initFrame()
	{
		setTitle("Admin - Klassenverwaltung");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{61, 284, 260, 67, 0};
		gbl_contentPane.rowHeights = new int[]{27, 0, 39, 40, 16, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		scrollPane.setViewportView(list);
		
		JButton btnKlasseBearbeiten = new JButton("Klasse bearbeiten");
		btnKlasseBearbeiten.addActionListener(this);
		GridBagConstraints gbc_btnKlasseBearbeiten = new GridBagConstraints();
		gbc_btnKlasseBearbeiten.fill = GridBagConstraints.BOTH;
		gbc_btnKlasseBearbeiten.insets = new Insets(0, 0, 5, 5);
		gbc_btnKlasseBearbeiten.gridx = 1;
		gbc_btnKlasseBearbeiten.gridy = 2;
		contentPane.add(btnKlasseBearbeiten, gbc_btnKlasseBearbeiten);
		
		JButton btnKlasseHinzufgen = new JButton("Klasse hinzuf\u00FCgen");
		btnKlasseHinzufgen.addActionListener(this);
		GridBagConstraints gbc_btnKlasseHinzufgen = new GridBagConstraints();
		gbc_btnKlasseHinzufgen.fill = GridBagConstraints.BOTH;
		gbc_btnKlasseHinzufgen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKlasseHinzufgen.gridx = 2;
		gbc_btnKlasseHinzufgen.gridy = 2;
		contentPane.add(btnKlasseHinzufgen, gbc_btnKlasseHinzufgen);
		
		JButton btnKlasseLschen = new JButton("Klasse l\u00F6schen");
		btnKlasseLschen.addActionListener(this);
		GridBagConstraints gbc_btnKlasseLschen = new GridBagConstraints();
		gbc_btnKlasseLschen.fill = GridBagConstraints.BOTH;
		gbc_btnKlasseLschen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKlasseLschen.gridx = 1;
		gbc_btnKlasseLschen.gridy = 3;
		contentPane.add(btnKlasseLschen, gbc_btnKlasseLschen);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(this);
		GridBagConstraints gbc_btnZurck = new GridBagConstraints();
		gbc_btnZurck.fill = GridBagConstraints.BOTH;
		gbc_btnZurck.insets = new Insets(0, 0, 5, 5);
		gbc_btnZurck.gridx = 2;
		gbc_btnZurck.gridy = 3;
		contentPane.add(btnZurck, gbc_btnZurck);
		
		setDatenToMaske();
	}
	
	public void setDatenToMaske()
	{
		klistmodel.clear();
		for(Klasse k: Klasse.alleLesen())
		{
			klistmodel.addElement(k);
		}
		list.setModel(klistmodel);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="Klasse bearbeiten")
		{
			if(list.isSelectionEmpty()!=true)
			{
				Dialog_adm_KlasseBearbeiten dia = new Dialog_adm_KlasseBearbeiten(list.getSelectedValue(), this);
				dia.pack();
				this.setVisible(false);
				dia.setVisible(true);
			}
		}
		else if(e.getActionCommand()=="Klasse hinzuf\u00FCgen")
		{
			Dialog_adm_KlasseBearbeiten dia = new Dialog_adm_KlasseBearbeiten(this);
			dia.pack();
			this.setVisible(false);
			dia.setVisible(true);
		}
		else if(e.getActionCommand()=="Klasse l\u00F6schen")
		{
			try
			{
				Klasse k = list.getSelectedValue();
				k.loeschen();
				setDatenToMaske();
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Die Klasse besitzt noch abhängige Daten!","Achtung",JOptionPane.OK_OPTION);
			}
			
		}
		else if(e.getActionCommand()=="Zur\u00FCck")
		{
			this.dispose();
			dia.setVisible(true);
		}
		
	}

	public DefaultListModel<Klasse> getKlistmodel() {
		return klistmodel;
	}

	public void setKlistmodel(DefaultListModel<Klasse> klistmodel) {
		this.klistmodel = klistmodel;
	}
	public Dialog_Klassenauswahl getDia() {
		return dia;
	}
	public void setDia(Dialog_Klassenauswahl dia) {
		this.dia = dia;
	}

}
