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

import Fachklassen.DatumSJ;
import Fachklassen.Schueler;
import Fachklassen.Zeugnis;
import Fachklassen.Zeugnisart;
import Fachklassen.Zeugnisfach;
import Fachklassen.Zeugnisnote;



public class Dialog_ZeugnisnotenZumSchueler extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private JTable table = new JTable();
	private DefaultTableModel model = new DefaultTableModel(){
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
	
	private Dialog_ZeugnisnotenZumSchueler(Schueler s, Dialog_Schuelerwahl sw) 
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
		DatumSJ tsj = new DatumSJ(LocalDate.now());
		ArrayList<Zeugnis> zeugnislist = Zeugnis.alleLesen(tsj, getSchueler());
		for(Zeugnis z: zeugnislist)
		{
			LocalDate a = LocalDate.now();
			LocalDate b = z.getSchuljahr().getBeginn();
			LocalDate c = z.getSchuljahr().getHalbjahr();
			LocalDate d = z.getSchuljahr().getEnde();
			if(a.isAfter(b)&&a.isBefore(c)||a.isAfter(c)&&a.isBefore(d))
			{
				this.setZeugnis(z);
			}
		}
		if(this.getZeugnis()!=null)
		{

			zfaecher = Zeugnisfach.alleLesen(this.getSchueler().getKlasseid());
			for(Zeugnisfach zfach:zfaecher)
			{
				
				String fachBez = zfach.getBez();
				double errNote = Zeugnisnote.berechneNote(zfach, this.schueler);
				
				model.addRow(new Object[]{fachBez, errNote,""});			
			}
			table.setModel(model);
		}
		else
		{
			List<Zeugnisart> zartlist = Zeugnisart.alleLesen();
			String[] zarten = new String[zartlist.size()];
			int count = 0;
			for(Zeugnisart zar: zartlist)
			{
				boolean flag = false;
				for(Zeugnis tzeug:zeugnislist)
				{
					if(tzeug.getZeugnisart().equals(zar))
					{
						flag=true;
					}
				}
				if(flag==false)
				{
					zarten[count] = zar.getZeugnisart();
					count++;
				}
				
			}
			Zeugnis z = new Zeugnis();
			DatumSJ sj = new DatumSJ(LocalDate.now());
			z.setSchuljahr(sj);
			z.setSchueler(this.getSchueler());
			String zart= null;
			while(zart==null)
			{
				int selected_index = JOptionPane.showOptionDialog(this, "Der Schüler besitzt noch kein gültiges Zeugnis für diesen Zeitraum. Bitte wählen sie eine gültige Zeugnisart aus!","Achtung!",JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, zarten, zarten[0]); 
				if(selected_index>=0&&selected_index<=zarten.length)
				{
					zart = zarten[selected_index];
				}
			}
			for(Zeugnisart zar: zartlist)
			{
				if(zar.getZeugnisart().equals(zart))
				{
					z.setZeugnisart(zar);
					break;
				}
			}
			z.speichern();
			setDatenToMaske();
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
			
			zfaecher = Zeugnisfach.alleLesen(this.getSchueler().getKlasseid());
			
			ArrayList<Zeugnisnote> znoten = Zeugnisnote.alleLesen(this.schueler, this.zeugnis.getSchuljahr());
			
			for(int i = 0;i < zfaecher.size();i++)
			{
				//Schauen ob errechnet 0 ist, wenn dann wird die Schleife von neuem begonnen
				if((Double)table.getValueAt(i, 1) == 0.00) continue;
				
				//2. Schaun ob der Schüler bereits eine Zeugnisnote hat für das jeweilige Fach, nicht dass
				//evntl. zwei Noten für das selbe Fach angelegt werden
				
				boolean isZNoteVorhanden = false;
				
				for(Zeugnisnote zn : znoten)
				{
					if(zn.getZeugnisfach().getId() == zfaecher.get(i).getId())
					{
						isZNoteVorhanden = true;
						zn.setAenderungszeitpunkt(LocalDate.now());
						zn.setNoteZeugnis(Integer.valueOf((String) table.getValueAt(i, 2)));
						zn.setNoteErrechnet((Double)table.getValueAt(i, 1));
						zn.speichern();
						break;
					}
					
				}
				
				
				//3.1 Erstellen
				if(!isZNoteVorhanden)
				{
					Zeugnisnote zn = new Zeugnisnote();
					zn.setAenderungszeitpunkt(LocalDate.now());
					zn.setNoteErrechnet((Double)table.getValueAt(i, 1));
					zn.setNoteZeugnis(Integer.valueOf((String) table.getValueAt(i, 2)));
					zn.setSchueler(this.schueler);
					zn.setZeugnis(this.getZeugnis());
					zn.setZeugnisfach(zfaecher.get(i));
					zn.speichern();

				}
					
					
				
			}
				
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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

	/**
	 * Überschriebene Methode des ActionListener
	 */
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
	public static void initGui(Schueler s, Dialog_Schuelerwahl sw)
	{
		if(Dialog_Klassenauswahl.dlg_ZeugnisnotenZumSchueler == null)
			Dialog_Klassenauswahl.dlg_ZeugnisnotenZumSchueler = new Dialog_ZeugnisnotenZumSchueler(s,sw);
		
		Dialog_Klassenauswahl.dlg_ZeugnisnotenZumSchueler.setVisible(true);
		Dialog_Klassenauswahl.dlg_ZeugnisnotenZumSchueler.toFront();
	}
	
}