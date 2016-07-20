package Dialog;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Fachklassen.Leistung;
import Fachklassen.Schueler;

public class NotenTableModel extends DefaultTableModel
{	
	private Vector<Vector<Object>> savevector = new Vector();
	
	public NotenTableModel()
	{
		super();		
	}
	
	public void addRowToSaveVector()
	{
		savevector.add(new Vector<Object>());
	}
	
	public boolean addLeistungToSaveVector(Leistung l, int y)
	{
		if(this.savevector.get(y) != null)
		{
			this.savevector.get(y).add(l);
			return true;
		}
		else		
			return false;	
	}
	
	public boolean addLeistungAtCoordinatesToSaveVector(Leistung l, int x, int y)
	{
		if(this.savevector.get(y) != null)
		{
			Vector<Object> v = (Vector<Object>) this.savevector.get(y);
			v.insertElementAt(l, x);
			return true;
		}
		else		
			return false;
	}
	
	public boolean addSchuelerToSaveVector(Schueler s, int y)
	{
		if(this.savevector.get(y) != null)
		{
			this.savevector.get(y).add(s);
			
			return true;
		}
		else		
			return false;		
	}
	
	public Object getLeistungFromCoordinates(int x, int y)
	{		
		return this.savevector.get(y).get(x);
	}
	
	public Vector<Vector<Object>> getSaveVector()
	{
		return this.savevector;
	}
}
