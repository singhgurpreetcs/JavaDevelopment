package model;

import java.util.ArrayList;
import java.util.List;

/*
 * Gurpreet Singh
 * Date: 03-08-2020
 */

public class ISO8583FieldsDatabase 
{
	private ArrayList<ISO8583MessageManager> isoFields;
	
	//Constructor
	public ISO8583FieldsDatabase() {
		isoFields = new ArrayList<ISO8583MessageManager>();	
	}
	
	//add the new ISO Row
	public void addISOFields(ISO8583MessageManager isoFieldRow) {
		isoFields.add(isoFieldRow);
	}
	
	//get the ISO Rows
	public List<ISO8583MessageManager> getISOFields() {
		return isoFields;
	}
}