package controller;

import java.util.List;

import model.ISO8583FieldLengthTypes;
import model.ISO8583FieldsDatabase;
import model.ISO8583MessageManager;
import view.ISO8583FieldsPanel;

/*
 * Gurpreet Singh
 * Date: 03-08-2020
 */

/*
 * ISO8583Controller
 * Description: A controller to handle the ISO8583 core functionality
 * 
 */

public class ISO8583Controller 
{
	private String tcpApplicationData;
	private int i;
	private String[] strBinaryData;
	private String strBinaryBitMapData;
	private String[] strBitMapHexData;
	private String strBitMapHex;
	private char[] strBitMap;
	private int intBitMapLen;
 	private String strTcpAppData;
	private int selectedFldCount;
	private String tcpMsgType;
	private int tcpBitMapType; //0-PRIMARY ONLY, 1-SECONDARY PRESENT
	private String tcpData ="";
	
	private String ISOFieldLenArr[][] = 
			{
				{"0", "0", "0"},
				{"1", "0", "0"},
				{"2", "LL", "19"},
				{"3", "FIX", "6"},
				{"4", "FIX", "12"},
				{"5", "FIX", "12"},
				{"6", "FIX", "12"},
				{"7", "FIX", "10"},
				{"8", "FIX", "8"},
				{"9", "FIX", "8"},
				{"10", "FIX", "8"},
				{"11", "FIX", "6"},
				{"12", "FIX", "6"},
				{"13", "FIX", "4"},
				{"14", "FIX", "4"},
				{"15", "FIX", "4"},
				{"16", "FIX", "4"},
				{"17", "FIX", "4"},
				{"18", "FIX", "4"},
				{"19", "FIX", "3"},
				{"20", "FIX", "3"},
				{"21", "FIX", "3"},
				{"22", "FIX", "3"},
				{"23", "FIX", "3"},
				{"24", "FIX", "3"},
				{"25", "FIX", "2"},
				{"26", "FIX", "2"},
				{"27", "FIX", "1"},
				{"28", "FIX", "8"},
				{"29", "FIX", "8"},
				{"30", "FIX", "8"},
				{"31", "FIX", "8"},
				{"32", "LL", "11"},
				{"33", "LL", "11"},
				{"34", "LL", "28"},
				{"35", "LL", "37"},
				{"36", "LLL", "104"},
				{"37", "FIX", "12"},
				{"38", "FIX", "6"},
				{"39", "FIX", "2"},
				{"40", "FIX", "3"},
				{"41", "FIX", "8"},
				{"42", "FIX", "15"},
				{"43", "FIX", "40"},
				{"44", "LL", "25"},
				{"45", "LL", "76"},
				{"46", "LLL", "999"},
				{"47", "LLL", "999"},
				{"48", "LLL", "999"},
				{"49", "FIX", "3"},
				{"50", "FIX", "3"},
				{"51", "FIX", "3"},
				{"52", "FIX", "64"},
				{"53", "FIX", "16"},
				{"54", "LLL", "120"},
				{"55", "LLL", "999"},
				{"56", "LLL", "999"},
				{"57", "LLL", "999"},
				{"58", "LLL", "999"},
				{"59", "LLL", "999"},
				{"60", "LLL", "999"},
				{"61", "LLL", "999"},
				{"62", "LLL", "999"},
				{"63", "LLL", "999"},
				{"64", "FIX", "64"},
				{"65", "FIX", "1"},
				{"66", "FIX", "1"},
				{"67", "FIX", "2"},
				{"68", "FIX", "3"},
				{"69", "FIX", "3"},
				{"70", "FIX", "3"},
				{"71", "FIX", "4"},
				{"72", "FIX", "4"},
				{"73", "FIX", "6"},
				{"74", "FIX", "10"},
				{"75", "FIX", "10"},
				{"76", "FIX", "10"},
				{"77", "FIX", "10"},
				{"78", "FIX", "10"},
				{"79", "FIX", "10"},
				{"80", "FIX", "10"},
				{"81", "FIX", "10"},
				{"82", "FIX", "12"},
				{"83", "FIX", "12"},
				{"84", "FIX", "12"},
				{"85", "FIX", "12"},
				{"86", "FIX", "16"},
				{"87", "FIX", "16"},
				{"88", "FIX", "16"},
				{"89", "FIX", "16"},
				{"90", "FIX", "42"},
				{"91", "FIX", "1"},
				{"92", "FIX", "2"},
				{"93", "FIX", "5"},
				{"94", "FIX", "7"},
				{"95", "FIX", "42"},
				{"96", "FIX", "64"},
				{"97", "FIX", "16"},
				{"98", "FIX", "25"},
				{"99", "LL", "11"},
				{"100", "LL", "11"},
				{"101", "LL", "11"},
				{"102", "LL", "11"},
				{"103", "LL", "11"},
				{"104", "LLL", "100"},
				{"105", "LLL", "999"},
				{"106", "LLL", "999"},
				{"107", "LLL", "999"},
				{"108", "LLL", "999"},
				{"109", "LLL", "999"},
				{"110", "LLL", "999"},
				{"111", "LLL", "999"},
				{"112", "LLL", "999"},
				{"113", "LLL", "999"},
				{"114", "LLL", "999"},
				{"115", "LLL", "999"},
				{"116", "LLL", "999"},
				{"117", "LLL", "999"},
				{"118", "LLL", "999"},
				{"119", "LLL", "999"},
				{"120", "LLL", "999"},
				{"121", "LLL", "999"},
				{"122", "LLL", "999"},
				{"123", "LLL", "999"},
				{"124", "LLL", "999"},
				{"125", "LLL", "999"},
				{"126", "LLL", "999"},
				{"127", "LLL", "999"},
				{"128", "FIX", "64"}
			};
	
