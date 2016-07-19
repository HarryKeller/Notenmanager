package Dialog;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import Fachklassen.Schueler;
import Fachklassen.Zeugnis;
import Fachklassen.Zeugnisfach;
import Fachklassen.Zeugnisnote;



public class Dialog_ZeugnisnotenZumSchueler extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private JTable table = new JTable();
	private DefaultTableModel model = new DefaultTableModel(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	@Override
	    public boolean isCellEditable(int row, int column) {
	       if(column>=0&&column<2)
	       {
	    	   return false;
	       }
	       else
	       {
	    	   return true;
	       }
	       
	    }};
	private List<Zeugnisnote> spnoten = new ArrayList<Zeugnisnote>();
	private JButton btnSpeichern = new JButton("Speichern");
	private List<Zeugnisnote> zfachnoten;
	private List<Zeugnisfach> zfaecher;
	private Schueler schueler;
	private Dialog_Schuelerwahl swahl;
	private Zeugnis zeugnis;
	
	public Dialog_ZeugnisnotenZumSchueler(Schueler s, Dialog_Schuelerwahl sw) 
	{
		setSchueler(s);
		setSwahl(sw);
		
		this.setTitle("Zeugnisnoten - Anzeigen");
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
		
		JButton btnZeugnisDrucken = new JButton("Zeugnis anzeigen");
		btnZeugnisDrucken.addActionListener(this);
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
		GetZeugnisFromZeugnisnoten(zfachnoten);
		zfaecher = Zeugnisfach.alleLesen(this.getSchueler().getKlasseid());
		
		for(Zeugnisnote znote: zfachnoten)
		{
			System.out.println(znote);
		}
		
		for(Zeugnisfach zfach:zfaecher)
		{
			boolean couldsorted = false;
			String fachBez = zfach.getBez();
			double errNote = 0;
			int finalNote =  0;
			for(Zeugnisnote znote: zfachnoten)
			{
				errNote = 0;
				finalNote=0;
				if(znote.getZeugnisfach().getBez().equals(zfach.getBez()))
				{
					znote.berechneNote(znote.getZeugnisfach(), this.getSchueler());
					znote.speichern();
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
				Zeugnisnote zno = new Zeugnisnote();
				zno.setAenderungszeitpunkt(LocalDate.now());
				zno.setZeugnisfach(zfach);
				zno.setSchueler(schueler);
				zno.setNoteErrechnet(zno.berechneNote(zfach, schueler));
				if(this.getZeugnis()==null)
				{
					Zeugnis z = new Zeugnis();
					z.setSchueler(this.getSchueler());
					z.speichern();
					this.setZeugnis(z);
					zno.setZeugnis(z);
				}
				else
				{
					zno.setZeugnis(this.getZeugnis());
				}
				zno.speichern();
				this.zfachnoten.add(zno);
				model.addRow(new Object[]{fachBez, zno.getNoteErrechnet(),""});
			}
			
		}
		table.setModel(model);
	}
	
	
	/**
	* Falls der Schüler schon Noten hat, holt sich die Methode das dazugehörige Zeugnis.
	*/
	private void GetZeugnisFromZeugnisnoten(List<Zeugnisnote> list)
	{
		for(Zeugnisnote note:list)
		{
			if(this.getZeugnis()==null)
			{
				this.setZeugnis(note.getZeugnis());
			}
		}
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
			int counter = 0;
			for(Zeugnisfach zfach:zfaecher)
			{
				if(zfach.getBez().equals((table.getValueAt(counter, 0))))
				{
					try
					{
						int wert =  (int)Math.round(Double.parseDouble(table.getValueAt(counter, 2).toString()));
						for(Zeugnisnote znote: zfachnoten)
						{
							if(znote.getZeugnisfach().getBez().equals(model.getValueAt(counter, 0).toString())&&znote.getNoteErrechnet()!=0)
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
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Die Note des Zeugnisfachs " +  znote.getZeugnisfach().getBez() + " hat einen ungültigen Wert!", "Warnung", JOptionPane.OK_OPTION);
								}
							}
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}	
				counter++;
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
			this.setVisible(false);
			getSwahl().setVisible(true);
		}
		else if(e.getActionCommand()=="Speichern")
		{
			getDatenFromMaske();
		}
		else if(e.getActionCommand()=="Zeugnis anzeigen")
		{
			//Weiterleitung zum Zeugnisdruck-Formular
		}
		
	}



	public Dialog_Schuelerwahl getSwahl() {
		return swahl;
	}



	public void setSwahl(Dialog_Schuelerwahl swahl) {
		this.swahl = swahl;
	}



	public Zeugnis getZeugnis() {
		return zeugnis;
	}



	public void setZeugnis(Zeugnis zeugnis) {
		this.zeugnis = zeugnis;
	}

	
}