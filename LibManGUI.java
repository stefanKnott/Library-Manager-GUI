

//package library;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class LibManGUI{
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel, addPanel, searchPanel;
   private JButton addButton2;
   

   public LibManGUI(){
      libManager library = new libManager();
      addPanel = new JPanel();
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

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      
      addButton2 = new JButton("Add");
 //     addPanel = new JPanel();
      JTextField textBox = new JTextField(10);
    //  textBox.setBounds(70, 25, 100, 30);
    //  textBox.setSize(200, 100);

      addPanel.add(addButton2);
      addPanel.add(textBox);
      
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
   private void updateTxt()
   {
//	prepareGUI();
   }
   private void showButtonDemo(){

      headerLabel.setText("Library Manager"); 
 
  //resources folder should be inside SWING folder.
      //ImageIcon icon = createImageIcon("/resources/java_icon.png","Java");

      JButton addButton = new JButton("Add");        
      JButton searchButton = new JButton("Search");
      JButton chkOutButton = new JButton("Checkout");
      chkOutButton.setHorizontalTextPosition(SwingConstants.LEFT);   

      addButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
		/*final JTextField textField = new JTextField();
		mainFrame.remove(controlPanel);
		mainFrame.setContentPane(addPanel);
		mainFrame.validate();
		mainFrame.repaint();
//		textField.addActionListener(this);
		addButton2.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e){						String addBk = textField.getText().toString();
			//textArea.append(addBk);
//			textField.selectAll();
			System.out.println(addBk);
			String report = libManager.addHandler(addBk);
			System.out.println(report);
		}*/
		//mainFrame.add(textField);
		String input = JOptionPane.showInputDialog("Name of book to add");
		String report = libManager.addHandler(input);
		System.out.println(report);

			
         }          
      });


      searchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            	String input = JOptionPane.showInputDialog("Book Title");
		String report = libManager.searchHandler(input);
            	statusLabel.setText(report);
         }
      });

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
