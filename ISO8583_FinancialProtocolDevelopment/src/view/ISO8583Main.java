package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 * Gurpreet Singh
 * Date: 02-08-2020
 */

public class ISO8583Main 
{

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run() 
			{
				//creating an object to call MainFrame
				new ISO8583MainFrame();		
			}			
		});
	}
}
