package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/*
 * Gurpreet Singh
 * Date: 02-08-2020
 */

/*
 * ISO8583OutputBitmapSubPanel
 * Description: A subpanel on main outputpanel.
 * it contains text area to display the tcp bitmap.
 * 
 */

public class ISO8583OutputBitmapSubPanel extends JPanel 
{
	private JTextArea textAreaBitMap;
	public ISO8583OutputBitmapSubPanel()
	{

		textAreaBitMap = new JTextArea();
		add(textAreaBitMap);
		setLayout(new BorderLayout());
		add(new JScrollPane(textAreaBitMap));
		//Setting the compound border
	    Border innerBorder = BorderFactory.createTitledBorder("TCP BITMAP");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}
	public void appendTextToBitMapMsgSubPanel(String aText)
	{
		if(aText.length() == 16)
		{
			aText = "BITMAP (PRIMARY) ONLY:" +"\n" + aText;
		}
		else if(aText.length() == 32)
		{
			aText = "BITMAP ONLY:" +"\n" + aText;
		}
		
		textAreaBitMap.append(aText);
	}
	public void resetBitMapMessageTextArea()
	{
		textAreaBitMap.setText(null);
	}
}
