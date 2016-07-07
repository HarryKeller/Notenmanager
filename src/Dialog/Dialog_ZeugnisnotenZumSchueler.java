package Dialog;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTable;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;

import Fachklassen.Schueler;
import Fachklassen.Zeugnisfach;
import Fachklassen.Zeugnisnote;
import Persistenz.DBZugriff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Dialog_ZeugnisnotenZumSchueler extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table = new JTable();;
	private DefaultTableModel model = new DefaultTableModel();
	private List<Zeugnisnote> spnoten = new ArrayList<Zeugnisnote>();
	private JButton btnSpeichern = new JButton("Speichern");
	private List<Zeugnisnote> zfachnoten;
	private List<Zeugnisfach> zfaecher;
	
	private Schueler schueler;

	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					DBZugriff.initDB();
					Dialog_ZeugnisnotenZumSchueler dialog = new Dialog_ZeugnisnotenZumSchueler(new Schueler(4));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Dialog_ZeugnisnotenZumSchueler(Schueler s) 
	{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				DBZugriff.closeDB();
			}
		});
		setSchueler(s);
		
		
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
		
		JLabel label = new JLabel(s.getNachname() + " " + s.getVorname());
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_schueler = new GridBagConstraints();
		gbc_label_schueler.anchor = GridBagConstraints.SOUTHWEST;
		gbc_label_schueler.insets = new Insets(0, 0, 5, 5);
		gbc_label_schueler.gridx = 2;
		gbc_label_schueler.gridy = 0;
		getContentPane().add(label, gbc_label_schueler);
		
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		
		
		model.addColumn("Fach");
		model.addColumn("Errechnet");
		model.addColumn("Festgelegt");
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(this);
		GridBagConstraints gbc_btnZurck = new GridBagConstraints();
		gbc_btnZurck.insets = new Insets(0, 0, 0, 5);
		gbc_btnZurck.gridx = 1;
		gbc_btnZurck.gridy = 2;
		getContentPane().add(btnZurck, gbc_btnZurck);
		
		
		btnSpeichern.addActionListener(this);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.anchor = GridBagConstraints.EAST;
		gbc_btnSpeichern.insets = new Insets(0, 0, 0, 5);
		gbc_btnSpeichern.gridx = 2;
		gbc_btnSpeichern.gridy = 2;
		getContentPane().add(btnSpeichern, gbc_btnSpeichern);
		
		JButton btnZeugnisDrucken = new JButton("Zeugnis drucken");
		btnZeugnisDrucken.addActionListener(this);
		btnZeugnisDrucken.setEnabled(false);
		GridBagConstraints gbc_btnZeugnisDrucken = new GridBagConstraints();
		gbc_btnZeugnisDrucken.insets = new Insets(0, 0, 0, 5);
		gbc_btnZeugnisDrucken.anchor = GridBagConstraints.EAST;
		gbc_btnZeugnisDrucken.gridx = 3;
		gbc_btnZeugnisDrucken.gridy = 2;
		getContentPane().add(btnZeugnisDrucken, gbc_btnZeugnisDrucken);
		setDatenToMaske();
	}
	
	
	
	/**
	* Liest durch eine Liste mit allen Zeugnisfächern der Klasse eines bestimmten
	* Schülers und eine Liste mit allen Zeugnisfächern des Schülers. Zu jedem
	* Zeugnisfach der Klassenliste wird das dazugehörige Zeugnisfach des
	* Schülers zugeordet und ausgegeben.
	*/
	public void setDatenToMaske()
	{
		int n = model.getRowCount();
		for(int i=n-1;i>=0;i=i-1)
		{
			model.removeRow(i);
		}
		zfachnoten = Zeugnisnote.alleLesen(this.getSchueler(), LocalDate.now());
		zfaecher = Zeugnisfach.alleLesen(this.getSchueler().getKlasseid());
		for(Zeugnisfach zfach:zfaecher)
		{
			boolean couldsorted = false;
			String fachBez = zfach.getBez();
			double errNote = 0;
			int finalNote =  0;
			for(Zeugnisnote znote: zfachnoten)
			{
				if(znote.getZeugnisfach().getBez().equals(zfach.getBez()))
				{
					errNote = znote.getNoteErrechnet();
					finalNote =  znote.getNoteZeugnis();
					if(finalNote==0)
					{
						model.addRow(new Object[]{fachBez, errNote,""});
					}
					else
					{
						model.addRow(new Object[]{fachBez, errNote, finalNote});
					}
					couldsorted=true;
				}
			}
			if(couldsorted==false)
			{
				model.addRow(new Object[]{fachBez, "",""});
			}
			
		}
		table.setModel(model);
	}
	
	
	/**
	* Holt sich alle Daten aus der Maske und speichert die Objekte, die geändert wurden.
	*/
	public void getDatenFromMaske()
	{
		try
		{
			try 
			{
				table.getCellEditor().stopCellEditing();
			} 
			catch(Exception e) {}
			int rows = model.getRowCount();
			for(int row=0;row<rows-1;row++)
			{
				double pruef = 0;
				try
				{
					 pruef = Double.parseDouble(model.getValueAt(row, 1).toString());
				}
				catch(Exception ex)
				{
					pruef = 0;
				}
				if(pruef!=0)
				{
					int wert =  (int)Math.round(Double.parseDouble(table.getValueAt(row, 2).toString()));
					for(Zeugnisnote znote: zfachnoten)
					{
						
						if(znote.getZeugnisfach().getBez().equals(model.getValueAt(row, 0).toString())&&znote.getNoteErrechnet()!=0)
						{
							boolean checksave = false;
							if(wert>0&&wert<7)
							{
								checksave = true;
							}
							else
							{
								checksave = false;
							}
							if(checksave==true)
							{
								znote.setNoteZeugnis(wert);
								spnoten.add(znote);
								JOptionPane.showMessageDialog(null, "Die Daten konnten erfolgreich gespeichert werden!", "Meldung", JOptionPane.OK_OPTION);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Die Note des Zeugnisfachs " +  znote.getZeugnisfach().getBez() + " hat einen ungültigen Wert!", "Warnung", JOptionPane.OK_OPTION);
							}
							
							
						}
					}
					
				}
				
			}
			for(Zeugnisnote zn:spnoten)
			{				
				zn.speichern();
			}
			try
			{
				setDatenToMaske();
			}
			catch(Exception es)
			{
				JOptionPane.showMessageDialog(null, "Fehler beim Aktualisieren der Zeugnisnotenliste!", "Meldung", JOptionPane.OK_OPTION);
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Speichern der Zeugnisnoten war nicht erfolgreich!", "Warnung", JOptionPane.OK_OPTION);
		}
		
		
	}
	
	
	
	/**
	* Holt sich den gespeicherten Schüler.
	*/
	public Schueler getSchueler() {
		return schueler;
	}

	/**
	* Setzt für diese Klasse einen bestimmten Schüler.
	*/
	public void setSchueler(Schueler schueler) {
		this.schueler = schueler;
	}

	//Überschriebene Methode des ActionListener
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="Zur\u00FCck")
		{
			//Zurück zur Schülerauswahl
		}
		else if(e.getActionCommand()=="Speichern")
		{
			getDatenFromMaske();
		}
		else if(e.getActionCommand()=="Zeugnis drucken")
		{
			//Weiterleitung zum Zeugnisdruck-Formular
		}
		
	}

}


