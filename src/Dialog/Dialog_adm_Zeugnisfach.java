package Dialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import Fachklassen.Zeugnisfach;
import Persistenz.DBZugriff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Dialog_adm_Zeugnisfach extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton button_Zeugnisfach_anlegen;
	private JButton button_Zeugnisfach_bearbeiten;
	private JButton button_Zeugnisfach_loeschen;
	private JButton button_Zurueck;
	
	private JList<Zeugnisfach> list_Zeugnisfach = new JList<Zeugnisfach>();
	

	public Dialog_adm_Zeugnisfach() 
	{
		setTitle("Zeugnisfach");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 5, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		
		scrollPane.setViewportView(list_Zeugnisfach);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(5, 5, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		button_Zeugnisfach_anlegen = new JButton("Zeugnisfach anlegen");
		button_Zeugnisfach_anlegen.addActionListener(this);
		GridBagConstraints gbc_button_Zeugnisfach_anlegen = new GridBagConstraints();
		gbc_button_Zeugnisfach_anlegen.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_Zeugnisfach_anlegen.insets = new Insets(5, 5, 5, 5);
		gbc_button_Zeugnisfach_anlegen.gridx = 0;
		gbc_button_Zeugnisfach_anlegen.gridy = 0;
		panel_1.add(button_Zeugnisfach_anlegen, gbc_button_Zeugnisfach_anlegen);
		
		button_Zeugnisfach_bearbeiten = new JButton("Zeugnisfach bearbeiten");
		button_Zeugnisfach_bearbeiten.addActionListener(this);
		GridBagConstraints gbc_button_Zeugnisfach_bearbeiten = new GridBagConstraints();
		gbc_button_Zeugnisfach_bearbeiten.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_Zeugnisfach_bearbeiten.insets = new Insets(5, 5, 5, 5);
		gbc_button_Zeugnisfach_bearbeiten.gridx = 1;
		gbc_button_Zeugnisfach_bearbeiten.gridy = 0;
		panel_1.add(button_Zeugnisfach_bearbeiten, gbc_button_Zeugnisfach_bearbeiten);
		
		button_Zeugnisfach_loeschen = new JButton("Zeugnisfach l\u00F6schen");
		button_Zeugnisfach_loeschen.addActionListener(this);
		GridBagConstraints gbc_button_Zeugnisfach_loeschen = new GridBagConstraints();
		gbc_button_Zeugnisfach_loeschen.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_Zeugnisfach_loeschen.insets = new Insets(5, 5, 5, 5);
		gbc_button_Zeugnisfach_loeschen.gridx = 0;
		gbc_button_Zeugnisfach_loeschen.gridy = 1;
		panel_1.add(button_Zeugnisfach_loeschen, gbc_button_Zeugnisfach_loeschen);
		
		button_Zurueck = new JButton("Zur\u00FCck");
		button_Zurueck.addActionListener(this);
		GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
		gbc_button_Zurueck.insets = new Insets(5, 5, 5, 5);
		gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_Zurueck.gridx = 1;
		gbc_button_Zurueck.gridy = 1;
		panel_1.add(button_Zurueck, gbc_button_Zurueck);
		
		this.setList();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(this.button_Zeugnisfach_anlegen.getActionCommand()))
		{
			this.dispose();
			Dialog_adm_Zeugnisfach_Bearbeiten dialog_zeugnisfach = new Dialog_adm_Zeugnisfach_Bearbeiten();
			dialog_zeugnisfach.setVisible(true);
		}	
		if(e.getActionCommand().equals(this.button_Zeugnisfach_bearbeiten.getActionCommand()))
		{
			try
			{
				this.dispose();
				Dialog_adm_Zeugnisfach_Bearbeiten dialog_zeugnisfach = new Dialog_adm_Zeugnisfach_Bearbeiten(list_Zeugnisfach.getSelectedValue());
				dialog_zeugnisfach.setVisible(true);
			}
			catch(Exception exception)
			{
				JOptionPane.showMessageDialog(this, "Es wurde kein Zeugnisfach ausgewählt \n oder \n Das Zeugnisfach konnte nicht gelöscht werden");
			}
		}
		if(e.getActionCommand().equals(this.button_Zeugnisfach_loeschen.getActionCommand()))
		{
			try
			{
				this.list_Zeugnisfach.getSelectedValue().loeschen();
			}
			catch(Exception exception)
			{
				JOptionPane.showMessageDialog(this, "Es wurde kein Zeugnisfach ausgewählt \n oder \n Das Zeugnisfach konnte nicht gelöscht werden");
			}
		}
		if(e.getActionCommand().equals(this.button_Zurueck.getActionCommand()))
		{
			this.dispose();
		}
	}
	
	public void setList()
	{
		ArrayList<Zeugnisfach> al_zeugnisfach = new ArrayList<Zeugnisfach>();
		DBZugriff.alleLesen("Zeugnisfach", al_zeugnisfach, "");
		this.list_Zeugnisfach.setListData(ErzeugeZeugnisfachArrayAusArrayList(al_zeugnisfach));
	}
	
	public Zeugnisfach[] ErzeugeZeugnisfachArrayAusArrayList(ArrayList<Zeugnisfach> alist)
	{
		Zeugnisfach[] llist = new Zeugnisfach[alist.size()];
		
		for(int i = 0; i < alist.size(); i++)
		{
			llist[i] = (Zeugnisfach)alist.get(i);
		}
		
		return llist;
	}
}
