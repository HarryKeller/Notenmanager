package Dialog;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Fachklassen.Klasse;
import Fachklassen.Lehrer;
import Fachklassen.Leistung;
import Fachklassen.Schueler;
import Fachklassen.Unterrichtsfach;
import Persistenz.DBZugriff;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.WindowFocusListener;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.awt.event.WindowEvent;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Dialog_NotenausgabeKlasse extends JFrame implements ActionListener, WindowFocusListener
{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Klasse;
	private JTextField textField_Fach;
	private JTextField textField_LehrerIn;
	private JTable table_noten;
	private DefaultTableModel model_noten;
	private Lehrer lehrer;
	private Klasse klasse;
	private Unterrichtsfach fach;
	
	public static void main(String[] args)
	{
		DBZugriff.initDB();
		Dialog_NotenausgabeKlasse d = new Dialog_NotenausgabeKlasse(new Lehrer(1), new Klasse(1), new Unterrichtsfach(1));
		d.setVisible(true);
		DBZugriff.closeDB();
	}
	/**
	 * Create the dialog.
	 */
	public Dialog_NotenausgabeKlasse()
	{
		this.initGUI();
	}
	
	public Dialog_NotenausgabeKlasse(Lehrer l, Klasse k, Unterrichtsfach f)
	{
		this.lehrer = l;
		this.klasse = k;
		this.fach = f;
		
		initGUI();
		
		this.setDatenInMaske();
	}
	private void initGUI() {
		addWindowFocusListener(this);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 60, 0, 25, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel_Head = new JPanel();
			GridBagConstraints gbc_panel_Head = new GridBagConstraints();
			gbc_panel_Head.insets = new Insets(0, 0, 5, 5);
			gbc_panel_Head.fill = GridBagConstraints.BOTH;
			gbc_panel_Head.gridx = 1;
			gbc_panel_Head.gridy = 1;
			contentPanel.add(panel_Head, gbc_panel_Head);
			GridBagLayout gbl_panel_Head = new GridBagLayout();
			gbl_panel_Head.columnWidths = new int[]{0, 0, 0};
			gbl_panel_Head.rowHeights = new int[]{0, 0};
			gbl_panel_Head.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel_Head.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_Head.setLayout(gbl_panel_Head);
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 0, 5);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel_Head.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 125, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel label_Klasse = new JLabel("Klasse");
					label_Klasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
					GridBagConstraints gbc_label_Klasse = new GridBagConstraints();
					gbc_label_Klasse.anchor = GridBagConstraints.EAST;
					gbc_label_Klasse.insets = new Insets(0, 0, 5, 5);
					gbc_label_Klasse.gridx = 0;
					gbc_label_Klasse.gridy = 0;
					panel_1.add(label_Klasse, gbc_label_Klasse);
				}
				{
					textField_Klasse = new JTextField();
					textField_Klasse.setEditable(false);
					GridBagConstraints gbc_textField_Klasse = new GridBagConstraints();
					gbc_textField_Klasse.insets = new Insets(0, 0, 5, 0);
					gbc_textField_Klasse.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_Klasse.gridx = 1;
					gbc_textField_Klasse.gridy = 0;
					panel_1.add(textField_Klasse, gbc_textField_Klasse);
					textField_Klasse.setColumns(10);
				}
				{
					JLabel label_Fach = new JLabel("Fach");
					label_Fach.setFont(new Font("Tahoma", Font.PLAIN, 14));
					GridBagConstraints gbc_label_Fach = new GridBagConstraints();
					gbc_label_Fach.anchor = GridBagConstraints.EAST;
					gbc_label_Fach.insets = new Insets(0, 0, 0, 5);
					gbc_label_Fach.gridx = 0;
					gbc_label_Fach.gridy = 1;
					panel_1.add(label_Fach, gbc_label_Fach);
				}
				{
					textField_Fach = new JTextField();
					textField_Fach.setEditable(false);
					GridBagConstraints gbc_textField_Fach = new GridBagConstraints();
					gbc_textField_Fach.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_Fach.gridx = 1;
					gbc_textField_Fach.gridy = 1;
					panel_1.add(textField_Fach, gbc_textField_Fach);
					textField_Fach.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 0;
				panel_Head.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 125, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0};
				gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel label_LehrerIn = new JLabel("Lehrer/in");
					label_LehrerIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
					GridBagConstraints gbc_label_LehrerIn = new GridBagConstraints();
					gbc_label_LehrerIn.insets = new Insets(0, 0, 0, 5);
					gbc_label_LehrerIn.anchor = GridBagConstraints.EAST;
					gbc_label_LehrerIn.gridx = 0;
					gbc_label_LehrerIn.gridy = 0;
					panel_1.add(label_LehrerIn, gbc_label_LehrerIn);
				}
				{
					textField_LehrerIn = new JTextField();
					textField_LehrerIn.setEditable(false);
					GridBagConstraints gbc_textField_LehrerIn = new GridBagConstraints();
					gbc_textField_LehrerIn.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_LehrerIn.gridx = 1;
					gbc_textField_LehrerIn.gridy = 0;
					panel_1.add(textField_LehrerIn, gbc_textField_LehrerIn);
					textField_LehrerIn.setColumns(10);
				}
			}
		}		
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 2;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			
			panel.setLayout(gbl_panel);
			{
				this.model_noten = new DefaultTableModel();
				{
					JScrollPane scrollPane = new JScrollPane();
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.fill = GridBagConstraints.BOTH;
					gbc_scrollPane.gridx = 0;
					gbc_scrollPane.gridy = 0;
					panel.add(scrollPane, gbc_scrollPane);
					table_noten = new JTable();
					scrollPane.setViewportView(this.table_noten);
					table_noten.setModel(this.model_noten);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
			{
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{65, 0};
				gbl_panel.rowHeights = new int[]{23, 0};
				gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
			}
			JButton button_Zurueck = new JButton("Zur\u00FCck");
			button_Zurueck.addActionListener(this);
			GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
			gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Zurueck.anchor = GridBagConstraints.NORTHWEST;
			gbc_button_Zurueck.gridx = 0;
			gbc_button_Zurueck.gridy = 0;
			panel.add(button_Zurueck, gbc_button_Zurueck);
		}
	}

	public void setDatenInMaske()
	{
		Set<Schueler> schueler = this.klasse.getSchueler();
		this.model_noten.addColumn("Name");
		this.model_noten.addColumn("Vorname");
		this.model_noten.addColumn("Noten Mündlich");
		this.model_noten.addColumn("Noten Schriftlich");
		
		this.textField_Fach.setText(this.fach.getBez());
		this.textField_Klasse.setText(this.klasse.getBez());
		this.textField_LehrerIn.setText(this.lehrer.getNachname());
		for(Schueler s : schueler)
		{
			Object[] data = {s.getNachname(), s.getVorname(), s.getMuendlich(this.fach), s.getSchriftlich(this.fach)};
			this.model_noten.addRow(data);
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	public void windowGainedFocus(WindowEvent e) 
	{
		
	}
	public void windowLostFocus(WindowEvent e) 
	{
		this.requestFocus();
	}
}
