package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.ISO8583Controller;

/*
 * Gurpreet Singh
 * Date: 02-08-2020
 */

/*
 * ISO8583MainFrame
 * Description: A class which creates a main JFrame GUI.
 * 
 */

public class ISO8583MainFrame extends JFrame 
{
	private int rowCount;
	private ISO8583TitlePanel titlePanel;
	private ISO8583ToolbarPanel toolBarPanel;
	private ISO8583FieldsPanel fieldsPanel;
	private ISO8583OutputPanel outputPanel;
	private ISO8583Controller controller;
	private ISO8583FieldsTableModel tableModel;	
	private String controllerOutput;
	//default constructor
	public ISO8583MainFrame()
	{
		super("ISO8583 Financial Graphical Simulator");
		//Make sure it takes the entire screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		//working with Panels on Frame
		//setup title panel
		titlePanel = new ISO8583TitlePanel();		
		add(titlePanel, BorderLayout.NORTH);
		
		//setup toolbars panel
		toolBarPanel = new ISO8583ToolbarPanel();
		add(toolBarPanel, BorderLayout.WEST);
		
		//setup fields panel
		fieldsPanel = new ISO8583FieldsPanel();
		add(fieldsPanel, BorderLayout.CENTER);
		
		//setup output panel
		outputPanel = new ISO8583OutputPanel();
		add(outputPanel, BorderLayout.EAST);
		
		controller = new ISO8583Controller();
		
		rowCount = fieldsPanel.getTableRowCount();
		
		//fieldsPanel.getTableData(FieldNumber, FieldName, FieldValue , FieldSelected, FieldLenType );
		setJMenuBar(createMenuBar());
		toolBarPanel.setStringListener(new ISO8583TCPDataStringListener() 
		{
			//System.out.println("Inside MainFrame");
			public void textEmitted(String text) 
			{
				controllerOutput = null;
				controllerOutput = controller.generateBitMap(rowCount, fieldsPanel);
				if(controllerOutput.equals("noselectedfield"))
				{
					JOptionPane.showMessageDialog(ISO8583MainFrame.this, "No Fields Selected", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(controllerOutput.equals("lengthError"))
				{
					JOptionPane.showMessageDialog(ISO8583MainFrame.this, "Field Length Error", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					System.out.println("TCPData ["+controllerOutput + "]");
					System.out.println("Calling appendText text[" + controllerOutput + "]");
					outputPanel.appendText(controllerOutput);
				}
			}

			public void resetTextAreas() 
			{
				outputPanel.resetTextAreas();
			}

			public void deselectFields() 
			{
				System.out.println("Calling Deselect fields");
				fieldsPanel.deselectFields(rowCount);
			}
		});
		
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(exitItem);

		JMenu aboutMenu = new JMenu("About");
		JMenuItem descItem = new JMenuItem("Description");
		
		aboutMenu.add(descItem);
		
		JMenu featureMenu = new JMenu("Features");
		JMenuItem showfeatureItem = new JMenuItem("Show");
		
		featureMenu.add(showfeatureItem);
		
		menuBar.add(fileMenu);
		menuBar.add(featureMenu);
		menuBar.add(aboutMenu);
		

		fileMenu.setMnemonic(KeyEvent.VK_F);
		showfeatureItem.setMnemonic(KeyEvent.VK_M);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(ISO8583MainFrame.this,
						"Do you really want to exit the application?",
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		descItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(ISO8583MainFrame.this, "This is a ISO8583 Financial protocol programmatical simulator\n Developed by Gurpreet Singh\n Last Date: 03-08-2020\n", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
			}
		});
		showfeatureItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(ISO8583MainFrame.this, "Features:\n 1. ISO 8583 Message Format Simulation\n 2. TCP RAW Message Formation\n 3. TCP BITMAP Displayed\n 4. Selected ISO Fields displayed\n 5. Full TCP RAW Message from selected ISO Fields\n 6. User can reset Fields and rerun\n 7. User can reset text areas", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
			}
		});

		return menuBar;
	}
}
