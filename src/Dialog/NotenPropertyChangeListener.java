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

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Fachklassen.Leistung;
import Fachklassen.Leistungsart;

public class NotenPropertyChangeListener implements PropertyChangeListener, Runnable
{
	
	private NotenTable table;
	private int editedRow;
	private int editedCol;
	
	/**
	@param t Zu Beobachtende NotenTable
	**/
	
	public NotenPropertyChangeListener(NotenTable t)
	{
		this.table = t;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e)
	{		
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
	
	private void editingStarted()
	{
		SwingUtilities.invokeLater(this);
	}
	
	private void editingStopped(PropertyChangeEvent e)
	{
		try
		{
			NotenTableModel model = (NotenTableModel) this.table.getModel();
			
			Vector idVec = model.getIdVector();
			Vector<Object> idRow = (Vector<Object>) idVec.get(editedRow);
			Leistung l = (Leistung) idRow.get(this.editedCol);
			
			Vector row = (Vector) model.getDataVector().get(this.editedRow);				
			Object newVal = row.get(editedCol);	
			
			String[] note = new String[2];
			
			if(newVal.toString().startsWith("-"))
			{
				note = newVal.toString().split("-");				
			}
			else if(newVal.toString().startsWith("+"))
			{
				note = newVal.toString().split("+");				
			}
			else if(note[0] != null && note[1] != null)	
			{
				l.setNotenstufe(Integer.parseInt(note[1]));	
				char[] c = note[0].toCharArray();
				
				l.setTendenz(c[0]);
			}
			else if(l.getId() == 0)
			{
				NotenTableHeader header = (NotenTableHeader) this.table.getTableHeader();
				
				for(Leistungsart la : Leistungsart.AlleLesen())
				{
					if(la.getBez() == table.getColumnName(editedCol))
						l.setLeistungsart(la);
				}
				
				l.setErhebungsdatum(LocalDate.parse(header.getTooltip(editedCol), DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM
									).withLocale(Locale.ENGLISH)));
			}
			else if(l.getId() != 0)
			{
				l.setNotenstufe(Integer.parseInt(newVal.toString()));	
				l.setTendenz('o');
				l.setLetzteaenderung(LocalDate.now());
			}
		}
		catch(Exception ex)
		{
			
		}
	}
	
	@Override
	public void run()
	{		
		this.editedCol = this.table.getEditingColumn();
		this.editedRow = this.table.getEditingRow();
	}	
}
