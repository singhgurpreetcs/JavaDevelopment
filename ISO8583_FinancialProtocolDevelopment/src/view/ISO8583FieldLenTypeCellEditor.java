package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import model.ISO8583FieldLengthTypes;
 
/*
 * Gurpreet Singh
 * Date: 03-08-2020
 */

public class ISO8583FieldLenTypeCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener 
{
	private static final long serialVersionUID = 1L;
	private ISO8583FieldLengthTypes isoFieldLenType;
    private List<ISO8583FieldLengthTypes> listisoFieldLenType;
     
    public ISO8583FieldLenTypeCellEditor(List<ISO8583FieldLengthTypes> listisoFieldLenType) {
        this.listisoFieldLenType = listisoFieldLenType;
    }
     
    public Object getCellEditorValue() {
        return this.isoFieldLenType;
    }
 
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (value instanceof ISO8583FieldLengthTypes) {
            this.isoFieldLenType = (ISO8583FieldLengthTypes) value;
        }
         
        JComboBox<ISO8583FieldLengthTypes> comboIsoFields = new JComboBox<ISO8583FieldLengthTypes>();
         
        for (ISO8583FieldLengthTypes aIsoFields : listisoFieldLenType) 
        {
        	System.out.println("ISofields"+ aIsoFields.getName());
        	comboIsoFields.addItem(aIsoFields);
        }
         
        comboIsoFields.setSelectedItem(isoFieldLenType);
        comboIsoFields.addActionListener(this);
         
        return comboIsoFields;
    }
 
    public void actionPerformed(ActionEvent event) 
    {
        JComboBox<ISO8583FieldLengthTypes> comboIsoFields = (JComboBox<ISO8583FieldLengthTypes>) event.getSource();
        System.out.println("actionPerformed");
        this.isoFieldLenType = (ISO8583FieldLengthTypes) comboIsoFields.getSelectedItem();
    }
}