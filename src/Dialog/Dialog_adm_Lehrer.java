package Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Insets;
import java.awt.CardLayout;

public class Dialog_adm_Lehrer extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private final JList list_Lehrer = new JList();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JPanel panel = new JPanel();
	private final JButton button_Lehrer_Anlegen = new JButton("Lehrer anlegen");
	private final JButton btnLehrerBearbeiten = new JButton("Lehrer bearbeiten");
	private final JButton button_Lehrer_loeschen = new JButton("Lehrer l\u00F6schen");
	private final JButton btnZurck = new JButton("Zur\u00FCck");

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
		setModal(true);
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
		panel.add(button_Lehrer_Anlegen, gbc_button_Lehrer_Anlegen);
		GridBagConstraints gbc_btnLehrerBearbeiten = new GridBagConstraints();
		gbc_btnLehrerBearbeiten.anchor = GridBagConstraints.NORTH;
		gbc_btnLehrerBearbeiten.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLehrerBearbeiten.insets = new Insets(0, 0, 5, 0);
		gbc_btnLehrerBearbeiten.gridx = 1;
		gbc_btnLehrerBearbeiten.gridy = 0;
		panel.add(btnLehrerBearbeiten, gbc_btnLehrerBearbeiten);
		GridBagConstraints gbc_button_Lehrer_loeschen = new GridBagConstraints();
		gbc_button_Lehrer_loeschen.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_Lehrer_loeschen.insets = new Insets(0, 0, 0, 5);
		gbc_button_Lehrer_loeschen.gridx = 0;
		gbc_button_Lehrer_loeschen.gridy = 1;
		panel.add(button_Lehrer_loeschen, gbc_button_Lehrer_loeschen);
		GridBagConstraints gbc_btnZurck = new GridBagConstraints();
		gbc_btnZurck.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnZurck.gridx = 1;
		gbc_btnZurck.gridy = 1;
		panel.add(btnZurck, gbc_btnZurck);
	}

}