	public ISO8583Controller()
	{
		tcpData = "";
		tcpMsgType = "";
		strTcpAppData = null;
		tcpBitMapType = 0;
		strBinaryBitMapData = "";
		strBitMapHex = "";
		tcpApplicationData = "";
	}
	
	ISO8583FieldsDatabase db = new ISO8583FieldsDatabase();
	ISO8583MessageManager t = new ISO8583MessageManager();
	public List<ISO8583MessageManager> getTotalIsoFields()
	{
		return db.getISOFields();
	}
	
	public String generateBitMap(int rowCount, ISO8583FieldsPanel outputPanel)
	{
		tcpData = "";
		tcpMsgType = "";
		strTcpAppData = "";
		tcpBitMapType = 0;
		strBinaryBitMapData = "";
		strBitMapHex = "";
		tcpApplicationData = "";
		strBinaryData = new String[rowCount];
		strBitMapHexData = new String[rowCount];
		strBitMap = new char[rowCount];
		intBitMapLen = 0;
		selectedFldCount = 0;
		System.out.println("Row Count [" +  rowCount);
		//Printing Data From ISO Table
		System.out.print("FieldNumber\tFieldName\tFieldValue\tFieldSelected\tFieldLenType");
		for(i =0; i < rowCount; i++ )
		{
			System.out.print(outputPanel.getFieldNumber(i));
			System.out.print(outputPanel.getFieldName(i));
			System.out.print(outputPanel.getFieldValue(i));
			System.out.print(outputPanel.getFieldSelected(i));
			System.out.println(outputPanel.getFieldLenType(i));
			if((boolean) outputPanel.getFieldSelected(i))
			{
				selectedFldCount++;
			}
		}

		//Return error in case there are no field selected
		if(selectedFldCount == 0)
		{
			return "noselectedfield";
		}

		i = 0;
		//set TCP Message Type
		int intMsgTypeLen = outputPanel.getFieldValue(i).length();
		if(intMsgTypeLen > 4 || intMsgTypeLen < 4)
		{
			return "invalidmsgtypelength";
		}
		else
		{	
			tcpMsgType ="";
			if((String) outputPanel.getFieldLenType(i).getName() == "BCD")
			{
				tcpMsgType = (String) outputPanel.getFieldValue(i);
			}
			else if((String) outputPanel.getFieldLenType(i).getName() == "HEX")
			{
				int x = 0;
				for(x = 0 ;x <outputPanel.getFieldValue(i).length() ; x++)
				{
					tcpMsgType = tcpMsgType + "3" +  outputPanel.getFieldValue(i).charAt(x);
				}
			}
		}
		
		//Generate TCPMessageApplicationData
	
		String strRet = "";
		tcpApplicationData = "";
		for(i = 1; i < rowCount; i++ )
		{
			strRet = "";
			if((boolean) outputPanel.getFieldSelected(i))
			{
				if(((String) outputPanel.getFieldLenType(i).getName()) == "BCD" )
				{
					strRet = BCDLengthHandler(outputPanel.getFieldNumber(i), outputPanel.getFieldValue(i), i+1 , ISOFieldLenArr);
					if(strRet.equals("lengthError"))
					{
						return "lengthError";
					}
					BuildBCDData(outputPanel.getFieldNumber(i), outputPanel.getFieldValue(i),  i+1, ISOFieldLenArr);
				}
				else if(((String) outputPanel.getFieldLenType(i).getName()) == "HEX" )
				{
					//ASCIILengthHandler();
					strRet = BCDLengthHandler(outputPanel.getFieldNumber(i), outputPanel.getFieldValue(i), i+1 , ISOFieldLenArr);
					if(strRet.equals("lengthError"))
					{
						return "lengthError";
					}
					BuildHexData(outputPanel.getFieldNumber(i), outputPanel.getFieldValue(i), i+1, ISOFieldLenArr);
					
				}
				tcpApplicationData = tcpApplicationData + outputPanel.getFieldName(i)+ "=" + outputPanel.getFieldValue(i) +"\n";
			}
		}
		System.out.println("TCPDATA Level1 ["+ tcpData+ "]");
		//Generate BITMAP
		//Find if secondary BITMAP is present
		FindTCPBITMAPType(outputPanel, rowCount);
		
		//ConvertToBinary
		ConvertISOFieldsToBinary(outputPanel, rowCount);
		
		//ConveryBITMAPtoHex
		ConvertISOBITMAPToHex(outputPanel, rowCount);
		System.out.println("BITMAP IN HEX Level2["+ strBitMapHex + "]");
		//GenerateFinalBitMap- Not Required
		//GenerateTCPBITMAP(outputPanel, rowCount);
		
		//Final TCP Message 
		
		strTcpAppData = tcpMsgType + strBitMapHex + tcpData;
		System.out.println("TCPDATA FINAL ["+ strTcpAppData+ "]");
		
		int byteArrLen = strTcpAppData.length()/2;
		String strHexLen = Integer.toHexString(byteArrLen);
		if(1 ==  strHexLen.length())
		{
			strTcpAppData = "000" + strHexLen + strTcpAppData;
		}
		else if(2 ==  strHexLen.length())
		{
			strTcpAppData = "00" + strHexLen + strTcpAppData;
		}
		else if(3 ==  strHexLen.length())
		{
			strTcpAppData = "0" + strHexLen + strTcpAppData;
		}
		System.out.println("FINALLLLlllllllllllllll ["+ tcpApplicationData+ "]");
		return strTcpAppData+"-"+strBitMapHex+"-"+tcpApplicationData;
	}

