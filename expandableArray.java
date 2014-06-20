//package com.tooCoolforSchool.libraryManager.server;

//import java.io.*;
//import java.util.Scanner;
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
	//Scanner key = new Scanner(System.in);

	///Constructor for expandable array
	public expandableArray()
	{
		length = 10;
		books = new Book[length];
	}

	public void addBook(Book bk)
	{
		if(totalBooks != 0)
		{
			shlfSpot = this.openSpot();
		}
		if(shlfSpot < 0 || shlfSpot > length)
		{
			System.out.println("Error!");
		}
		books[shlfSpot] = bk;
		if(totalBooks == length)
		{
			this.expand();
		}
		books[shlfSpot].setLoc(shlfSpot);
		++totalBooks;
		++shlfSpot;
		System.out.println("Your book has been added to the shelf!");
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
	
	 public Book searchHandler(String search_item)
     {
//		int menuDecision = 0;
//        System.out.println("How would you like to search?");
//        System.out.println("1. By Book Title");
//        System.out.println("2. By Rentee's name");
//        menuDecision = key.nextInt();
//        key.nextLine();
//        if(menuDecision == 1)
//        {
//			this.srchByTitle();
//        }else if(menuDecision == 2)
//        {
//			this.searchByRentersName();
//        }
		 
		 if(srchByTitle(search_item) != null)
			 return srchByTitle(search_item);
		 else
		 	return searchByRentersName(search_item);
	
	 }

	public Book srchByTitle(String searchItem)
	{
//		System.out.println("Title of the book: ");
        String bookTitle = searchItem;
        //key.nextLine();
		for(int i = 0; i < totalBooks; ++i)
        {
			String temp = books[i].getTitle();
            if(bookTitle.equals(temp))
            {
//            	System.out.println("Book found!");
                return books[i];
            }
         }
		return null;

	}

	public Book searchByRentersName(String rentee)
	{
		 //System.out.println("Rentee's name: ");
         //String rentName = "0";
         //key.nextLine();
         //Book retBook = new Book();
         for(int i = 0; i < books.length; i++)
         {
        	 if(books[i].myRenter.equals(rentee))
             {
        		 //System.out.println(rentName + "has the following book rented: ");
                 //books[i].displayReport();
                 return books[i];
             }
         }
         return null;
	}
	
	public void editBook(Book bk)
	{
		System.out.println("Edit Options");
		System.out.println("1. Edit Title");
		System.out.println("2. Edit Checkout Date");
		int menuDecision = 0;
//		key.nextInt();
//		key.nextLine();
		if(menuDecision == 1)
		{
			System.out.println("New Title: ");
			String newTitle = "0";
			//key.nextLine();
			bk.setTitle(newTitle);
		}else if(menuDecision == 2)
		{
			System.out.println("New Checkout Date: ");
			int month = 0;
			//key.nextInt();
			int day = 0;
			//key.nextInt();
			int year = 0;
			//key.nextInt();
			//key.nextLine();
			bk.setMyCheckoutDate(month, day, year);
		}
	}
	
	public void writeToFile()
	{	
		
//		BufferedWriter writer = null;
//		try
//		{
//		//	File library = new File(".txt");
//			//PrintWriter output = new
//			//PrintWriter("library.txt");
//			for(int i = 0; i < totalBooks; ++i)
//			{
//				//output.println(books[i].displayReport() + "\n");
//			}
//			//output.close();
//		}catch(IOException e)
//		{
//		}
	}
}

