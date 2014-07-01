//package libManGUI.LibManGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;


/**
LibManGUI implements Java Swing applications to provide the user with a simple library management program which can keep track
of books and whom has rented them. 
@author Stefan Knott 
*/ 
public class LibManGUI extends JFrame
{ 

   private static final long serialVersionUID = 1L;
   private JFrame mainFrame;
   private JLabel statusLabel;
   private JPanel controlPanel, addPanel, searchPanel, chkOutPanel;
   private JButton addButton, addButton2, searchButton, searchButton2, chkOutButton, chkOutButton2;
   private JTextField addTxt, searchTxt, bkTxt, rentTxt;
   private JLabel picLabel;

   ///Default Constructor
   public LibManGUI()
   {
      new libManager();
      libManager.readInHandler();
      prepareGUI();      
   }

   ///Where the GUI is ran from
   public static void main(String[] args)
   {
      LibManGUI gui = new LibManGUI();      
      gui.runGUI();   
   }
	
   /**Method prepare the layout for the GUI's panels which are used for adding, searching and checking out.
   */
   private void prepareGUI()
   {
      controlPanel = new JPanel();
      mainFrame = new JFrame("Library Manager");
      mainFrame.setSize(400, 400);
      mainFrame.getContentPane().setBackground(new Color(255,255, 255));

      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
		libManager.writeToFileHandler();		
            System.exit(0);
         }        
      });
	
      controlPanel.setBackground(Color.WHITE);
      try{
	BufferedImage mainIcon = ImageIO.read(new File("bookworm.jpg"));
	      controlPanel.setLayout(null);
	      picLabel = new JLabel(new ImageIcon(mainIcon));
	      picLabel.setBounds(10, 43, 135, 121);
	      controlPanel.add(picLabel);
       }catch(IOException e){}
      
      statusLabel = new JLabel("Welcome to Your Library!");
      statusLabel.setBounds(138, 23, 157, 16);	 
      controlPanel.add(statusLabel);
      
      addButton2 = new JButton("Add");
      addTxt = new JTextField(10);
      addPanel = new JPanel();
      addPanel.add(addButton2);
      addPanel.add(addTxt);

      searchButton2 = new JButton("Search");
      searchTxt = new JTextField(10);
      searchPanel = new JPanel();
      searchPanel.add(searchButton2);
      searchPanel.add(searchTxt);
      
      chkOutButton2 = new JButton("Check Out");
      bkTxt = new JTextField(10);
      rentTxt = new JTextField(10);
      chkOutPanel = new JPanel();
      chkOutPanel.add(chkOutButton2);
      chkOutPanel.add(bkTxt);
      chkOutPanel.add(rentTxt);

      mainFrame.getContentPane().add(controlPanel);
      
            addButton = new JButton("Add");
            addButton.setBounds(151, 45, 75, 29);
            
                  controlPanel.add(addButton);
                  searchButton = new JButton("Search");
                  searchButton.setBounds(151, 80, 85, 29);
                  controlPanel.add(searchButton);
                  chkOutButton = new JButton("Checkout");
                  chkOutButton.setBounds(151, 115, 104, 29);
                  controlPanel.add(chkOutButton);
      mainFrame.setVisible(true);  
   }

   /**Method used to set the control of the mainFrame
   @param rmv JPanel to be removed from mainFrame
   @param set JPanel to be set to MainFrame
   */
   private void resetPane(JPanel rmv, JPanel set)
   {
	mainFrame.remove(rmv);
	mainFrame.setContentPane(set);
	mainFrame.validate();
	mainFrame.repaint();
        mainFrame.getContentPane().setBackground(new Color(255, 255, 255));

//	statusLabel.setSize(200, 50);
//	statusLabel.setBounds(50, 275, 300, 50);	 
   }
 
   /**Method used to maintain the control and output for add operations.
   */
   private void addPanel()
   {
	addButton2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String addBk = new String();
			addBk = addTxt.getText().trim();
			if(addBk.equals(""))
			{}
			else{
				String report = libManager.addHandler(addBk);
				if(report.equals("Error")){}
				else{
					statusLabel.setText(addBk + " was added to the library");
				}
			}
			resetPane(addPanel, controlPanel);
      			mainFrame.getContentPane().setBackground(new Color(255, 255, 255));
			for(ActionListener al : addButton2.getActionListeners())
			{
				addButton2.removeActionListener(al);
			}			
		}
         });          
   
   }

   /**Method used to maintain the control and output for search operations.
   */
   private void searchPanel()
   {
	searchButton2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String searchItem = searchTxt.getText().trim();
			if(searchItem.equals(""))
			{}
			else
			{
				String report = libManager.searchHandler(searchItem);
				if(report.equals("Error"))
				{}
				else
				{
					statusLabel.setText("Book info: " + report);
				}
			}
			resetPane(searchPanel, controlPanel);
	
			for(ActionListener al : searchButton2.getActionListeners())
			{
				searchButton2.removeActionListener(al);
			}		
		}
         });
	return;
   }

   /**Method used to maintain the control and output for checkout operations.
   */
   private void chkOutPanel()
   {
	chkOutButton2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String bk = bkTxt.getText().trim();
			String renter = rentTxt.getText().trim();
			if(bk.equals("") || renter.equals(""))
			{}
			else
			{
				String report = libManager.chkOutHandler(bk, renter);
				if(report.equals("Error"))
				{}
				else
				{	
					statusLabel.setText("Book: " + bk + " is now checked out by " + renter);
				}
			}
			resetPane(chkOutPanel, controlPanel);
		}
        });
   }
	
   /**Method used to maintain control of the GUI from the control panel
   */
   private void runGUI()
   {
      addButton.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
	 {
		resetPane(controlPanel, addPanel);
		addPanel();
      	 }
      });

      searchButton.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
	 {
		resetPane(controlPanel, searchPanel);
		searchPanel();
      	 }
      });

      chkOutButton.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
         {
		resetPane(controlPanel, chkOutPanel);
		chkOutPanel();
		
         }
      });
	
      controlPanel.add(addButton);
      controlPanel.add(searchButton);
      controlPanel.add(chkOutButton);       

      mainFrame.setVisible(true);  
   }
}
