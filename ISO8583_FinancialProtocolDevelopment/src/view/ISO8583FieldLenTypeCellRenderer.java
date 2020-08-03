package view;


import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import model.ISO8583FieldLengthTypes;

/*
 * Gurpreet Singh
 * Date: 03-08-2020
 */

public class ISO8583FieldLenTypeCellRenderer extends DefaultTableCellRenderer 
{
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) 
	{
        if (value instanceof ISO8583FieldLengthTypes) 
        {
        	ISO8583FieldLengthTypes isoFieldLenType = (ISO8583FieldLengthTypes) value;
            setText(isoFieldLenType.getName());
        }
        return this;
    }
}
