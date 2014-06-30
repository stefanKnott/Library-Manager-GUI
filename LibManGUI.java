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
   private JButton addButton, addButton2, searchButton, searchButton2, chkOutButton, chkOutButton2;
   private JTextField addTxt, searchTxt, bkTxt, rentTxt;

   public LibManGUI(){
      new libManager();
      libManager.readInHandler();
      prepareGUI();      
   }

   public static void main(String[] args){
      LibManGUI gui = new LibManGUI();      
      gui.runGUI();   
   }
	
   private void prepareGUI(){

      mainFrame = new JFrame("Library Manager");
      mainFrame.setSize(250,200);
      mainFrame.setLayout(new GridLayout(1, 5));
      mainFrame.getContentPane().setBackground(new Color(0, 0, 0));

      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
		libManager.writeToFileHandler();
		
            System.exit(0);
         }        
      });    

      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
 
      addButton = new JButton("Add");
      searchButton = new JButton("Search");
      chkOutButton = new JButton("Checkout");
      controlPanel = new JPanel();
      controlPanel.add(addButton);
      controlPanel.add(searchButton);
      controlPanel.add(chkOutButton);
      controlPanel.setBackground(Color.BLACK);
      try{
	BufferedImage mainIcon = ImageIO.read(new File("bookworm.jpg"));
	JLabel picLabel = new JLabel(new ImageIcon(mainIcon));
//	picLabel.setLocation(125, 50);
	controlPanel.add(picLabel);
       }catch(IOException e){}
    
      controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      
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

      mainFrame.add(controlPanel);

      mainFrame.setVisible(true);  

   }

   private void resetPane(JPanel rmv, JPanel set)
   {
	mainFrame.remove(rmv);
	mainFrame.setContentPane(set);
	mainFrame.validate();
	mainFrame.repaint();
        mainFrame.getContentPane().setBackground(new Color(0, 0, 0));
	
   }
 
   private void addPanel()
   {
	for(ActionListener al : addButton2.getActionListeners()){
		addButton2.removeActionListener(al);
	}
		addButton2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String addBk = new String();
			addBk = addTxt.getText().trim();
			if(addBk.equals(""))
			{}else{
			String report = libManager.addHandler(addBk);
			if(report.equals("Error")){}
			else{
			System.out.println(report);
			}
			}
			resetPane(addPanel, controlPanel);
      			mainFrame.getContentPane().setBackground(new Color(0, 0, 0));
	
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
			String searchBk = searchTxt.getText().trim();
			if(searchBk.equals("")){}
			else{
			String report = libManager.searchHandler(searchBk);
			if(report.equals("Error")){}
			else{
			System.out.println(report);
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

   private void chkOutPanel()
   {
	for(ActionListener al : chkOutButton2.getActionListeners())
	{
		chkOutButton2.removeActionListener(al);
	}
		chkOutButton2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String bk = bkTxt.getText().trim();
			String renter = rentTxt.getText().trim();
			if(bk.equals("") || renter.equals("")){}
			else{
			String report = libManager.chkOutHandler(bk, renter);
			if(report.equals("Error")){}
			else{
			System.out.println(report);	
			}
			}
			resetPane(chkOutPanel, controlPanel);
		}
         });
   }
	

   private void runGUI(){
      headerLabel.setText("Library Manager"); 
      addButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		resetPane(controlPanel, addPanel);
		addPanel();
      }});

      searchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		resetPane(controlPanel, searchPanel);
		searchPanel();
      }});

      chkOutButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
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
