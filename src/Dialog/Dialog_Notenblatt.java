package Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Dialog_Notenblatt extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_Notenblatt dialog = new Dialog_Notenblatt();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_Notenblatt() {
		setTitle("Notenblatt");
		initGUI();
	}
	private void initGUI() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 424, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 0, 0, 0, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 0, 5);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblSchlerin = new JLabel("Sch\u00FCler/in");
					GridBagConstraints gbc_lblSchlerin = new GridBagConstraints();
					gbc_lblSchlerin.insets = new Insets(0, 0, 5, 5);
					gbc_lblSchlerin.gridx = 0;
					gbc_lblSchlerin.gridy = 0;
					panel_1.add(lblSchlerin, gbc_lblSchlerin);
				}
				{
					textField = new JTextField();
					textField.setEditable(false);
					GridBagConstraints gbc_textField = new GridBagConstraints();
					gbc_textField.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField.insets = new Insets(0, 0, 5, 0);
					gbc_textField.gridx = 1;
					gbc_textField.gridy = 0;
					panel_1.add(textField, gbc_textField);
					textField.setColumns(10);
				}
				{
					JLabel lblKlasse = new JLabel("Klasse");
					GridBagConstraints gbc_lblKlasse = new GridBagConstraints();
					gbc_lblKlasse.insets = new Insets(0, 0, 0, 5);
					gbc_lblKlasse.gridx = 0;
					gbc_lblKlasse.gridy = 1;
					panel_1.add(lblKlasse, gbc_lblKlasse);
				}
				{
					textField_1 = new JTextField();
					textField_1.setEditable(false);
					GridBagConstraints gbc_textField_1 = new GridBagConstraints();
					gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_1.gridx = 1;
					gbc_textField_1.gridy = 1;
					panel_1.add(textField_1, gbc_textField_1);
					textField_1.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblLehrer = new JLabel("Lehrer");
					GridBagConstraints gbc_lblLehrer = new GridBagConstraints();
					gbc_lblLehrer.insets = new Insets(0, 0, 0, 5);
					gbc_lblLehrer.anchor = GridBagConstraints.EAST;
					gbc_lblLehrer.gridx = 0;
					gbc_lblLehrer.gridy = 0;
					panel_1.add(lblLehrer, gbc_lblLehrer);
				}
				{
					textField_2 = new JTextField();
					textField_2.setEditable(false);
					GridBagConstraints gbc_textField_2 = new GridBagConstraints();
					gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_2.gridx = 1;
					gbc_textField_2.gridy = 0;
					panel_1.add(textField_2, gbc_textField_2);
					textField_2.setColumns(10);
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
				table = new JTable();
				table.setBorder(new LineBorder(Color.GRAY));
				GridBagConstraints gbc_table = new GridBagConstraints();
				gbc_table.fill = GridBagConstraints.BOTH;
				gbc_table.gridx = 0;
				gbc_table.gridy = 0;
				panel.add(table, gbc_table);
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
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JButton btnZurck = new JButton("Zur\u00FCck");
				GridBagConstraints gbc_btnZurck = new GridBagConstraints();
				gbc_btnZurck.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnZurck.gridx = 0;
				gbc_btnZurck.gridy = 0;
				panel.add(btnZurck, gbc_btnZurck);
			}
		}
	}

}
