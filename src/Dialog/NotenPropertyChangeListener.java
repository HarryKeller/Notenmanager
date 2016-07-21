package Dialog;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Fachklassen.Leistung;
import Fachklassen.Leistungsart;

public class NotenPropertyChangeListener implements PropertyChangeListener, Runnable
{
	
	private NotenTable table;
	private JButton button;
	private int editedRow;
	private int editedCol;
	
	/**
	@param t Zu Beobachtende NotenTable
	**/
	
	public NotenPropertyChangeListener(NotenTable t, JButton b)
	{
		this.table = t;
		this.button = b;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e)
	{		
		//Fragt ab wann der Cell editor arbeitet => also wann Zelle bearbeitet und wann nicht mehr
		if("tableCellEditor".equals(e.getPropertyName()))
		{
			if(this.table.isEditing())
			{
				this.editingStarted();
			}
			else
			{				
				this.editingStopped(e);									
			}
		}		
		
	}
	
	//Benötigt um Thread zu starten, der die Position der bearbeiteten Zelle zu holen
	//invokeLater um GUI thread nicht in die Quere zu kommen
	private void editingStarted()
	{
		SwingUtilities.invokeLater(this);
		this.button.setEnabled(false);
		
	}
	
	private void editingStopped(PropertyChangeEvent e)
	{
		try
		{
			NotenTableModel model = (NotenTableModel) this.table.getModel();
			
			Vector saveVec = model.getSaveVector();
			Vector<Object> saveRow = (Vector<Object>) saveVec.get(editedRow);
			Leistung l = (Leistung) saveRow.get(this.editedCol);
			
			Vector dataRow = (Vector) model.getDataVector().get(this.editedRow);				
			Object newVal = dataRow.get(editedCol);	
			
			String[] note = new String[2];
						
			//Prüfung ob Tendenz an der Note steht
			if(newVal.toString().startsWith("+") || newVal.toString().startsWith("-"))
			{
				String s = newVal.toString().substring(1);	
				
				note[0] = newVal.toString().substring(0, 1);
				note[1] = s;
			}			
			
			//Notenstufe auf 100 setzen bei ungültiger Note umd späteren Datenbankzugriff zu verhindern durch
			//bewusst falschen Wert
			if(Math.abs(Integer.parseInt(newVal.toString())) > 6 || Math.abs(Integer.parseInt(newVal.toString())) < 1)
			{
				JOptionPane.showMessageDialog(this.table, "Ungültige Note eingegeben! Die Note muss zwischen 1 und 6 liegen.");
				l.setNotenstufe(100);
			}			
			else if(note[0] != null && note[1] != null)	
			{
				l.setNotenstufe(Integer.parseInt(note[1]));	
				char[] c = note[0].toCharArray();
				
				l.setTendenz(c[0]);
				
				//Für den Fall das die Leistung neu ist, aber eine Tendenz hat
				if(l.getId() == 0)
				{
					NotenTableHeader header = (NotenTableHeader) this.table.getTableHeader();
					
					for(Leistungsart la : Leistungsart.AlleLesen())
					{
						if(la.getBez().equals(table.getColumnName(editedCol)))
							l.setLeistungsart(la);
					}
					
					try
					{
						l.setErhebungsdatum(LocalDate.parse(header.getTooltip(editedCol)));
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						System.out.println(ex.getMessage());
					}
					
					l.setLetzteaenderung(LocalDate.now());
				}
			}
			else if(l.getId() == 0) 
			{
				//Für den Fall, das Leistung neu ist, aber keine Tendenz hat => default Tendenz o wird gesetzt
				//Fügt außerdem Leistungsart und Erhebungsdatum der Leistung hinzu
				NotenTableHeader header = (NotenTableHeader) this.table.getTableHeader();
				
				for(Leistungsart la : Leistungsart.AlleLesen())
				{
					if(la.getBez().equals(table.getColumnName(editedCol)))
						l.setLeistungsart(la);
				}
				
				try
				{
					l.setErhebungsdatum(LocalDate.parse(header.getTooltip(editedCol)));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
				
				l.setNotenstufe(Integer.parseInt(newVal.toString()));	
				l.setTendenz('o');
				l.setLetzteaenderung(LocalDate.now());
				
			}
			else if(l.getId() != 0) //Bestehende Leistung wird bearbeitet
			{
				l.setNotenstufe(Integer.parseInt(newVal.toString()));	
				l.setTendenz('o');
				l.setLetzteaenderung(LocalDate.now());
			}
		}
		catch(Exception ex)
		{
			
		}
		
		this.button.setEnabled(true);
	}
	
	@Override
	public void run()
	{		
		//Bestimmt die Position der bearbeiteten Zelle
		this.editedCol = this.table.getEditingColumn();
		this.editedRow = this.table.getEditingRow();
	}	
}
