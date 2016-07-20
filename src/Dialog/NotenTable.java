package Dialog;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class NotenTable extends JTable
{
	public NotenTable()
	{
		super();		
	}

	@Override
	public void addColumn(TableColumn aColumn)
	{
		// TODO Auto-generated method stub
		super.addColumn(aColumn);
	}

	@Override
	protected JTableHeader createDefaultTableHeader()
	{
		return new NotenTableHeader(columnModel);
	}	
}
