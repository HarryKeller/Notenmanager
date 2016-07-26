package Dialog;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import Fachklassen.Ausbildungszweig;
import Fachklassen.Zeugnisfach;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;


public class Dialog_adm_Zeugnisfach_Bearbeiten extends JDialog implements ActionListener, MouseListener {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Bezeichnung;
	private JTextField textField_Fachart;
	private JCheckBox checkBox_Vorrueckungsfach;
	private JCheckBox checkBox_AbschliessendesFach;

	private JButton button_Speichern;
	private JButton button_Verwerfen;
	private JButton button_Leeren;
	private JButton button_Zurueck;
	
	private Zeugnisfach zeugnisfach;
	
	private JList<Ausbildungszweig> list_ausbildungszweig = new JList<Ausbildungszweig>();
	private DefaultListModel<Ausbildungszweig> list_ausbildungszweig_model = new DefaultListModel<Ausbildungszweig>();
	private JList<Ausbildungszweig> list_neuausbildungszweig = new JList<Ausbildungszweig>();
	private DefaultListModel<Ausbildungszweig> list_neuausbildungszweig__model = new DefaultListModel<Ausbildungszweig>();
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JPanel panel_3;
	private JPanel panel_4;
	

	public Dialog_adm_Zeugnisfach_Bearbeiten() 
	{
		setZeugnisfach(new Zeugnisfach());
		initGUI();
	}
	public Dialog_adm_Zeugnisfach_Bearbeiten(Zeugnisfach zeugnisfach) 
	{
		setZeugnisfach(zeugnisfach);
		initGUI();
		setDatenInMaske();
	}

