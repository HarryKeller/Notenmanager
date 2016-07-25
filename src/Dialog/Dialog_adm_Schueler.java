package Dialog;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JList;

import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import Fachklassen.Schueler;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Dialog_adm_Schueler extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JPanel panel;	
	private JPanel panel_buttons;
	private JScrollPane scrollPane;
	private JButton btnSchuelerBearbeiten;
	private JButton btnSchuelerAnlegen;
	private JButton btnZurueck;
	private DefaultListModel<Schueler> model = new DefaultListModel<Schueler>();
	private JList<Schueler> list_schueler;

	public Dialog_adm_Schueler()
	{
		initGUI();
		setDatenInMaske();
	}
		
	private void initGUI() 
	{
		setTitle("Sch\u00FCler auswahl");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{225, 48, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.contentPane.add(this.panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.panel.setLayout(gbl_panel);
		
		this.scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		this.panel.add(this.scrollPane, gbc_scrollPane);
		
		this.list_schueler = new JList<Schueler>(model);
		this.scrollPane.setViewportView(this.list_schueler);
		
		this.panel_buttons = new JPanel();
		GridBagConstraints gbc_panel_buttons = new GridBagConstraints();
		gbc_panel_buttons.fill = GridBagConstraints.BOTH;
		gbc_panel_buttons.gridx = 0;
		gbc_panel_buttons.gridy = 1;
		this.contentPane.add(this.panel_buttons, gbc_panel_buttons);
		GridBagLayout gbl_panel_buttons = new GridBagLayout();
		gbl_panel_buttons.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_buttons.rowHeights = new int[]{0, 0};
		gbl_panel_buttons.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_buttons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.panel_buttons.setLayout(gbl_panel_buttons);
		
		this.btnSchuelerBearbeiten = new JButton("Sch\u00FCler bearbeiten");
		this.btnSchuelerBearbeiten.addActionListener(this);
		GridBagConstraints gbc_btnSchuelerBearbeiten = new GridBagConstraints();
		gbc_btnSchuelerBearbeiten.fill = GridBagConstraints.BOTH;
		gbc_btnSchuelerBearbeiten.insets = new Insets(5, 5, 5, 5);
		gbc_btnSchuelerBearbeiten.gridx = 0;
		gbc_btnSchuelerBearbeiten.gridy = 0;
		this.panel_buttons.add(this.btnSchuelerBearbeiten, gbc_btnSchuelerBearbeiten);
		
		this.btnSchuelerAnlegen = new JButton("Sch\u00FCler anlegen");
		this.btnSchuelerAnlegen.addActionListener(this);
		GridBagConstraints gbc_btnSchuelerAnlegen = new GridBagConstraints();
		gbc_btnSchuelerAnlegen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSchuelerAnlegen.insets = new Insets(5, 5, 5, 5);
		gbc_btnSchuelerAnlegen.gridx = 1;
		gbc_btnSchuelerAnlegen.gridy = 0;
		this.panel_buttons.add(this.btnSchuelerAnlegen, gbc_btnSchuelerAnlegen);
		
		this.btnZurueck = new JButton("Zur\u00FCck");
		this.btnZurueck.addActionListener(this);
		GridBagConstraints gbc_btnZurueck = new GridBagConstraints();
		gbc_btnZurueck.insets = new Insets(5, 5, 5, 5);
		gbc_btnZurueck.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnZurueck.gridx = 2;
		gbc_btnZurueck.gridy = 0;
		this.panel_buttons.add(this.btnZurueck, gbc_btnZurueck);
	}

	private void setDatenInMaske()
	{
		for(Schueler s : Schueler.alleLesen())
		{
			model.addElement(s);
		}
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getActionCommand().equals(btnSchuelerBearbeiten.getActionCommand()))
		{
			Dialog_adm_Schueler_Bearbeiten dlg_schueler = new Dialog_adm_Schueler_Bearbeiten(list_schueler.getSelectedValue());
			dlg_schueler.setVisible(true);
			this.dispose();
		}
		else if(arg0.getActionCommand().equals(btnSchuelerAnlegen.getActionCommand()))
		{
			Dialog_adm_Schueler_Bearbeiten dlg_schueler = new Dialog_adm_Schueler_Bearbeiten();
			dlg_schueler.setVisible(true);
			this.dispose();
		}
		else
		{
			this.dispose();
		}
		
	}
}
