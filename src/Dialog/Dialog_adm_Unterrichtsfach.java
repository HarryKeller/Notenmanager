package Dialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import Fachklassen.Unterrichtsfach;
import Fachklassen.Zeugnisfach;
import Persistenz.DBZugriff;

public class Dialog_adm_Unterrichtsfach extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton _btnUnterrichtsfachAnlegen;
	private JButton _btnUnterrichtsfachBearbeiten;
	private JButton _btnUnterrichtsfachLschen;
	private JButton button_Zurueck;
	
	private JList<Unterrichtsfach> list_Unterrichtsfach = new JList<Unterrichtsfach>();
	

	private Dialog_adm_Unterrichtsfach() 
	{
		setTitle("Unterrichtsfach");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{25, 0, 25, 0};
		gbl_contentPane.rowHeights = new int[]{25, 0, 25, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
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
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		
		scrollPane.setViewportView(list_Unterrichtsfach);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
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
		
		_btnUnterrichtsfachAnlegen = new JButton("Unterrichtsfach anlegen");
		_btnUnterrichtsfachAnlegen.addActionListener(this);
		GridBagConstraints gbc_btnUnterrichtsfachAnlegen = new GridBagConstraints();
		gbc_btnUnterrichtsfachAnlegen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUnterrichtsfachAnlegen.insets = new Insets(0, 0, 5, 5);
		gbc_btnUnterrichtsfachAnlegen.gridx = 0;
		gbc_btnUnterrichtsfachAnlegen.gridy = 0;
		panel_1.add(_btnUnterrichtsfachAnlegen, gbc_btnUnterrichtsfachAnlegen);
		
		_btnUnterrichtsfachBearbeiten = new JButton("Unterrichtsfach bearbeiten");
		_btnUnterrichtsfachBearbeiten.addActionListener(this);
		GridBagConstraints gbc_btnUnterrichtsfachBearbeiten = new GridBagConstraints();
		gbc_btnUnterrichtsfachBearbeiten.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUnterrichtsfachBearbeiten.insets = new Insets(0, 0, 5, 0);
		gbc_btnUnterrichtsfachBearbeiten.gridx = 1;
		gbc_btnUnterrichtsfachBearbeiten.gridy = 0;
		panel_1.add(_btnUnterrichtsfachBearbeiten, gbc_btnUnterrichtsfachBearbeiten);
		
		_btnUnterrichtsfachLschen = new JButton("Unterrichtsfach l\u00F6schen");
		_btnUnterrichtsfachLschen.addActionListener(this);
		GridBagConstraints gbc_btnUnterrichtsfachLschen = new GridBagConstraints();
		gbc_btnUnterrichtsfachLschen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUnterrichtsfachLschen.insets = new Insets(0, 0, 0, 5);
		gbc_btnUnterrichtsfachLschen.gridx = 0;
		gbc_btnUnterrichtsfachLschen.gridy = 1;
		panel_1.add(_btnUnterrichtsfachLschen, gbc_btnUnterrichtsfachLschen);
		
		button_Zurueck = new JButton("Zur\u00FCck");
		button_Zurueck.addActionListener(this);
		GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
		gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_Zurueck.gridx = 1;
		gbc_button_Zurueck.gridy = 1;
		panel_1.add(button_Zurueck, gbc_button_Zurueck);
		
		this.setList();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(this._btnUnterrichtsfachAnlegen.getActionCommand()))
		{
			this.dispose();
			Dialog_adm_Unterrichtsfach_bearbeiten.initGui();
		}	
		if(e.getActionCommand().equals(this._btnUnterrichtsfachBearbeiten.getActionCommand()))
		{
			try
			{
				
				Dialog_adm_Unterrichtsfach_bearbeiten.initGui(list_Unterrichtsfach.getSelectedValue());
			}
			catch(Exception exception)
			{
				JOptionPane.showMessageDialog(this, "Es wurde kein Unterrichtsfach ausgewählt \n oder \n Das Unterrichtsfach konnte nicht gelöscht werden");
			}
		}
		if(e.getActionCommand().equals(this._btnUnterrichtsfachLschen.getActionCommand()))
		{
			try
			{
				this.list_Unterrichtsfach.getSelectedValue().loeschen();
				this.list_Unterrichtsfach.removeAll();
				this.setList();
			}
			catch(Exception exception)
			{
				JOptionPane.showMessageDialog(this, "Es wurde kein Unterrichtsfach ausgewählt \n oder \n Das Unterrichtsfach konnte nicht gelöscht werden");
			}
		}
		if(e.getActionCommand().equals(this.button_Zurueck.getActionCommand()))
		{
			this.dispose();
		}
	}
	
	public void setList()
	{
		ArrayList<Unterrichtsfach> al_unterrichtsfach = new ArrayList<Unterrichtsfach>();
		DBZugriff.alleLesen("Unterrichtsfach", al_unterrichtsfach, "");
		this.list_Unterrichtsfach.setListData(ErzeugeZeugnisfachArrayAusArrayList(al_unterrichtsfach));
	}
	
	public Unterrichtsfach[] ErzeugeZeugnisfachArrayAusArrayList(ArrayList<Unterrichtsfach> alist)
	{
		Unterrichtsfach[] llist = new Unterrichtsfach[alist.size()];
		
		for(int i = 0; i < alist.size(); i++)
		{
			llist[i] = (Unterrichtsfach) alist.get(i);
		}
		
		return llist;
	}
	public static void initGui()
	{
		if(Dialog_Klassenauswahl.dlg_adm_unterrichtsfach == null)
			Dialog_Klassenauswahl.dlg_adm_unterrichtsfach = new Dialog_adm_Unterrichtsfach();
		
		Dialog_Klassenauswahl.dlg_adm_unterrichtsfach.setVisible(true);
		Dialog_Klassenauswahl.dlg_adm_unterrichtsfach.toFront();
	}
}
