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

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;


public class Dialog_NotenausgabeKlasse extends JFrame implements ActionListener, WindowFocusListener
{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Klasse;
	private JTextField textField_Fach;
	private JTextField textField_LehrerIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			Dialog_NotenausgabeKlasse dialog = new Dialog_NotenausgabeKlasse();
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
	public Dialog_NotenausgabeKlasse()
	{
		initGUI();
	}
	private void initGUI() {
		addWindowFocusListener(this);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 0, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 60, 0, 25, 25, 0};
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
			JPanel panel_SchuelerNoten = new JPanel();
			GridBagConstraints gbc_panel_SchuelerNoten = new GridBagConstraints();
			gbc_panel_SchuelerNoten.insets = new Insets(0, 0, 5, 5);
			gbc_panel_SchuelerNoten.fill = GridBagConstraints.BOTH;
			gbc_panel_SchuelerNoten.gridx = 1;
			gbc_panel_SchuelerNoten.gridy = 2;
			contentPanel.add(panel_SchuelerNoten, gbc_panel_SchuelerNoten);
			GridBagLayout gbl_panel_SchuelerNoten = new GridBagLayout();
			gbl_panel_SchuelerNoten.columnWidths = new int[]{0, 0};
			gbl_panel_SchuelerNoten.rowHeights = new int[]{0, 0};
			gbl_panel_SchuelerNoten.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_SchuelerNoten.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			
			DefaultTableModel tablecontent = new DefaultTableModel(); 		
			
			panel_SchuelerNoten.setLayout(gbl_panel_SchuelerNoten);
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
