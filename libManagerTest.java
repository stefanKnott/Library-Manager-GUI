import junit.framework.TestCase;


public class libManagerTest extends TestCase {
	//Book class tests
	public void testDefaultConstructor() {
		new libManager();
		
		Book test = new Book();
		
		assertEquals(null, test.myTitle);
		assertEquals(null, test.myRenter);
		assertEquals(false, test.rentStatus);
	}
	
	public void testConstructor() {
		new libManager();
		
		Book test = new Book("test",0, "testrentee", false);
		
		assertEquals("test", test.myTitle);
		assertEquals("testrentee", test.myRenter);
		assertEquals(false, test.rentStatus);
	}
	
	
	public void testSettersGetters_Rentee() {
		new libManager();
		Book test = new Book();
		
		test.setMyRenter("testrentee");		
		assertEquals("testrentee", test.getRenter());
	}
	
	public void testSettersGetters_Title() {
		new libManager();
		Book test = new Book();
		
		test.setTitle("test");	
		assertEquals("test", test.getTitle());
	}

	public void testSettersGetters_RentStatus() {
		new libManager();
		Book test = new Book();
		
		test.setRentStatus(false);
		assertEquals(false, test.getRentStatus());
	}
	
	public void testSettersGetters_CheckoutDate() {
		new libManager();
		Book test = new Book();
		
		test.setMyCheckoutDate(10, 10, 2014);
		assertEquals(new Date(10, 10, 2014), test.getCheckoutDate());
	}
	
	public void testSettersGetters_ReturnDate() {
		new libManager();
		Book test = new Book();
		
		test.setReturnDate(10, 11, 2014);
		assertEquals(new Date(10, 11, 2014), test.getReturnDate());
	}
	
	public void testSettersGetters_Loc() {
		new libManager();
		Book test = new Book();
		
		test.setLoc(0);
		assertEquals(0, test.getLoc());
	}
	
	
	//libManager tests
	public void testaddHandler_null() {
		new libManager();
		
		assertEquals("Error", libManager.addHandler(null));
	}
	
	public void testSearchAddHandler_valid() {
		new libManager();
		libManager.addHandler("test");
		
		assertEquals("test", libManager.searchHandler("test"));
		
	}
}
