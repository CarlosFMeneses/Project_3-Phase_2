/*
Carlos F. Meneses
03/30/2015
Bergen Community College
Advanced Java Programming

Homework Project 3, Phase 2, Problem 1
*/
/**
StringTooLongException: This exception gets thrown if the user enters a string 
which has 20 or more characters. (see also: StringApp.java)
*/

public class StringTooLongException extends Exception
{
	public StringTooLongException()
	{
		super ("Too many characters. Try again...");
	}
}