//package libManGUI.LibManGUI;

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
        private int openSpot = -1;
	public int length;

	///Constructor for expandable array
	public expandableArray()
	{
		length = 10;
		books = new Book[length];
	}
	
	/**Adds a book to the library (expandableARray).
	@param bk Book to add
	*/
	public void addBook(Book bk)
	{
	//	if(search(bk.getTitle()) == null){
			
		if(shlfSpot < 0 || shlfSpot > length)
			return;
		
		if(totalBooks == length)
			this.expand();
	
		if(openSpot >= 0)
		{
			books[openSpot] = bk;
			books[openSpot].setLoc(openSpot);
			openSpot = -1;
		}else{
		books[shlfSpot] = bk;
		books[shlfSpot].setLoc(shlfSpot);
		++shlfSpot;	
		}
		++totalBooks;	
	//	}
		return;
	}

	/**Expands the array by copying the data into another array 2x the size of the original.
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

	public int findBk(String name)
	{
		for(int i = 0; i < length; i++)
		{
			if(books[i] == null)
			{}
				if(books[i] != null)
				{
					if(name.equals(books[i].getTitle()))
					{
						return i;
					}
				}
		}
		return -1;
	}

	/**Set's bk's location in the array to null -- effectively removing it.
	@param bk Book to remove
	*/
	public void removeBook(Book bk)
	{
		int loc = findBk(bk.myTitle);
		if(loc == -1){return;}
		openSpot = loc;
		books[loc] = null;
		--totalBooks;	
	}
	
	/**Searches for the search query via search by title and search by renter functions.
	@param search_item The user's search query
	@return Book which has information mation the search query
	*/
	 public Book search(String search_item)
   	{
	if(totalBooks == 0 || search_item == null)
	{
		return null;
	}	 
	
	Book bk = new Book();
	bk = srchByTitle(search_item);	 
	if(bk != null)
		 return bk;
	else
		bk = searchByRentersName(search_item);
	 	if(bk != null)
	 		return bk;
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
	@param bookTitle The search query
	@return Book if it's name matches the search query
	*/
	public Book srchByTitle(String bookTitle)
	{
		for(int i = 0; i < totalBooks; i++)
      		{
			if(books[i] != null){
			String temp = books[i].getTitle();
          		if(bookTitle.equals(temp))
          		{
              			return books[i];
          		}
			}
       		}
		return null;
	}

	/**Search the book array to see if a book is rented by someone whose name matches the parameter passed.
	@param rentee The search query
	@return Book if it is rented by someone whose name matches the parameter rentee passed
	*/
	public Book searchByRentersName(String rentee)
	{
       		for(int i = 0; i < totalBooks; i++)
       		{
			if(books[i] != null){
			if(books[i].myRenter != null)
			{
      	 			if(books[i].myRenter.equals(rentee))
         			{
               				return books[i];
         			}
			}
       		}}
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
			for(int i = 0; i < length; ++i)
			{
				if(books[i] == null)
				{}
				else{
					output.println(books[i].displayReport());		
				}
			}
			output.close();
		}catch(IOException e){}
	}
}
