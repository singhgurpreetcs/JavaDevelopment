package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.ISO8583FieldLengthTypes;
import model.ISO8583FieldsDatabase;
import model.ISO8583MessageManager;

public class ISO8583FieldsTableModel extends AbstractTableModel
{
	private List<ISO8583MessageManager> isoFieldsDb = new ArrayList<>();
	private String[] colNames = 
		{"FLDNumber", "FLDName", "FLDValue", "FLDIsSelected", "FLDLengthType"};
	 private final Class[] columnClass = new Class[] {
		        String.class, String.class, String.class, Boolean.class, ISO8583FieldLengthTypes.class
		    };
		 
	@Override
	public String getColumnName(int column)
	{
		return colNames[column];
	}
	
	public ISO8583FieldsTableModel(List<ISO8583MessageManager> isoFieldsDb) 
	{
		this.isoFieldsDb = isoFieldsDb;
	}
	public ISO8583FieldsTableModel(ArrayList<ISO8583MessageManager> isoFields) 
	{
		this.isoFieldsDb = isoFields;
	}
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colNames.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return isoFieldsDb.size();
	}

	public Object getValueAt(int row, int col) 
	{
		ISO8583MessageManager isoFieldRow = isoFieldsDb.get(row);

		switch(col)
		{
			case 0:
				return isoFieldRow.getFLDNumber();
			case 1:
				return isoFieldRow.getFLDName();
			case 2:
				return isoFieldRow.getFLDValue();
			case 3:
				return isoFieldRow.isSelected();
			case 4:
				return isoFieldRow.getFieldLenType();
		}

		return null;
	}
	 public boolean isCellEditable(int rowIndex, int columnIndex)
	 {
		 	if(columnIndex >= 2  )
		 	{
		 		System.out.println("Yes\n");
		 		return true;
		 	}
		 	else
		 		return false;
	 }
	 public Class<?> getColumnClass(int columnIndex)
	 {
	       return columnClass[columnIndex];
	 }
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{
		ISO8583MessageManager isoFieldRow = isoFieldsDb.get(rowIndex);
		
		if(0 == columnIndex) 
		{
			isoFieldRow.setFLDNumber((String) aValue);
	    }
	    else if(1 == columnIndex) 
	    {
	      isoFieldRow.setFLDName((String) aValue);
	    }
	    else if(2 == columnIndex) 
	    {
	      isoFieldRow.setFLDValue((String) aValue);
	    }
	    else if(3 == columnIndex)
	    {
	    	System.out.println("Setting value");
	    	//if((String) aValue.equals("true"))
	      isoFieldRow.setSelected((Boolean)aValue);
	    }
	    else if(4 == columnIndex)
	    {
	      isoFieldRow.setFieldLenType((ISO8583FieldLengthTypes) aValue);
	    }
	}
}