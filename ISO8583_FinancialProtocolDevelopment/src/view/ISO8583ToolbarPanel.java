package view;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * Gurpreet Singh
 * Date: 02-08-2020
 */

/*
 * ISO8583ToolbarPanel
 * Description: A class which creates a toolbars
 * It has 3 buttons.
 * 1- Generate TCP Message,
 * 2- Show Bitmap 
 * 3- Reset ISO Fields
 * 4- Reset Output Text Areas
 */

public class ISO8583ToolbarPanel extends JPanel implements ActionListener
{
	private JButton genTCPMsgBtn;
	private JButton showBitmapsBtn;
	private JButton resetFieldsBtn;
	private JButton resetOutputAreaBtn;
	private ISO8583TCPDataStringListener tcpDataAreaListener;

	public ISO8583ToolbarPanel()
	{
		//set dimensions
		Dimension dim= getPreferredSize();
		dim.width =200;
		setPreferredSize(dim);	
		setBorder(BorderFactory.createEtchedBorder());
		
		//initialize and setup buttons
		genTCPMsgBtn = new JButton("Gen TCPMsg");
		resetFieldsBtn = new JButton("Reset Fields");
		resetOutputAreaBtn = new JButton("Reset Output");
		showBitmapsBtn = new JButton("Show Bitmap");
		
		 genTCPMsgBtn.addActionListener(this);
		 resetFieldsBtn.addActionListener(this);
		 resetOutputAreaBtn.addActionListener(this);
		 showBitmapsBtn.addActionListener(this);
		    
		JPanel layout = new JPanel(new GridBagLayout());
		JPanel btnPanel = new JPanel(new GridLayout(4, 1, 25, 15));
	    btnPanel.add(genTCPMsgBtn);
	    btnPanel.add(resetFieldsBtn);
	    btnPanel.add(resetOutputAreaBtn);      
	    //btnPanel.add(showBitmapsBtn);

	    layout.add(btnPanel);
	    add(layout, BorderLayout.CENTER);
	    
	    showBitmapsBtn.setEnabled(false);
	    resetOutputAreaBtn.setEnabled(false);
	    
	    
	    //Setting the compound border
	    Border innerBorder = BorderFactory.createTitledBorder("Execute");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}
	
	public void setStringListener(ISO8583TCPDataStringListener listener)
	{
		this.tcpDataAreaListener = listener;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		JButton clicked = (JButton) e.getSource();
		
		if(clicked == genTCPMsgBtn)
		{
			if(tcpDataAreaListener != null)
			{				
				System.out.println("Inside genTCPMsgBtn Clicked");
				tcpDataAreaListener.textEmitted("Hello\n");
				resetOutputAreaBtn.setEnabled(true);
			}
		}
		else if(clicked == resetFieldsBtn)
		{
			if(tcpDataAreaListener != null)
			{
				System.out.println("Inside resetFieldsBtn Clicked");
				tcpDataAreaListener.deselectFields();
			}
		}
		else if(clicked == resetOutputAreaBtn)
		{
			if(tcpDataAreaListener != null)
			{
				System.out.println("Inside resetOutputAreaBtn Clicked");
				tcpDataAreaListener.resetTextAreas();
			}
		}
	}
}