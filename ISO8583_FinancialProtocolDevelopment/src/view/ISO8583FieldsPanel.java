package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import model.ISO8583FieldLengthTypes;
import model.ISO8583FieldsDatabase;
import model.ISO8583MessageManager;

/*
 * Gurpreet Singh
 * Date: 02-08-2020
 */

/*
 * ISO8583FieldsPanel
 * Description: A class which creates a ISO Fields panel on the frame.
 * 
 */

public class ISO8583FieldsPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private JTable messageGrid;
	private JScrollPane messageScrollPane;
	private ISO8583FieldsTableModel isoFieldTableModel;

	public ISO8583FieldsPanel()
	{
		ISO8583FieldsDatabase db1 = new ISO8583FieldsDatabase();
		//TableModel->ListFields->ListFieldLengthTypes
		List<ISO8583MessageManager> listIsoMsgMgr = new ArrayList<>();

		//ISO Fields Default Message
		listIsoMsgMgr.add(new ISO8583MessageManager("1","Message Type", "0100", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
				
		listIsoMsgMgr.add(new ISO8583MessageManager("2","Primary account number (PAN)", "1234123412341234", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("3","Processing code","030000", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));		
		listIsoMsgMgr.add(new ISO8583MessageManager("4","Amount, transaction","000000004000", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("5","Amount, settlement","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("6","Amount, cardholder billing","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("7","Transmission date & time","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("8","Amount, cardholder billing fee","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("9","Conversion rate, settlement","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("11","System trace audit number (STAN)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("10","Conversion rate, cardholder billing", "null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("12","Local transaction time (hhmmss)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("13","Local transaction date (MMDD)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("14","Expiration date","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("15","Settlement date","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("16","Currency conversion date","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("17","Capture date","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("18","Merchant type, or merchant category code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("19","Acquiring institution (country code)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("20","PAN extended (country code)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("21","Forwarding institution (country code)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("22","Point of service entry mode","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("23","Application PAN sequence number","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("24","network international identifier (NII)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("25","Point of service condition code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("26","Point of service capture code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("27","Authorizing identification response length","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("28","Amount, transaction fee","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("29","Amount, settlement fee","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("30","Amount, transaction processing fee","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("31","Amount, settlement processing fee","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("32","Acquiring institution identification code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("33","Forwarding institution identification code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("34","Primary account number, extended","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("35","Track 2 data","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("36","Track 3 data","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("37","Retrieval reference number","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("38","Authorization identification response","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("39","Response code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("40","Service restriction code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("41","Card acceptor terminal identification","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("42","Card acceptor identification code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("43","Card acceptor name/location","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("44","Additional response data","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("45","Track 1 data","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("46","Additional data (ISO)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("47","Additional data (national)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("48","Additional data (private)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("49","Currency code, transaction","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("50","Currency code, settlement","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("51","Currency code, cardholder billing","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("52","Personal identification number data","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("53","Security related control information","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("54","Additional amounts","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("55","ICC data – EMV having multiple tags","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("56","Reserved (ISO)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("57","Reserved (national)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("58","Reserved (national)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("59","Reserved (national)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("60","Reserved (national)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("61","Reserved (private)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("62","Reserved (private)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("63","Reserved (private)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("64","Message authentication code (MAC)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("65","Extended bitmap indicator","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("66","Settlement code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("67","Extended payment code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("68","Receiving institution country code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("69","Settlement institution country code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("70","Network management information code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("71","Message number","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("72","Last message's number","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("73","Action date (YYMMDD)","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("74","Number of credits","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("75","Credits, reversal number","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("76","Number of debits","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("77","Debits, reversal number","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("78","Transfer number","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("79","Transfer, reversal number","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("80","Number of inquiries","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("81","Number of authorizations","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("82","Credits, processing fee amount","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("83","Credits, transaction fee amount","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("84","Debits, processing fee amount","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("85","Debits, transaction fee amount","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("86","Total amount of credits","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("87","Credits, reversal amount","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("88","Total amount of debits","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("89","Debits, reversal amount","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("90","Original data elements","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("91","File security code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("92","File security code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("93","Response indicator","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("94","Service indicator","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("95","Replacement amounts","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("96","Message security code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("97","Net settlement amount","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("98","Payee","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("99","Settlement institution identification code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("100","Receiving institution identification code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("101","File name","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("102","Account identification 1","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("103","Account identification 2","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("104","Transaction description","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("105","Reserved for ISO use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("106","Reserved for ISO use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("107","Reserved for ISO use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("108","Reserved for ISO use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("109","Reserved for ISO use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("110","Reserved for ISO use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("111","Reserved for ISO use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("112","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("113","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("114","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("115","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("116","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("117","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("118","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("119","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("120","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("121","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("122","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("123","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("124","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("125","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("126","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("127","Reserved for national use","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));
		listIsoMsgMgr.add(new ISO8583MessageManager("128","Message authentication code","null", Boolean.FALSE, new ISO8583FieldLengthTypes("HEX")));

		
		//list of FieldLenTypes
		List<ISO8583FieldLengthTypes> listISO8583FieldLengthTypes = new ArrayList<>();
		listISO8583FieldLengthTypes.add(new ISO8583FieldLengthTypes("HEX"));
		listISO8583FieldLengthTypes.add(new ISO8583FieldLengthTypes("BCD"));
		//listISO8583FieldLengthTypes.add(new ISO8583FieldLengthTypes("ASCII"));
		isoFieldTableModel = new ISO8583FieldsTableModel(listIsoMsgMgr);
 
		messageGrid = new JTable();
		messageScrollPane = new JScrollPane(messageGrid);
		System.out.println("here");
		messageGrid.setDefaultRenderer(ISO8583FieldLengthTypes.class, new ISO8583FieldLenTypeCellRenderer());
		messageGrid.setDefaultEditor(ISO8583FieldLengthTypes.class, new ISO8583FieldLenTypeCellEditor(listISO8583FieldLengthTypes));
        
		messageGrid.setModel(isoFieldTableModel);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(messageGrid));
		//messageScrollPane.setViewportView(messageGrid);

		//add(messageGrid);
		//messageGrid.setVisible(true);
		//setVisible(true);
		
		//Dimension dim= getPreferredSize();
		//dim.width =400;
		//setPreferredSize(dim);
		setBorder(BorderFactory.createEtchedBorder()); 
		//Setting the compound border
	    Border innerBorder = BorderFactory.createTitledBorder("ISO Message");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}
	
	public int getTableRowCount()
	{
		return isoFieldTableModel.getRowCount(); 
	}
	public String getFieldNumber(int index)
	{
		return (String) isoFieldTableModel.getValueAt(index, 0);
	}
	public String getFieldName(int index)
	{
		return (String) isoFieldTableModel.getValueAt(index, 1);
	}
	public String getFieldValue(int index)
	{
		return (String) isoFieldTableModel.getValueAt(index, 2);
	}
	public boolean getFieldSelected(int index)
	{
		return (boolean) isoFieldTableModel.getValueAt(index, 3);
	}
	public ISO8583FieldLengthTypes getFieldLenType(int index)
	{
		return (ISO8583FieldLengthTypes) isoFieldTableModel.getValueAt(index, 4);
	}
	public void deselectFields(int rowCount)
	{
		int minLoopCounter =0;
		for(minLoopCounter = 0;  minLoopCounter< rowCount; minLoopCounter++)
		{
			if(((boolean)isoFieldTableModel.getValueAt(minLoopCounter, 3)))
			{
				isoFieldTableModel.setValueAt(Boolean.parseBoolean("false"), minLoopCounter, 3);
			}
		}
	}
}