	//Generate the Final BitMap
	private void GenerateTCPBITMAP(ISO8583FieldsPanel fieldPanel, int rowCount)
	{
		int lCounter = 0;
		int minLoopCounter = 0;
		intBitMapLen = 0;
		for(minLoopCounter = 0; minLoopCounter < rowCount; minLoopCounter++)
		{
			strBitMap[minLoopCounter]  = '-';
		}
		minLoopCounter = 0;
		for(minLoopCounter = 0; minLoopCounter < strBitMapHex.length();minLoopCounter++)
		{
			if((strBitMapHex.charAt(minLoopCounter) >= 'a' &&  strBitMapHex.charAt(minLoopCounter) <= 'z')
				|| (strBitMapHex.charAt(minLoopCounter) >= 'A' &&  strBitMapHex.charAt(minLoopCounter) <= 'Z')
				|| (strBitMapHex.charAt(minLoopCounter) >= '0' &&  strBitMapHex.charAt(minLoopCounter) <= '9'))
			{
				if(strBitMapHex.charAt(minLoopCounter) >= '0' &&  strBitMapHex.charAt(minLoopCounter) <= '9')
				{
					strBitMap[lCounter++] = '3';
					strBitMap[lCounter++] = strBitMapHex.charAt(minLoopCounter);
				}
				else if(strBitMapHex.charAt(minLoopCounter) == 'A' &&  strBitMapHex.charAt(minLoopCounter) == 'a')
				{
					strBitMap[lCounter++] = '4';
					strBitMap[lCounter++] = '1';
				}
				else if(strBitMapHex.charAt(minLoopCounter) == 'B' &&  strBitMapHex.charAt(minLoopCounter) == 'b')
				{
					strBitMap[lCounter++] = '4';
					strBitMap[lCounter++] = '2';
				}
				else if(strBitMapHex.charAt(minLoopCounter) == 'C' &&  strBitMapHex.charAt(minLoopCounter) == 'c')
				{
					strBitMap[lCounter++] = '4';
					strBitMap[lCounter++] = '3';
				}
				else if(strBitMapHex.charAt(minLoopCounter) == 'D' &&  strBitMapHex.charAt(minLoopCounter) == 'd')
				{
					strBitMap[lCounter++] = '4';
					strBitMap[lCounter++] = '4';
				}
				else if(strBitMapHex.charAt(minLoopCounter) == 'E' &&  strBitMapHex.charAt(minLoopCounter) == 'e')
				{
					strBitMap[lCounter++] = '4';
					strBitMap[lCounter++] = '5';
				}
				else if(strBitMapHex.charAt(minLoopCounter) == 'F' &&  strBitMapHex.charAt(minLoopCounter) == 'f')
				{
					strBitMap[lCounter++] = '4';
					strBitMap[lCounter++] = '6';
				}
			}
		}
		strBitMap[lCounter] = '\0';
		
		//Setting BitMap Length
		intBitMapLen = lCounter;
		
		//printing bitmap
		System.out.println("PRINTING BITMAP [");
		minLoopCounter =0;
		for(minLoopCounter = 0; minLoopCounter < strBitMap.length; minLoopCounter++)
		{
			if('-' != strBitMap[minLoopCounter]){
				System.out.print(strBitMap[minLoopCounter]);
			}
		}
		System.out.println("]");
	}
	private void ConvertISOBITMAPToHex(ISO8583FieldsPanel fieldPanel, int rowCount)
	{
		int minLoopCounter = 0;
		for(minLoopCounter = 0; minLoopCounter < rowCount; minLoopCounter++)
		{
			strBitMapHexData[minLoopCounter]  = null;
		}
		int lSum = 0;
		int digitNumber = 1;
		
		int lCount = 0;
		for(minLoopCounter = 0; minLoopCounter <strBinaryBitMapData.length(); minLoopCounter++)
		{
			if(1 == digitNumber)
			{
				lSum+=Integer.parseInt(strBinaryBitMapData.charAt(minLoopCounter)+ "") * 8;
			}
			else if(2 == digitNumber)
			{
				lSum+=Integer.parseInt(strBinaryBitMapData.charAt(minLoopCounter)+ "") * 4;
			}
			else if(3 == digitNumber)
			{
				lSum+=Integer.parseInt(strBinaryBitMapData.charAt(minLoopCounter)+ "") * 2;
			}
			else if( 4 == digitNumber || minLoopCounter < strBinaryBitMapData.length() + 1)
			{
				lSum+=Integer.parseInt(strBinaryBitMapData.charAt(minLoopCounter)+ "") * 1;
				digitNumber = 0;
				if(lSum < 10)
				{
					strBitMapHexData[lCount++] = Integer.toString(lSum);
				}
				else if(lSum == 10)
				{
					strBitMapHexData[lCount++] = "A";
				}
				else if(lSum == 11)
				{
					strBitMapHexData[lCount++] = "B";
				}
				else if(lSum == 12)
				{
					strBitMapHexData[lCount++] = "C";
				}
				else if(lSum == 13)
				{
					strBitMapHexData[lCount++] = "D";
				}
				else if(lSum == 14)
				{
					strBitMapHexData[lCount++] = "E";
				}
				else if(lSum == 15)
				{
					strBitMapHexData[lCount++] = "F";
				}
				lSum = 0;
			}
			digitNumber++;
		}
		minLoopCounter = 0;
		
		for(minLoopCounter = 0; minLoopCounter < rowCount; minLoopCounter++)
		{
			if(strBitMapHexData[minLoopCounter] != null)
			{
				strBitMapHex = strBitMapHex + strBitMapHexData[minLoopCounter];
			}
		}
		
	}
	private void ConvertISOFieldsToBinary(ISO8583FieldsPanel fieldPanel, int rowCount)
	{
		int minLoopCounter = 0;
		int maxLoopCounter = 64;
		if(1 == tcpBitMapType)//secondary bitmap present
			maxLoopCounter = 128;
		
		for(minLoopCounter = 0; minLoopCounter < rowCount; minLoopCounter++)
		{
			strBinaryData[minLoopCounter]  = null;
		}
		minLoopCounter = 0;
		
		for(minLoopCounter = 0; minLoopCounter < maxLoopCounter ; minLoopCounter++)
		{
			if( 0 == minLoopCounter)
			{	
				if(1 == tcpBitMapType)
				{
					//Both primary and secondary bitmaps are present
					strBinaryData[minLoopCounter] = "1";
				}
				else
					strBinaryData[minLoopCounter] = "0";
			}
			else
			{
				if((boolean) fieldPanel.getFieldSelected(minLoopCounter))
				{
					strBinaryData[minLoopCounter] = "1";
				}
				else
					strBinaryData[minLoopCounter] = "0";
			}
		}
		minLoopCounter = 0;
		for(minLoopCounter = 0; minLoopCounter <rowCount; minLoopCounter++)
		{
			if(strBinaryData[minLoopCounter] != null)
			{
				strBinaryBitMapData = strBinaryBitMapData + strBinaryData[minLoopCounter];
			}
		}

		minLoopCounter = 0;
		System.out.println("Binary Data is: [");
		for(minLoopCounter = 0; minLoopCounter < rowCount; minLoopCounter++)
		{
			if(strBinaryData[minLoopCounter] != null)
			{
				System.out.print(strBinaryData[minLoopCounter]);
			}
		}
		System.out.println("]");
	}
	//Function to find if secondary bitmap is present
	private void FindTCPBITMAPType(ISO8583FieldsPanel fieldPanel, int rowCount)
	{
		int i = 0;
		//find secondary bitmap
		for(i=65; i<rowCount; i++)
		{
			if((boolean) fieldPanel.getFieldSelected(i))
			{
				tcpBitMapType = 1; //primary and secondary bitmap is present
				break;
			}
		}
	}

