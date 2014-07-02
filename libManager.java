/** 
@author Stefan Knott
This class serves as a Management class for the user's library.Then methods here are used to handle and change the library's data which is held in an epandableArray object.
 */
public class libManager
{
	public static expandableArray books;
	static int menuDecision = 0;	

	/**
	 * Default Constructor
	 */
	public libManager()
	{
		books = new expandableArray();
	}
	
	/**
	 This method serves as a handler method to handle the addition of books to the expandableArray object.
	 @param title The title of the book to be added
	 */
	public static String addHandler(String title)
	{
		if(title == null)
			return "Error";
		Book newBook = new Book(title);
		newBook.setTitle(title);
		books.addBook(newBook);
		return newBook.displayReport();	
	}

	/**
	 This method serves as a handler method to make searching for a book in the expandableArray object easy.
	 @param searchItem The search query typed in the search box
	 */
	public static String searchHandler(String searchItem)
	{
		if(searchItem == null)
		{
			return "Error";
		}
		if(books.search(searchItem) == null)
		{
			return "Error";
		}
		Book bk = books.search(searchItem);
		return bk.displayReport();
	}
	
	/**Handler method used to check out a book with title bookTitle to the renter rentee
	@param bookTtile Title of book to be checked out
	@param rentee Name of the person renting the book
	*/
	public static String chkOutHandler(String bookTitle, String rentee){
		if(bookTitle == null || rentee == null)
		{
			return "Error";
		}
                Book bk = new Book();
		bk = books.search(bookTitle);
		String report = "";
		if(bk == null)
		{
			return "Error";
		}else
		{
			report = bk.displayReport();
		}
		if(report.equals("Error"))
		{
			return "Error";
		}
		books.checkOut(bookTitle, rentee);
		return report;
	}

	/**Handler method used to read in the library from library.txt
	*/
        public static void readInHandler()
	{
		books.readFromFile();
	}	

	/**Handler method used to remove a book relating to the searchItem from the array.
	@param searchItem the item, whether be Book Title or Renter
	@return the searchItem or Error upon error
	*/
	public static String rmvHandler(String searchItem)
	{
		Book bk = new Book();
		bk = books.search(searchItem);
		if(bk != null){
		books.removeBook(bk);
		return searchItem;
		}else
		{
			return "Error";
		}
	}
	/**Handler method used to call the writeToFile function in the ADT expandableArray
	*/
	public static void writeToFileHandler()
	{
		books.writeToFile();
	}
}
