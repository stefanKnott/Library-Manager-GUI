/**
This class is used to create a book, and store all of it's member variables
@author Stefan Knott, Chris Meyer
@version 0.0.2
*/
public class Book
{	
	public String myTitle = null;
	public String myRenter = null;
	public int myLoc = 0;
	public boolean rentStatus = false;

	/**Default Constructor
	*/
	public Book()
	{
		myTitle = null;
		myRenter = null;
		rentStatus = false;
		myLoc = -1;
	}
	
	/**This method constructs a book with just a title
	  @param title 
	*/
	public Book(String title)
	{
		myTitle = title;
		myRenter = null;
		rentStatus = false;
		myLoc = -1;
	}
	
	/**This method constructs a book when passed a title, shelf spot, renter and rented status
	@param aTitle is the title of a book passed
	@param aLoc is the shelf location of a book
	@param aRenter is the renter passed
	@param rented is the rent status passed (0 or 1)
	*/
	public Book(String aTitle, int aLoc, String aRenter, boolean rented)
	{
		myLoc = aLoc;
		myTitle = aTitle;
		myRenter = aRenter;
		if(rentStatus != true)
			rentStatus = false;
		else
			rentStatus = rented;
	}
	
	/**This method sets the name for the book
	@param name is set as the name of this book
	*/
	public void setTitle(String name)
	{
		myTitle = name;
	}
	
	/**This method sets the rent status for the book
	@param status is set as the rentStatus of this book
	*/
	public void setRentStatus(boolean status)
	{
		if (status == false || status == true)
		rentStatus = status;
	}

	public void setMyRenter(String renter)
	{
		myRenter = renter;
	}
	
	/**This method sets the ID for this book
	@param i set as ID for this book
	*/
	public void setLoc(int i)
	{
		myLoc = i;
	}
	
	/**This method returns the title for this book
	@return myTitle returns title of book
	*/
	public String getTitle()
	{
		return myTitle;
	}
	
	/**This method returns the renter for this book
	@return myRenter returns current renter of book
	*/
	public String getRenter()
	{
		return myRenter;
	}
	
	/**This method returns the rent status for this book
	@return rentStatus returns rent status of Book
	*/
	public boolean getRentStatus()
	{
		return rentStatus;
	}
	
	public int getLoc()
	{
		return myLoc;
	}
	
	/**This method returns the Title, Status, Renter, Checkout and Return date, and Shelf Spot
	@return String this string includes all info of the book
	*/
	public String displayReport()
	{
		String output = "";
		output += myTitle + "\n";
		output += myRenter + "\n";
		return output;
	}
}
