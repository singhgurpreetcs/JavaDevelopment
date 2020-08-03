package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Gurpreet Singh
 * Date: 02-08-2020
 */

/*
 * ISO8583TitlePanel
 * Description: A class which creates a title panel on the frame.
 * 
 */

public class ISO8583TitlePanel extends JPanel 
{
	private JLabel titleLabel;
	
	public ISO8583TitlePanel()
	{
		titleLabel = new JLabel("ISO8583 FINANCIAL PROTOCOL: INTRODUCTION AND SIMULATION");
		//set up panel dimension
		Dimension dim= getPreferredSize();
		dim.height =75;
		setPreferredSize(dim);
		//set up border around panel
		setBorder(BorderFactory.createEtchedBorder());
		
		// Set up Label
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		titleLabel.setPreferredSize(new Dimension(900, 75));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.CYAN);
		add(titleLabel);
	}
}