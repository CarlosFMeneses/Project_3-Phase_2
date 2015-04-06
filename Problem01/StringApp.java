/*
Carlos F. Meneses
03/30/2015
Bergen Community College
Advanced Java Programming

Homework Project 3, Phase 2, Problem 1
*/
/**
StringApp.java: Modification of Project 3 Phase 2 Problem 1. App reads strings 
from pre-existing data file data.txt until "DONE" is read-in. Throws exception 
if a string is entered that is 20 or more characters long. The exception 
StringTooLongException catches and handles such exception. For every String that 
is read in error, the program logs that error (the string and the line number of 
the offending statement. Store the errors in a file called error.log (see also: 
StringTooLongException.java)
*/

import java.nio.file.*;
import java.io.*;

public class StringApp
{
	public static void main(String[] args) throws StringTooLongException
	{
		String inFileName = "data.txt";
		String outFileName = "error.log";
		boolean done = false;
		int maxLength = 20;
		String doneString = "done";
		Path inPath = Paths.get(inFileName);
		String inString = null;
				
		try
		{
			InputStream inStream = new BufferedInputStream(Files.newInputStream(inPath));
			BufferedReader inRead = new BufferedReader(new InputStreamReader(inStream));
			
			System.out.println("Reading from file " + inFileName + "...");
			
			while (!done)
			{
				inString = inRead.readLine();
				
				if (doneString.equalsIgnoreCase(inString))
				{
					done = true;
				}
				
				if (inString.length() >= maxLength)
				{
					throw(new StringTooLongException());
				}
				else
				{
					System.out.print(inString);
				}
			}
		}
		catch (StringTooLongException stle)
		{
			System.out.println(stle);
		}
		
		System.out.println("Done! Please check file " + outFileName + 
						   " for possible errors");
	}
}