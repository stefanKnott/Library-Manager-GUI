//package libManGUI.LibManGUI;

import java.awt.Color;
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
   private JPanel controlPanel, addPanel, searchPanel, chkOutPanel, rmvPanel;
   private JButton addButton, addButton2, searchButton, searchButton2, chkOutButton, chkOutButton2, rmvButton, rmvButton2;
   private JTextField addTxt, searchTxt, bkTxt, rentTxt, rmvTxt;

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
	
   private void setControlPanelComponents()
   {
      statusLabel = new JLabel("Welcome to Your Library!",JLabel.CENTER);    
      statusLabel.setBounds(40, 275, 300, 50);	  

      addButton = new JButton("Add");
      rmvButton = new JButton("Remove");
      searchButton = new JButton("Search");
      chkOutButton = new JButton("Checkout");

      controlPanel.setLayout(null); 
      controlPanel.setOpaque(true);  

      addButton.setBounds(250, 75, 115, 30);	 
      rmvButton.setBounds(250, 110, 115, 30);	 
      searchButton.setBounds(250, 145, 115, 30);	 
      chkOutButton.setBounds(250, 180, 115, 30);	 

      try{
	BufferedImage mainIcon = ImageIO.read(new File("bookworm.jpg"));
	JLabel picLabel = new JLabel(new ImageIcon(mainIcon));
        picLabel.setBounds(50, 75, 150, 150);	 
	controlPanel.add(picLabel);
       }catch(IOException e){}


      controlPanel.add(addButton);
      controlPanel.add(rmvButton);
      controlPanel.add(searchButton);
      controlPanel.add(chkOutButton);
      controlPanel.add(statusLabel);	
      controlPanel.setBackground(Color.WHITE);
   }

   private void addPicture(JPanel panel)
   {
      try{
	BufferedImage bookworm = ImageIO.read(new File("bookworm21.gif"));
	JLabel wormLabel = new JLabel(new ImageIcon(bookworm));
        wormLabel.setBounds(50, 265, 150, 67);	 
	panel.add(wormLabel);
       }catch(IOException e){}	
   }

   private void setAddPanelComponents()
   {
      addPanel.setLayout(null); 
      addPanel.setOpaque(true);  

      JLabel addLabel = new JLabel("Book title:");
      addButton2 = new JButton("Add");
      addTxt = new JTextField(10);

      addPicture(addPanel);

      addLabel.setBounds(55, 105, 115, 30);
      addButton2.setBounds(250, 105, 115, 30);	 	
      addTxt.setBounds(130, 105, 115, 30);

      addPanel.add(addLabel);
      addPanel.add(addButton2);
      addPanel.add(addTxt);
   }

   private void setRmvPanelComponents()
   {
      rmvPanel.setLayout(null); 
      rmvPanel.setOpaque(true);  

      rmvButton2 = new JButton("Remove");
      rmvTxt = new JTextField(10);
      JLabel rmvLabel = new JLabel("Book title: ");
      rmvPanel.add(rmvButton2);
      rmvPanel.add(rmvTxt);
      rmvPanel.add(rmvLabel);

      addPicture(rmvPanel);

      rmvLabel.setBounds(55, 105, 115, 30);
      rmvButton2.setBounds(250, 105, 115, 30);	 	
      rmvTxt.setBounds(130, 105, 115, 30);
   }
   
 
   private void setSearchPanelComponents()
   {
      searchPanel.setLayout(null); 
      searchPanel.setOpaque(true);  

      searchButton2 = new JButton("Search");
      searchTxt = new JTextField(10);
      JLabel searchLabel = new JLabel("Book title:");

      searchPanel.add(searchButton2);
      searchPanel.add(searchTxt);
      searchPanel.add(searchLabel);

      addPicture(searchPanel);

      searchLabel.setBounds(55, 105, 115, 30);
      searchButton2.setBounds(250, 105, 115, 30);	 	
      searchTxt.setBounds(130, 105, 115, 30);
   }

   private void setChkOutPanelComponents()
   {
      chkOutPanel.setLayout(null); 
      chkOutPanel.setOpaque(true);  

      chkOutButton2 = new JButton("Check Out");
      bkTxt = new JTextField(10);
      rentTxt = new JTextField(10);
      JLabel bookLabel = new JLabel("Book title:");
      JLabel renterLabel = new JLabel("Renter:");

      chkOutPanel.add(chkOutButton2);
      chkOutPanel.add(bkTxt);
      chkOutPanel.add(rentTxt);
      chkOutPanel.add(bookLabel);
      chkOutPanel.add(renterLabel);

      addPicture(chkOutPanel);
       
      bookLabel.setBounds(55, 100, 115, 30);
      renterLabel.setBounds(75, 135, 115, 30);
      chkOutButton2.setBounds(250, 135, 115, 30);	 	
      bkTxt.setBounds(130, 100, 115, 30);
      rentTxt.setBounds(130, 135, 115, 30);
   }

   /**Method prepare the layout for the GUI's panels which are used for adding, searching and checking out.
   */
   private void prepareGUI()
   {
      controlPanel = new JPanel();
      addPanel = new JPanel();
      rmvPanel = new JPanel();
      searchPanel = new JPanel();
      chkOutPanel = new JPanel();

      mainFrame = new JFrame("Library Manager");
      mainFrame.setSize(400, 350);
      mainFrame.getContentPane().setBackground(new Color(255,255, 255));
      mainFrame.setResizable(false);

      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
		libManager.writeToFileHandler();		
            System.exit(0);
         }        
      });    

      setControlPanelComponents();
      setAddPanelComponents();
      setSearchPanelComponents();
      setChkOutPanelComponents();
      setRmvPanelComponents();

      mainFrame.add(controlPanel);
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

	statusLabel.setSize(200, 50);
	statusLabel.setBounds(50, 275, 300, 50);	 
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

   private void rmvPanel()
   {
	rmvButton2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			String rmvBk = new String();
			rmvBk = rmvTxt.getText().trim();
			if(rmvBk.equals(""))
			{}
			else{
				String report = libManager.rmvHandler(rmvBk);
				if(report.equals("Error")){}
				else{
					statusLabel.setText(rmvBk + " was removed from the library");
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

      rmvButton.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
	 {
		resetPane(controlPanel, rmvPanel);
                rmvPanel();
      	 }
      });

      controlPanel.add(addButton);
      controlPanel.add(rmvButton);
      controlPanel.add(searchButton);
      controlPanel.add(chkOutButton);       

      mainFrame.setVisible(true);  
   }
}
