package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * Gurpreet Singh
 * Date: 02-08-2020
 */

/*
 * ISO8583OutputPanel
 * Description: A class which creates a output panel to display bitmaps and TCP Message
 * 
 */

public class ISO8583OutputPanel extends JPanel 
{
	private ISO8583OutputBitmapSubPanel outputBitmapSubPanel;
	private ISO8583OutputMsgSubPanel outputMsgSubPanel;
	
	public ISO8583OutputPanel()
	{
		//Two sub panels on the output panel.
		//sub panels contain the text areas
		setLayout(new GridLayout(2, 1));
		outputMsgSubPanel = new ISO8583OutputMsgSubPanel();
		outputBitmapSubPanel = new ISO8583OutputBitmapSubPanel();
		
		add(outputMsgSubPanel);
		add(outputBitmapSubPanel);
		
		Dimension dim= getPreferredSize();
		dim.width =600;
		setPreferredSize(dim);
		setBorder(BorderFactory.createEtchedBorder());
		//set up and initialize text areas
		
		//Setting the compound border
	    Border innerBorder = BorderFactory.createTitledBorder("Output");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}
	public void appendText(String aText)
	{
		String strTcpRawMessage = null ;
		String strTcpBitMap = null;
		String strTcpApplicationData = null;
		int lTokenCount = 0;
		StringTokenizer st = new StringTokenizer(aText,"-");  
		while (st.hasMoreTokens()) 
		{  
				if(0 == lTokenCount)
					strTcpRawMessage = st.nextToken();
				else if(1 == lTokenCount)
					strTcpBitMap = st.nextToken();  
				else if(2 == lTokenCount)
					strTcpApplicationData = st.nextToken();

				lTokenCount++;
		}  
		System.out.println("ISO8583OutputMsgSubPanel Text 					[" + aText + "]");
		System.out.println("ISO8583OutputMsgSubPanel TCPMessage 			[" + strTcpRawMessage + "]");
		System.out.println("ISO8583OutputMsgSubPanel TCPBitMap  			[" + strTcpBitMap + "]");
		System.out.println("ISO8583OutputMsgSubPanel strTcpApplicationData  [" + strTcpApplicationData + "]");
		outputMsgSubPanel.appendTextToTCPMsgSubPanel("TCP Raw packet: \n" + strTcpRawMessage+"\n\n"+ "ISO Fields:\n" + strTcpApplicationData);
		outputBitmapSubPanel.appendTextToBitMapMsgSubPanel(strTcpBitMap);
	}
	
	public void resetTextAreas()
	{
		outputMsgSubPanel.resetTCPMessageTextArea();
		outputBitmapSubPanel.resetBitMapMessageTextArea();
	}
}