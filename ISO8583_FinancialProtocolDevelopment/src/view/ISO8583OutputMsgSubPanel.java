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
 * ISO8583OutputMsgSubPanel
 * Description: A subpanel on main outputpanel.
 * it contains text area to display the tcp message.
 * 
 */

public class ISO8583OutputMsgSubPanel extends JPanel 
{
	private JTextArea textAreaTCPMsg;
	public ISO8583OutputMsgSubPanel()
	{
		textAreaTCPMsg = new JTextArea();
		add(textAreaTCPMsg);
		setLayout(new BorderLayout());
		add(new JScrollPane(textAreaTCPMsg));
		//Setting the compound border
	    Border innerBorder = BorderFactory.createTitledBorder("TCP Message");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}
	public void appendTextToTCPMsgSubPanel(String aText)
	{
		System.out.println("ISO8583OutputMsgSubPanel Text [" + aText + "]");
		textAreaTCPMsg.append(aText);
	}
	public void resetTCPMessageTextArea()
	{
		textAreaTCPMsg.setText(null);
	}
}