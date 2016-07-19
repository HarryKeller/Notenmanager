package Dialog;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Fachklassen.Lehrer;
import Fachklassen.UFachLehrer;
import Persistenz.DBZugriff;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Dialog_adm_Lehrer extends JFrame implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private final JList<Lehrer> list_Lehrer = new JList<Lehrer>();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JPanel panel = new JPanel();
	private final JButton button_Lehrer_Anlegen = new JButton("Lehrer anlegen");
	private final JButton button_Lehrer_bearbeiten = new JButton("Lehrer bearbeiten");
	private final JButton btnLehrerKndigen = new JButton("Lehrer k\u00FCndigen");
	private final JButton button_Zurueck = new JButton("Zur\u00FCck");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			Dialog_adm_Lehrer dialog = new Dialog_adm_Lehrer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_adm_Lehrer()
	{
		setTitle("Lehrer - Auswahl");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 1, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 1, 0, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPanel.add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportView(list_Lehrer);
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{75, 119, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		GridBagConstraints gbc_button_Lehrer_Anlegen = new GridBagConstraints();
		gbc_button_Lehrer_Anlegen.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_Lehrer_Anlegen.insets = new Insets(0, 0, 5, 5);
		gbc_button_Lehrer_Anlegen.gridx = 0;
		gbc_button_Lehrer_Anlegen.gridy = 0;
		button_Lehrer_Anlegen.addActionListener(this);
		panel.add(button_Lehrer_Anlegen, gbc_button_Lehrer_Anlegen);
		GridBagConstraints gbc_button_Lehrer_bearbeiten = new GridBagConstraints();
		gbc_button_Lehrer_bearbeiten.anchor = GridBagConstraints.NORTH;
		gbc_button_Lehrer_bearbeiten.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_Lehrer_bearbeiten.insets = new Insets(0, 0, 5, 0);
		gbc_button_Lehrer_bearbeiten.gridx = 1;
		gbc_button_Lehrer_bearbeiten.gridy = 0;
		button_Lehrer_bearbeiten.addActionListener(this);
		panel.add(button_Lehrer_bearbeiten, gbc_button_Lehrer_bearbeiten);
		GridBagConstraints gbc_btnLehrerKndigen = new GridBagConstraints();
		gbc_btnLehrerKndigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLehrerKndigen.insets = new Insets(0, 0, 0, 5);
		gbc_btnLehrerKndigen.gridx = 0;
		gbc_btnLehrerKndigen.gridy = 1;
		btnLehrerKndigen.addActionListener(this);
		panel.add(btnLehrerKndigen, gbc_btnLehrerKndigen);
		GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
		gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_Zurueck.gridx = 1;
		gbc_button_Zurueck.gridy = 1;
		button_Zurueck.addActionListener(this);
		panel.add(button_Zurueck, gbc_button_Zurueck);
		
		
		DBZugriff.initDB();
		this.list_Lehrer.setListData(ErzeugeLehrerArrayAusArrayList(Lehrer.alleLesen()));
	}

	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getActionCommand().equals(this.button_Lehrer_Anlegen.getActionCommand()))
		{
			Dialog_adm_Lehrer_Bearbeiten dialog_lehrer = new Dialog_adm_Lehrer_Bearbeiten();
			dialog_lehrer.setVisible(true);
		}
		if(arg0.getActionCommand().equals(this.button_Lehrer_bearbeiten.getActionCommand()))
		{
			Dialog_adm_Lehrer_Bearbeiten dialog_lehrer = new Dialog_adm_Lehrer_Bearbeiten(((Lehrer)this.list_Lehrer.getSelectedValue()));
			dialog_lehrer.setVisible(true);
		}
		if(arg0.getActionCommand().equals(this.btnLehrerKndigen.getActionCommand()))
		{
			try
			{
			if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Wollen sie den Lehrer wirklich löschen?", "Warnung!", JOptionPane.YES_NO_OPTION))
			{
				if(!UFachLehrer.unterrichtetNoch(this.list_Lehrer.getSelectedValue()))
				{
					this.list_Lehrer.getSelectedValue().setArbeitetAnDieserSchule(false);
					this.list_Lehrer.getSelectedValue().speichern();
					this.list_Lehrer.setListData(ErzeugeLehrerArrayAusArrayList(Lehrer.alleLesen()));
				}
				
				}
				else
				{
					
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Lehrer konnte nicht gelöscht werden, eventuell besitzt er noch Verbindungen die nicht getrennt werden können \n" + e.getMessage());
			}
		}
		if(arg0.getActionCommand().equals(this.button_Zurueck.getActionCommand()))
		{
			this.dispose();
		}
	}
	public Lehrer[] ErzeugeLehrerArrayAusArrayList(ArrayList<Lehrer> alist)
	{
		Lehrer[] llist = new Lehrer[alist.size()];
		
		for(int i = 0; i < alist.size(); i++)
		{
			llist[i] = (Lehrer)alist.get(i);
		}
		
		return llist;
	}
}
