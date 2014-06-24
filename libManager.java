//package com.tooCoolforSchool.libraryManager.server;

//import java.util.Scanner;
/**
 * 
 * @author Stefan KNOTT
 * This class serves as a Management class for the user's library.  Then methods here
 * are used to handle and change the library's data which is held in an epandableArray
 * object
 */
public class libManager
{
	//static Scanner key = new Scanner(System.in);
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
	 * @author Stefan Knott
	 * This method serves as a handler method to handle the addition of books to the
	 * expandableArray object.
	 * @param title 
	 */
	public static String addHandler(String title)
	{
		if(title == null)
		{
			return "Error";
		}
		Book newBook = new Book();
		newBook.setTitle(title);
		books.addBook(newBook);
		books.writeToFile();
		return newBook.displayReport();	
		
	}

	/**
	 * @author Stefan Knott, Chris Meyer
	 * This method serves as a handler method to make searching for a book in the 
	 * expandableArray object easy
	 */
	public static String searchHandler(String searchItem)
	{
		if(searchItem == null)
		{
			return "Error";
		}
		Book bk = books.searchHandler(searchItem);
	//	if(bk.displayReport() ==
		return bk.displayReport();
	}

	/**
	 * @author Stefan Knott
	 * This method is used as a handler class.  It is needed to help make it easy to
	 * edit the infomation in the expandableArray object
	 */
	public static void editHandler(String searchItem)
	{
		Book bk = books.searchHandler(searchItem);
	    books.editBook(bk);
	    if(bk != null)
	    {
	    	bk.displayReport();
	    }
	}
	
	public void removeHandler(String searchItem)
	{
		Book bk = books.searchHandler(searchItem);
		books.removeBook(bk);
		books.writeToFile();
	}
}