	private void initGUI() 
	{
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Zeugnisfach bearbeiten");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 481, 519);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(5, 5, 0, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{127, 119, 106, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JPanel panel_2 = new JPanel();
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.insets = new Insets(5, 5, 5, 5);
			gbc_panel_2.fill = GridBagConstraints.BOTH;
			gbc_panel_2.gridx = 0;
			gbc_panel_2.gridy = 0;
			panel.add(panel_2, gbc_panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{0, 0, 0};
			gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			
			JLabel lblBezeichnung = new JLabel("Bezeichnung");
			GridBagConstraints gbc_lblBezeichnung = new GridBagConstraints();
			gbc_lblBezeichnung.anchor = GridBagConstraints.EAST;
			gbc_lblBezeichnung.insets = new Insets(5, 5, 5, 5);
			gbc_lblBezeichnung.gridx = 0;
			gbc_lblBezeichnung.gridy = 0;
			panel_2.add(lblBezeichnung, gbc_lblBezeichnung);
			
			textField_Bezeichnung = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(5, 5, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			panel_2.add(textField_Bezeichnung, gbc_textField);
			textField_Bezeichnung.setColumns(10);
			
			JLabel label_Fachart = new JLabel("Fachart");
			GridBagConstraints gbc_label_Fachart = new GridBagConstraints();
			gbc_label_Fachart.anchor = GridBagConstraints.EAST;
			gbc_label_Fachart.insets = new Insets(0, 0, 5, 5);
			gbc_label_Fachart.gridx = 0;
			gbc_label_Fachart.gridy = 1;
			panel_2.add(label_Fachart, gbc_label_Fachart);
			
			textField_Fachart = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(5, 5, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			panel_2.add(textField_Fachart, gbc_textField_1);
			textField_Fachart.setColumns(10);
			
			checkBox_Vorrueckungsfach = new JCheckBox("Vorr\u00FCckungsfach");
			GridBagConstraints gbc_checkBox_Vorrueckungsfach = new GridBagConstraints();
			gbc_checkBox_Vorrueckungsfach.fill = GridBagConstraints.HORIZONTAL;
			gbc_checkBox_Vorrueckungsfach.insets = new Insets(0, 0, 5, 0);
			gbc_checkBox_Vorrueckungsfach.gridx = 1;
			gbc_checkBox_Vorrueckungsfach.gridy = 2;
			panel_2.add(checkBox_Vorrueckungsfach, gbc_checkBox_Vorrueckungsfach);
			
			checkBox_AbschliessendesFach = new JCheckBox("Abschlie\u00DFendes Fach");
			GridBagConstraints gbc_checkBox_AbschliessendesFach = new GridBagConstraints();
			gbc_checkBox_AbschliessendesFach.fill = GridBagConstraints.HORIZONTAL;
			gbc_checkBox_AbschliessendesFach.gridx = 1;
			gbc_checkBox_AbschliessendesFach.gridy = 3;
			panel_2.add(checkBox_AbschliessendesFach, gbc_checkBox_AbschliessendesFach);
			
			panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Ausbildungsrichtungen des Zeugnisfachs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel_3 = new GridBagConstraints();
			gbc_panel_3.fill = GridBagConstraints.BOTH;
			gbc_panel_3.insets = new Insets(5, 5, 5, 5);
			gbc_panel_3.gridx = 0;
			gbc_panel_3.gridy = 1;
			panel.add(panel_3, gbc_panel_3);
			GridBagLayout gbl_panel_3 = new GridBagLayout();
			gbl_panel_3.columnWidths = new int[]{0, 0};
			gbl_panel_3.rowHeights = new int[]{119, 0};
			gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_3.setLayout(gbl_panel_3);
			list_ausbildungszweig.addMouseListener(this);
			
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			panel_3.add(scrollPane, gbc_scrollPane);
			scrollPane.setViewportView(list_ausbildungszweig);
			
			panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(null, "Verfügbare Ausbildungsrichtungen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel_4 = new GridBagConstraints();
			gbc_panel_4.fill = GridBagConstraints.BOTH;
			gbc_panel_4.insets = new Insets(5, 5, 5, 5);
			gbc_panel_4.gridx = 0;
			gbc_panel_4.gridy = 2;
			panel.add(panel_4, gbc_panel_4);
			GridBagLayout gbl_panel_4 = new GridBagLayout();
			gbl_panel_4.columnWidths = new int[]{0, 0};
			gbl_panel_4.rowHeights = new int[]{106, 0};
			gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_4.setLayout(gbl_panel_4);
			list_neuausbildungszweig.addMouseListener(this);
			
			scrollPane_1 = new JScrollPane();
			GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
			gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_1.gridx = 0;
			gbc_scrollPane_1.gridy = 0;
			panel_4.add(scrollPane_1, gbc_scrollPane_1);
			scrollPane_1.setViewportView(list_neuausbildungszweig);
			
			JPanel panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(5, 5, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 3;
			panel.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{100, 100, 100, 100, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			
			button_Speichern = new JButton("Speichern");
			button_Speichern.addActionListener(this);
			GridBagConstraints gbc_button_Speichern = new GridBagConstraints();
			gbc_button_Speichern.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Speichern.insets = new Insets(5, 5, 5, 5);
			gbc_button_Speichern.gridx = 0;
			gbc_button_Speichern.gridy = 0;
			panel_1.add(button_Speichern, gbc_button_Speichern);
			
			button_Verwerfen = new JButton("Verwerfen");
			button_Verwerfen.addActionListener(this);
			GridBagConstraints gbc_button_Verwerfen = new GridBagConstraints();
			gbc_button_Verwerfen.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Verwerfen.insets = new Insets(5, 5, 5, 5);
			gbc_button_Verwerfen.gridx = 1;
			gbc_button_Verwerfen.gridy = 0;
			panel_1.add(button_Verwerfen, gbc_button_Verwerfen);
			
			button_Leeren = new JButton("Leeren");
			button_Leeren.addActionListener(this);
			GridBagConstraints gbc_button_Leeren = new GridBagConstraints();
			gbc_button_Leeren.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Leeren.insets = new Insets(5, 5, 5, 5);
			gbc_button_Leeren.gridx = 2;
			gbc_button_Leeren.gridy = 0;
			panel_1.add(button_Leeren, gbc_button_Leeren);
			
			button_Zurueck = new JButton("Zur\u00FCck");
			button_Zurueck.addActionListener(this);
			GridBagConstraints gbc_button_Zurueck = new GridBagConstraints();
			gbc_button_Zurueck.insets = new Insets(5, 5, 5, 5);
			gbc_button_Zurueck.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_Zurueck.gridx = 3;
			gbc_button_Zurueck.gridy = 0;
			panel_1.add(button_Zurueck, gbc_button_Zurueck);
		}
	}

	private void setDatenInMaske() 
	{
		this.textField_Bezeichnung.setText(this.getZeugnisfach().getBez());
		this.textField_Fachart.setText(this.getZeugnisfach().getFachart());
		this.checkBox_Vorrueckungsfach.setSelected(this.getZeugnisfach().isVorrueckungsfach());
		this.checkBox_AbschliessendesFach.setSelected(this.getZeugnisfach().isAbschliessendesFach());
		list_ausbildungszweig_model.removeAllElements();
		list_neuausbildungszweig__model.removeAllElements();
		for(Ausbildungszweig z : getZeugnisfach().getAusbildungszweig())
		{
			list_ausbildungszweig_model.addElement(z);
		}
		list_ausbildungszweig.setModel(list_ausbildungszweig_model);
		for(Ausbildungszweig z : Ausbildungszweig.alleLesen())
		{
			boolean flag = false;
			for(Ausbildungszweig e :getZeugnisfach().getAusbildungszweig())
			{
				if(z.getAusbidldungsart().equals(e.getAusbidldungsart()))
				{
					flag = true;
				}
			}
			if(flag!=true)
			{
				list_neuausbildungszweig__model.addElement(z);
			}
		}
		list_neuausbildungszweig.setModel(list_neuausbildungszweig__model);
	}
	private void getDatenInMaske() 
	{
		this.getZeugnisfach().setBez(this.textField_Bezeichnung.getText());
		this.getZeugnisfach().setFachart(this.textField_Fachart.getText());
		this.getZeugnisfach().setAbschliessendesFach(this.checkBox_AbschliessendesFach.isSelected());
		this.getZeugnisfach().setVorrueckungsfach(this.checkBox_Vorrueckungsfach.isSelected());
		
		for(int i=  0; i<list_ausbildungszweig_model.getSize();i++)
		{
			boolean flag = false;
			for(Ausbildungszweig z: getZeugnisfach().getAusbildungszweig())
			{
				if(z.getAusbidldungsart().equals(list_ausbildungszweig_model.getElementAt(i)))
				{
					flag = true;
				}
			}
			if(flag!=true)
			{
				getZeugnisfach().getAusbildungszweig().add(list_ausbildungszweig_model.getElementAt(i));
			}
			
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(button_Speichern))
		{
			if(!this.textField_Bezeichnung.getText().equals("") && !this.textField_Fachart.getText().equals(""))
			{
				getDatenInMaske();
				getZeugnisfach().speichern();
				this.dispose();
				Dialog_adm_Zeugnisfach dia = new Dialog_adm_Zeugnisfach();
				dia.pack();
				dia.setVisible(true);
			}
		}
		else if(e.getSource().equals(button_Verwerfen))
		{
			setDatenInMaske();
		}
		else if(e.getSource().equals(button_Leeren))
		{
			textField_Bezeichnung.setText("");
			textField_Fachart.setText("");
			checkBox_Vorrueckungsfach.setSelected(false);
			checkBox_AbschliessendesFach.setSelected(false);
		}
		else if(e.getSource()==button_Zurueck)
		{
			setVisible(false);
			Dialog_adm_Zeugnisfach dia = new Dialog_adm_Zeugnisfach();
			dia.pack();
			dia.setVisible(true);
		}
	}
	private Zeugnisfach getZeugnisfach() {
		return zeugnisfach;
	}
	private void setZeugnisfach(Zeugnisfach zeugnisfach) {
		this.zeugnisfach = zeugnisfach;
	}
	public DefaultListModel<Ausbildungszweig> getList_ausbildungszweig_model() {
		return list_ausbildungszweig_model;
	}
	public void setList_ausbildungszweig_model(
			DefaultListModel<Ausbildungszweig> list_ausbildungszweig_model) {
		this.list_ausbildungszweig_model = list_ausbildungszweig_model;
	}
	public DefaultListModel<Ausbildungszweig> getList_neuausbildungszweig__model() {
		return list_neuausbildungszweig__model;
	}
	public void setList_neuausbildungszweig__model(
			DefaultListModel<Ausbildungszweig> list_neuausbildungszweig__model) {
		this.list_neuausbildungszweig__model = list_neuausbildungszweig__model;
	}
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==list_ausbildungszweig)
		{
			if ( e.getClickCount() == 2 ) 
			{
				list_neuausbildungszweig__model.addElement(list_ausbildungszweig.getSelectedValue());
				list_neuausbildungszweig.setModel(list_neuausbildungszweig__model);
				list_ausbildungszweig_model.remove(list_ausbildungszweig.getSelectedIndex());
				list_ausbildungszweig.setModel(list_ausbildungszweig_model);
			}
		}
		else if(e.getSource()==list_neuausbildungszweig)
		{
			if ( e.getClickCount() == 2 ) 
			{
			    list_ausbildungszweig_model.addElement(list_neuausbildungszweig.getSelectedValue());
			    list_ausbildungszweig.setModel(list_ausbildungszweig_model);
			    list_neuausbildungszweig__model.remove(list_neuausbildungszweig.getSelectedIndex());
				list_neuausbildungszweig.setModel(list_neuausbildungszweig__model);
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
