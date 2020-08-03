package model;

/*
 * Gurpreet Singh
 * Date: 03-08-2020
 */

public class ISO8583FieldLengthTypes 
{
	private String Name;

	//constructor to build field length types
	public ISO8583FieldLengthTypes(String name)
	{
		super();
		this.Name = name; 
	}
	
	// getters and setters
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	 public String toString() {
	        return this.Name;
	    }
}