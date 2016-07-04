package Dialog;

import java.awt.EventQueue;

import javax.swing.JDialog;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTable;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JScrollPane;

public class Dialog_ZeugnisnotenZumSchueler extends JDialog {
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialog_ZeugnisnotenZumSchueler dialog = new Dialog_ZeugnisnotenZumSchueler();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_ZeugnisnotenZumSchueler() 
	{
		setBounds(100, 100, 762, 496);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 178, 326, 151, 0, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblZeugnisnotenDesSchlers = new JLabel("Zeugnisnoten des Sch\u00FClers:");
		lblZeugnisnotenDesSchlers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblZeugnisnotenDesSchlers = new GridBagConstraints();
		gbc_lblZeugnisnotenDesSchlers.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblZeugnisnotenDesSchlers.insets = new Insets(0, 0, 5, 5);
		gbc_lblZeugnisnotenDesSchlers.gridx = 1;
		gbc_lblZeugnisnotenDesSchlers.gridy = 0;
		getContentPane().add(lblZeugnisnotenDesSchlers, gbc_lblZeugnisnotenDesSchlers);
		
		JLabel label = new JLabel("Keller Harry");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_schueler = new GridBagConstraints();
		gbc_label_schueler.anchor = GridBagConstraints.SOUTHWEST;
		gbc_label_schueler.insets = new Insets(0, 0, 5, 5);
		gbc_label_schueler.gridx = 2;
		gbc_label_schueler.gridy = 0;
		getContentPane().add(label, gbc_label_schueler);
		model.addColumn("Fach");
		model.addColumn("Errechnet");
		model.addColumn("Festgelegt");
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		GridBagConstraints gbc_btnZurck = new GridBagConstraints();
		gbc_btnZurck.insets = new Insets(0, 0, 0, 5);
		gbc_btnZurck.gridx = 1;
		gbc_btnZurck.gridy = 2;
		getContentPane().add(btnZurck, gbc_btnZurck);
		
		JButton btnSpeichern = new JButton("Speichern");
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.anchor = GridBagConstraints.EAST;
		gbc_btnSpeichern.insets = new Insets(0, 0, 0, 5);
		gbc_btnSpeichern.gridx = 2;
		gbc_btnSpeichern.gridy = 2;
		getContentPane().add(btnSpeichern, gbc_btnSpeichern);
		
		JButton btnZeugnisDrucken = new JButton("Zeugnis drucken");
		btnZeugnisDrucken.setEnabled(false);
		GridBagConstraints gbc_btnZeugnisDrucken = new GridBagConstraints();
		gbc_btnZeugnisDrucken.insets = new Insets(0, 0, 0, 5);
		gbc_btnZeugnisDrucken.anchor = GridBagConstraints.EAST;
		gbc_btnZeugnisDrucken.gridx = 3;
		gbc_btnZeugnisDrucken.gridy = 2;
		getContentPane().add(btnZeugnisDrucken, gbc_btnZeugnisDrucken);

	}

}
