package Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import Fachklassen.Schueler;

public class Dialog_Zeugnis extends JDialog implements ActionListener, ListSelectionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JButton button_Druckansicht;
	private JButton button_Zurueck;
	private JPanel panel_1;
	private JLabel label_Zeugnis;
	private JTextField txtBlarf;
	private JScrollPane scrollPane;
	
	Schueler schueler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_Zeugnis dialog = new Dialog_Zeugnis();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_Zeugnis() {
		setTitle("Zeugnis");
		initGUI();
	}
	private void initGUI() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 0, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 0, 0, 0, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 1;
			gbc_panel_1.gridy = 1;
			contentPanel.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			{
				label_Zeugnis = new JLabel("Zeugnis von");
				GridBagConstraints gbc_label_Zeugnis = new GridBagConstraints();
				gbc_label_Zeugnis.insets = new Insets(0, 0, 5, 0);
				gbc_label_Zeugnis.gridx = 0;
				gbc_label_Zeugnis.gridy = 0;
				panel_1.add(label_Zeugnis, gbc_label_Zeugnis);
			}
			{
				txtBlarf = new JTextField();
				txtBlarf.setEditable(false);
				txtBlarf.setHorizontalAlignment(JTextField.CENTER);
				GridBagConstraints gbc_txtBlarf = new GridBagConstraints();
				gbc_txtBlarf.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtBlarf.gridx = 0;
				gbc_txtBlarf.gridy = 1;
				panel_1.add(txtBlarf, gbc_txtBlarf);
				txtBlarf.setColumns(10);
			}
		}
		{
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 2;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				JList list_Zeugnisnoten = new JList();
				list_Zeugnisnoten.addListSelectionListener(this);
				scrollPane.setViewportView(list_Zeugnisnoten);
			}
		}
		{
			panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{150, 150, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				button_Druckansicht = new JButton("Druckansicht");
				button_Druckansicht.addActionListener(this);
				GridBagConstraints gbc_button_Druckansicht = new GridBagConstraints();
				gbc_button_Druckansicht.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Druckansicht.insets = new Insets(0, 0, 0, 5);
				gbc_button_Druckansicht.gridx = 0;
				gbc_button_Druckansicht.gridy = 0;
				panel.add(button_Druckansicht, gbc_button_Druckansicht);
			}
			{
				button_Zurueck = new JButton("Zur\u00FCck");
				button_Zurueck.addActionListener(this);
				GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
				gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Zurueck.gridx = 1;
				gbc_button_Zurueck.gridy = 0;
				panel.add(button_Zurueck, gbc_button_Zurueck);
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) 
	{
	}
	public void valueChanged(ListSelectionEvent arg0) 
	{
	}
}