	private String BCDLengthHandler(String FldNumber, String FldValue, int index, String[][] strLenArr)
	{
		String strBCDLength = "";
		if(index > 0)
		{
			if((FldValue.length()) <= Integer.parseInt(strLenArr[index][2]))
			{
				String strLen = Integer.toString(FldValue.length());
				int intLen = strLen.length();
				if(strLenArr[index][1].equals("LL"))
				{
						if(intLen == 1)
							AppendDECLength(strLen, intLen);
						else if(intLen == 2)
							tcpData = tcpData +  strLen;
				}
				else if(strLenArr[index][1].equals("LLL"))
				{
					System.out.println("Here in LLL tcpData ["+ tcpData +"]");
					if(FldValue.length() > 0 && FldValue.length() <=99)
					{
						//making it 2 byte
						tcpData = tcpData + "00";
						if(intLen == 1)
						{
							AppendDECLength(strLen, intLen);
						}
						else if(intLen == 2)
						{
							tcpData = tcpData +  strLen;
						}
					}
					else if(FldValue.length() > 99)
					{
						if(intLen == 3)
						{
							tcpData = tcpData + "0" + strLen;
						}
					}
				}
			}
			else
			{
				return "lengthError";
			}
		}
		
		return strBCDLength;
	}

	private void AppendDECLength(String aDecLen, int aBytePadLen)
	{
		int i;
		for(i = 0; i < aBytePadLen ; i++)
		{
			tcpData = tcpData + "0";
		}
		tcpData = tcpData + aDecLen;
	}
	
