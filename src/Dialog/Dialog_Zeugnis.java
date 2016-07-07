package Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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

import javax.swing.JSlider;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Dialog_Zeugnis extends JFrame implements ActionListener, ListSelectionListener {

	private final JPanel contentPanel = new JPanel();
	
	Schueler schueler;
	private JPanel panel;
	private JPanel panel_1;
	private JSlider slider;
	private JButton btnDrucken;
	private JButton btnZurck;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{25, 0, 0, 25, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 0, 0, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbl_panel_1.columnWidths = new int[]{100, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			{
				btnDrucken = new JButton("Drucken");
				GridBagConstraints gbc_btnDrucken = new GridBagConstraints();
				gbc_btnDrucken.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnDrucken.insets = new Insets(0, 0, 5, 0);
				gbc_btnDrucken.gridx = 0;
				gbc_btnDrucken.gridy = 0;
				panel_1.add(btnDrucken, gbc_btnDrucken);
			}
			{
				btnZurck = new JButton("Zur\u00FCck");
				GridBagConstraints gbc_btnZurck = new GridBagConstraints();
				gbc_btnZurck.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnZurck.gridx = 0;
				gbc_btnZurck.gridy = 1;
				panel_1.add(btnZurck, gbc_btnZurck);
			}
		}
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 2;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0};
			gbl_panel.rowHeights = new int[]{0};
			gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
		}
		{
			slider = new JSlider();
			slider.setFont(new Font("Arial", Font.PLAIN, 10));
			slider.setMajorTickSpacing(20);
			slider.setMinorTickSpacing(5);
			slider.setValue(100);
			slider.setPaintLabels(true);
			slider.setPaintTicks(true);
			GridBagConstraints gbc_slider = new GridBagConstraints();
			gbc_slider.insets = new Insets(0, 0, 5, 5);
			gbc_slider.fill = GridBagConstraints.BOTH;
			gbc_slider.gridx = 2;
			gbc_slider.gridy = 2;
			contentPanel.add(slider, gbc_slider);
		}
	}

	public void actionPerformed(ActionEvent arg0) 
	{
	}
	public void valueChanged(ListSelectionEvent arg0) 
	{
	}
}
