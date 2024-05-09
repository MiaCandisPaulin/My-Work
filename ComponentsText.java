import java.io.*;
import javax.swing.filechooser.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//This is a program by Mia Paulin that displays a text editor with radiobutton
//combo boxes, checkboxes, textfields, a text area, menus and a label
public class ComponentsTest
{
	public static void main(String[] args)
	{
	 PanelFrame myFrame= new PanelFrame();
	 myFrame.pack();
	 myFrame.setVisible(true);
	}
}

class PanelFrame extends JFrame
{
	//instance variables and objects created so that they wouldn't be declared final
	
	 JTextArea textArea=new JTextArea(50, 50);
	private String fontName;
	private JTextField field1=new JTextField(15);
	private JTextField field2=new JTextField(15);
	JMenuItem cutItem=new JMenuItem("Cut");
	JMenuItem copyItem=new JMenuItem("Copy");
	JMenuItem pasteItem=new JMenuItem("Paste");
	JMenuItem exitItem=new JMenuItem("Exit");
	JMenuItem openItem=new JMenuItem("Open");
	JMenuItem saveItem=new JMenuItem("Save");
	JMenuItem saveAsItem=new JMenuItem("Save As");
	



	//declares and initalizes font variable to be used when setting font later in program with setFony method
	private int fontSize=0;
	