	//fUNCTIONS TO BUILD dATA
	//BuildBCDData
	private void BuildBCDData(String FldNumber, String FldValue, int index, String[][] strLenArr)
	{
		int i;
		int PadLength = 0;
		
		if(strLenArr[index][1].equals("FIX"))
		{
			if(FldValue.length() < (Integer.parseInt(strLenArr[index][2])))
			{
				PadLength = Integer.parseInt(strLenArr[index][2]) - FldValue.length();
			}
		}
		
		System.out.println("PadLength = ["+ PadLength + "]");
		if(FldValue.length()%2 != 0 && (FldValue.length() == (Integer.parseInt(strLenArr[index][2]))))
		{
			FldValue =  "0" + FldValue ;
		}
		
		for(i=0; i<FldValue.length(); i++)
		{
			tcpData = tcpData + FldValue.charAt(i);
		}
		i = 0;
		for(i = 0; i< PadLength ; i++)
		{
			tcpData = tcpData + "0";
		}
	}

	private void BuildHexData(String FldNumber, String FldValue, int index, String[][] strLenArr)
	{
		int PadLength = 0;
		
		if(strLenArr[index][1].equals("FIX"))
		{
			if(FldValue.length() < (Integer.parseInt(strLenArr[index][2])))
			{
				PadLength = Integer.parseInt(strLenArr[index][2]) - FldValue.length();
			}
		}
		
		System.out.println("PadLength ["+ PadLength + "]");
		int i;
		StringBuffer lStr = new StringBuffer();
		for(i=0; i<FldValue.length(); i++)
		{
			lStr.append(Integer.toHexString((int) FldValue.charAt(i)));
		}
		tcpData = tcpData + lStr.toString();

		for(i = 0; i< PadLength ; i++)
		{
			tcpData = tcpData + "20";
		}
	}
}