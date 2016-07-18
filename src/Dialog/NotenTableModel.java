package Dialog;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Fachklassen.Leistung;
import Fachklassen.Schueler;

public class NotenTableModel extends DefaultTableModel
{	
	private Vector<Vector<Object>> vec = new Vector();
	
	public NotenTableModel()
	{
		super();
	}
	
	public void addRowToVector()
	{
		vec.add(new Vector<Object>());
	}
	
	public boolean addLeistungToVector(Leistung l, int y)
	{
		if(this.vec.get(y) != null)
		{
			this.vec.get(y).add(l);
			return true;
		}
		else		
			return false;	
	}
	
	public boolean addSchuelerToVector(Schueler s, int y)
	{
		if(this.vec.get(y) != null)
		{
			this.vec.get(y).add(s);
			
			return true;
		}
		else		
			return false;		
	}
	
	public Object getLeistungFromCoordinates(int x, int y)
	{
		return this.vec.get(y).get(x);
	}
	
	public Vector<Vector<Object>> getIdVector()
	{
		return this.vec;
	}
}
