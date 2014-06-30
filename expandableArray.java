import java.io.*;

/**This class is an expadable array data structure
@author Stefan Knott
@version 1.0
*/



public class expandableArray
{
	public Book[] books;
	private int totalBooks = 0;
	private int shlfSpot = 0;
	public int length;

	///Constructor for expandable array
	public expandableArray()
	{
		length = 10;
		books = new Book[length];
	}
	
	/**
	*Function used to add a book to the library (expandableARray).
	*@param Book bk : book to add
	*/
	public void addBook(Book bk)
	{
		if(search(bk.getTitle()) == null){
			
		if(shlfSpot < 0 || shlfSpot > length)
			return;
		
		if(totalBooks == length)
			this.expand();
	
		books[shlfSpot] = bk;
		++totalBooks;
		books[shlfSpot].setLoc(shlfSpot);
		++shlfSpot;
		}
		return;
	}

	public int openSpot()
	{
		for(int i = 0; i < books.length; i++)
		{
			if(books[i] == null)
			{
				return i;
			}
		}
		return -1;
	}

	/**Used to expand by copying the data into another array 2x the size of 	the original.
	*/
	public void expand()
	{
		int newLength = length*2;
		Book[] expanded = new Book[newLength];
		for(int i = 0; i < length; i++)
		{
			expanded[i] = books[i];
		}
		books = expanded;
		length *= 2;	
	}

	public void removeBook(Book bk)
	{
		--totalBooks;
		books[bk.myLoc] = null;
	}
	
	/**Searches for the search query via search by title and search by renter functions.
	*/
	 public Book search(String search_item)
   	{
	if(totalBooks == 0 || search_item == null)
	{
		return null;
	}	 
		 
	if(srchByTitle(search_item) != null)
		 return srchByTitle(search_item);
	else
	 	if(searchByRentersName(search_item) != null)
	 		return searchByRentersName(search_item);
	 	else
	 		return null;
	 }
	
	/**Sets a book's myRenter variable to the name of the renter passed to the function.
	@param String book : Name of the book to check out
	@param String renter : Name of the renter who is checking the book out
	*/
	public Book checkOut(String book, String renter)
	{
		Book bk = new Book();
		bk = search(book);
		if(bk == null)
		{
			return null;
		}
		else{
		bk.setMyRenter(renter);
		bk.setRentStatus(true);
		return bk;
		}
	}

	/**Searches the book array to see if a book's name matches the search item.
	@param String searchItem : The search query
	@return Book : return the book if it's name matches the search query
	*/
	public Book srchByTitle(String searchItem)
	{
      		String bookTitle = searchItem;
		for(int i = 0; i < totalBooks; ++i)
      		{
			String temp = books[i].getTitle();
          		if(bookTitle.equals(temp))
          		{
              			return books[i];
          		}
       		}
		return null;
	}

	/**Search the book array to see if a book is rented by someone whose name matches the parameter passed.
	@param String rentee : the search query
	@return Book : return the book if it is rented by someone whose name matches the parameter rentee passed
	*/
	public Book searchByRentersName(String rentee)
	{
       		for(int i = 0; i < totalBooks; i++)
       		{
      	 		if(books[i].myRenter.equals(rentee))
         		{
               			return books[i];
         		}
       		}
       		return null;
	}
	

	/**Loads library (books and renters) into the program from the text file library.txt found in the same directory as the source code.
	*/
	public void readFromFile()
	{       
		try{
			BufferedReader in = new BufferedReader(new FileReader("library.txt"));
			String line;
			while((line = in.readLine()) != null)
			{
				Book bk = new Book(line);
				line = in.readLine();
				bk.myRenter = line;
				addBook(bk);
				line = in.readLine();
			}
			in.close();
		}catch(IOException e){}
	}

	/**Wrote the library (books and renters) to the file library.txt
	*/
	public void writeToFile()
	{	
		try
		{
			PrintWriter output = new
			PrintWriter("library.txt");
			for(int i = 0; i < totalBooks; ++i)
			{
				output.println(books[i].displayReport());
			}
			output.close();
		}catch(IOException e){}
	}
}
