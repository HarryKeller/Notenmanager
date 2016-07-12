package Dialog;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.event.TableColumnModelEvent;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.util.*;

public class NotenTableHeader extends JTableHeader
{

	private List<String> tooltips = new ArrayList<String>();
		
	public NotenTableHeader(TableColumnModel cm)
	{
		super(cm);		
	}


	@Override
	public String getToolTipText(MouseEvent arg0)
	{		
		Point position = arg0.getPoint();
		int colindex = table.columnAtPoint(position);
		
		if(colindex >= 0)
		{
			return this.tooltips.get(colindex);
		}
		else
		{
			return "";
		}
	}
	
	public void addColumnTooltip(String tooltip)
	{
		this.tooltips.add(tooltip);
	}
	
	public int findColumnWithTooltip(String tooltip)
	{
		int i = 0;
		int ret = -1;
		
		for(String s : this.tooltips)
		{
			if(tooltip.equals(s))
			{
				ret = i;
			}
			
			i++;
		}
		
		return ret;		
	}	
	
	public void emptyTooltips()
	{
		this.tooltips.clear();
	}
}
