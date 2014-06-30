import junit.framework.TestCase;

import java.util.Random;



public class CompleteUnitTest extends TestCase {

//////////////////
//////////////////BEGIN BOOK CLASS TEST CASES
//////////////////
	
	//Test Default Constructor
	public void testDefaultConstructor(){
		new libManager();
		Book test = new Book();
		
		assertEquals(null, test.getTitle());
		assertEquals(null, test.getRenter());
		assertEquals(false, test.getRentStatus());
	}
		
	//Test Title Constructor
	public void testTitleConstructor(){
		new libManager();
		Book test = new Book("testTitle");
		
		assertEquals("testTitle", test.getTitle());
	}
		
	//Test Full Constructor
	public void testFullConstructor(){
		new libManager();
		Book test = new Book("testTitle", 0, "testRenter", false);
		
		assertEquals("testTitle", test.getTitle());
		assertEquals(0, test.getLoc());
		assertEquals("testRenter", test.getRenter());
		assertEquals(false, test.getRentStatus());
	}
		
	//Test Setter/Getter pairs
	public void testSettersandGetters(){
		Book test = new Book();
		
		test.setTitle("newTitle");
		assertEquals("newTitle", test.getTitle());
		
		test.setRentStatus(false);
		assertEquals(false,test.getRentStatus());
		
		test.setMyRenter("newRenter");
		assertEquals("newRenter", test.getRenter());
		
		test.setLoc(1);
		assertEquals(1, test.getLoc());
	}

	
//////////////////
//////////////////END BOOK CLASS TEST CASES
//////////////////BEGIN LIBMANAGER CLASS TEST CASES
//////////////////
	
	
	//Test addHandler
	public void testAddHandler(){
		new libManager();
		Book test = new Book("testTitle");
		
		libManager.addHandler("testTitle");
		assertEquals(test.displayReport(), libManager.searchHandler("testTitle"));
	}
	
	//Test searchHandler
	public void testSearchHandler(){
		new libManager();
	}
	
	//Test chkOutHandler
	public void testChkOutHandler(){
		new libManager();
		Book test = new Book("testTitle");
		
		libManager.chkOutHandler("testTitle", "testRenter");
		assertEquals("testRenter", test.getRenter());
		assertEquals(true, test.getRentStatus());
	}


//////////////////
//////////////////END LIBMANAGER CLASS TEST CASES
//////////////////BEGIN EXPANDABLEARRAY TEST CASES
//////////////////
	
	//Test default expandableArray constructor
	public void testArrayDefaultConstructor(){
		expandableArray testArray = new expandableArray();
		Book test = new Book();
		assertTrue(testArray.length == 10);
		//assertEquals(testArray.books, new Book[]{null,null,null,null,null,null,null,null,null,null});
		assertEquals(testArray.books, new Book[]{test,test,test,test,test,test,test,test,test,test});

	}
	
	//Test expandableArray.addBook()
	public void testAddBook(){
		expandableArray testArray = new expandableArray();
		Book test = new Book("testTitle");
		
		//add standard book
		testArray.addBook(test);
		assertEquals(test, testArray.books[0]);
		
		//add duplicate book, should not create a duplicate.
		//We may decide that this is OK behaviour
		testArray.addBook(test);
		assertNotSame(test, testArray.books[1]);
		
	}
	
	//Test expandableArray.openSpot()
	public void testOpenSpot(){
		expandableArray testArray = new expandableArray();
		Book test = new Book("testTitle");
		
		//test that first spot is open when no books have been added
		assertEquals(testArray.openSpot(), 0);
		
		//fill up our initial array of size 10
		for(int i = 0; i != 9; i++){
			int j = i;
			String title = Integer.toString(j);
			testArray.addBook(new Book(title));
			assertEquals(i + 1, testArray.openSpot());
		}
		
		//test that the array recognizes it has no open spots when we fill the last spot
		testArray.addBook(test);
		assertEquals(-1, testArray.openSpot());
	}
	
	//Test expandableArray.expand()
	public void testExpand(){
		expandableArray testArray = new expandableArray();
		Book test = new Book("testTitle");

		
		//fill up our array without causing expand() to be called
		for(int i = 0; i != 10; i++){
			int j = i;
			String title = Integer.toString(j);
			testArray.addBook(new Book(title));
			}
		assertEquals(10, testArray.length);
		
		//make expand() be called by adding a new book to the already full array
		testArray.addBook(test);
		assertEquals(20, testArray.length);
	}
	
	public void testSearch(){
		expandableArray testArray = new expandableArray();
		Random rnd = new Random();
		
		String search1 = "testTitle";
		String search2 = "";
		String search3 = null;
		String search4 = "!@#$%^&*(){}:<>?|\"Ω≈ç√∫˜µ≤≥÷…¬˚∆˙©ƒ∂ßåœ∑´®†¥¨ˆøπ“‘«≠–ºª•¶§∞¢£™¡";
				
		//Ensure that we return null if there are no items in the array
		assertEquals(null, testArray.search(search1));
		assertEquals(null, testArray.search(search2));
		assertEquals(null, testArray.search(search3));
		assertEquals(null, testArray.search(search4));

		
		//Fill new array including four expansions to test search terms on. Each book 
		//will have the following format:
		//Title: title(i), Loc: [i], Rentee: author(i), Rented: random (true/false)
		//ie. Book[0] = (title0, 0, author0, True); (or false for rent status);
		//Where [i] is relative to the books location in the array.
		for(int i = 0; i != 100; i++){
			int loc = i;
			String append = Integer.toString(i);
			String title = "title" + append;
			String rentee = "rentee" + append;
			Book temp = new Book(title, loc, rentee, rnd.nextBoolean());
			
			testArray.addBook(temp);
			
			assertEquals(temp, testArray.search(title));
			assertEquals(testArray.search(title), testArray.search(rentee));
			assertEquals(title, testArray.search(title).getTitle());
			assertEquals(rentee, testArray.search(rentee).getRenter());
			assertEquals(loc, testArray.search(title).getLoc());
			
			assertEquals(null, testArray.search(search1));
			assertEquals(null, testArray.search(search2));
			assertEquals(null, testArray.search(search3));
			assertEquals(null, testArray.search(search4));

		}
	}
	
	public void testcheckOut(){
		expandableArray testArray = new expandableArray();
		Book test = new Book("testTitle");
		
		//Attempt to checkout non-existent book
		assertEquals(null, testArray.checkOut("Luke Skywalker", "Darth Vader"));
		
		//Attempt to checkout a book we just added and check its status before and after
		testArray.addBook(test);
		assertEquals(false,testArray.search(test.getTitle()).getRentStatus());
		
		assertEquals(test, testArray.checkOut(test.getTitle(), "Obi-Wan Kenobi"));
		assertEquals("Obi-Wan Kenobi", testArray.search(test.getTitle()).getRenter());
		assertEquals(true,testArray.search(test.getTitle()).getRentStatus());
		
	}
	
	public void testReadFromFile(){
		
	}
	
	public void testWriteToFile(){
		
	}
	
//////////////////
//////////////////END EXPANDABLEARRAY TEST CASES
//////////////////
	
	
}
