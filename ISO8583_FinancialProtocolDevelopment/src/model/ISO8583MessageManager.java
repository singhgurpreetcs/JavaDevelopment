package model;

/*
 * Gurpreet Singh
 * Date: 03-08-2020
 */

public class ISO8583MessageManager
{
	public static int count = 0;
	private int ID;
	private String FLDNumber;
	private String FLDName;
	private String FLDValue;
	private boolean isSelected;

	private ISO8583FieldLengthTypes FieldLenType;
	
	public ISO8583MessageManager()
	{
		
	}
	//construct
	public ISO8583MessageManager(String aFLDNumber, String aFLDName, String aFLDValue,
			boolean aIsSelected, ISO8583FieldLengthTypes aISO8583FieldLengthTypes)
	{
		this.FLDNumber 		= aFLDNumber;
		this.FLDName 		= aFLDName;
		this.FLDValue		= aFLDValue;
		this.isSelected 	= aIsSelected;
		this.FieldLenType 	= aISO8583FieldLengthTypes;
		
		this.ID = count;
		count++;
	}

	//getters and setters
	public int getID() {
		return ID;
	}
	public String getFLDValue() {
		return FLDValue;
	}

	public void setFLDValue(String fLDValue) {
		this.FLDValue = fLDValue;
	}

	public void setID(int iD) {
		this.ID = iD;
	}
	public String getFLDNumber() {
		return FLDNumber;
	}
	public void setFLDNumber(String fLDNumber) {
		this.FLDNumber = fLDNumber;
	}
	public String getFLDName() {
		return FLDName;
	}
	public void setFLDName(String fLDName) {
		this.FLDName = fLDName;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	public void setSelected(String isSelected) {
		if(isSelected == "true")
			this.isSelected = true;
		else
			this.isSelected = false;		
	}

	public ISO8583FieldLengthTypes getFieldLenType() {
		return FieldLenType;
	}
	public void setFieldLenType(ISO8583FieldLengthTypes fieldLenType) {
		this.FieldLenType = fieldLenType;
	}
}