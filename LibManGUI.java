

//package library;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class LibManGUI{
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel, addPanel, searchPanel;
   private JButton addButton, addButton2, searchButton, searchButton2, chkOutButton, chkOutButton2;
   private JTextField addTxt, searchTxt;

   public LibManGUI(){
      libManager library = new libManager();
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
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);
 
      addButton = new JButton("Add");
      searchButton = new JButton("Search");
      chkOutButton = new JButton("Checkout");
      controlPanel = new JPanel();
      controlPanel.add(addButton);
      controlPanel.add(searchButton);
      controlPanel.add(chkOutButton);
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
   {	for(ActionListener al : addButton2.getActionListeners()){
		addButton2.removeActionListener(al);
	}
		addButton2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String addBk = null;
			addBk = addTxt.getText();
			String report = libManager.addHandler(addBk);
			System.out.println(report);
			mainFrame.remove(addPanel);
			mainFrame.setContentPane(controlPanel);
			mainFrame.validate();
			mainFrame.repaint();
			return;
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
//		final JTextField textField = new JTextField();
		mainFrame.remove(controlPanel);		
		mainFrame.setContentPane(addPanel);
		mainFrame.validate();
		mainFrame.repaint();
		addPanel();
		return;
      }});

      searchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		mainFrame.remove(controlPanel);
		mainFrame.setContentPane(searchPanel);
		mainFrame.validate();
		mainFrame.repaint();
		searchButton2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String searchBk = searchTxt.getText();
			String report = libManager.searchHandler(searchBk);
			System.out.println(report);
		}
/*            	String input = JOptionPane.showInputDialog("Book Title");
		String report = libManager.searchHandler(input);
            	statusLabel.setText(report);*/
         });
      }});

      chkOutButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		String input = JOptionPane.showInputDialog("Who checked the book out?");
		
		
         }
      });

      controlPanel.add(addButton);
      controlPanel.add(searchButton);
      controlPanel.add(chkOutButton);       

      mainFrame.setVisible(true);  
   }
}
