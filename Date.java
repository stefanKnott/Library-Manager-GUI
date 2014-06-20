//package com.tooCoolforSchool.libraryManager.server;

public class Date
{
	public int myMonth;
	public int myYear;
	public int myDay;
	
	Date()
	{	
		myMonth = 1;
		myDay = 1;
		myYear = 2000;
	}
	
	Date(int m, int d, int y)
	{
		myMonth = m;
		myDay = d;
		myYear = y;
	}
	
	void setDay(int d)
	{
		myDay = d;
	}
	void setMonth(int m)
	{
		myMonth = m;
	}
	void setYear(int y)
	{
		myYear = y;
	}

	int getDay()
	{
		return myDay;
	}
	int getMonth()
	{
		return myMonth;
	}
	int getYear()
	{
		return myYear;
	}
	
	public String toString()
	{
		return myMonth + "/" + myDay + "/" + myYear;	
	}
}

