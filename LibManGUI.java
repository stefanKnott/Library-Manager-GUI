//package libManGUI;
//

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
 
public class LibManGUI extends JFrame{ 

   private static final long serialVersionUID = 1L;
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel, addPanel, searchPanel, chkOutPanel;
   private JButton addButton, addButton2, searchButton, searchButton2, chkOutButton, chkOutButton2, saveButton;
   private JTextField addTxt, searchTxt, bkTxt, rentTxt;

   public LibManGUI(){
      new libManager();
      libManager.readInHandler();
	prepareGUI();      
   }

   public static void main(String[] args){
      LibManGUI gui = new LibManGUI();      
      gui.showButtonDemo();   
   }
	
   private void prepareGUI(){

      mainFrame = new JFrame("Library Manager");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      mainFrame.getContentPane().setBackground(new Color(0, 0, 0));

      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    

      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
 
      addButton = new JButton("Add");
      searchButton = new JButton("Search");
      chkOutButton = new JButton("Checkout");
      saveButton = new JButton("Save");
      controlPanel = new JPanel();
      controlPanel.add(addButton);
      controlPanel.add(searchButton);
      controlPanel.add(chkOutButton);
      controlPanel.add(saveButton);
      controlPanel.setBackground(Color.BLACK);
	try{
	BufferedImage mainIcon = ImageIO.read(new File("bookworm.jpg"));
	JLabel picLabel = new JLabel(new ImageIcon(mainIcon));
	controlPanel.add(picLabel);
	}catch(IOException e){}
    
      controlPanel.setLayout(new FlowLayout());
      
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

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);

      mainFrame.setVisible(true);  

   }
    
   /*private static ImageIcon createImageIcon(String path, 
      String description) {
      java.net.URL imgURL = LibManGUI.class.getResource(path);
      if (imgURL != null) {
         return new ImageIcon(imgURL, description);
      } else {            
         System.err.println("Couldn't find file: " + path);
         return null;
      }
   } */  
   private void addPanel()
   {
	for(ActionListener al : addButton2.getActionListeners()){
		addButton2.removeActionListener(al);
	}
		addButton2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String addBk = new String();
			addBk = addTxt.getText();
			if(addBk.equals(""))
			{}else{
			String report = libManager.addHandler(addBk);
			System.out.println(report);
			}
			mainFrame.remove(addPanel);
			mainFrame.setContentPane(controlPanel);
			mainFrame.validate();
			mainFrame.repaint();
	for(ActionListener al : addButton2.getActionListeners()){
		addButton2.removeActionListener(al);
	}			
		}
         });          
   
   }

   private void searchPanel(){
	for(ActionListener al : searchButton2.getActionListeners()){

		searchButton2.removeActionListener(al);
	}		
		searchButton2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String searchBk = searchTxt.getText();
			String report = libManager.searchHandler(searchBk);
			System.out.println(report);
			mainFrame.remove(searchPanel);
			mainFrame.setContentPane(controlPanel);
			mainFrame.validate();
			mainFrame.repaint();
	for(ActionListener al : searchButton2.getActionListeners())
	{
		searchButton2.removeActionListener(al);
	}	
	}
         });
	return;
   }

   private void chkOutPanel()
   {
	for(ActionListener al : chkOutButton2.getActionListeners())
	{
		chkOutButton2.removeActionListener(al);
	}
		chkOutButton2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String bk = bkTxt.getText();
			String renter = rentTxt.getText();
			String report = libManager.chkOutHandler(bk, renter);
			System.out.println(report);
			mainFrame.remove(searchPanel);
			mainFrame.setContentPane(controlPanel);
			mainFrame.validate();
			mainFrame.repaint();
		}
         });
   }
	

   private void showButtonDemo(){
      headerLabel.setText("Library Manager"); 
  //resources folder should be inside SWING folder.
      //ImageIcon icon = createImageIcon("/resources/java_icon.png","Java");

    //  JButton addButton = new JButton("Add");        
    //  JButton searchButton = new JButton("Search");
    //  JButton chkOutButton = new JButton("Checkout");
    //  chkOutButton.setHorizontalTextPosition(SwingConstants.LEFT);   

      addButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		mainFrame.remove(controlPanel);		
		mainFrame.setContentPane(addPanel);
		mainFrame.validate();
		mainFrame.repaint();
		addPanel();
	//	showButtonDemo();
      }});

      searchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		mainFrame.remove(controlPanel);
		mainFrame.setContentPane(searchPanel);
		mainFrame.validate();
		mainFrame.repaint();
		searchPanel();
	//	showButtonDemo();
      }});

      chkOutButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		mainFrame.remove(controlPanel);
		mainFrame.setContentPane(chkOutPanel);
		mainFrame.validate();
		mainFrame.repaint();
		chkOutPanel();
	//	showButtonDemo();		
         }
      });
	
      saveButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		libManager.writeToFileHandler();
	}
      });

      controlPanel.add(addButton);
      controlPanel.add(searchButton);
      controlPanel.add(chkOutButton);       
      controlPanel.add(saveButton);
      mainFrame.setVisible(true);  
   }
}