	public PanelFrame()
	{
		//set the length and width of the frame and adds a label to the top
		setTitle("Component Text");
		setSize(300,200);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		//creates a menubar to put the file and edit menus on
		JMenuBar menuBar1=new JMenuBar();
		
		//creates the file menu and all the menu items for it
		JMenu fileMenu=new JMenu("File");
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(exitItem);
		menuBar1.add(fileMenu);
		
		//closes program when you press the x
		class XWindowListener extends WindowAdapter
		{
			 public void windowClosing(WindowEvent e)
			{
				int result1=JOptionPane.showConfirmDialog(null, "Do you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(result1==JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		}
		
		addWindowListener(new XWindowListener());
		
	//gives you save dialog box and selects current directory and saves selected item
	ActionListener saveAsListener=new ActionListener()	
		{
		public void actionPerformed(ActionEvent Event)
		{

			
				JFileChooser saveAsChooser=new JFileChooser();
				saveAsChooser.setCurrentDirectory(new File("."));
				
				int result=saveAsChooser.showSaveDialog(PanelFrame.this);
				if (result==JFileChooser.APPROVE_OPTION)
					{
						saveAsChooser.getSelectedFile().getPath();
		FileOutputStream myFile=null;
		BufferedOutputStream myBuffer=null;
		try
		{//opens a file and puts it buffer
			myFile=new FileOutputStream(saveAsChooser.getSelectedFile().getPath());
			myBuffer=new BufferedOutputStream(myFile);
			
			//reads file in buffer and stores in an int 
			String myStr=textArea.getText();
			for(int i=0;i<myStr.length();i++)
			{
				myBuffer.write(myStr.charAt(i));
			}			//prints out file
			
			//closes buffere object
			myBuffer.close();
			//closes fileinputstream object
			myFile.close();
		}
		catch(IOException e){}			
		}
			
		}
  };
  	saveAsItem.addActionListener(saveAsListener);

  

	
	//also gives you a save dialod box
		ActionListener saveListener=new ActionListener()
		{
		public void actionPerformed(ActionEvent Event)
		{
							JFileChooser saveChooser=new JFileChooser();
				saveChooser.setCurrentDirectory(new File("."));
				//String filename=saveChooser.getSelectedFile().getPath();
				if (saveChooser.getSelectedFile()==null)				
				{				
				int result=saveChooser.showSaveDialog(PanelFrame.this);
				if (result==JFileChooser.APPROVE_OPTION)
					{
						saveChooser.getSelectedFile().getPath();
																			FileOutputStream myFile=null;
		BufferedOutputStream myBuffer=null;
		try
		{//opens a file and puts it buffer
			myFile=new FileOutputStream(saveChooser.getSelectedFile().getPath());
			myBuffer=new BufferedOutputStream(myFile);
			
			//reads file in buffer and stores in an int 
			String myStr=textArea.getText();
			for(int i=0;i<myStr.length();i++)
			{
				myBuffer.write(myStr.charAt(i));
			}			//prints out file
			
			//closes buffere object
			myBuffer.close();
			//closes fileinputstream object
			myFile.close();
		}
		catch(IOException e){}	
					}
			}
			
			else if
			 (saveChooser.getSelectedFile()!=null)	
			{
				FileOutputStream myFile=null;
		BufferedOutputStream myBuffer=null;
		try
		{//opens a file and puts it buffer
			myFile=new FileOutputStream(saveChooser.getSelectedFile().getPath());
			myBuffer=new BufferedOutputStream(myFile);
			
			//reads file in buffer and stores in an int 
			String myStr=textArea.getText();
			for(int i=0;i<myStr.length();i++)
			{
				myBuffer.write(myStr.charAt(i));
			}			//prints out file
			
			//closes buffere object
			myBuffer.close();
			//closes fileinputstream object
			myFile.close();
		}
		catch(IOException e){}	

			}
		}
	};
	saveItem.addActionListener(saveListener);


	
	//opens and selects a file, reads the file, saves it to a buffer and then prints it out on screen
		ActionListener openListener=new ActionListener()
		{
		public void actionPerformed(ActionEvent Event)
		{
			JFileChooser openChooser=new JFileChooser();
				openChooser.setCurrentDirectory(new File("."));
								int result=openChooser.showOpenDialog(PanelFrame.this);
				if (result==JFileChooser.APPROVE_OPTION)
					{
						openChooser.getSelectedFile().getPath();
						
							
								FileInputStream myFile=null;
		BufferedInputStream myBuffer=null;
		try
		{//opens a file and puts it buffer
			myFile=new FileInputStream(openChooser.getSelectedFile().getPath());
			myBuffer=new BufferedInputStream(myFile);
			
			//reads file in buffer and stores in an int 
			String myStr="";
			int myCh=myBuffer.read();
			while(myCh != -1)
			{
				//converts int file into word format
				myStr+= (char)myCh;
				myCh=myBuffer.read();
			}
			//prints out file
			textArea.setText(myStr);
			//closes buffere object
			myBuffer.close();
			//closes fileinputstream object
			myFile.close();
		}
		//catched exception if file isn't there
		catch(FileNotFoundException e)
		{
			textArea.setText("That file is not found");
		}			
		//catch
					
					
		
		catch(IOException e)
		{
			System.out.println(e);
		}
		}
		}
	};
	openItem.addActionListener(openListener);

	
	//creates dialog box for exit menu item. asks if you want to exit and if you do, closes program
	ActionListener exitListener=new ActionListener()
	{
		public void actionPerformed(ActionEvent Event)
		{
			int result=JOptionPane.showConfirmDialog(null, "Would you like to Exit","Exit Yes/No", JOptionPane.YES_NO_OPTION);
					switch(result)
					{
					case JOptionPane.YES_OPTION:
							{
							System.exit(0);
								}
						break;
					}
		}
	};
	//adds actionlistener to exit Item
	exitItem.addActionListener(exitListener);
	
	//cuts selected area in text 
	ActionListener cutListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				textArea.cut();
			}
		};
		
		//creates event handler for cutItem
		cutItem.addActionListener(cutListener);
		
		//copy's selected item in text area
		ActionListener copyListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				textArea.copy();
			}
		};
		//cerated event handler for copy item
		copyItem.addActionListener(copyListener);
		
		//paste a previously selected item
		ActionListener pasteListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				textArea.paste();
			}
		};
		//creaed event handler for paste item
		pasteItem.addActionListener(pasteListener);
				
				//creates the edit menu and all the menu items for it
		JMenu editMenu=new JMenu("Edit");
		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		menuBar1.add(editMenu);
		
		//adds the menubar to the frame
		this.setJMenuBar(menuBar1);
		
		//adds the north panel to the frame
		this.add(new NorthPanel(), BorderLayout.NORTH);
		
		this.add(new JScrollPane(textArea));


		//adds the center panel to the frame
		//this.add(new CenterPanel(), BorderLayout.CENTER);
		
		//adds the south panel to the frame
		this.add(new SouthPanel(), BorderLayout.SOUTH);
		
	}
	
	//this is the named inner class that creates the north panel, divided into 2 different panels with
	//components on the top and bottom
	class NorthPanel extends JPanel
	{
		private JPanel northPanel1=new JPanel();//panel at top of northpanel
		private JPanel southPanel1=new JPanel();//pane; at bottom of northpanel
		 JComboBox<String> fontCombo=new JComboBox<>();
		  JCheckBoxMenuItem boldItem=new JCheckBoxMenuItem("Bold");
		   JRadioButton smallRadioButton= new JRadioButton("Small");
		   JRadioButton mediumRadioButton=new JRadioButton("Medium");
			 JCheckBoxMenuItem italicItem=new JCheckBoxMenuItem("Italic");
			 JRadioButton largeRadioButton=new JRadioButton("Large");




		public NorthPanel()
		{
			//sets the layout manager to border layout
			this.setLayout(new BorderLayout());
			
			//creates a combobox that adds different items
						fontCombo.addItem("Sans Serif");
			fontCombo.addItem("Serif");
			fontCombo.addItem("Monospaced");
			fontCombo.addItem("Dialog");
			fontCombo.addItem("dialogInput");
			//adds the combobox to the north panel on th left side
			northPanel1.add(fontCombo);
			//creates and adds a checkbox in the middle of the northpanel1
		
			northPanel1.add(boldItem);
			
			//creates another checkbox that is added to the northpanel1, the panel at the top of the north panel
		 			northPanel1.add(italicItem);
			//adds NorthPanel1 to top of north Panel
			this.add(northPanel1);
			
			//creates a group of radiobuttons and adds it to the southpanel1, the medium on is selected
			ButtonGroup group1=new ButtonGroup();
		  			mediumRadioButton.setSelected(true);
						group1.add(smallRadioButton);
			group1.add(mediumRadioButton);
			group1.add(largeRadioButton);
			southPanel1.add(smallRadioButton);
			southPanel1.add(mediumRadioButton);
			southPanel1.add(largeRadioButton);
			//adds the southpanel1 to bottom of north panel
			this.add(southPanel1, BorderLayout.SOUTH);

								
   		//creates different font for combobox, radiobuttons and checkboxes and sets font for textarea           					
			ActionListener listener=new ActionListener()
			{
				public void actionPerformed(ActionEvent Event)
				{
					fontName=fontCombo.getItemAt(fontCombo.getSelectedIndex());
					  int fontStyle=0;
					 if (boldItem.isSelected()) fontStyle += Font.BOLD;
					 
               if (italicItem.isSelected()) fontStyle += Font.ITALIC;
					
					if(smallRadioButton.isSelected()) 
					fontSize=8;
					if(mediumRadioButton.isSelected())
					fontSize=12;
					if(largeRadioButton.isSelected())
					fontSize=18;

					textArea.setFont(new Font(fontName, fontStyle, fontSize));
				

			}};	
			//creates event handlers for font objects
			fontCombo.addActionListener(listener);
			boldItem.addActionListener(listener);
			italicItem.addActionListener(listener);
			smallRadioButton.addActionListener(listener);
			mediumRadioButton.addActionListener(listener);
			largeRadioButton.addActionListener(listener);
						
			}
		}
	

		//class for center panel where textare is added
		//class CenterPanel extends JPanel
		//{
			
									//adds a new scrollbar object and wraps it around the textarea
						//}
		//}
		
		//class for southpanel that is divided into two panels
		class SouthPanel extends JPanel
		{
			private JPanel southPanel2=new JPanel();
			private JButton replaceButton=new JButton("Replace");			
			private String string1;
			private String string2;
			
			public SouthPanel()
			{
				//adds replace buttons and first field
				southPanel2.add(replaceButton);
				southPanel2.add(field1);	
				
				//adds "with" label and second field and then adds to south panel2
				southPanel2.add(new JLabel("with"));
				southPanel2.add(field2);	
				this.add(southPanel2);
				
				
				ActionListener listener2=new ActionListener()
				{
					public void actionPerformed(ActionEvent Event)
					{
					//sets one variable to get text for textarea
					//then makes another to replace words in first file with words of secon field
					//in text and sets second variable using  replsce method
					//replaces first instance of replaced string in text area
					String s=textArea.getText();
					String s2=s.replaceFirst(field1.getText(), field2.getText());
					textArea.setText(s2);
					
					}
				};
				replaceButton.addActionListener(listener2);
			}
		}
		
	}

